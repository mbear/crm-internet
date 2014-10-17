/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhisland.data.crm_internet.preuser.dtos.ApplyStatus;

/**
 * @author muzongyan
 *
 */
public interface ApplyStatusMapper {
    
    @Select("SELECT member_id AS memberId, step1_status AS step1Status,"
            + " step2_status AS step2Status, step3_status AS step3Status,"
            + " step4_status AS step4Status, is_submit AS isSubmit"
            + " FROM client_apply_status"
            + " WHERE is_valid = 1 AND id =#{id} ")
    public ApplyStatus getApplyStatus(@Param("id") int id) throws Exception;

    @Update("update client_apply_status set step1_status = #{status} where id = #{id}")
    public void updateStep1Status(@Param("status") boolean status, @Param("id") int id) throws Exception;
    
    @Update("update client_apply_status set step2_status = #{status} where id = #{id}")
    public void updateStep2Status(@Param("status") boolean status, @Param("id") int id) throws Exception;
    
    @Update("update client_apply_status set step3_status = #{status} where id = #{id}")
    public void updateStep3Status(@Param("status") boolean status, @Param("id") int id) throws Exception;
    
    @Update("update client_apply_status set step4_status = #{status} where id = #{id}")
    public void updateStep4Status(@Param("status") boolean status, @Param("id") int id) throws Exception;
    
    @Update("update client_apply_status set is_submit = #{submit} where id = #{id}")
    public void submit(@Param("submit") boolean submit, @Param("id") int id) throws Exception;
}
