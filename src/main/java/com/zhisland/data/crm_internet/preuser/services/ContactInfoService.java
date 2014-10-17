/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhisland.data.crm_internet.preuser.dtos.ContactInfo;
import com.zhisland.data.crm_internet.preuser.mappers.ContactInfoMapper;

/**
 * @author muzongyan
 *
 */
@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoMapper contactInfoMapper;

    public ContactInfo findContactInfoByMemberId(int memberId) throws Exception {
        return contactInfoMapper.findContactInfoByMemberId(memberId);
    }

    public void updateContactInfoByMemberId(ContactInfo contactInfo, int memberId) throws Exception {
        contactInfoMapper.updateContactInfoByMemberId(contactInfo, memberId);
    }
}
