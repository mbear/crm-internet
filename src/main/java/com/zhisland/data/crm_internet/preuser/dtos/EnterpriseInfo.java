/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.dtos;

import java.sql.Date;

/**
 * @author muzongyan
 *
 */
public class EnterpriseInfo {

    private int memberId;

    private int enterpriseId;

    private int extendId;

    // 企业名称
    private String enterpriceCnName;

    // 企业营业额
    private String enterpriseTurnover;
    
    // 新企业营业额
    private int enterpriseNewturnover;

    // 职务
    private String clientPosition;

    // 是否上市
    private String isPublicCompany;

    // 股票代码
    private String stockCode;

    // 股票代码2
    private String stockCodeTwo;

    // 股票代码3
    private String stockCodeThree;

    // 上市交易所
    private String gopublicAddress;

    // 上市交易所2
    private String gopublicAddressTwo;

    // 上市交易所3
    private String gopublicAddressThree;

    // 上市时间
    private String announcedDate;

    // 上市时间2
    private String announcedDateTwo;

    // 上市时间3
    private String announcedDateThree;

    // 主营行业
    private String enterpriseMainIndustry;

    // 其他行业
    private String industry;

    // 其他行业 for modal check
    private String[] industryForView;

    // 员工人数
    private String enterpriseStaffNum;

    // 企业性质
    private String enterpriseNature;

    // 企业划分
    private String enterpriseDivide;

    // 企业所在地（省份）
    private String enterpriseProvince;

    private int provinceIdForView;

    // 企业所在地（地市）
    private String enterpriseCity;

    private int cityIdForView;

    // 下属企业数
    private int subordinateCompanyNum;

    private String subordinateCompanyNumForView;

    // 注册地点
    private String registerAddress;

    // 成立日期
    private Date enterpriseRegisterDatetime;

    private String enterpriseRegisterDatetimeForView;

    // 主营业务/产品
    private String coreBusiness;

    // 主要市场
    private String mainMarket;

    // 主要市场 for modal check
    private String[] mainMarketForView;

    // 企业上年度营业收入
    private String salesAmount;

    // 年增长率
    private String salesGrowth;

    // 企业上年度纳税总额
    private String payTaxesAmount;

    // 年增长率
    private String taxesGrowth;

    // 企业上年度资产总额
    private String assetAmount;

    // 年增长率
    private String assetGrowth;

    // 企业介绍
    private String enterpriseProfile;

    // 财务信息年度
    private String dataYear;

    /**
     * @return the enterpriseNewturnover
     */
    public int getEnterpriseNewturnover() {
        return enterpriseNewturnover;
    }

    /**
     * @param enterpriseNewturnover the enterpriseNewturnover to set
     */
    public void setEnterpriseNewturnover(int enterpriseNewturnover) {
        this.enterpriseNewturnover = enterpriseNewturnover;
    }

    /**
     * @return the dataYear
     */
    public String getDataYear() {
        return dataYear;
    }

    /**
     * @param dataYear
     *            the dataYear to set
     */
    public void setDataYear(String dataYear) {
        this.dataYear = dataYear;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     *            the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the enterpriseTurnover
     */
    public String getEnterpriseTurnover() {
        return enterpriseTurnover;
    }

    /**
     * @param enterpriseTurnover
     *            the enterpriseTurnover to set
     */
    public void setEnterpriseTurnover(String enterpriseTurnover) {
        this.enterpriseTurnover = enterpriseTurnover;
    }

    /**
     * @return the enterpriseId
     */
    public int getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * @param enterpriseId
     *            the enterpriseId to set
     */
    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * @return the extendId
     */
    public int getExtendId() {
        return extendId;
    }

    /**
     * @param extendId
     *            the extendId to set
     */
    public void setExtendId(int extendId) {
        this.extendId = extendId;
    }

    /**
     * @return the industryForView
     */
    public String[] getIndustryForView() {
        return industryForView;
    }

    /**
     * @param industryForView
     *            the industryForView to set
     */
    public void setIndustryForView(String[] industryForView) {
        this.industryForView = industryForView;
    }

    /**
     * @return the enterpriceCnName
     */
    public String getEnterpriceCnName() {
        return enterpriceCnName;
    }

    /**
     * @param enterpriceCnName
     *            the enterpriceCnName to set
     */
    public void setEnterpriceCnName(String enterpriceCnName) {
        this.enterpriceCnName = enterpriceCnName;
    }

    /**
     * @return the clientPosition
     */
    public String getClientPosition() {
        return clientPosition;
    }

    /**
     * @param clientPosition
     *            the clientPosition to set
     */
    public void setClientPosition(String clientPosition) {
        this.clientPosition = clientPosition;
    }

    /**
     * @return the isPublicCompany
     */
    public String getIsPublicCompany() {
        return isPublicCompany;
    }

    /**
     * @param isPublicCompany
     *            the isPublicCompany to set
     */
    public void setIsPublicCompany(String isPublicCompany) {
        this.isPublicCompany = isPublicCompany;
    }

    /**
     * @return the stockCode
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * @param stockCode
     *            the stockCode to set
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * @return the stockCodeTwo
     */
    public String getStockCodeTwo() {
        return stockCodeTwo;
    }

    /**
     * @param stockCodeTwo
     *            the stockCodeTwo to set
     */
    public void setStockCodeTwo(String stockCodeTwo) {
        this.stockCodeTwo = stockCodeTwo;
    }

    /**
     * @return the stockCodeThree
     */
    public String getStockCodeThree() {
        return stockCodeThree;
    }

    /**
     * @param stockCodeThree
     *            the stockCodeThree to set
     */
    public void setStockCodeThree(String stockCodeThree) {
        this.stockCodeThree = stockCodeThree;
    }

    /**
     * @return the gopublicAddress
     */
    public String getGopublicAddress() {
        return gopublicAddress;
    }

    /**
     * @param gopublicAddress
     *            the gopublicAddress to set
     */
    public void setGopublicAddress(String gopublicAddress) {
        this.gopublicAddress = gopublicAddress;
    }

    /**
     * @return the gopublicAddressTwo
     */
    public String getGopublicAddressTwo() {
        return gopublicAddressTwo;
    }

    /**
     * @param gopublicAddressTwo
     *            the gopublicAddressTwo to set
     */
    public void setGopublicAddressTwo(String gopublicAddressTwo) {
        this.gopublicAddressTwo = gopublicAddressTwo;
    }

    /**
     * @return the gopublicAddressThree
     */
    public String getGopublicAddressThree() {
        return gopublicAddressThree;
    }

    /**
     * @param gopublicAddressThree
     *            the gopublicAddressThree to set
     */
    public void setGopublicAddressThree(String gopublicAddressThree) {
        this.gopublicAddressThree = gopublicAddressThree;
    }

    /**
     * @return the announcedDate
     */
    public String getAnnouncedDate() {
        return announcedDate;
    }

    /**
     * @param announcedDate
     *            the announcedDate to set
     */
    public void setAnnouncedDate(String announcedDate) {
        this.announcedDate = announcedDate;
    }

    /**
     * @return the announcedDateTwo
     */
    public String getAnnouncedDateTwo() {
        return announcedDateTwo;
    }

    /**
     * @param announcedDateTwo
     *            the announcedDateTwo to set
     */
    public void setAnnouncedDateTwo(String announcedDateTwo) {
        this.announcedDateTwo = announcedDateTwo;
    }

    /**
     * @return the announcedDateThree
     */
    public String getAnnouncedDateThree() {
        return announcedDateThree;
    }

    /**
     * @param announcedDateThree
     *            the announcedDateThree to set
     */
    public void setAnnouncedDateThree(String announcedDateThree) {
        this.announcedDateThree = announcedDateThree;
    }

    /**
     * @return the enterpriseMainIndustry
     */
    public String getEnterpriseMainIndustry() {
        return enterpriseMainIndustry;
    }

    /**
     * @param enterpriseMainIndustry
     *            the enterpriseMainIndustry to set
     */
    public void setEnterpriseMainIndustry(String enterpriseMainIndustry) {
        this.enterpriseMainIndustry = enterpriseMainIndustry;
    }

    /**
     * @return the enterpriseStaffNum
     */
    public String getEnterpriseStaffNum() {
        return enterpriseStaffNum;
    }

    /**
     * @param enterpriseStaffNum
     *            the enterpriseStaffNum to set
     */
    public void setEnterpriseStaffNum(String enterpriseStaffNum) {
        this.enterpriseStaffNum = enterpriseStaffNum;
    }

    /**
     * @return the enterpriseNature
     */
    public String getEnterpriseNature() {
        return enterpriseNature;
    }

    /**
     * @param enterpriseNature
     *            the enterpriseNature to set
     */
    public void setEnterpriseNature(String enterpriseNature) {
        this.enterpriseNature = enterpriseNature;
    }

    /**
     * @return the enterpriseDivide
     */
    public String getEnterpriseDivide() {
        return enterpriseDivide;
    }

    /**
     * @param enterpriseDivide
     *            the enterpriseDivide to set
     */
    public void setEnterpriseDivide(String enterpriseDivide) {
        this.enterpriseDivide = enterpriseDivide;
    }

    /**
     * @return the enterpriseProvince
     */
    public String getEnterpriseProvince() {
        return enterpriseProvince;
    }

    /**
     * @param enterpriseProvince
     *            the enterpriseProvince to set
     */
    public void setEnterpriseProvince(String enterpriseProvince) {
        this.enterpriseProvince = enterpriseProvince;
    }

    /**
     * @return the enterpriseCity
     */
    public String getEnterpriseCity() {
        return enterpriseCity;
    }

    /**
     * @param enterpriseCity
     *            the enterpriseCity to set
     */
    public void setEnterpriseCity(String enterpriseCity) {
        this.enterpriseCity = enterpriseCity;
    }

    /**
     * @return the subordinateCompanyNum
     */
    public int getSubordinateCompanyNum() {
        return subordinateCompanyNum;
    }

    /**
     * @param subordinateCompanyNum
     *            the subordinateCompanyNum to set
     */
    public void setSubordinateCompanyNum(int subordinateCompanyNum) {
        this.subordinateCompanyNum = subordinateCompanyNum;
    }

    /**
     * @return the registerAddress
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * @param registerAddress
     *            the registerAddress to set
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    /**
     * @return the enterpriseRegisterDatetime
     */
    public Date getEnterpriseRegisterDatetime() {
        return enterpriseRegisterDatetime;
    }

    /**
     * @param enterpriseRegisterDatetime
     *            the enterpriseRegisterDatetime to set
     */
    public void setEnterpriseRegisterDatetime(Date enterpriseRegisterDatetime) {
        this.enterpriseRegisterDatetime = enterpriseRegisterDatetime;
    }

    /**
     * @return the coreBusiness
     */
    public String getCoreBusiness() {
        return coreBusiness;
    }

    /**
     * @param coreBusiness
     *            the coreBusiness to set
     */
    public void setCoreBusiness(String coreBusiness) {
        this.coreBusiness = coreBusiness;
    }

    /**
     * @return the mainMarket
     */
    public String getMainMarket() {
        return mainMarket;
    }

    /**
     * @param mainMarket
     *            the mainMarket to set
     */
    public void setMainMarket(String mainMarket) {
        this.mainMarket = mainMarket;
    }

    /**
     * @return the salesAmount
     */
    public String getSalesAmount() {
        return salesAmount;
    }

    /**
     * @param salesAmount
     *            the salesAmount to set
     */
    public void setSalesAmount(String salesAmount) {
        this.salesAmount = salesAmount;
    }

    /**
     * @return the salesGrowth
     */
    public String getSalesGrowth() {
        return salesGrowth;
    }

    /**
     * @param salesGrowth
     *            the salesGrowth to set
     */
    public void setSalesGrowth(String salesGrowth) {
        this.salesGrowth = salesGrowth;
    }

    /**
     * @return the payTaxesAmount
     */
    public String getPayTaxesAmount() {
        return payTaxesAmount;
    }

    /**
     * @param payTaxesAmount
     *            the payTaxesAmount to set
     */
    public void setPayTaxesAmount(String payTaxesAmount) {
        this.payTaxesAmount = payTaxesAmount;
    }

    /**
     * @return the taxesGrowth
     */
    public String getTaxesGrowth() {
        return taxesGrowth;
    }

    /**
     * @param taxesGrowth
     *            the taxesGrowth to set
     */
    public void setTaxesGrowth(String taxesGrowth) {
        this.taxesGrowth = taxesGrowth;
    }

    /**
     * @return the assetAmount
     */
    public String getAssetAmount() {
        return assetAmount;
    }

    /**
     * @param assetAmount
     *            the assetAmount to set
     */
    public void setAssetAmount(String assetAmount) {
        this.assetAmount = assetAmount;
    }

    /**
     * @return the assetGrowth
     */
    public String getAssetGrowth() {
        return assetGrowth;
    }

    /**
     * @param assetGrowth
     *            the assetGrowth to set
     */
    public void setAssetGrowth(String assetGrowth) {
        this.assetGrowth = assetGrowth;
    }

    /**
     * @return the enterpriseProfile
     */
    public String getEnterpriseProfile() {
        return enterpriseProfile;
    }

    /**
     * @param enterpriseProfile
     *            the enterpriseProfile to set
     */
    public void setEnterpriseProfile(String enterpriseProfile) {
        this.enterpriseProfile = enterpriseProfile;
    }

    /**
     * @return the industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     *            the industry to set
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * @return the mainMarketForView
     */
    public String[] getMainMarketForView() {
        return mainMarketForView;
    }

    /**
     * @param mainMarketForView
     *            the mainMarketForView to set
     */
    public void setMainMarketForView(String[] mainMarketForView) {
        this.mainMarketForView = mainMarketForView;
    }

    /**
     * @return the provinceIdForView
     */
    public int getProvinceIdForView() {
        return provinceIdForView;
    }

    /**
     * @param provinceIdForView
     *            the provinceIdForView to set
     */
    public void setProvinceIdForView(int provinceIdForView) {
        this.provinceIdForView = provinceIdForView;
    }

    /**
     * @return the cityIdForView
     */
    public int getCityIdForView() {
        return cityIdForView;
    }

    /**
     * @param cityIdForView
     *            the cityIdForView to set
     */
    public void setCityIdForView(int cityIdForView) {
        this.cityIdForView = cityIdForView;
    }

    /**
     * @return the subordinateCompanyNumForView
     */
    public String getSubordinateCompanyNumForView() {
        return subordinateCompanyNumForView;
    }

    /**
     * @param subordinateCompanyNumForView
     *            the subordinateCompanyNumForView to set
     */
    public void setSubordinateCompanyNumForView(String subordinateCompanyNumForView) {
        this.subordinateCompanyNumForView = subordinateCompanyNumForView;
    }

    /**
     * @return the enterpriseRegisterDatetimeForView
     */
    public String getEnterpriseRegisterDatetimeForView() {
        return enterpriseRegisterDatetimeForView;
    }

    /**
     * @param enterpriseRegisterDatetimeForView
     *            the enterpriseRegisterDatetimeForView to set
     */
    public void setEnterpriseRegisterDatetimeForView(String enterpriseRegisterDatetimeForView) {
        this.enterpriseRegisterDatetimeForView = enterpriseRegisterDatetimeForView;
    }

}
