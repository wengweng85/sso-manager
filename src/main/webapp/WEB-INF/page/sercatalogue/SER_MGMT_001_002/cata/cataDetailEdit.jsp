<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务目录事项明细编辑</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body style="margin-top:10px;overflow: hidden;">
	<div >
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
		    <div class="ibox-title">
				<h5>服务事项明细</h5>
				<div class="ibox-tools">
				    <a class="btn btn-xs  btn-danger " onclick="_delete('${catadetail.cata_detail_id }')"><i class="fa fa-remove"></i>删除</a>
				    <a class="btn btn-xs  btn-primary " onclick="_save()"><i class="fa fa-save"></i>修改</a>
				</div>
			</div>
			<div class="ibox-content" >
				<form action="<c:url value='/cata/publish/detail/saveorupdate'/>" class="form-horizontal" method="post" id="myform">
					<rc:hidden property="cata_detail_id"  value="${catadetail.cata_detail_id }"/>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_detail_name"   value="${catadetail.cata_detail_name }"   label="事项流程名称" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入事项详情名称'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_detail_code" readonly="true" value="${catadetail.cata_detail_code }"   label="事项详情编码" required="true"  cols="2,10" validate="{required:true,messages:{required:'请输入事项详情编号'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textarea rows="4" property="cata_detail_desc"  value="${catadetail.cata_detail_desc }"    label="事项详情描述" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入事项详情描述'}}" />
					</div>
					<div class="hr-line-dashed"></div>
					<div class="form-group">
						<rc:textedit property="cata_detail_sort"  type="number" value="${catadetail.cata_detail_sort }"   label="排序号" required="true"  cols="2,10"  validate="{required:true,messages:{required:'请输入排序号'}}" />
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
   		rc.validAndAjaxSubmit($("#myform"),_callback);
   });

   //回调函数
   function _callback(response){
	  if(response.success){
       	  layer.msg(response.message);
       	  parent._reflash();
	  }
	  else{
		  alert(response.message);
	  }
   }
   
   //保存配置信息
   function _save(){
      $('#myform').submit();
   }
   
   function _delete(id){
	    var layer_index=layer.confirm('确定删除此事项明细吗？', function(index){
		var url= "<c:url value='/cata/publish/detail/delete/'/>"+id;
		rc.ajax(url, null,function (response) {
				if(response.success){
					layer.msg(response.message);
					parent._reflash();
				}else{
					layer.msg(response.message);
				}
				layer.close(layer_index);
		    });
       });
   }
</script>
</body>
</html>