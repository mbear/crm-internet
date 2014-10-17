<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
  <form:form commandName="baseInfo" class="form-horizontal" role="form">
    <div class="form-group">
      <h4 class="col-md-10 col-md-offset-1" style="padding: 20px 0 10px;"><small>用于个人名片，便于其他岛邻认识您。*为必填内容</small></h4>
    </div>
    
    <div class="form-group">
      <label for="clientName" class="col-md-2 control-label">姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
      <div class="col-md-8">
        <form:input path="clientName" type="text" class="form-control" readonly="true" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="clientGender" class="col-md-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
      <div class="col-md-3">
        <label class="checkbox-inline">
          <form:radiobutton path="clientGender" value="男" />先生
        </label>
        <label class="checkbox-inline">
          <form:radiobutton path="clientGender" value="女" />女士
        </label>
      </div>
    </div>
    
    <div class="form-group">
      <label for="clientBirthdayForView" class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>出生日期</label>
      <div class="col-md-8">
        <form:input path="clientBirthdayForView" type="text" class="form-control" placeholder="例如：1990-01-01" />
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>证件信息</label>
      <div class="col-md-2">
        <form:select path="cardtype" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${cardTypes}" itemValue="itemId" itemLabel="itemName"/>
        </form:select>
      </div>
      <div class="col-md-6">
        <form:input path="cardnumber" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>常来往城市</label>
      <div class="col-md-2">
        <select id="province" name="province" class="form-control"></select>
      </div>
      <div class="col-md-2">
        <select id="city" name="city" class="form-control"></select>
      </div>
      <div class="col-md-4">
        <form:input path="commutingProvince" type="text" class="form-control" />
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label" for="input01"><span style="color: #FF0000;">*&nbsp;</span>电子邮件</label>
      <div class="col-md-8">
        <form:input path="clientEmail" type="text" class="form-control" />
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label" for="input01"><span style="color: #FF0000;">*&nbsp;</span>联系地址</label>
      <div class="col-md-8">
        <form:input path="clientMailingaddress" type="text" class="form-control" />
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>毕业院校</label>
      <div class="col-md-2">
        <form:select path="educationType" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${educationTypes}" itemValue="itemId" itemLabel="itemName" />
        </form:select>
      </div>
      <div class="col-md-6">
        <form:input path="schoolName" autocomplete="off" type="text" class="form-control" placeholder="学校名称" data-provide="typeahead" data-source='${schoolNames }'/>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>商学院</label>
      <div class="col-md-2">
        <form:select path="collegeType" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${collegeTypes}" itemValue="itemId" itemLabel="itemName"/>
        </form:select>
      </div>
      <div class="col-md-6">
        <form:input path="businessCollege" autocomplete="off" type="text" class="form-control" placeholder="学校名称" data-provide="typeahead" data-source='${businessColleges }' />
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-2 control-label">个人介绍</label>
      <div class="col-md-8">
        <form:textarea path="clientDetail" class="form-control" rows="3" placeholder="如从业经历、个性特质等"></form:textarea>
      </div>
    </div>

   <div class="form-group">
     <div class="col-md-offset-5">
       <button type="submit" class="btn btn-primary">保存，下一步</button>
     </div>
   </div>

  </form:form>
  <script type="text/javascript" charset="UTF-8">var data = '${provinceCity}';</script>
  <script type="text/javascript">
  
  // 省市联动
  data = $.parseJSON(data);
  $('#province, #city').citylist({data:data, id:'id', children:'citys',name:'name',metaTag:'name'});
  
  // 日历控件
  // 出生日期
  $('#clientBirthdayForView').datepicker({
    format: "yyyy-mm-dd",
    weekStart: 1,
    language: "zh-CN",
    autoclose: true,
    todayHighlight: true
  });
  
  // 常来往城市
  $('#commutingProvince').tagsinput();
  $('#city').change(function() {
    $('#commutingProvince').tagsinput('add', $(this).children('option:selected').val());
  });
  </script>
</body>
</html>