<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务目录配置管理-受理部门管理</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<!-- 导航 -->
		<ol class="breadcrumb">
		  <li><a href="#">首页</a></li>
		  <li><a href="#">服务目录配置管理</a></li>
		  <li class="active">受理部门管理</li>
		</ol>
		<div class="col-sm-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>受理部门列表区</h5>
					<div class="ibox-tools">
					</div>
				</div>
				<!-- 模型 tpl  -->
	            <script id="tpl" type="text/x-handlebars-template" >
	                <a class="link" onclick="_delete('{{department_id}}')" ><i class="fa fa-remove"></i>&nbsp;删除</a>
                    <a class="link" onclick="_edit('{{department_id}}','{{department_name}}')" ><i class="fa fa-edit"></i>&nbsp;编辑</a>  
                </script>
				<div class="ibox-content">
					<table id="departmnttable"  data-pagination="true"  data-url="<c:url value='/cata/departmnt/querylist'/>">
						<thead>
						    <tr>
						        <th data-formatter="_indexFormatter" >序号</th>
			                    <th data-field="department_name" >受理部门名称</th>
			                    <th data-field="department_address" >地址</th>
			                    <th data-formatter="_opFormatter" >操作</th>
						    </tr>
				        </thead>
					</table>
				</div>
			</div>
		</div>

		<div class="col-sm-8" >
			<!-- 此处是相关代码 -->
		    <ul class="nav nav-tabs" role="tablist">
		    </ul>
		    <div class="tab-content" style="width:100%;height: 800px;">
		    </div>
		    <!-- 相关代码结束 -->
		</div>
		</div>
	</div>
<rc:jsfooter />
<script type="text/javascript">
   //初始化
   $(function(){
	    $('#departmnttable').inittable();
   		var item = {
 			'id':"0",
 			'name':"新增受理部门",
 			'url':"<c:url value='/cata/departmnt/add'/>",
 			'closable':false
   		};
		closableTab.addTab(item);
   });
   //新增角
   function _edit(department_id,name){
		var item = {
			'id':department_id,
			'name':name+"受理部门编辑",
			'url':"<c:url value='/cata/departmnt/edit/'/>/"+department_id,
			'closable':true
		};
		closableTab.addTab(item);
   }
   
   //回调函数
   function _callback(response){
	  if(response.success){
       	  alert(response.message);
       	  $('#departmnttable').refreshtable();
	  }
	  else{
		  alert(response.message);
	  }
   }
   
   //format区域
   function _opFormatter(value, row, index) {
        var tpl = $("#tpl").html();  
	  	//预编译模板  
	  	var template = Handlebars.compile(tpl);  
	  	return template(row);
   }
 
   function _indexFormatter(value, row, index) {
       return index+1;
   }
   
   
   //删除角色
   function _delete(department_id){
   	  if(department_id){
   		layer.confirm('确定删除要此受理部门吗？', function(index){
   			var url= "<c:url value='/cata/departmnt/del/'/>"+department_id;
   			rc.ajax(url, null,function (response) {
   				if(response.success){
   					$('#departmnttable').refreshtable();
   				}else{
   					layer.msg(response.message);
   				}
   			});
   			layer.close(index);
   		});
   	  }else{
   		layer.msg('请先选择一个你要删除事项');
   	  }
   }
</script>
</body>
</html>