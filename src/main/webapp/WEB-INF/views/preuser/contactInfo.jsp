<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <form:form commandName="contactInfo" class="form-horizontal" role="form">
    <div class="form-group">
      <h4 class="col-md-10 col-md-offset-1" style="padding: 20px 0 10px;">联系人信息<br/><small><br/>请填写一位日常联系人的信息，方便我们后期为您提供服务</small></h4>
    </div>
    
    <div class="form-group">
      <label for="secritriceName" class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
      <div class="col-md-6">
        <form:input path="secritriceName" type="text" class="form-control" placeholder="请输入日常联系人的姓名" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="secritriceGender" class="col-md-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
      <div class="col-md-3">
        <label class="checkbox-inline">
          <form:radiobutton path="secritriceGender" value="男" />先生
        </label>
        <label class="checkbox-inline">
          <form:radiobutton path="secritriceGender" value="女" />女士
        </label>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>职&nbsp;&nbsp;&nbsp;&nbsp;务</label>
      <div class="col-md-6">
        <form:input path="secritriceTitle" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>手机号码</label>
      <div class="col-md-6">
        <form:input path="secritriceMobile" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">办公电话</label>
      <div class="col-md-6">
        <form:input path="secritricePhone" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">电子邮件</label>
      <div class="col-md-6">
        <form:input path="secritriceEmail" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <h4 class="col-md-10 col-md-offset-1" style="padding: 20px 0 10px;">推荐人信息<br/><small><br/>请填写一位熟悉您的相关领域权威人士的信息，我们将与之联系核实您的基本情况。请优先选择正和岛会员作为推荐人</small></h4>
    </div>
    
    <div class="form-group">
      <label for="reterenceName" class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
      <div class="col-md-6">
        <form:input path="reterenceName" type="text" class="form-control" placeholder="请输入入岛推荐人的姓名" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="reterenceGender" class="col-md-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;别</label>
      <div class="col-md-3">
        <label class="checkbox-inline">
          <form:radiobutton path="reterenceGender" value="男" />先生
        </label>
        <label class="checkbox-inline">
          <form:radiobutton path="reterenceGender" value="女" />女士
        </label>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">职&nbsp;&nbsp;&nbsp;&nbsp;务</label>
      <div class="col-md-6">
        <form:input path="reterenceJob" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>手机号码</label>
      <div class="col-md-6">
        <form:input path="reterenceMobile" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">公司名称</label>
      <div class="col-md-6">
        <form:input path="reterenceEnterprise" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">正和岛会员</label>
      <div class="col-md-3">
        <label class="checkbox-inline">
          <form:radiobutton path="reterenceIsMember" value="1" />是
        </label>
        <label class="checkbox-inline">
          <form:radiobutton path="reterenceIsMember" value="0" />否
        </label>
      </div>
    </div>
    
    <div class="form-group">
     <div class="col-md-offset-5">
       <button type="submit" class="btn btn-primary">保存，完成</button>
     </div>
    </div>
  </form:form>
</body>
</html>