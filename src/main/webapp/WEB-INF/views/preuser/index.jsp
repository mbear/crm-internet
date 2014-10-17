<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>入岛申请表 - 正和岛-中国商界第一高端人脉与网络社交平台</title>
<%@ include file="../inc-meta.jsp" %>
<%@ include file="../inc-link.jsp" %>
<link type="text/css" rel="stylesheet" href='<%=request.getContextPath()%>/resources/css/preuser.css' />
</head>
<body>
  <%@ include file="../inc-header.jsp"%>
  <div class="container" style="padding: 20px 0 0;">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">入岛申请表</h3>
      </div>
      <div class="panel-body">
        <p>正和岛是以信任为基础的企业家网络社交平台，以下信息的真实性、客观性将会成为您在正和岛信用评价的依据。请如实填写，我们将对您填写的资料信息严格保密，仅用于正和岛会员资格申请及日后方便为您提供服务之用。<br/></p>
        <ul id="preuserTab" class="nav nav-tabs nav-justified" data-trigger="tab">
          <li><a data-trigger="ajax" href="<%=request.getContextPath()%>/preuser/${member}/base" data-target="#baseInfo" >个人基本信息</a></li>
          <li><a data-trigger="ajax" href="<%=request.getContextPath()%>/preuser/${member}/enterprise" data-target="#enterpriseInfo" >企业基本信息</a></li>
          <li><a data-trigger="ajax" href="<%=request.getContextPath()%>/preuser/${member}/exhibition" data-target="#exhibitionInfo" >展示信息</a></li>
          <li><a data-trigger="ajax" href="<%=request.getContextPath()%>/preuser/${member}/contact" data-target="#contactInfo" >联系信息</a></li>
        </ul>
        <div id="preuserTabContent" class="pane-wrapper">
          <div id="baseInfo"></div>
          <div id="enterpriseInfo"></div>
          <div id="exhibitionInfo"></div>
          <div id="contactInfo"></div>
        </div>

      </div>
    </div>
  </div>
  <%@ include file="../inc-footer.jsp"%>
  <%@ include file="../inc-script.jsp" %>
  <script type="text/javascript" charset="UTF-8">var ctx = "${pageContext.request.contextPath}"</script>
  <!--[if lt IE 8]> 
  <script type="text/javascript">
    window.location = ctx + "/ieupdate";
  </script>
  <![endif]-->
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/preuser.js" charset="UTF-8"></script>
</body>
</html>