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

import com.zhisland.data.crm_internet.data_dict.services.DataDictService;
import com.zhisland.data.crm_internet.preuser.dtos.ApplyStatus;
import com.zhisland.data.crm_internet.preuser.dtos.ContactInfo;
import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.preuser.services.ContactInfoService;
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
public class ContactInfoController {

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private ContactInfoService contactInfoService;

    @Autowired
    private ApplyStatusService applyStatusService;

    /**
     * 显示联系信息
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/contact", method = RequestMethod.GET)
    public ModelAndView showContactInfo(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        ContactInfo contactInfo = contactInfoService.findContactInfoByMemberId(memberId);
        
        if (StringUtils.isBlank(contactInfo.getReterenceGender())) {
            contactInfo.setReterenceGender(Constants.GENDER_DEFAULT);
        }
        
        if (StringUtils.isBlank(contactInfo.getSecritriceGender())) {
            contactInfo.setSecritriceGender(Constants.GENDER_DEFAULT);
        }
        
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("contactInfo", contactInfo);

        return new ModelAndView("/preuser/contactInfo", modelMap);
    }

    /**
     * 更新联系信息
     * 
     * @param member
     * @param contactInfo
     * @param request
     * @param response
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/{member}/contact", method = RequestMethod.POST)
    @ResponseBody
    public String postContactInfo(@PathVariable String member, ContactInfo contactInfo, HttpServletRequest request,
            HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {

        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        JsonStruct struct = new JsonStruct();
        JsonData data = new JsonData();
        Map<String, String> errorsMap = new HashMap<String, String>();

        // validate start
        if (GenericValidator.isBlankOrNull(contactInfo.getSecritriceName())) {
            errorsMap.put("secritriceName", "请填写日常联系人的姓名");
        }

        if (!GenericValidator.maxLength(contactInfo.getSecritriceName(), 50)) {
            errorsMap.put("secritriceName", "日常联系人姓名输入过长，最多可输入50字");
        }

        if (GenericValidator.isBlankOrNull(contactInfo.getSecritriceTitle())) {
            errorsMap.put("secritriceTitle", "请填写日常联系人的职务");
        }

        if (!GenericValidator.maxLength(contactInfo.getSecritriceTitle(), 50)) {
            errorsMap.put("secritriceTitle", "联系人职务输入过长，最多可输入50字");
        }

        if (GenericValidator.isBlankOrNull(contactInfo.getSecritriceMobile())) {
            errorsMap.put("secritriceMobile", "请填写日常联系人的手机号码");
        }

        if (contactInfo.getSecritriceMobile().length() != 11) {
            errorsMap.put("secritriceMobile", "您输入的联系人手机号码格式错误");
        }

        if (!GenericValidator.isLong(contactInfo.getSecritriceMobile())) {
            errorsMap.put("secritriceMobile", "您输入的联系人手机号码格式错误");
        }

        if (!GenericValidator.isBlankOrNull(contactInfo.getSecritriceEmail())
                && !GenericValidator.isEmail(contactInfo.getSecritriceEmail())) {
            errorsMap.put("secritriceEmail", "您输入的联系人电子邮件格式错误");
        }

        if (GenericValidator.isBlankOrNull(contactInfo.getReterenceName())) {
            errorsMap.put("reterenceName", "请填写入岛推荐人的姓名");
        }

        if (!GenericValidator.maxLength(contactInfo.getReterenceName(), 50)) {
            errorsMap.put("reterenceName", "推荐人姓名输入过长，最多可输入50字");
        }

        if (GenericValidator.isBlankOrNull(contactInfo.getReterenceMobile())) {
            errorsMap.put("reterenceMobile", "请填写入岛推荐人的手机号码");
        }

        if (contactInfo.getReterenceMobile().length() != 11) {
            errorsMap.put("reterenceMobile", "您输入的推荐人手机号码格式错误");
        }

        if (!GenericValidator.isLong(contactInfo.getReterenceMobile())) {
            errorsMap.put("reterenceMobile", "您输入的推荐人手机号码格式错误");
        }

        if (!GenericValidator.maxLength(contactInfo.getReterenceEnterprise(), 100)) {
            errorsMap.put("reterenceEnterprise", "推荐人公司名称输入过长，最多可输入100字");
        }

        if (!GenericValidator.maxLength(contactInfo.getReterenceJob(), 50)) {
            errorsMap.put("reterenceJob", "推荐人职务输入过长，最多可输入50字");
        }
        // validate end

        if (!errorsMap.isEmpty()) {
            data.put("errors", errorsMap);
            struct.setStatusToFail();
        } else {
            // update exhibitionInfo
            try {
                contactInfoService.updateContactInfoByMemberId(contactInfo, memberId);
                applyStatusService.updateStep4Status(true, ShortURL.decode(member));

                ApplyStatus applyStatus = applyStatusService.getApplyStatus(member);
                if (!applyStatus.isStep1Status()) {
                    data.put("next", "base");
                } else if (!applyStatus.isStep2Status()) {
                    data.put("next", "enterprise");
                } else if (!applyStatus.isStep3Status()) {
                    data.put("next", "exhibition");
                } else {
                    data.put("next", request.getContextPath() + "/preuser/" + member + "/confirm");
                }

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
