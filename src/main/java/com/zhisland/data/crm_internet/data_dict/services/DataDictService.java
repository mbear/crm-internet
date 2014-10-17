/**
 * 
 */
package com.zhisland.data.crm_internet.data_dict.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zhisland.data.crm_internet.data_dict.dto.City;
import com.zhisland.data.crm_internet.data_dict.dto.DataDictDTO;
import com.zhisland.data.crm_internet.data_dict.dto.EnterpriseTurnoverScale;
import com.zhisland.data.crm_internet.data_dict.dto.Province;
import com.zhisland.data.crm_internet.data_dict.mappers.DataDictMapper;

/**
 * @author muzongyan
 *
 */
@Service
@Scope("singleton")
public class DataDictService implements DataDictCategories {

    @Autowired
    private DataDictMapper dataDictMapper;

    // 证件类型
    private TreeSet<DataDictDTO> cardTypes = new TreeSet<DataDictDTO>();

    // 省份(包括市)
    private List<Province> provinces = new ArrayList<Province>();

    // 学历类型
    private TreeSet<DataDictDTO> educationTypes = new TreeSet<DataDictDTO>();

    // 学历类型除MBA
    private TreeSet<DataDictDTO> educationTypesExceptMBA = new TreeSet<DataDictDTO>();

    // 商学院学历类型
    private TreeSet<DataDictDTO> collegeTypes = new TreeSet<DataDictDTO>();

    // 大学列表
    private TreeSet<DataDictDTO> schoolNames = new TreeSet<DataDictDTO>();

    // 商学院
    private TreeSet<DataDictDTO> businessColleges = new TreeSet<DataDictDTO>();

    // 上市地点
    private TreeSet<DataDictDTO> gopublicAddresses = new TreeSet<DataDictDTO>();

    // 员工人数
    private TreeSet<DataDictDTO> enterpriseStaffNums = new TreeSet<DataDictDTO>();

    // 企业性质
    private TreeSet<DataDictDTO> enterpriseNatures = new TreeSet<DataDictDTO>();

    // 企业划分
    private TreeSet<DataDictDTO> enterpriseDivides = new TreeSet<DataDictDTO>();

    // 关注行业
    private TreeSet<DataDictDTO> attentionIndustries = new TreeSet<DataDictDTO>();

    // 个人擅长或经验
    private TreeSet<DataDictDTO> personalExperiences = new TreeSet<DataDictDTO>();

    // 业余爱好
    private TreeSet<DataDictDTO> freetimeactivities = new TreeSet<DataDictDTO>();

    // 社交圈
    private TreeSet<DataDictDTO> socialCircles = new TreeSet<DataDictDTO>();

    // 主营行业
    private TreeSet<DataDictDTO> enterpriseIndustries = new TreeSet<DataDictDTO>();

    // 上市年份
    private TreeSet<DataDictDTO> announcedDates = new TreeSet<DataDictDTO>();

    // 主要市场
    private TreeSet<DataDictDTO> mainMarkets = new TreeSet<DataDictDTO>();

    // 企业规模
    private TreeSet<DataDictDTO> enterpriseTurnover = new TreeSet<DataDictDTO>();

    // 上岛期望
    private TreeSet<DataDictDTO> expects = new TreeSet<DataDictDTO>();

    private void setExpects() {
        expects = dataDictMapper.findAllItemsByOneLevelCategory(EXPECT);
    }

    private void setEnterpriseTurnovers() {
        enterpriseTurnover = dataDictMapper.findAllItemsByOneLevelCategory(ENTERPRISE_TURNOVER);
    }

    private void setMainMarkets() {
        mainMarkets = dataDictMapper.findAllItemsByOneLevelCategory(MAIN_MARKET);
    }

    private void setAnnouncedDates() {
        announcedDates = dataDictMapper.findAllItemsByOneLevelCategory(ANNOUNCED_DATE);
    }

    private void setEnterpriseIndustries() {
        enterpriseIndustries = dataDictMapper.findAllItemsByOneLevelCategory(ENTERPRISE_INDUSTRY);
    }

    private void setCardTypes() {
        cardTypes = dataDictMapper.findAllItemsByOneLevelCategory(CARD_TYPE);
    }

    private void setAllProvinces() {
        provinces = dataDictMapper.findAllProvinces();

        for (Province p : provinces) {
            List<City> citys = dataDictMapper.findAllCitiesByProvince(p.getId());
            p.setCitys(citys);
        }
    }

    private void setAllEducationTypes() {
        educationTypes = dataDictMapper.findAllItemsByOneLevelCategory(EDUCATION_TYPE);
    }

    private void setEducationTypeExceptionMBA() {
        // if (educationTypes == null || educationTypes.size() == 0) {
        setAllEducationTypes();
        // }

        educationTypesExceptMBA.clear();
        educationTypesExceptMBA.addAll(educationTypes);

        Iterator<DataDictDTO> itr = educationTypesExceptMBA.iterator();
        while (itr.hasNext()) {
            String itemName = itr.next().getItemName();
            if ("MBA".equals(itemName) || "EMBA".equals(itemName)) {
                itr.remove();
            }
        }
    }

    private void setAllCollegeTypes() {
        collegeTypes = dataDictMapper.findAllItemsByOneLevelCategory(COLLEGE_TYPE);
    }

    private void setAllSchoolNames() {
        schoolNames = dataDictMapper.findAllItemsByTwoLevelCategory(SCHOOL_NAME);
    }

    private void setAllBusinessColleges() {
        businessColleges = dataDictMapper.findAllItemsByOneLevelCategory(BUSINESS_COLLEGE);
    }

    private void setAllGopublicAddresses() {
        gopublicAddresses = dataDictMapper.findAllItemsByOneLevelCategory(GOPUBLIC_ADDRESS);
    }

    private void setAllEnterpriseStaffNums() {
        enterpriseStaffNums = dataDictMapper.findAllItemsByOneLevelCategory(ENTERPRISE_STAFF_NUM);
    }

    private void setAllEnterpriseNatures() {
        enterpriseNatures = dataDictMapper.findAllItemsByOneLevelCategory(ENTERPRISE_NATURE);
    }

    private void setAllEnterpriseDivides() {
        enterpriseDivides = dataDictMapper.findAllItemsByOneLevelCategory(ENTERPRISE_DIVIDE);
    }

    private void setAllAttentionIndustries() {
        attentionIndustries = dataDictMapper.findAllItemsByOneLevelCategory(ATTENTION_INDUSTRY);
    }

    private void setAllPersonalExperiences() {
        personalExperiences = dataDictMapper.findAllItemsByOneLevelCategory(PERSONAL_EXPERIENCE);
    }

    private void setAllFreetimeActivities() {
        freetimeactivities = dataDictMapper.findAllItemsByOneLevelCategory(FREETIMEACTIVITIES);
    }

    private void setAllSocialCircles() {
        socialCircles = dataDictMapper.findAllItemsByOneLevelCategory(SOCIAL_CIRCLE);
    }

    /**
     * 取得企业规模
     * 
     * @return
     */
    public TreeSet<EnterpriseTurnoverScale> getEnterpriseTurnovers() {
        // if (enterpriseTurnover == null || enterpriseTurnover.size() == 0) {
        setEnterpriseTurnovers();
        // }

        TreeSet<EnterpriseTurnoverScale> etsSet = new TreeSet<EnterpriseTurnoverScale>();
        Gson gson = new Gson();
        for (DataDictDTO ddd : enterpriseTurnover) {
            EnterpriseTurnoverScale ets = new EnterpriseTurnoverScale();
            ets = gson.fromJson(ddd.getItemDescription(), EnterpriseTurnoverScale.class);
            BeanUtils.copyProperties(ddd, ets);
            etsSet.add(ets);
        }

        return etsSet;
    }

    /**
     * 取得上岛期望
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getExpects() {
        // if (expects == null || expects.size() == 0) {
        setExpects();
        // }

        return expects;
    }

    /**
     * 取得上岛期望字符串列表
     * 
     * @return
     */
    public List<String> getExpectStrList() {
        // if (expects == null || expects.size() == 0) {
        setExpects();
        // }

        List<String> list = new ArrayList<String>();
        for (DataDictDTO dd : expects) {
            list.add(dd.getItemName());
        }

        return list;
    }

    /**
     * 取得主要市场
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getMainMarkets() {
        // if (mainMarkets == null || mainMarkets.size() == 0) {
        setMainMarkets();
        // }

        return mainMarkets;
    }

    /**
     * 取得主要市场字符串列表
     * 
     * @return
     */
    public List<String> getMainMarketStrList() {
        // if (mainMarkets == null || mainMarkets.size() == 0) {
        setMainMarkets();
        // }

        List<String> mmList = new ArrayList<String>();
        for (DataDictDTO dd : mainMarkets) {
            mmList.add(dd.getItemName());
        }

        return mmList;
    }

    /**
     * 取得上市年份
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAnnouncedDates() {
        // if (announcedDates == null || announcedDates.size() == 0) {
        setAnnouncedDates();
        // }

        return announcedDates;
    }

    /**
     * 取得主营行业
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getEnterpriseIndustries() {
        // if (enterpriseIndustries == null || enterpriseIndustries.size() == 0) {
        setEnterpriseIndustries();
        // }

        return enterpriseIndustries;
    }

    /**
     * 取得主营行业字符串列表
     * 
     * @return
     */
    public List<String> getEnterpriseIndustryStrList() {
        // if (enterpriseIndustries == null || enterpriseIndustries.size() == 0) {
        setEnterpriseIndustries();
        // }

        List<String> eiList = new ArrayList<String>();
        for (DataDictDTO dd : enterpriseIndustries) {
            eiList.add(dd.getItemName());
        }

        return eiList;
    }

    /**
     * 取得证件类型
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getCardTypes() {
        // if (cardTypes == null || cardTypes.size() == 0) {
        setCardTypes();
        // }

        return cardTypes;
    }

    /**
     * 取得所有省份(包括对应的市)
     * 
     * @return
     */
    public List<Province> getAllProvinces() {
        // if (provinces == null || provinces.size() == 0) {
        setAllProvinces();
        // }

        return provinces;
    }

    /**
     * 取得所有学历类型
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllEducationTypes() {
        // if (educationTypes == null || educationTypes.size() == 0) {
        setAllEducationTypes();
        // }

        return educationTypes;
    }

    /**
     * 取得学历类型，除MBA
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getEducationTypesExceptMBA() {
        // if (educationTypesExceptMBA == null || educationTypesExceptMBA.size() == 0) {
        setEducationTypeExceptionMBA();
        // }

        return educationTypesExceptMBA;
    }

    /**
     * 取得商学院学历类型
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllCollegeTypes() {
        // if (collegeTypes == null || collegeTypes.size() == 0) {
        setAllCollegeTypes();
        // }

        return collegeTypes;
    }

    /**
     * 取得所有大学列表
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllSchoolNames() {
        // if (schoolNames == null || schoolNames.size() == 0) {
        setAllSchoolNames();
        // }

        return schoolNames;
    }

    /**
     * 取得所有大学名称列表
     * 
     * @return
     */
    public List<String> getAllSchoolNameStrList() {
        // if (schoolNames == null || schoolNames.size() == 0) {
        setAllSchoolNames();
        // }

        List<String> snList = new ArrayList<String>();
        for (DataDictDTO bc : schoolNames) {
            snList.add(bc.getItemName());
        }

        return snList;
    }

    /**
     * 取得所有商学院
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllBusinessColleges() {
        // if (businessColleges == null || businessColleges.size() == 0) {
        setAllBusinessColleges();
        // }

        return businessColleges;
    }

    /**
     * 取得所有商学院名称列表
     * 
     * @return
     */
    public List<String> getAllBusinessCollegeStrList() {
        // if (businessColleges == null || businessColleges.size() == 0) {
        setAllBusinessColleges();
        // }

        List<String> bcList = new ArrayList<String>();
        for (DataDictDTO bc : businessColleges) {
            bcList.add(bc.getItemName());
        }

        return bcList;
    }

    /**
     * 取得所有上市地点
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllGopublicAddresses() {
        // if (gopublicAddresses == null || gopublicAddresses.size() == 0) {
        setAllGopublicAddresses();
        // }

        return gopublicAddresses;
    }

    /**
     * 取得员工人数
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllEnterpriseStaffNum() {
        // if (enterpriseStaffNums == null || enterpriseStaffNums.size() == 0) {
        setAllEnterpriseStaffNums();
        // }

        return enterpriseStaffNums;
    }

    /**
     * 取得所有企业性质
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllEnterpriseNatures() {
        // if (enterpriseNatures == null || enterpriseNatures.size() == 0) {
        setAllEnterpriseNatures();
        // }

        return enterpriseNatures;
    }

    /**
     * 取得所有企业划分
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllEnterpriseDivides() {
        // if (enterpriseDivides == null || enterpriseDivides.size() == 0) {
        setAllEnterpriseDivides();
        // }

        return enterpriseDivides;
    }

    /**
     * 取得所有关注行业
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllAttentionIndustries() {
        // if (attentionIndustries == null || attentionIndustries.size() == 0) {
        setAllAttentionIndustries();
        // }

        return attentionIndustries;
    }

    /**
     * 取得所有关注行业字符串列表
     * 
     * @return
     */
    public List<String> getAllAttentionIndustryStrList() {
        // if (attentionIndustries == null || attentionIndustries.size() == 0) {
        setAllAttentionIndustries();
        // }

        List<String> list = new ArrayList<String>();
        for (DataDictDTO ddd : attentionIndustries) {
            list.add(ddd.getItemName());
        }

        return list;
    }

    /**
     * 取得个人擅长或经验
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllPersonalExperiences() {
        // if (personalExperiences == null || personalExperiences.size() == 0) {
        setAllPersonalExperiences();
        // }

        return personalExperiences;
    }

    /**
     * 取得个人擅长或经验字符串列表
     * 
     * @return
     */
    public List<String> getAllPersonalExperienceStrList() {
        // if (personalExperiences == null || personalExperiences.size() == 0) {
        setAllPersonalExperiences();
        // }

        List<String> list = new ArrayList<String>();
        for (DataDictDTO ddd : personalExperiences) {
            list.add(ddd.getItemName());
        }

        return list;
    }

    /**
     * 取得兴趣爱好
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllFreetimeActivities() {
        // if (freetimeactivities == null || freetimeactivities.size() == 0) {
        setAllFreetimeActivities();
        // }

        return freetimeactivities;
    }

    /**
     * 取得兴趣爱好字符串列表
     * 
     * @return
     */
    public List<String> getAllFreetimeActivitieStrList() {
        // if (freetimeactivities == null || freetimeactivities.size() == 0) {
        setAllFreetimeActivities();
        // }

        List<String> list = new ArrayList<String>();
        for (DataDictDTO ddd : freetimeactivities) {
            list.add(ddd.getItemName());
        }

        return list;
    }

    /**
     * 取得社交圈
     * 
     * @return
     */
    public TreeSet<DataDictDTO> getAllSocialCircles() {
        // if (socialCircles == null || socialCircles.size() == 0) {
        setAllSocialCircles();
        // }

        return socialCircles;
    }

    /**
     * 取得社交圈字符串列表
     * 
     * @return
     */
    public List<String> getAllSocialCircleStrList() {
        // if (socialCircles == null || socialCircles.size() == 0) {
        setAllSocialCircles();
        // }

        List<String> list = new ArrayList<String>();
        for (DataDictDTO ddd : socialCircles) {
            list.add(ddd.getItemName());
        }

        return list;
    }
}
