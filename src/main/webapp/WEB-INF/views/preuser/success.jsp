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
            <div class="row-fluid">
                <div class="col-md-12">
                    <div class="centering text-center">
                        <div class="text-center">
                            <h2 class="without-margin text-success">入岛申请表提交成功！<br/><br/></h2>
                        </div>
                        <hr/>
                   </div>
               </div>
            </div>
            <div class="row-fluid">
                <div class="col-md-12">
                  <blockquote>
                    <p>附：入岛需提交材料（可线下提交至服务岛丁）</p>
                    <small>
                      <ul>
                        <li>申请资料：</li>
                          <ol>
                            <li>正和岛入岛申请表（已完成在线填写<%-- ，可<a href="<%=request.getContextPath()%>/preuser/${member}/application.pdf">下载</a> --%>）</li>
                            <li>正和岛入岛声明&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/resources/rudaoshengming.docx">入岛声明（非投资类）</a>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/resources/rudaoshengming_touzi.docx">入岛声明（投资类）</a></li>
                            <li>申请人个人照片（提交电子版）</li>
                          </ol>
                        <li>资质证明：</li>
                          <ol>
                            <li>身份证正反面，或护照信息页（提交复印件，加盖公章）</li>
                            <li>企业营业执照（提交复印件，加盖公章）</li>
                            <li>企业组织机构代码证（提交复印件，加盖公章）</li>
                            <li>企业税务登记证（提交复印件，加盖公章）</li>
                            <li>如提交以下资料，将获得更高的正和岛信用评价、享受更多权益</li>
                            <li>公司出具的财务三表——资产负债表、利润表、现金流量表（提交复印件，加盖公章）</li>
                            <li>上一年经会计师事务所出具的企业审计报告，包含资产负债表、利润表、现金流量表、报告附注（提交复印件，加盖公章）</li>
                          </ol>
                      </ul>
                      <hr/>
                      <p>邮寄地址：北京市海淀区中关村东路1号院 清华科技园创新大厦B座9层  100084</p>
                    </small>
                  </blockquote>
                </div>
            </div>
      </div>
    </div>
  </div>
  <%@ include file="../inc-footer.jsp"%>
  <%@ include file="../inc-script.jsp" %>
</body>
</html>