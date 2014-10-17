/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

import com.zhisland.data.crm_internet.data_dict.services.DataDictService;
import com.zhisland.data.crm_internet.preuser.dtos.ExhibitionInfo;
import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.preuser.services.ExhibitionInfoService;
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
public class ExhibitionInfoController {

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private ExhibitionInfoService exhibitionInfoService;

    @Autowired
    private ApplyStatusService applyStatusService;

    /**
     * 显示展示信息
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/exhibition", method = RequestMethod.GET)
    public ModelAndView showExhibitionInfo(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        ExhibitionInfo exhibitionInfo = exhibitionInfoService.findExhibitionInfoByMemberId(memberId);

        List<String> tempList;

        String[] aiArray = StringUtils.split(exhibitionInfo.getAttentionIndustry(), Constants.COMMA);
        List<String> aiDataDictList = dataDictService.getEnterpriseIndustryStrList();
        exhibitionInfo.setAttentionIndustryForView(aiArray);
        if (aiArray != null) {
            tempList = new ArrayList<String>(Arrays.asList(aiArray));
            tempList.removeAll(aiDataDictList);

            exhibitionInfo.setAttentionIndustryForViewOther(StringUtils.join(tempList, Constants.COMMA));
        }

        String[] fiaArray = StringUtils.split(exhibitionInfo.getFreetimeactivities(), Constants.COMMA);
        List<String> fiaDataDictList = dataDictService.getAllFreetimeActivitieStrList();
        exhibitionInfo.setFreetimeactivitiesForView(fiaArray);
        if (fiaArray != null) {
            tempList = new ArrayList<String>(Arrays.asList(fiaArray));
            tempList.removeAll(fiaDataDictList);
            exhibitionInfo.setFreetimeactivitiesForViewOther(StringUtils.join(tempList, Constants.COMMA));
        }

        String[] peArray = StringUtils.split(exhibitionInfo.getPersonalExperience(), Constants.COMMA);
        List<String> peDataDictList = dataDictService.getAllPersonalExperienceStrList();
        exhibitionInfo.setPersonalExperienceForView(peArray);
        if (peArray != null) {
            tempList = new ArrayList<String>(Arrays.asList(peArray));
            tempList.removeAll(peDataDictList);
            exhibitionInfo.setPersonalExperienceForViewOther(StringUtils.join(tempList, Constants.COMMA));
        }

        String[] scArray = StringUtils.split(exhibitionInfo.getSocialCircle(), Constants.COMMA);
        List<String> scDataDictList = dataDictService.getAllSocialCircleStrList();
        exhibitionInfo.setSocialCircleForView(scArray);
        if (scArray != null) {
            tempList = new ArrayList<String>(Arrays.asList(scArray));
            tempList.removeAll(scDataDictList);
            exhibitionInfo.setSocialCircleForViewOther(StringUtils.join(tempList, Constants.COMMA));
        }

        String[] exArray = StringUtils.split(exhibitionInfo.getExpect(), Constants.COMMA);
        List<String> exDataDictList = dataDictService.getExpectStrList();
        exhibitionInfo.setExpectForView(exArray);
        if (exArray != null) {
            tempList = new ArrayList<String>(Arrays.asList(exArray));
            tempList.removeAll(exDataDictList);
            exhibitionInfo.setExpectForViewOther(StringUtils.join(tempList, Constants.COMMA));
        }

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("exhibitionInfo", exhibitionInfo);
        modelMap.put("attentionIndustries", aiDataDictList);
        modelMap.put("personalExperiences", peDataDictList);
        modelMap.put("socialCircles", scDataDictList);
        modelMap.put("freetimeactivities", fiaDataDictList);
        modelMap.put("expects", exDataDictList);

        return new ModelAndView("/preuser/exhibitionInfo", modelMap);
    }

    /**
     * 更新展示信息
     * 
     * @param member
     * @param exhibitionInfo
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/{member}/exhibition", method = RequestMethod.POST)
    @ResponseBody
    public String postExhibitionInfo(@PathVariable String member, ExhibitionInfo exhibitionInfo,
            HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException,
            JsonMappingException, IOException {
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        JsonStruct struct = new JsonStruct();
        JsonData data = new JsonData();
        Map<String, String> errorsMap = new HashMap<String, String>();

        // validate start
        if (GenericValidator.isBlankOrNull(exhibitionInfo.getSocialCircle())) {
            errorsMap.put("socialCircle", "请选择申请人已加入的商会/俱乐部/校友会");
        }

        if (GenericValidator.isBlankOrNull(exhibitionInfo.getSocialposition())) {
            errorsMap.put("socialposition", "请填写申请人的社会职务，没有可填写无");
        }

        if (GenericValidator.isBlankOrNull(exhibitionInfo.getAttentionIndustry())) {
            errorsMap.put("attentionIndustry", "请选择申请人关注的行业");
        }

        if (GenericValidator.isBlankOrNull(exhibitionInfo.getPersonalExperience())) {
            errorsMap.put("personalExperience", "请选择申请人的个人擅长或经验");
        }

        if (GenericValidator.isBlankOrNull(exhibitionInfo.getFreetimeactivities())) {
            errorsMap.put("freetimeactivities", "请选择申请人的兴趣爱好");
        }

        if (GenericValidator.isBlankOrNull(exhibitionInfo.getExpect())) {
            errorsMap.put("expect", "请填写加入正和岛的期望，没有可填写无");
        }
        // validate end

        if (!errorsMap.isEmpty()) {
            data.put("errors", errorsMap);
            struct.setStatusToFail();
        } else {
            // update exhibitionInfo
            try {
                exhibitionInfoService.updateExhibitionInfoByMemberId(exhibitionInfo, memberId);
                applyStatusService.updateStep3Status(true, ShortURL.decode(member));
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
