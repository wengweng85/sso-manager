<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务事项</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body style="margin-top:10px;overflow: hidden;">
	<div >
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
		    <div class="ibox-title">
				<h5>服务事项</h5>
				<div class="ibox-tools">
				    <a class="btn btn-xs  btn-primary " onclick="event_type_save()"><i class="fa fa-save"></i>保存</a>
				</div>
			</div>
			<div class="ibox-content" >
				<form action="<c:url value='/cata/publish/saveorupdate'/>" class="form-horizontal" method="post" id="myform">
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:hidden property="bus_type_id"  value="${bustype.bus_type_id }"/>
					    <rc:textedit property="bus_type_name" value="${bustype.bus_type_name }"  readonly="true"   label="事项类别"  cols="2,10"  />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_code"    label="事项编号" required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入事项编号'}}" />
					    <rc:textedit property="cata_sort"    label="事项序号" required="true"  cols="2,4"  validate="{required:true,messages:{required:'请输入事项序号'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_name"    label="事项名称" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入类型名称'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:select codetype="SER_BUS_TYPE" property="bus_type_id"    label="业务分类" required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					    <rc:select codetype="SER_EVENT_TYPE" property="event_type_id"    label="行政类型 " required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入行政类型'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:select codetype="SER_CONSUMER_TYPE" property="consumer_type_id"     label="对象类型" required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					    <rc:select codetype="SER_POWER_TYPE" property="power_type_id"     label="权力类型 " required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入行政类型'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:select codetype="SER_DEPARTMENT" property="department_id"     label="受理部门" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_hand_time_limit"    label="服务法定办理时限" required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入事项编号'}}" />
					    <rc:textedit property="cata_promise_time_limit"  label="服务承诺办理时限" required="true"  cols="2,4"  validate="{required:true,messages:{required:'请输入事项序号'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_is_charge"   label="服务是否收费" required="true"  cols="2,4" validate="{required:true,messages:{required:'请输入事项编号'}}" />
					    <rc:textedit property="cata_complaint_tel"   label="服务监督电话" required="true"  cols="2,4"  validate="{required:true,messages:{required:'请输入事项序号'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:textarea rows="4"  property="cata_establish"    label="法律依据描述" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:textarea rows="4"  property="cata_hand_term"   label="申请条件描述" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:textarea rows="8"  property="cata_app_material"    label="受理材料描述" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:textarea rows="8"  property="cata_process"   label="办理流程描述" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入业务分类'}}" />
					</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<rc:jsfooter />
<script type="text/javascript">
   //初始化
   $(function(){
   	    //角色编辑
   		rc.validAndAjaxSubmit($("#myform"),event_type_callback);
   });

   //回调函数
   function event_type_callback(response){
	  if(response.success){
       	  layer.msg(response.message);
       	  parent._reflash();
	  }
	  else{
		  alert(response.message);
	  }
   }
   
   //保存配置信息
   function event_type_save(){
      $('#myform').submit();
   }
</script>
</body>
</html>