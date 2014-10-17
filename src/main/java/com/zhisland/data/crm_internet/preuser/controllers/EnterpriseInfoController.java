/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zhisland.data.crm_internet.data_dict.dto.City;
import com.zhisland.data.crm_internet.data_dict.dto.DataDictDTO;
import com.zhisland.data.crm_internet.data_dict.dto.Province;
import com.zhisland.data.crm_internet.data_dict.services.DataDictService;
import com.zhisland.data.crm_internet.preuser.dtos.EnterpriseInfo;
import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.preuser.services.EnterpriseInfoService;
import com.zhisland.data.crm_internet.utils.Constants;
import com.zhisland.data.crm_internet.utils.ShortURL;
import com.zhisland.data.crm_internet.utils.jsend.JsonData;
import com.zhisland.data.crm_internet.utils.jsend.JsonStruct;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/preuser")
public class EnterpriseInfoController {

    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @Autowired
    private DataDictService dataDictService;
    
    @Autowired
    private ApplyStatusService applyStatusService;

    /**
     * 显示企业基本信息
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/enterprise", method = RequestMethod.GET)
    public ModelAndView showEnterpriseInfo(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());
        
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.findEnterpriseInfoByMemberId(memberId);
        
        if (StringUtils.isBlank(enterpriseInfo.getIsPublicCompany())) {
            enterpriseInfo.setIsPublicCompany(Constants.PUBLIC_COMPANY_DEFAULT);
        }

        enterpriseInfo.setMainMarketForView(StringUtils.split(enterpriseInfo.getMainMarket(), Constants.COMMA));
        enterpriseInfo.setIndustryForView(StringUtils.split(enterpriseInfo.getIndustry(), Constants.COMMA));
        
        List<Province> provinceCity = dataDictService.getAllProvinces();
        for (Province p : provinceCity) {
            if (StringUtils.equals(p.getName(), enterpriseInfo.getEnterpriseProvince())) {
                enterpriseInfo.setProvinceIdForView(p.getId());
                
                for (City c : p.getCitys()) {
                    if (StringUtils.equals(c.getName(), enterpriseInfo.getEnterpriseCity())) {
                        enterpriseInfo.setCityIdForView(c.getId());
                        break;
                    }
                }
                break;
            }
        }
        
        // 企业最新年度
        TreeSet<DataDictDTO> dataYear = new TreeSet<DataDictDTO>();
        Calendar ca = Calendar.getInstance();
        
        DataDictDTO thisYear = new DataDictDTO();
        thisYear.setItemName(Integer.toString(ca.get(Calendar.YEAR)));
        thisYear.setItemSort(1);
        dataYear.add(thisYear);
        
        DataDictDTO lastYear = new DataDictDTO();
        lastYear.setItemName(Integer.toString(ca.get(Calendar.YEAR) - 1));
        lastYear.setItemSort(2);
        dataYear.add(lastYear);
        
        DataDictDTO theYearBeforeLast = new DataDictDTO();
        theYearBeforeLast.setItemName(Integer.toString(ca.get(Calendar.YEAR) - 2));
        theYearBeforeLast.setItemSort(3);
        dataYear.add(theYearBeforeLast);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("enterpriseInfo", enterpriseInfo);
        modelMap.put("enterpriseIndustries", dataDictService.getEnterpriseIndustries());
        modelMap.put("enterpriseIndustryStrList", dataDictService.getEnterpriseIndustryStrList());
        modelMap.put("enterpriseStaffNums", dataDictService.getAllEnterpriseStaffNum());
        modelMap.put("enterpriseNatures", dataDictService.getAllEnterpriseNatures());
        modelMap.put("enterpriseDivides", dataDictService.getAllEnterpriseDivides());
        modelMap.put("provinceCity", new Gson().toJson(provinceCity));
        modelMap.put("gopublicAddresses", dataDictService.getAllGopublicAddresses());
        modelMap.put("announcedDates", dataDictService.getAnnouncedDates());
        modelMap.put("mainMarkets", dataDictService.getMainMarketStrList());
        modelMap.put("dataYear", dataYear);

        return new ModelAndView("/preuser/enterpriseInfo", modelMap);
    }

    /**
     * 更新企业基本信息
     * 
     * @param member
     * @param enterpriseInfo
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/{member}/enterprise", method = RequestMethod.POST)
    @ResponseBody
    public String postEnterpriseInfo(@PathVariable String member, EnterpriseInfo enterpriseInfo,
            HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException,
            JsonMappingException, IOException {
        
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());
        
        JsonStruct struct = new JsonStruct();
        JsonData data = new JsonData();
        Map<String, String> errorsMap = new HashMap<String, String>();

        // validate start
        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriceCnName())) {
            errorsMap.put("enterpriceCnName", "请填写企业名称");
        }

        if (!GenericValidator.maxLength(enterpriseInfo.getEnterpriceCnName(), 100)) {
            errorsMap.put("enterpriceCnName", "企业名称输入过长，最多可输入100字");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getClientPosition())) {
            errorsMap.put("clientPosition", "请填写申请人所在公司职务");
        }

        if (!GenericValidator.maxLength(enterpriseInfo.getClientPosition(), 50)) {
            errorsMap.put("clientPosition", "申请人职务输入过长，最多可输入50字");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseMainIndustry())) {
            errorsMap.put("enterpriseMainIndustry", "请选择公司的主营行业");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseNature())) {
            errorsMap.put("enterpriseNature", "请选择企业性质");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseDivide())) {
            errorsMap.put("enterpriseDivide", "请选择企业划分类型");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseProvince())) {
            errorsMap.put("enterpriseProvince", "请选择企业所在地区，需选择到市/区");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseCity())) {
            errorsMap.put("enterpriseCity", "请选择企业所在地区，需选择到市/区");
        }

        if (!GenericValidator.maxLength(enterpriseInfo.getRegisterAddress(), 100)) {
            errorsMap.put("registerAddress", "注册地点输入过长，最多可输入100字");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getCoreBusiness())) {
            errorsMap.put("coreBusiness", "请填写公司的主营业务/产品");
        }

        if (!GenericValidator.maxLength(enterpriseInfo.getCoreBusiness(), 300)) {
            errorsMap.put("coreBusiness", "主营业务/产品输入过长，最多可输入300字");
        }

        if (GenericValidator.isBlankOrNull(enterpriseInfo.getSalesAmount())) {
            errorsMap.put("salesAmount", "请填写您企业上年度的营业收入");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getSalesAmount())
                && !GenericValidator.isDouble(enterpriseInfo.getSalesAmount())) {
            errorsMap.put("salesAmount", "您输入的企业上年度营业收入格式错误，须为数字");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getSalesGrowth())
                && !GenericValidator.isDouble(enterpriseInfo.getSalesGrowth())) {
            errorsMap.put("salesGrowth", "您输入的企业上年度营业收入年增长率格式错误，须为数字");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getPayTaxesAmount())
                && !GenericValidator.isDouble(enterpriseInfo.getPayTaxesAmount())) {
            errorsMap.put("payTaxesAmount", "您输入的企业上年度纳税总额格式错误，须为数字");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getTaxesGrowth())
                && !GenericValidator.isDouble(enterpriseInfo.getTaxesGrowth())) {
            errorsMap.put("taxesGrowth", "您输入的企业上年度纳税总额年增长率格式错误，须为数字");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getAssetAmount())
                && !GenericValidator.isDouble(enterpriseInfo.getAssetAmount())) {
            errorsMap.put("assetAmount", "您输入的企业上年度资产总额格式错误，须为数字");
        }

        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getAssetGrowth())
                && !GenericValidator.isDouble(enterpriseInfo.getAssetGrowth())) {
            errorsMap.put("assetGrowth", "您输入的企业上年度资产总额年增长率格式错误，须为数字");
        }

        if (!GenericValidator.maxLength(enterpriseInfo.getEnterpriseProfile(), 300)) {
            errorsMap.put("enterpriseProfile", "企业介绍输入过长，最多可输入300字");
        }

        if ("是".equals(enterpriseInfo.getIsPublicCompany())) {
            if (GenericValidator.isBlankOrNull(enterpriseInfo.getStockCode())) {
                errorsMap.put("stockCode", "请填写公司上市的股票代码");
            }
        }
        
        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getSubordinateCompanyNumForView())
                && !GenericValidator.isDouble(enterpriseInfo.getSubordinateCompanyNumForView())) {
            errorsMap.put("subordinateCompanyNumForView", "您输入的下属企业数格式错误，须为数字");
        }
        
        if (!GenericValidator.isBlankOrNull(enterpriseInfo.getEnterpriseRegisterDatetimeForView())
                && !GenericValidator.isDate(enterpriseInfo.getEnterpriseRegisterDatetimeForView(), Constants.DATE_FORMAT, true)) {
            errorsMap.put("enterpriseRegisterDatetimeForView", "您输入的成立日期数格式错误，须为日期yyyy-mm-dd");
        }
        
        if (GenericValidator.isBlankOrNull(enterpriseInfo.getDataYear())) {
            errorsMap.put("dataYear", "请选择财务信息年度");
        }
        // validate end

        if (!errorsMap.isEmpty()) {
            data.put("errors", errorsMap);
            struct.setStatusToFail();
        } else {
            // update enterpriseinfo
            try {
                enterpriseInfoService.updateEnterpriseInfoByMemberId(enterpriseInfo, memberId);
                applyStatusService.updateStep2Status(true, ShortURL.decode(member));
                struct.setStatusToSuccess();
            } catch (Exception e) {
                struct.setMessage("系统异常，请重试");
                struct.setStatusToError();

                e.printStackTrace();
            }
        }

        struct.setData(data);
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, struct);

        return out.toString(Constants.ENCODING_UTF_8);
    }

}
