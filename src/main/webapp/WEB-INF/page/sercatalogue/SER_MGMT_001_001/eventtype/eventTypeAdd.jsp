<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务目录事项类型编辑</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body style="margin-top:10px;overflow: hidden;">
	<div >
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
		    <div class="ibox-title">
				<h5>事项类型</h5>
				<div class="ibox-tools">
				    <a class="btn btn-xs  btn-primary " onclick="event_type_save()"><i class="fa fa-save"></i>保存</a>
				</div>
			</div>
			<div class="ibox-content" >
				<form action="<c:url value='/cata/eventtype/saveorupdate'/>" class="form-horizontal" method="post" id="myform">
					<div class="form-group">
					    <rc:textedit label="所属地区" property="bus_area_code"  required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入业务分类地区'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="event_type_code"    label="事项编码 " required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入事项编码 '}}" />
					</div>
						<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="event_type_name"     label="事项名称" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入事项名称'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="event_type_sort"  type="number"  label="同级序号" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入事项描述'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
					    <rc:textarea rows="4" label="事项描述" property="event_type_desc"  required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入事项描述'}}" />
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
      	  parent.$('#eventtypetable').refreshtable();
      	  rc.clean($("#myform"));
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