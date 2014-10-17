/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.dtos;

import java.sql.Date;

/**
 * 预注册用户个人基本信息
 * 
 * @author muzongyan
 *
 */
public class BaseInfo {

    private int memberId;

    // 姓名
    private String clientName;

    // 性别
    private String clientGender;

    // 出生日期
    private Date clientBirthday;
    
    private String clientBirthdayForView;

    // 证件类型
    private String cardtype;

    // 证件信息
    private String cardnumber;

    // 常来往
    private String commutingProvince;

    // 电子邮件
    private String clientEmail;

    // 联系地址
    private String clientMailingaddress;

    // 毕业院校-学历
    private String educationType;

    // 毕业院校
    private String schoolName;

    // 商学院-学历
    private String collegeType;

    // 商学院
    private String businessCollege;

    // 自我介绍
    private String clientDetail;

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
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName
     *            the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientGender
     */
    public String getClientGender() {
        return clientGender;
    }

    /**
     * @param clientGender
     *            the clientGender to set
     */
    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    /**
     * @return the clientBirthday
     */
    public Date getClientBirthday() {
        return clientBirthday;
    }

    /**
     * @param clientBirthday the clientBirthday to set
     */
    public void setClientBirthday(Date clientBirthday) {
        this.clientBirthday = clientBirthday;
    }

    /**
     * @return the clientBirthdayForView
     */
    public String getClientBirthdayForView() {
        return clientBirthdayForView;
    }

    /**
     * @param clientBirthdayForView the clientBirthdayForView to set
     */
    public void setClientBirthdayForView(String clientBirthdayForView) {
        this.clientBirthdayForView = clientBirthdayForView;
    }

    /**
     * @return the cardtype
     */
    public String getCardtype() {
        return cardtype;
    }

    /**
     * @param cardtype
     *            the cardtype to set
     */
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    /**
     * @return the cardnumber
     */
    public String getCardnumber() {
        return cardnumber;
    }

    /**
     * @param cardnumber
     *            the cardnumber to set
     */
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    /**
     * @return the commutingProvince
     */
    public String getCommutingProvince() {
        return commutingProvince;
    }

    /**
     * @param commutingProvince
     *            the commutingProvince to set
     */
    public void setCommutingProvince(String commutingProvince) {
        this.commutingProvince = commutingProvince;
    }

    /**
     * @return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail
     *            the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * @return the clientMailingaddress
     */
    public String getClientMailingaddress() {
        return clientMailingaddress;
    }

    /**
     * @param clientMailingaddress
     *            the clientMailingaddress to set
     */
    public void setClientMailingaddress(String clientMailingaddress) {
        this.clientMailingaddress = clientMailingaddress;
    }

    /**
     * @return the schoolName
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName
     *            the schoolName to set
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return the businessCollege
     */
    public String getBusinessCollege() {
        return businessCollege;
    }

    /**
     * @param businessCollege
     *            the businessCollege to set
     */
    public void setBusinessCollege(String businessCollege) {
        this.businessCollege = businessCollege;
    }

    /**
     * @return the clientDetail
     */
    public String getClientDetail() {
        return clientDetail;
    }

    /**
     * @param clientDetail
     *            the clientDetail to set
     */
    public void setClientDetail(String clientDetail) {
        this.clientDetail = clientDetail;
    }

    /**
     * @return the educationType
     */
    public String getEducationType() {
        return educationType;
    }

    /**
     * @param educationType
     *            the educationType to set
     */
    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    /**
     * @return the collegeType
     */
    public String getCollegeType() {
        return collegeType;
    }

    /**
     * @param collegeType
     *            the collegeType to set
     */
    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

}
