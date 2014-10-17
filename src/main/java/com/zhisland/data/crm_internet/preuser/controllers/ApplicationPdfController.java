/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zhisland.data.crm_internet.preuser.dtos.BaseInfo;
import com.zhisland.data.crm_internet.preuser.services.BaseInfoService;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/preuser")
public class ApplicationPdfController {

    @Autowired
    private BaseInfoService baseInfoService;

    /**
     * 下载入岛申请表pdf
     * 
     * @param member
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/application", method = RequestMethod.GET)
    public ModelAndView showSuccessPage(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());

        Map<String, Object> modelMap = new HashMap<String, Object>();
        BaseInfo baseinfo = baseInfoService.findBaseInfoByMemberId(memberId);
        List<BaseInfo> list = new ArrayList<BaseInfo>();
        list.add(baseinfo);
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        modelMap.put("applyblank", jrDataSource);

        return new ModelAndView("applyBlankPdfReport", modelMap);
    }
}
