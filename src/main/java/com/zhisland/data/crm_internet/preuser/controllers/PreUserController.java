/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.utils.ShortURL;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/preuser")
public class PreUserController {
    
    @Autowired
    private ApplyStatusService applyStatusService;

    /**
     * 显示入岛申请表 memberEncode => memberId
     * 
     * @param member
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}", method = RequestMethod.GET)
    public ModelAndView showPreUserBaseInfo(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());
        
        return new ModelAndView("/preuser/index", "memberId", memberId);
    }

    /**
     * 完成确认页面
     * 
     * @param member
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/{member}/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmPage(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) {
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());
        
        return new ModelAndView("/preuser/confirm", "memberId", memberId);
    }
    
    /**
     * 确认提交
     * 
     * @param member
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{member}/ido", method = RequestMethod.GET)
    public String confirmSubmit(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        applyStatusService.submit(true, ShortURL.decode(member));
        return "redirect:/preuser/" + member + "/success";
    }
    
    /**
     * 成功提交页面
     * 
     * @param member
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/{member}/success", method = RequestMethod.GET)
    public ModelAndView showSuccessPage(@PathVariable String member, HttpServletRequest request,
            HttpServletResponse response) {
        int memberId = Integer.parseInt(request.getAttribute("memberId").toString());
        
        return new ModelAndView("/preuser/success", "memberId", memberId);
    }
}
