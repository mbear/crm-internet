/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.services;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhisland.data.crm_internet.preuser.dtos.BaseInfo;
import com.zhisland.data.crm_internet.preuser.mappers.BaseInfoMapper;
import com.zhisland.data.crm_internet.utils.Constants;

/**
 * @author muzongyan
 *
 */
@Service
public class BaseInfoService {

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    public BaseInfo findBaseInfoByMemberId(int memberId) throws Exception {
        BaseInfo baseinfo = baseInfoMapper.findBaseInfoByMemberId(memberId);
        if (baseinfo.getClientBirthday() != null) {
            baseinfo.setClientBirthdayForView(new SimpleDateFormat(Constants.DATE_FORMAT).format(baseinfo
                    .getClientBirthday()));
        }

        return baseinfo;
    }

    public void updateBaseInfoByMemberId(BaseInfo baseInfo, int memberId) throws Exception {
        baseInfo.setClientBirthday(Date.valueOf(baseInfo.getClientBirthdayForView()));

        baseInfoMapper.updateBaseInfoByMemberId(baseInfo, memberId);
    }
}
