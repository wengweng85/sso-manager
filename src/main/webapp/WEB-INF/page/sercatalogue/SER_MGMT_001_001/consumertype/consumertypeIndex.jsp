<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务目录配置管理-业务类型管理</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<!-- 导航 -->
		<ol class="breadcrumb">
		  <li><a href="#">首页</a></li>
		  <li><a href="#">服务目录配置管理</a></li>
		  <li class="active">业务类型管理</li>
		</ol>
		<div class="col-sm-4">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>业务类型列表区</h5>
					<div class="ibox-tools">
					</div>
				</div>
				<!-- 模型 tpl  -->
	            <script id="tpl" type="text/x-handlebars-template" >
	                <a class="link" onclick="_delete('{{consumer_type_id}}')" ><i class="fa fa-remove"></i>&nbsp;删除</a>
                    <a class="link" onclick="_edit('{{consumer_type_id}}','{{consumer_type_name}}')" ><i class="fa fa-edit"></i>&nbsp;编辑</a>  
                </script>
				<div class="ibox-content">
					<table id="consumertypetable"  data-pagination="true"  data-url="<c:url value='/cata/consumertype/querylist'/>">
						<thead>
						    <tr>
						        <th data-formatter="_indexFormatter" >序号</th>
			                    <th data-field="consumer_type_name" >名称</th>
			                    <th data-field="consumer_type_code" >编号</th>
			                    <th data-field="consumer_type_desc" >描述</th>
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
	    $('#consumertypetable').inittable();
   		var item = {
 			'id':"0",
 			'name':"新增服务对象",
 			'url':"<c:url value='/cata/consumertype/add'/>",
 			'closable':false
   		};
		closableTab.addTab(item);
   });
   //新增角
   function _edit(consumer_type_id,name){
		var item = {
			'id':consumer_type_id,
			'name':name+"服务对象编辑",
			'url':"<c:url value='/cata/consumertype/edit/'/>/"+consumer_type_id,
			'closable':true
		};
		closableTab.addTab(item);
   }
   
   //回调函数
   function _callback(response){
	  if(response.success){
       	  alert(response.message);
       	  $('#consumertypetable').refreshtable();
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
   function _delete(consumer_type_id){
   	  if(consumer_type_id){
   		layer.confirm('确定删除要此服务对象吗？', function(index){
   			var url= "<c:url value='/cata/consumertype/del/'/>"+consumer_type_id;
   			rc.ajax(url, null,function (response) {
   				if(response.success){
   					$('#consumertypetable').refreshtable();
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