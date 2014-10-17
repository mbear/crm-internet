<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
  <form:form commandName="exhibitionInfo" class="form-horizontal" role="form">
    <div class="form-group">
      <h4 class="col-md-10 col-md-offset-1" style="padding: 20px 0 10px;"><small>用于个性化服务、推介人脉及链接商业。*为必填内容</small></h4>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>关注行业</label>
      <div class="col-md-8" data-toggle="modal" data-target="#attentionIndustryModal">
        <form:input path="attentionIndustry" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>个人擅长或经验</label>
      <div class="col-md-8" data-toggle="modal" data-target="#personalExperienceModal">
        <form:input path="personalExperience" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>已入商会/校友会/俱乐部</label>
      <div class="col-md-8" data-toggle="modal" data-target="#socialCircleModal">
        <form:input path="socialCircle" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>兴趣爱好</label>
      <div class="col-md-8" data-toggle="modal" data-target="#freetimeactivityModal">
        <form:input path="freetimeactivities" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>上岛期望</label>
      <div class="col-md-8" data-toggle="modal" data-target="#expectModal">
        <form:input path="expect" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>社会职务</label>
      <div class="col-md-8">
        <form:textarea path="socialposition" class="form-control" rows="3" placeholder="如人大代表、政协委员、工商联主席、商会会长等"></form:textarea>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">企业曾获荣誉</label>
      <div class="col-md-8">
        <form:textarea path="enterpriseHonor" class="form-control" rows="3"></form:textarea>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">个人曾获荣誉</label>
      <div class="col-md-8">
        <form:textarea path="personalHonor" class="form-control" rows="3"></form:textarea>
      </div>
    </div>
    
    <div class="form-group">
     <div class="col-md-offset-5">
       <button type="submit" class="btn btn-primary">保存，下一步</button>
     </div>
    </div>
    
    <!-- 关注行业 modal -->
    <div id="attentionIndustryModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="关注行业" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">关注行业</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${attentionIndustries}" varStatus="status">
                  <c:if test="${status.index%4 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="attentionIndustryForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%4 eq 3}"></tr></c:if>
                </c:forEach>
                <%-- <tr style="line-height: 25px;">
                  <td style="padding-right: 20px;" colspan="4">
                    <label>其他</label>
                    <form:input path="attentionIndustryForViewOther" type="text" class="form-control" />
                  </td>
                </tr> --%>
              </tbody>
            </table>
            
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="attentionIndustryModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 个人擅长或经验 modal -->
    <div id="personalExperienceModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="个人擅长或经验" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">个人擅长或经验</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${personalExperiences}" varStatus="status">
                  <c:if test="${status.index%5 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="personalExperienceForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%5 eq 4}"></tr></c:if>
                </c:forEach>
                <tr style="line-height: 25px;">
                  <td style="padding-right: 20px;" colspan="5">
                    <label>其他</label>
                    <form:input path="personalExperienceForViewOther" type="text" class="form-control" />
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="personalExperienceModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 已入商会/校友会/俱乐部 modal -->
    <div id="socialCircleModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="已入商会/校友会/俱乐部 " aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">已入商会/校友会/俱乐部 </h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${socialCircles}" varStatus="status">
                  <c:if test="${status.index%4 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="socialCircleForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%4 eq 3}"></tr></c:if>
                </c:forEach>
                <tr style="line-height: 25px;">
                  <td style="padding-right: 20px;" colspan="4">
                    <label>其他</label>
                    <form:input path="socialCircleForViewOther" type="text" class="form-control" />
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="socialCircleModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 兴趣爱好 modal -->
    <div id="freetimeactivityModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="兴趣爱好 " aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">兴趣爱好</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${freetimeactivities}" varStatus="status">
                  <c:if test="${status.index%8 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="freetimeactivitiesForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%8 eq 7}"></tr></c:if>
                </c:forEach>
                <tr style="line-height: 25px;">
                  <td style="padding-right: 20px;" colspan="8">
                    <label>其他</label>
                    <form:input path="freetimeactivitiesForViewOther" type="text" class="form-control" />
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="freetimeactivityModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 上岛期望 modal -->
    <div id="expectModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="上岛期望 " aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">上岛期望</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${expects}" varStatus="status">
                  <tr style="line-height: 25px;">
                    <td style="padding-right: 20px;"><div><form:checkbox path="expectForView" value="${item}" />${item}</div></td>
                  </tr>
                </c:forEach>
                <tr style="line-height: 25px;">
                  <td style="padding-right: 20px;" >
                    <label>其他</label>
                    <form:input path="expectForViewOther" type="text" class="form-control" />
                  </td>
                </tr>
              </tbody>
            </table>
            
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="expectModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
  </form:form>
  <script type="text/javascript">
  $(document).ready( function() {
    // 关注行业 modal 多选
    var aiVals = [];
    
    // init
    $('#attentionIndustryModal input[type="checkbox"]:checked').each(function() {
      aiVals.push($(this).val());
    });
    
    $('#attentionIndustryModal input[type="checkbox"]').bind('click',function(e) {
      if($(this).is(':checked')) {
        if (aiVals.length < 3) {
          aiVals.push($(this).val());
        } else {
          e.preventDefault();
          $.scojs_message('最多选择三项', $.scojs_message.TYPE_ERROR);
        }
      } else {
        var del = $(this).val();
        aiVals = $.grep(aiVals, function(value) {
          return value != del;
        });
      }
    });
    
    $('#attentionIndustryModal_ensure').click(function() {
      $('#attentionIndustry').val(aiVals);
      $('#attentionIndustryModal').modal('hide');
    });
    
    // 个人擅长或经验 modal 多选
    var peVals = [];
 
    $('#personalExperienceModal_ensure').click(function() {
      peVals = [];
      $('#personalExperienceModal input[type="checkbox"]:checked').each(function() {
        peVals.push($(this).val());
      });
      
      // add other content
      if ($('#personalExperienceForViewOther').val().length) {
        peVals.push($('#personalExperienceForViewOther').val());
      }
      
      $('#personalExperience').val(peVals);
      $('#personalExperienceModal').modal('hide');
    });
    
    // 已入商会/校友会/俱乐部 modal 多选
    var scVals = [];
 
    $('#socialCircleModal_ensure').click(function() {
      scVals = [];
      $('#socialCircleModal input[type="checkbox"]:checked').each(function() {
        scVals.push($(this).val());
      });
      
      // add other content
      if ($('#socialCircleForViewOther').val().length) {
        scVals.push($('#socialCircleForViewOther').val());
      }
      
      $('#socialCircle').val(scVals);
      $('#socialCircleModal').modal('hide');
    });
    
    // 兴趣爱好 modal 多选
    var ftaVals = [];
 
    $('#freetimeactivityModal_ensure').click(function() {
      ftaVals = [];
      $('#freetimeactivityModal input[type="checkbox"]:checked').each(function() {
        ftaVals.push($(this).val());
      });
      
      // add other content
      if ($('#freetimeactivitiesForViewOther').val().length) {
        ftaVals.push($('#freetimeactivitiesForViewOther').val());
      }
      
      $('#freetimeactivities').val(ftaVals);
      $('#freetimeactivityModal').modal('hide');
    });
    
    // 上岛期望 modal 多选
    var exVals = [];
 
    $('#expectModal_ensure').click(function() {
      exVals = [];
      $('#expectModal input[type="checkbox"]:checked').each(function() {
        exVals.push($(this).val());
      });
      
      // add other content
      if ($('#expectForViewOther').val().length) {
        exVals.push($('#expectForViewOther').val());
      }
      
      $('#expect').val(exVals);
      $('#expectModal').modal('hide');
    });
  });
  </script>
</body>
</html>