/**
 * 
 */
package com.zhisland.data.crm_internet.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhisland.data.crm_internet.preuser.dtos.ApplyStatus;
import com.zhisland.data.crm_internet.preuser.services.ApplyStatusService;
import com.zhisland.data.crm_internet.utils.Constants;

/**
 * @author muzongyan
 *
 */
public class PreuserInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ApplyStatusService applyStatusService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        String[] array = StringUtils.split(servletPath, Constants.SLASH);
        String member = StringUtils.EMPTY;
        if (array.length >= 2) {
            member = array[1];
        } else {
            return false;
        }

        ApplyStatus status = applyStatusService.getApplyStatus(member);
        if (status == null) {
            return false;
        }

        request.setAttribute("memberId", status.getMemberId());

        String successUrl = Constants.SLASH + array[0] + Constants.SLASH + member + "/success";
        String pdfUrl = Constants.SLASH + array[0] + Constants.SLASH + member + "/application.pdf";
        if (!status.isSubmit() && StringUtils.equals(servletPath, successUrl)) {
            response.sendRedirect(request.getContextPath() + Constants.SLASH + array[0] + Constants.SLASH + member);
            return false;
        }
        
        if (status.isSubmit() && StringUtils.equals(servletPath, pdfUrl)) {
            return true;
        }

        if (status.isSubmit() && !StringUtils.equals(servletPath, successUrl)) {
            response.sendRedirect(request.getContextPath() + successUrl);
            return false;
        }

        return true;
    }

}
