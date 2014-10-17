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
                            <h2 class="without-margin">入岛申请表填写完成，只需提交就大功告成咯！<br/><br/></h2>
                            <h4 class="text-success">温馨提示：提交前请先确认填写的信息准确无误，一经提交，不可在线修改哦~<br/><br/></h4>
                        </div>
                        <ul class="pager">
                          <li><a href="<%=request.getContextPath()%>/preuser/${member}">&rarr; 我要修改</a></li>
                        </ul>
                        <hr/>
                        <div class="text-center">
                          <p><input id="ido" type="checkbox" /> 本人承诺，以上申请信息真实有效</p>
                          <P><button id="confirm" type="button" class="btn btn-primary btn-lg">提交</button></P>
                        </div>
                   </div>
               </div>
            </div>
      </div>
    </div>
  </div>
  <%@ include file="../inc-footer.jsp"%>
  <%@ include file="../inc-script.jsp" %>
  <script type="text/javascript">
  $(document).ready( function() {
    $("#confirm").click(function(e) {
      if($("#ido").is(':checked')) {
        $('#confirm').scojs_confirm({
          content: "提交后信息不可修改，请确认填写的信息无误",
          action: "<%=request.getContextPath()%>/preuser/${member}/ido"
        });
      } else {
        e.preventDefault();
        $.scojs_message('如要提交，请先勾选承诺', $.scojs_message.TYPE_ERROR);
      }
    });
  });
  </script>
</body>
</html>