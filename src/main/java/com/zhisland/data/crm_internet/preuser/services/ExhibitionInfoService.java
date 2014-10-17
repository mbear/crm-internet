/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhisland.data.crm_internet.preuser.dtos.ExhibitionInfo;
import com.zhisland.data.crm_internet.preuser.mappers.ExhibitionInfoMapper;

/**
 * @author muzongyan
 *
 */
@Service
public class ExhibitionInfoService {

    @Autowired
    private ExhibitionInfoMapper exhibitionInfoMapper;

    public ExhibitionInfo findExhibitionInfoByMemberId(int memberId) throws Exception {
        return exhibitionInfoMapper.findExhibitionInfoByMemberId(memberId);
    }

    public void updateExhibitionInfoByMemberId(ExhibitionInfo exhibitionInfo, int memberId) throws Exception {
        exhibitionInfoMapper.updateExhibitionInfoByMemberId(exhibitionInfo, memberId);
    }
}
