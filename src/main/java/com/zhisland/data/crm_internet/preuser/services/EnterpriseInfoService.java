/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhisland.data.crm_internet.data_dict.dto.EnterpriseTurnoverScale;
import com.zhisland.data.crm_internet.data_dict.services.DataDictService;
import com.zhisland.data.crm_internet.preuser.dtos.EnterpriseInfo;
import com.zhisland.data.crm_internet.preuser.mappers.EnterpriseInfoMapper;
import com.zhisland.data.crm_internet.utils.Constants;

/**
 * @author muzongyan
 *
 */
@Service
public class EnterpriseInfoService {

    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    @Autowired
    private DataDictService dataDictService;

    public EnterpriseInfo findEnterpriseInfoByMemberId(int memberId) throws Exception {
        EnterpriseInfo enterpriseInfo = enterpriseInfoMapper.findEnterpriseInfoByMemberId(memberId);
        enterpriseInfo.setSubordinateCompanyNumForView(String.valueOf(enterpriseInfo.getSubordinateCompanyNum()));

        if (enterpriseInfo.getEnterpriseRegisterDatetime() != null) {
            enterpriseInfo.setEnterpriseRegisterDatetimeForView(new SimpleDateFormat(Constants.DATE_FORMAT)
                    .format(enterpriseInfo.getEnterpriseRegisterDatetime()));
        }

        return enterpriseInfo;
    }

    public void updateEnterpriseInfoByMemberId(EnterpriseInfo enterpriseInfo, int memberId) throws Exception {
        // 根据填写的企业上年度营业收入，设置企业营业额
        double salesAmount = Double.parseDouble(enterpriseInfo.getSalesAmount()) * 10000;
        TreeSet<EnterpriseTurnoverScale> etsSet = dataDictService.getEnterpriseTurnovers();
        for (EnterpriseTurnoverScale ets : etsSet) {
            if (salesAmount >= ets.getMin() && salesAmount < ets.getMax()) {
                enterpriseInfo.setEnterpriseTurnover(ets.getItemName());
                enterpriseInfo.setEnterpriseNewturnover(ets.getItemId());
            }
        }

        if (StringUtils.isBlank(enterpriseInfo.getSubordinateCompanyNumForView())) {
            enterpriseInfo.setSubordinateCompanyNum(0);
        } else {
            enterpriseInfo.setSubordinateCompanyNum(Integer.parseInt(enterpriseInfo.getSubordinateCompanyNumForView()));
        }

        if (StringUtils.isBlank(enterpriseInfo.getEnterpriseRegisterDatetimeForView())) {
            enterpriseInfo.setEnterpriseRegisterDatetime(null);
        } else {
            enterpriseInfo.setEnterpriseRegisterDatetime(Date.valueOf(enterpriseInfo
                    .getEnterpriseRegisterDatetimeForView()));
        }

        if (enterpriseInfo.getExtendId() == 0) {
            enterpriseInfo.setMemberId(memberId);
            enterpriseInfoMapper.insertEnterpriseExtendInfo(enterpriseInfo);
//            enterpriseInfo.setExtendId(id);
        }

        enterpriseInfoMapper.updateEnterpriseInfoByMemberId(enterpriseInfo, memberId);
    }
}
