<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
  <form:form commandName="enterpriseInfo" class="form-horizontal" role="form">
    <div class="form-group">
      <h4 class="col-md-10 col-md-offset-1" style="padding: 20px 0 10px;"><small>用于企业名片，便于其他岛邻认识并找到您的企业。*为必填内容</small></h4>
    </div>
    
    <div class="form-group">
      <label for="enterpriceCnName" class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>企业名称</label>
      <div class="col-md-4">
        <form:input path="enterpriceCnName" type="text" class="form-control" />
      </div>
      <label for="clientPosition" class="col-md-1 control-label"><span style="color: #FF0000;">*&nbsp;</span>职&nbsp;&nbsp;&nbsp;&nbsp;务</label>
      <div class="col-md-4">
        <form:input path="clientPosition" type="text" class="form-control" />
      </div>
    </div>
    
    <div class="form-group">
      <label for="registerAddress" class="col-md-2 control-label">注册地点</label>
      <div class="col-md-4">
        <form:input path="registerAddress" type="text" class="form-control" />
      </div>
      <label for="enterpriseRegisterDatetimeForView" class="col-md-1 control-label">成立日期</label>
      <div class="col-md-4">
        <form:input path="enterpriseRegisterDatetimeForView" type="text" class="form-control" placeholder="例如：1990-01-01" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>企业性质</label>
      <div class="col-md-4">
        <form:select path="enterpriseNature" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${enterpriseNatures}" itemValue="itemId" itemLabel="itemName"/>
        </form:select>
      </div>
      <label class="col-md-1 control-label"><span style="color: #FF0000;">*&nbsp;</span>企业划分</label>
      <div class="col-md-4">
        <form:select path="enterpriseDivide" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${enterpriseDivides}" itemValue="itemId" itemLabel="itemName"/>
        </form:select>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>企业所在地</label>
      <div class="col-md-2">
        <form:select path="enterpriseProvince" class="form-control"></form:select>
      </div>
      <div class="col-md-2">
        <form:select path="enterpriseCity" class="form-control"></form:select>
      </div>
      <label class="col-md-1 control-label">员工人数</label>
      <div class="col-md-4">
        <form:select path="enterpriseStaffNum" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${enterpriseStaffNums}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>主营行业</label>
      <div class="col-md-4">
        <form:select path="enterpriseMainIndustry" class="form-control">
          <form:option value="" label="--请选择--"/>
          <form:options items="${enterpriseIndustries}" itemValue="itemId" itemLabel="itemName"/>
        </form:select>
      </div>
      <label class="col-md-1 control-label">其他行业</label>
      <div class="col-md-4" data-toggle="modal" data-target="#industryModal">
        <form:input path="industry" type="text" class="form-control" readonly="true" value="" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>主营业务/产品</label>
      <div class="col-md-9">
        <form:input path="coreBusiness" type="text" class="form-control" placeholder="如企业的核心业务、创新产品及服务等" />
      </div>
    </div>
    
    <div class="form-group has-feedback">
      <label class="col-md-2 control-label">主要市场</label>
      <div class="col-md-4" data-toggle="modal" data-target="#mainMarketModal">
        <form:input path="mainMarket" type="text" class="form-control" readonly="true" />
        <span class="glyphicon glyphicon-edit form-control-feedback"></span>
      </div>
      <label class="col-md-1 control-label">下属企业</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="subordinateCompanyNumForView" type="text" class="form-control" />
          <span class="input-group-addon">个</span>
        </div>
      </div>
    </div>
    
    <hr/>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>财务信息年度</label>
      <div class="col-md-4">
      <form:select path="dataYear" class="form-control" >
        <form:option value="" label="--请选择企业最新年度财务信息--"/>
        <form:options items="${dataYear}" itemValue="itemName" itemLabel="itemName"/>
      </form:select>
      </div>
    </div>
    
    <div class="form-group">
      <label id="labelSalesAmount" class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>企业该年度营业收入</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="salesAmount" type="text" class="form-control" />
          <span class="input-group-addon">万元</span>
        </div>
      </div>
      <label class="col-md-1 control-label">年增长率</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="salesGrowth" type="text" class="form-control" />
          <span class="input-group-addon">%</span>
        </div>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">企业该年度纳税总额</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="payTaxesAmount" type="text" class="form-control" />
          <span class="input-group-addon">万元</span>
        </div>
      </div>
      <label class="col-md-1 control-label">年增长率</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="taxesGrowth" type="text" class="form-control" />
          <span class="input-group-addon">%</span>
        </div>
      </div>
    </div>
    
    <div class="form-group">
      <label class="col-md-2 control-label">企业该年度资产总额</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="assetAmount" type="text" class="form-control" />
          <span class="input-group-addon">万元</span>
        </div>
      </div>
      <label class="col-md-1 control-label">年增长率</label>
      <div class="col-md-4">
        <div class="input-group">
          <form:input path="assetGrowth" type="text" class="form-control" />
          <span class="input-group-addon">%</span>
        </div>
      </div>
    </div>
    
    <hr/>
    
    <div class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>是否上市</label>
      <div class="col-md-3">
        <label class="checkbox-inline">
          <form:radiobutton path="isPublicCompany" value="是" />是
        </label>
        <label class="checkbox-inline">
          <form:radiobutton path="isPublicCompany" value="否" />否
        </label>
      </div>
    </div>
    
    <div id="public1" class="form-group">
      <label class="col-md-2 control-label"><span style="color: #FF0000;">*&nbsp;</span>上市情况</label>
      <div class="col-md-3">
        <form:input path="stockCode" type="text" class="form-control" placeholder="股票代码"  />
      </div>
      <div class="col-md-3">
        <form:select path="gopublicAddress" class="form-control" >
          <form:option value="" label="--请选择上市交易所--"/>
          <form:options items="${gopublicAddresses}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
      <div class="col-md-3">
        <form:select path="announcedDate" class="form-control" >
          <form:option value="" label="--请选择上市年份--"/>
          <form:options items="${announcedDates}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
    </div>
    
    <div id="public2" class="form-group">
      <label class="col-md-2 control-label">上市情况2</label>
      <div class="col-md-3">
        <form:input path="stockCodeTwo" type="text" class="form-control" placeholder="股票代码"/>
      </div>
      <div class="col-md-3">
        <form:select path="gopublicAddressTwo" class="form-control">
          <form:option value="" label="--请选择上市交易所--"/>
          <form:options items="${gopublicAddresses}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
      <div class="col-md-3">
        <form:select path="announcedDateTwo" class="form-control">
          <form:option value="" label="--请选择上市年份--"/>
          <form:options items="${announcedDates}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
    </div>
    
    <div id="public3" class="form-group">
      <label class="col-md-2 control-label">上市情况3</label>
      <div class="col-md-3">
        <form:input path="stockCodeThree" type="text" class="form-control" placeholder="股票代码" />
      </div>
      <div class="col-md-3">
        <form:select path="gopublicAddressThree" class="form-control" >
          <form:option value="" label="--请选择上市交易所--"/>
          <form:options items="${gopublicAddresses}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
      <div class="col-md-3">
        <form:select path="announcedDateThree" class="form-control" >
          <form:option value="" label="--请选择上市年份--"/>
          <form:options items="${announcedDates}" itemValue="itemName" itemLabel="itemName"/>
        </form:select>
      </div>
    </div>
    
    <hr/>
    
    <div class="form-group">
      <label class="col-md-2 control-label">企业介绍</label>
      <div class="col-md-9">
        <form:textarea path="enterpriseProfile" class="form-control" rows="3" placeholder="如企业愿景、行业地位、专业优势、拥有资源等"></form:textarea>
      </div>
    </div>

    <div class="form-group">
     <div class="col-md-offset-5">
       <button type="submit" class="btn btn-primary">保存，下一步</button>
     </div>
    </div>
    
    <div class="form-group">
      <form:hidden path="enterpriseId" />
      <form:hidden path="extendId" />
    </div>
    
    <!-- 主要市场 modal -->
    <div id="mainMarketModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="主要市场" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">主要市场</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${mainMarkets}" varStatus="status">
                  <c:if test="${status.index%8 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="mainMarketForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%8 eq 7}"></tr></c:if>
                </c:forEach>
              </tbody>
            </table>
            
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="mainMarketModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 其他行业 modal -->
    <div id="industryModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="其他行业" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">其他行业</h4>
          </div>
          <div class="modal-body">
            <table style="margin-left: auto; margin-right: auto;">
              <tbody>
                <c:forEach var="item" items="${enterpriseIndustryStrList}" varStatus="status">
                  <c:if test="${status.index%4 eq 0}"><tr style="line-height: 25px;"></c:if>
                  <td style="padding-right: 20px;"><div><form:checkbox path="industryForView" value="${item}" />${item}</div></td>
                  <c:if test="${status.index%4 eq 3}"></tr></c:if>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button id="industryModal_ensure" type="button" class="btn btn-primary">确定</button>
          </div>
        </div>
      </div>
    </div>
  </form:form>
  <script type="text/javascript" charset="UTF-8">var data = '${provinceCity}';</script>
  <script type="text/javascript" charset="UTF-8">var selProvince = '${enterpriseInfo.provinceIdForView}';</script>
  <script type="text/javascript" charset="UTF-8">var selCity = '${enterpriseInfo.cityIdForView}';</script>
  <script type="text/javascript">
  $(document).ready( function() {
    
    // 日历控件
    // 成立日期
    $('#enterpriseRegisterDatetimeForView').datepicker({
      format: "yyyy-mm-dd",
      weekStart: 1,
      language: "zh-CN",
      autoclose: true,
      todayHighlight: true
    });
    
    // 省市联动
    data = $.parseJSON(data);
    $('#enterpriseProvince, #enterpriseCity').citylist({data:data, id:'id', children:'citys',name:'name',metaTag:'name',selected:[selProvince,selCity]});
    
    // 主要市场 modal 多选
    var mainMarketVals = [];
 
    $('#mainMarketModal_ensure').click(function() {
      mainMarketVals = [];
      $('#mainMarketModal input[type="checkbox"]:checked').each(function() {
        mainMarketVals.push($(this).val());
      });
      
      $('#mainMarket').val(mainMarketVals);
      $('#mainMarketModal').modal('hide');
    });
    
    // 其他行业 modal 多选
    var industryVals = [];
    
    // init
    $('#industryModal input[type="checkbox"]:checked').each(function() {
      industryVals.push($(this).val());
    });
    
    $('#industryModal input[type="checkbox"]').bind('click',function(e) {
      if($(this).is(':checked')) {
        if (industryVals.length < 2) {
          industryVals.push($(this).val());
        } else {
          e.preventDefault();
          $.scojs_message('最多选择两项', $.scojs_message.TYPE_ERROR);
        }
      } else {
        var del = $(this).val();
        industryVals = $.grep(industryVals, function(value) {
          return value != del;
        });
      }
    });
    
    $('#industryModal_ensure').click(function() {
      $('#industry').val(industryVals);
      $('#industryModal').modal('hide');
    });
    
    
    $('#enterpriseDivide').change(function() {
      if ($(this).children('option:selected').val() == 294) {
        $('#labelSalesAmount').html('<span style="color: #FF0000;">*&nbsp;</span>企业该年度管理资金');
      } else {
        $('#labelSalesAmount').html('<span style="color: #FF0000;">*&nbsp;</span>企业该年度营业收入');
      }
    });
    
    if ($('input[name="isPublicCompany"]:checked').val() == '否') {
      $('#public1').hide();
      $('#public2').hide();
      $('#public3').hide();
      
      $('#stockCode').val('');
      $('#gopublicAddress')[0].selectedIndex = 0;
      $('#announcedDate')[0].selectedIndex = 0;
      
      $('#stockCodeTwo').val('');
      $('#gopublicAddressTwo')[0].selectedIndex = 0;
      $('#announcedDateTwo')[0].selectedIndex = 0;
      
      $('#stockCodeThree').val('');
      $('#gopublicAddressThree')[0].selectedIndex = 0;
      $('#announcedDateThree')[0].selectedIndex = 0;
    }
    
    $('input[name="isPublicCompany"]').click(function() {
      if ($('input[name="isPublicCompany"]:checked').val() == '否') {
        $('#public1').hide();
        $('#public2').hide();
        $('#public3').hide();
        
        $('#stockCode').val('');
        $('#gopublicAddress')[0].selectedIndex = 0;
        $('#announcedDate')[0].selectedIndex = 0;
        
        $('#stockCodeTwo').val('');
        $('#gopublicAddressTwo')[0].selectedIndex = 0;
        $('#announcedDateTwo')[0].selectedIndex = 0;
        
        $('#stockCodeThree').val('');
        $('#gopublicAddressThree')[0].selectedIndex = 0;
        $('#announcedDateThree')[0].selectedIndex = 0;
      } else {
        $('#public1').show();
        $('#public2').show();
        $('#public3').show();
      }
    });
  });
  </script>
</body>
</html>