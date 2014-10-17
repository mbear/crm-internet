/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhisland.data.crm_internet.preuser.dtos.BaseInfo;

/**
 * @author muzongyan
 *
 */
public interface BaseInfoMapper {

    @Select("select c.client_name as clientName, c.client_gender as clientGender,"
            + " c.client_birthday as clientBirthday, c.cardtype as cardtype,"
            + " c.cardnumber as cardnumber, c.commuting_province as commutingProvince,"
            + " c.client_email as clientEmail, c.client_mailingaddress as clientMailingaddress,"
            + " c.education_type as educationType, c.school_name as schoolName,"
            + " c.college_type as collegeType, c.business_college as businessCollege,"
            + " c.client_detail as clientDetail"
            + " from client_info as c"
            + " where member_id=#{memberId}")
    public BaseInfo findBaseInfoByMemberId(@Param("memberId") int memberId) throws Exception;
    
    @Update("UPDATE client_info c SET c.client_gender = #{baseInfo.clientGender},"
            + " c.client_birthday = #{baseInfo.clientBirthday}, c.cardtype = #{baseInfo.cardtype},"
            + " c.cardnumber = #{baseInfo.cardnumber}, c.commuting_province = #{baseInfo.commutingProvince},"
            + " c.client_email = #{baseInfo.clientEmail}, c.client_mailingaddress = #{baseInfo.clientMailingaddress},"
            + " c.education_type = #{baseInfo.educationType}, c.school_name = #{baseInfo.schoolName},"
            + " c.college_type = #{baseInfo.collegeType}, c.business_college = #{baseInfo.businessCollege},"
            + " c.client_detail = #{baseInfo.clientDetail}"
            + " WHERE c.member_id = #{memberId}")
    public void updateBaseInfoByMemberId(@Param("baseInfo") BaseInfo baseInfo, @Param("memberId") int memberId) throws Exception;
}
