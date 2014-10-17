/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhisland.data.crm_internet.preuser.dtos.ExhibitionInfo;

/**
 * @author muzongyan
 *
 */
public interface ExhibitionInfoMapper {

    @Select("SELECT c.member_id AS memberId, c.socialposition AS socialposition,"
            + " e.enterpirse_id AS enterpriseId, e.attention_industry AS attentionIndustry,"
            + " e.enterprise_honor AS enterpriseHonor, z.personal_experience AS personalExperience,"
            + " z.social_circle AS socialCircle, z.freetimeactivities AS freetimeactivities,"
            + " z.expect AS expect, z.personal_honor AS personalHonor"
            + " FROM client_info c"
            + " INNER JOIN zhd_member_extend_information z ON c.member_id = z.member_id"
            + " LEFT OUTER JOIN enterprise_info e ON e.member_id = c.member_id WHERE c.member_id = #{memberId} limit 1")
    public ExhibitionInfo findExhibitionInfoByMemberId(@Param("memberId") int memberId) throws Exception;

     @Update("UPDATE client_info c"
             + " INNER JOIN zhd_member_extend_information z ON c.member_id = z.member_id"
             + " LEFT OUTER JOIN enterprise_info e ON e.member_id = c.member_id"
             + " SET c.socialposition = #{exhibitionInfo.socialposition},"
             + " e.attention_industry = #{exhibitionInfo.attentionIndustry},"
             + " e.enterprise_honor = #{exhibitionInfo.enterpriseHonor},"
             + " z.personal_experience = #{exhibitionInfo.personalExperience},"
             + " z.social_circle = #{exhibitionInfo.socialCircle},"
             + " z.freetimeactivities = #{exhibitionInfo.freetimeactivities},"
             + " z.expect = #{exhibitionInfo.expect},"
             + " z.personal_honor = #{exhibitionInfo.personalHonor}"
             + " WHERE c.member_id = #{memberId}")
     public void updateExhibitionInfoByMemberId(@Param("exhibitionInfo") ExhibitionInfo exhibitionInfo, @Param("memberId") int memberId) throws Exception;
}
