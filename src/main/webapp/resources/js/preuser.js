/**
 * @author muzongyan
 */
jQuery(function($) {
  $(document).ready( function() {

    // Tab init
    var $preuserTab = $.scojs_tab('#preuserTab');
    $preuserTab.select(0);
    
    // baseInfo form validate
    $('#baseInfo').scojs_valid({
      rules: {
        clientBirthdayForView: ['not_empty'],
        cardtype: ['not_empty'],
        cardnumber: ['not_empty'],
        commutingProvince: ['not_empty'],
        clientEmail: ['not_empty', 'email'],
        clientMailingaddress: ['not_empty'],
        educationType: ['not_empty'],
        schoolName: ['not_empty'],
        collegeType: ['not_empty'],
        clientDetail: [{'max_length': 300}]
      },
      
      messages: {
        clientBirthdayForView: {'not_empty': '请填写申请人出生日期'},
        cardtype: {'not_empty': '请选择证件类型'},
        cardnumber: {'not_empty': '请填写申请人证件号码'},
        commutingProvince: {'not_empty': '请选择申请人常来往的城市'},
        clientEmail: {'not_empty': '请填写申请人的电子邮件地址', 'email': '您输入的电子邮件格式不正确'},
        clientMailingaddress: {'not_empty': '请填写联系地址'},
        educationType: {'not_empty': '请选择毕业院校学历信息'},
        schoolName: {'not_empty': '请填写毕业院校'},
        collegeType: {'not_empty': '请选择商学院学历信息，没有请选择无'},
        clientDetail: {'max_length': '自我介绍输入过长，最多可输入300字'}
      },
      
      onSuccess: function(response, validator, $form) {
        $preuserTab.select(1);
      }
      
    });
    
    // enterprise form validate
    $('#enterpriseInfo').scojs_valid({
      rules: {
        enterpriceCnName: ['not_empty', {'max_length': 100}],
        clientPosition: ['not_empty', {'max_length': 50}],
        enterpriseMainIndustry: ['not_empty'],
        enterpriseNature: ['not_empty'],
        enterpriseDivide: ['not_empty'],
        enterpriseProvince: ['not_empty'],
        enterpriseCity: ['not_empty'],
        registerAddress: [{'max_length': 100}],
        coreBusiness: ['not_empty', {'max_length': 300}],
        salesAmount: ['not_empty', 'numeric'],
        salesGrowth: ['numeric'],
        payTaxesAmount: ['numeric'],
        taxesGrowth: ['numeric'],
        assetAmount: ['numeric'],
        assetGrowth: ['numeric'],
        enterpriseProfile: [{'max_length': 300}],
        subordinateCompanyNumForView: ['numeric'],
        dataYear: ['not_empty']
      },
      
      messages: {
        enterpriceCnName: {'not_empty': '请填写企业名称', 'max_length': '企业名称输入过长，最多可输入100字'},
        clientPosition: {'not_empty': '请填写申请人所在公司职务', 'max_length': '申请人职务输入过长，最多可输入50字'},
        enterpriseMainIndustry: {'not_empty': '请选择公司的主营行业'},
        enterpriseNature: {'not_empty': '请选择企业性质'},
        enterpriseDivide: {'not_empty': '请选择企业划分类型'},
        enterpriseProvince: {'not_empty': '请选择企业所在地区，需选择到市/区'},
        enterpriseCity: {'not_empty': '请选择企业所在地区，需选择到市/区'},
        registerAddress: {'max_length': '注册地点输入过长，最多可输入100字'},
        coreBusiness: {'not_empty': '请填写公司的主营业务/产品', 'max_length': '主营业务/产品输入过长，最多可输入300字'},
        salesAmount: {'not_empty': '请填写您企业上年度的营业收入', 'numeric': '您输入的企业上年度营业收入格式错误，须为数字'},
        salesGrowth: {'numeric': '您输入的企业上年度营业收入年增长率格式错误，须为数字'},
        payTaxesAmount: {'numeric': '您输入的企业上年度纳税总额格式错误，须为数字'},
        taxesGrowth: {'numeric': '您输入的企业上年度纳税总额年增长率格式错误，须为数字'},
        assetAmount: {'numeric': '您输入的企业上年度资产总额格式错误，须为数字'},
        assetGrowth: {'numeric': '您输入的企业上年度资产总额年增长率格式错误，须为数字'},
        enterpriseProfile: {'max_length': '企业介绍输入过长，最多可输入300字'},
        subordinateCompanyNumForView: {'numeric': '您输入的下属企业数格式错误，须为数字'},
        dataYear: {'not_empty': '请选择财务信息年度'}
      },
      
      onSuccess: function(response, validator, $form) {
        $preuserTab.select(2);
      }
    });
    
    // exhibition form validate
    $('#exhibitionInfo').scojs_valid({
      rules: {
        socialCircle: ['not_empty'],
        socialposition: ['not_empty'],
        attentionIndustry: ['not_empty'],
        personalExperience: ['not_empty'],
        freetimeactivities: ['not_empty'],
        expect: ['not_empty']
      },
      
      messages: {
        socialCircle: {'not_empty': '请选择申请人已加入的商会/俱乐部/校友会'},
        socialposition: {'not_empty': '请填写申请人的社会职务，没有可填写无'},
        attentionIndustry: {'not_empty': '请选择申请人关注的行业'},
        personalExperience: {'not_empty': '请选择申请人的个人擅长或经验'},
        freetimeactivities: {'not_empty': '请选择申请人的兴趣爱好'},
        expect: {'not_empty': '请填写加入正和岛的期望，没有可填写无'}
      },
      
      onSuccess: function(response, validator, $form) {
        $preuserTab.select(3);
      }
    });
    
    // contact form validate
    $('#contactInfo').scojs_valid({
      rules: {
        secritriceName: ['not_empty', {'max_length': 50}],
        secritriceTitle: ['not_empty', {'max_length': 50}],
        secritriceMobile: ['not_empty', {'exact_length': 11}, 'numeric'],
        //secritriceEmail: ['email'],
        reterenceName: ['not_empty', {'max_length': 50}],
        reterenceMobile: ['not_empty', {'exact_length': 11}, 'numeric'],
        reterenceEnterprise: [{'max_length': 100}],
        reterenceJob: [{'max_length': 50}]
      },
      
      messages: {
        secritriceName: {'not_empty': '请填写日常联系人的姓名', 'max_length': '日常联系人姓名输入过长，最多可输入50字'},
        secritriceTitle: {'not_empty': '请填写日常联系人的职务', 'max_length': '联系人职务输入过长，最多可输入50字'},
        secritriceMobile: {'not_empty': '请填写日常联系人的手机号码', 'exact_length': '您输入的联系人手机号码格式错误', 'numeric': '您输入的联系人手机号码格式错误'},
        //secritriceEmail: {'email': '您输入的联系人电子邮件格式错误'},
        reterenceName: {'not_empty': '请填写入岛推荐人的姓名', 'max_length': '推荐人姓名输入过长，最多可输入50字'},
        reterenceMobile: {'not_empty': '请填写入岛推荐人的手机号码', 'exact_length': '您输入的推荐人手机号码格式错误', 'numeric': '您输入的推荐人手机号码格式错误'},
        reterenceEnterprise: {'max_length': '推荐人公司名称输入过长，最多可输入100字'},
        reterenceJob: {'max_length': '推荐人职务输入过长，最多可输入50字'}
      },
      
      onSuccess: function(response, validator, xhr, $form) {
        if (response.data.next === 'base') {
          $preuserTab.select(0);
          $.scojs_message('个人基本信息未保存', $.scojs_message.TYPE_ERROR);
          xhr.preventDefault();
        } else if (response.data.next === 'enterprise') {
          $preuserTab.select(1);
          $.scojs_message('企业基本信息未保存', $.scojs_message.TYPE_ERROR);
          xhr.preventDefault();
        } else if (response.data.next === 'exhibition') {
          $preuserTab.select(2);
          $.scojs_message('展示信息未保存', $.scojs_message.TYPE_ERROR);
          xhr.preventDefault();
        }
      }
      
    });

  });
});