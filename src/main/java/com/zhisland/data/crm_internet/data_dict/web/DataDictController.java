/**
 * 
 */
package com.zhisland.data.crm_internet.data_dict.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhisland.data.crm_internet.data_dict.services.DataDictService;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/datadict")
public class DataDictController {

    @Autowired
    private DataDictService dataDictService;

    @ResponseBody
    @RequestMapping(value = "/businessColleges", method = RequestMethod.GET)
    public List<String> getAllbusinessColleges(HttpServletRequest request, HttpServletResponse response) {

        return dataDictService.getAllBusinessCollegeStrList();
    }
}
