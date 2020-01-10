<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务目录权力类型</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body style="margin-top:10px;overflow: hidden;">
	<div >
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
		    <div class="ibox-title">
				<h5>权力类型</h5>
				<div class="ibox-tools">
				    <a class="btn btn-xs  btn-primary " onclick="event_type_save()"><i class="fa fa-save"></i>保存</a>
				</div>
			</div>
			<div class="ibox-content" >
				<form action="<c:url value='/cata/powertype/saveorupdate'/>" class="form-horizontal" method="post" id="myform">
					<rc:hidden property="bus_type_id"  value="${type.power_type_id }"/>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="power_type_name"  value="${type.power_type_name }"   label="类型名称" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入类型名称'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="power_type_code"  readonly="true" value="${type.power_type_code }"   label="类型编号" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入类型编号'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="power_type_desc"  value="${type.power_type_name }"    label="类型描述" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入类型描述'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="power_type_sort"  type="number" value="${type.power_type_sort }"   label="排序号" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入排序号'}}" />
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
      	  parent.$('#powertypetable').refreshtable();
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