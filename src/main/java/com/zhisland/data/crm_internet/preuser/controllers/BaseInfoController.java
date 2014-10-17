/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.zhisland.data.crm_internet.data_dict.services.DataDictService;
import com.zhisland.data.crm_internet.preuser.dtos.BaseInfo;
import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.preuser.services.BaseInfoService;
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
public class BaseInfoController {

    @Autowired
    private BaseInfoService baseInfoService;

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private ApplyStatusService applyStatusService;

    /**
     * 显示个人基本信息
     * 
     * @param member
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/base", method = RequestMethod.GET)
    public ModelAndView showBaseInfo(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        BaseInfo baseInfo = baseInfoService.findBaseInfoByMemberId(memberId);

        if (StringUtils.isBlank(baseInfo.getClientGender())) {
            baseInfo.setClientGender(Constants.GENDER_DEFAULT);
        }

        Gson gson = new Gson();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("baseInfo", baseInfo);
        modelMap.put("cardTypes", dataDictService.getCardTypes());
        modelMap.put("provinceCity", gson.toJson(dataDictService.getAllProvinces()));
        modelMap.put("educationTypes", dataDictService.getEducationTypesExceptMBA());
        modelMap.put("schoolNames", gson.toJson(dataDictService.getAllSchoolNameStrList()));
        modelMap.put("collegeTypes", dataDictService.getAllCollegeTypes());
        modelMap.put("businessColleges", gson.toJson(dataDictService.getAllBusinessCollegeStrList()));

        return new ModelAndView("/preuser/baseInfo", modelMap);
    }

    /**
     * 更新个人基本信息
     * 
     * @param baseInfo
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    @RequestMapping(value = "/{member}/base", method = RequestMethod.POST)
    @ResponseBody
    public String postBaseInfo(@PathVariable String member, BaseInfo baseInfo, HttpServletRequest request,
            HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        JsonStruct struct = new JsonStruct();
        JsonData data = new JsonData();
        Map<String, String> errorsMap = new HashMap<String, String>();

        // validate start
        if (baseInfo.getClientBirthdayForView() == null) {
            errorsMap.put("clientBirthdayForView", "请填写申请人出生日期");
        }

        if (!GenericValidator.isDate(baseInfo.getClientBirthdayForView(), Constants.DATE_FORMAT, true)) {
            errorsMap.put("clientBirthdayForView", "您输入的出生日期格式错误，须为日期yyyy-mm-dd");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getCardtype())) {
            errorsMap.put("cardtype", "请选择证件类型");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getCardnumber())) {
            errorsMap.put("cardnumber", "请填写申请人证件号码");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getCommutingProvince())) {
            errorsMap.put("commutingProvince", "请选择申请人常来往的城市");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getClientEmail())) {
            errorsMap.put("clientEmail", "请填写申请人的电子邮件地址");
        } else if (!GenericValidator.isEmail(baseInfo.getClientEmail())) {
            errorsMap.put("clientEmail", "您输入的电子邮件格式不正确");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getClientMailingaddress())) {
            errorsMap.put("clientMailingaddress", "请填写联系地址");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getEducationType())) {
            errorsMap.put("educationType", "请选择毕业院校学历信息");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getSchoolName())) {
            errorsMap.put("schoolName", "请填写毕业院校");
        }

        if (GenericValidator.isBlankOrNull(baseInfo.getCollegeType())) {
            errorsMap.put("collegeType", "请选择商学院学历信息，没有请选择无");
        }

        if (!GenericValidator.isBlankOrNull(baseInfo.getCollegeType())) {
            if (StringUtils.equals(baseInfo.getCollegeType(), String.valueOf(1107))) {
                baseInfo.setBusinessCollege(StringUtils.EMPTY);
            } else if (GenericValidator.isBlankOrNull(baseInfo.getBusinessCollege())) {
                errorsMap.put("businessCollege", "请填写商学院");
            }
        }

        if (!GenericValidator.maxLength(baseInfo.getClientDetail(), 300)) {
            errorsMap.put("clientDetail", "自我介绍输入过长，最多可输入300字");
        }
        // validate end

        if (!errorsMap.isEmpty()) {
            data.put("errors", errorsMap);
            struct.setStatusToFail();
        } else {
            // update baseinfo
            try {
                baseInfoService.updateBaseInfoByMemberId(baseInfo, memberId);
                applyStatusService.updateStep1Status(true, ShortURL.decode(member));
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
