/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhisland.data.crm_internet.preuser.dtos.ContactInfo;

/**
 * @author muzongyan
 *
 */
public interface ContactInfoMapper {

    @Select("SELECT c.member_id AS memberId, c.secritrice_name AS secritriceName,"
            + " c.secritrice_title AS secritriceTitle, c.secritrice_gender AS secritriceGender,"
            + " c.secritrice_mobile AS secritriceMobile, c.secritrice_phone AS secritricePhone,"
            + " c.secritrice_email AS secritriceEmail, c.reterence_name AS reterenceName,"
            + " c.reterence_gender AS reterenceGender, c.reterence_enterprise AS reterenceEnterprise,"
            + " c.reterence_job AS reterenceJob, c.reterence_mobile AS reterenceMobile, z.reterence_is_member AS reterenceIsMember"
            + " FROM client_info c"
            + " INNER JOIN zhd_member_extend_information z ON c.member_id = z.member_id"
            + " WHERE c.member_id = #{memberId};")
    public ContactInfo findContactInfoByMemberId(@Param("memberId") int memberId) throws Exception;

    @Update("UPDATE client_info c"
            + " INNER JOIN zhd_member_extend_information z ON c.member_id = z.member_id"
            + " SET c.secritrice_name = #{contactInfo.secritriceName},"
            + " c.secritrice_title = #{contactInfo.secritriceTitle},"
            + " c.secritrice_gender = #{contactInfo.secritriceGender},"
            + " c.secritrice_mobile = #{contactInfo.secritriceMobile},"
            + " c.secritrice_phone = #{contactInfo.secritricePhone},"
            + " c.secritrice_email = #{contactInfo.secritriceEmail},"
            + " c.reterence_name = #{contactInfo.reterenceName},"
            + " c.reterence_gender = #{contactInfo.reterenceGender},"
            + " c.reterence_enterprise = #{contactInfo.reterenceEnterprise},"
            + " c.reterence_job = #{contactInfo.reterenceJob},"
            + " c.reterence_mobile = #{contactInfo.reterenceMobile},"
            + " z.reterence_is_member = #{contactInfo.reterenceIsMember}"
            + " WHERE c.member_id = #{memberId}")
    public void updateContactInfoByMemberId(@Param("contactInfo") ContactInfo contactInfo,
            @Param("memberId") int memberId) throws Exception;
}
