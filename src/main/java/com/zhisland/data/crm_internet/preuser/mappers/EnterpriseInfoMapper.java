/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.zhisland.data.crm_internet.preuser.dtos.EnterpriseInfo;

/**
 * @author muzongyan
 *
 */
public interface EnterpriseInfoMapper {

    @Select("SELECT c.client_position AS clientPosition,"
            + " e.enterpirse_id AS enterpriseId,"
            + " e.enterprice_cn_name AS enterpriceCnName, e.is_public_company AS isPublicCompany,"
            + " e.stock_code AS stockCode, e.stock_code_two AS stockCodeTwo,"
            + " e.stock_code_three AS stockCodeThree, e.gopublic_address AS gopublicAddress,"
            + " e.gopublic_address_two AS gopublicAddressTwo, e.gopublic_address_three AS gopublicAddressThree,"
            + " e.announced_date AS announcedDate, e.announced_date_two AS announcedDateTwo,"
            + " e.announced_date_three AS announcedDateThree, e.enterprise_main_industry AS enterpriseMainIndustry, e.industry AS industry,"
            + " e.enterprise_staff_num AS enterpriseStaffNum, e.enterprise_nature AS enterpriseNature,"
            + " e.enterprise_divide AS enterpriseDivide, e.enterprise_province AS enterpriseProvince,"
            + " e.enterprise_city AS enterpriseCity, e.register_address AS registerAddress,"
            + " e.enterprise_register_datetime AS enterpriseRegisterDatetime, e.core_business AS coreBusiness,"
            + " e.enterprise_profile AS enterpriseProfile, ex.subordinate_company_num AS subordinateCompanyNum,"
            + " ex.extend_id AS extendId,"
            + " ex.main_market AS mainMarket, ex.sales_amount AS salesAmount,"
            + " ex.sales_growth AS salesGrowth, ex.pay_taxes_amount AS payTaxesAmount,"
            + " ex.taxes_growth AS taxesGrowth, ex.asset_amount AS assetAmount, ex.asset_growth AS assetGrowth, ex.data_year AS dataYear"
            + " FROM client_info c"
            + " LEFT OUTER JOIN enterprise_info e ON e.member_id = c.member_id"
            + " LEFT OUTER JOIN enterprise_extend ex ON ex.enterpirse_id = e.enterpirse_id AND ex.member_id = c.member_id"
            + " WHERE c.member_id = #{memberId} ORDER BY ex.extend_id LIMIT 1")
    public EnterpriseInfo findEnterpriseInfoByMemberId(@Param("memberId") int memberId) throws Exception;

    @Update("UPDATE client_info c, enterprise_info e, enterprise_extend ex"
            + " SET c.client_position = #{enterpriseInfo.clientPosition},"
            + " e.enterprice_cn_name = #{enterpriseInfo.enterpriceCnName},"
            + " e.enterprise_newturnover = #{enterpriseInfo.enterpriseNewturnover},"
            + " e.is_public_company = #{enterpriseInfo.isPublicCompany},"
            + " e.stock_code = #{enterpriseInfo.stockCode},"
            + " e.stock_code_two = #{enterpriseInfo.stockCodeTwo},"
            + " e.stock_code_three = #{enterpriseInfo.stockCodeThree},"
            + " e.gopublic_address = #{enterpriseInfo.gopublicAddress},"
            + " e.gopublic_address_two = #{enterpriseInfo.gopublicAddressTwo},"
            + " e.gopublic_address_three = #{enterpriseInfo.gopublicAddressThree},"
            + " e.announced_date = #{enterpriseInfo.announcedDate},"
            + " e.announced_date_two = #{enterpriseInfo.announcedDateTwo},"
            + " e.announced_date_three = #{enterpriseInfo.announcedDateThree},"
            + " e.enterprise_main_industry = #{enterpriseInfo.enterpriseMainIndustry},"
            + " e.industry = #{enterpriseInfo.industry},"
            + " e.enterprise_staff_num = #{enterpriseInfo.enterpriseStaffNum},"
            + " e.enterprise_nature = #{enterpriseInfo.enterpriseNature},"
            + " e.enterprise_divide = #{enterpriseInfo.enterpriseDivide},"
            + " e.enterprise_province = #{enterpriseInfo.enterpriseProvince},"
            + " e.enterprise_city = #{enterpriseInfo.enterpriseCity},"
            + " e.register_address = #{enterpriseInfo.registerAddress},"
            + " e.enterprise_register_datetime = #{enterpriseInfo.enterpriseRegisterDatetime},"
            + " e.core_business = #{enterpriseInfo.coreBusiness},"
            + " e.enterprise_profile = #{enterpriseInfo.enterpriseProfile},"
            + " ex.subordinate_company_num = #{enterpriseInfo.subordinateCompanyNum},"
            + " ex.main_market = #{enterpriseInfo.mainMarket},"
            + " ex.sales_amount = #{enterpriseInfo.salesAmount},"
            + " ex.sales_growth = #{enterpriseInfo.salesGrowth},"
            + " ex.pay_taxes_amount = #{enterpriseInfo.payTaxesAmount},"
            + " ex.taxes_growth = #{enterpriseInfo.taxesGrowth},"
            + " ex.asset_amount = #{enterpriseInfo.assetAmount},"
            + " ex.asset_growth = #{enterpriseInfo.assetGrowth},"
            + " ex.data_year = #{enterpriseInfo.dataYear}"
            + " WHERE c.member_id = #{memberId} AND e.enterpirse_id = #{enterpriseInfo.enterpriseId} AND ex.extend_id = #{enterpriseInfo.extendId}")
    public void updateEnterpriseInfoByMemberId(@Param("enterpriseInfo") EnterpriseInfo enterpriseInfo,
            @Param("memberId") int memberId) throws Exception;

    @Insert("INSERT INTO enterprise_extend(enterpirse_id, member_id) VALUES (#{enterpriseinfo.enterpriseId}, #{enterpriseinfo.memberId})")
    @SelectKey(statementType=StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() as extendId", before = false, keyProperty = "enterpriseinfo.extendId", resultType = int.class)
    public void insertEnterpriseExtendInfo(@Param("enterpriseinfo") EnterpriseInfo enterpriseinfo) throws Exception;
}
