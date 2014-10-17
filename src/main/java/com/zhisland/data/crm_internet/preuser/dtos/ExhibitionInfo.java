/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.dtos;

/**
 * 展示信息
 * 
 * @author muzongyan
 *
 */
public class ExhibitionInfo {

    private int memberId;

    private int enterpriseId;

    // 关注行业
    private String attentionIndustry;

    // 关注行业 for modal check
    private String[] attentionIndustryForView;

    // 关注行业 for modal other
    private String attentionIndustryForViewOther;

    // 个人擅长或经验
    private String personalExperience;

    // 个人擅长或经验 for modal check
    private String[] personalExperienceForView;

    // 个人擅长或经验 for modal other
    private String personalExperienceForViewOther;

    // 已入商会/校友会/俱乐部
    private String socialCircle;

    // 已入商会/校友会/俱乐部 for modal check
    private String[] socialCircleForView;

    // 已入商会/校友会/俱乐部 for modal other
    private String socialCircleForViewOther;

    // 兴趣爱好
    private String freetimeactivities;

    // 兴趣爱好 for modal check
    private String[] freetimeactivitiesForView;

    // 兴趣爱好 for modal other
    private String freetimeactivitiesForViewOther;

    // 上岛期望
    private String expect;

    // 上岛期望 for modal check
    private String[] expectForView;

    // 上岛期望 for modal other
    private String expectForViewOther;

    // 社会职务
    private String socialposition;

    // 企业曾获荣誉
    private String enterpriseHonor;

    // 个人曾获荣誉
    private String personalHonor;

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
     * @return the attentionIndustry
     */
    public String getAttentionIndustry() {
        return attentionIndustry;
    }

    /**
     * @param attentionIndustry
     *            the attentionIndustry to set
     */
    public void setAttentionIndustry(String attentionIndustry) {
        this.attentionIndustry = attentionIndustry;
    }

    /**
     * @return the personalExperience
     */
    public String getPersonalExperience() {
        return personalExperience;
    }

    /**
     * @param personalExperience
     *            the personalExperience to set
     */
    public void setPersonalExperience(String personalExperience) {
        this.personalExperience = personalExperience;
    }

    /**
     * @return the socialCircle
     */
    public String getSocialCircle() {
        return socialCircle;
    }

    /**
     * @param socialCircle
     *            the socialCircle to set
     */
    public void setSocialCircle(String socialCircle) {
        this.socialCircle = socialCircle;
    }

    /**
     * @return the freetimeactivities
     */
    public String getFreetimeactivities() {
        return freetimeactivities;
    }

    /**
     * @param freetimeactivities
     *            the freetimeactivities to set
     */
    public void setFreetimeactivities(String freetimeactivities) {
        this.freetimeactivities = freetimeactivities;
    }

    /**
     * @return the socialposition
     */
    public String getSocialposition() {
        return socialposition;
    }

    /**
     * @param socialposition
     *            the socialposition to set
     */
    public void setSocialposition(String socialposition) {
        this.socialposition = socialposition;
    }

    /**
     * @return the expect
     */
    public String getExpect() {
        return expect;
    }

    /**
     * @param expect
     *            the expect to set
     */
    public void setExpect(String expect) {
        this.expect = expect;
    }

    /**
     * @return the enterpriseHonor
     */
    public String getEnterpriseHonor() {
        return enterpriseHonor;
    }

    /**
     * @param enterpriseHonor
     *            the enterpriseHonor to set
     */
    public void setEnterpriseHonor(String enterpriseHonor) {
        this.enterpriseHonor = enterpriseHonor;
    }

    /**
     * @return the personalHonor
     */
    public String getPersonalHonor() {
        return personalHonor;
    }

    /**
     * @param personalHonor
     *            the personalHonor to set
     */
    public void setPersonalHonor(String personalHonor) {
        this.personalHonor = personalHonor;
    }

    /**
     * @return the attentionIndustryForView
     */
    public String[] getAttentionIndustryForView() {
        return attentionIndustryForView;
    }

    /**
     * @param attentionIndustryForView
     *            the attentionIndustryForView to set
     */
    public void setAttentionIndustryForView(String[] attentionIndustryForView) {
        this.attentionIndustryForView = attentionIndustryForView;
    }

    /**
     * @return the personalExperienceForView
     */
    public String[] getPersonalExperienceForView() {
        return personalExperienceForView;
    }

    /**
     * @param personalExperienceForView
     *            the personalExperienceForView to set
     */
    public void setPersonalExperienceForView(String[] personalExperienceForView) {
        this.personalExperienceForView = personalExperienceForView;
    }

    /**
     * @return the socialCircleForView
     */
    public String[] getSocialCircleForView() {
        return socialCircleForView;
    }

    /**
     * @param socialCircleForView
     *            the socialCircleForView to set
     */
    public void setSocialCircleForView(String[] socialCircleForView) {
        this.socialCircleForView = socialCircleForView;
    }

    /**
     * @return the freetimeactivitiesForView
     */
    public String[] getFreetimeactivitiesForView() {
        return freetimeactivitiesForView;
    }

    /**
     * @param freetimeactivitiesForView
     *            the freetimeactivitiesForView to set
     */
    public void setFreetimeactivitiesForView(String[] freetimeactivitiesForView) {
        this.freetimeactivitiesForView = freetimeactivitiesForView;
    }

    /**
     * @return the expectForView
     */
    public String[] getExpectForView() {
        return expectForView;
    }

    /**
     * @param expectForView
     *            the expectForView to set
     */
    public void setExpectForView(String[] expectForView) {
        this.expectForView = expectForView;
    }

    /**
     * @return the attentionIndustryForViewOther
     */
    public String getAttentionIndustryForViewOther() {
        return attentionIndustryForViewOther;
    }

    /**
     * @param attentionIndustryForViewOther
     *            the attentionIndustryForViewOther to set
     */
    public void setAttentionIndustryForViewOther(String attentionIndustryForViewOther) {
        this.attentionIndustryForViewOther = attentionIndustryForViewOther;
    }

    /**
     * @return the personalExperienceForViewOther
     */
    public String getPersonalExperienceForViewOther() {
        return personalExperienceForViewOther;
    }

    /**
     * @param personalExperienceForViewOther
     *            the personalExperienceForViewOther to set
     */
    public void setPersonalExperienceForViewOther(String personalExperienceForViewOther) {
        this.personalExperienceForViewOther = personalExperienceForViewOther;
    }

    /**
     * @return the socialCircleForViewOther
     */
    public String getSocialCircleForViewOther() {
        return socialCircleForViewOther;
    }

    /**
     * @param socialCircleForViewOther
     *            the socialCircleForViewOther to set
     */
    public void setSocialCircleForViewOther(String socialCircleForViewOther) {
        this.socialCircleForViewOther = socialCircleForViewOther;
    }

    /**
     * @return the freetimeactivitiesForViewOther
     */
    public String getFreetimeactivitiesForViewOther() {
        return freetimeactivitiesForViewOther;
    }

    /**
     * @param freetimeactivitiesForViewOther
     *            the freetimeactivitiesForViewOther to set
     */
    public void setFreetimeactivitiesForViewOther(String freetimeactivitiesForViewOther) {
        this.freetimeactivitiesForViewOther = freetimeactivitiesForViewOther;
    }

    /**
     * @return the expectForViewOther
     */
    public String getExpectForViewOther() {
        return expectForViewOther;
    }

    /**
     * @param expectForViewOther
     *            the expectForViewOther to set
     */
    public void setExpectForViewOther(String expectForViewOther) {
        this.expectForViewOther = expectForViewOther;
    }

}
