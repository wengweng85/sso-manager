<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>角色管理</title>
<!-- css头文件  -->
<rc:csshead />
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>角色授权</h5>
					<div class="ibox-tools">
					    <a class="btn btn-success btn-xs J_menuItem " href="<c:url value='web/role/index'/>" ><i class="fa fa-share"></i>&nbsp;角色管理</a>
						<a id="btn_role_perm" class="btn btn-primary btn-xs " onclick="web_role_saveRolePermData()"><i class="fa fa-save"></i>&nbsp;保存</a>
					</div>
				</div>
				<div class="ibox-content">
					<div id="tree-div" class="ztree" style="overflow: auto; height: 550px; width: 450px;"></div>
				</div>
			</div>
		</div>
	</div>
<rc:jsfooter />
<script type="text/javascript">
   //初始化
   $(function(){
   	    //权限树加载
    	web_role_treeinit();
   });
   
   //角色-权限树配置
   var web_role_setting = {
	  view: {
          showLine: true
	  },	   
      check: {
		enable: true
	  },
   	  data: {
   		simpleData: {
   			enable: true,
   			pIdKey: "pid",
   			rootPId: '0'
   		}
   	  },
   	  async: {
   		 enable: true,
   		 url: "<c:url value='/web/role/treedata'/>",
   		 autoParam:["id"],
   		 otherParam: {"id":'${roleid}'}
   	  }
   };
   //树初始化
   function web_role_treeinit(){
	  $.fn.zTree.init($("#tree-div"), web_role_setting);
	  var zTree = $.fn.zTree.getZTreeObj("tree-div");
	  zTree.expandAll(true)
   }
   
   //保存角色-权限数据
   function web_role_saveRolePermData() {
	   var roleid=$('#roleid').val();
	   if(roleid){
		    var zTree = $.fn.zTree.getZTreeObj("tree-div");
		    var nodes = zTree.getCheckedNodes(true);
		    var selectnodes=",";
		    for(i=0;i<nodes.length;i++){
		       selectnodes+= nodes[i].id+",";
		    }
		    rc.ajax("<c:url value='/web/role/saveroleperm'/>", {roleid:roleid,selectnodes:selectnodes},function (response) {
		    	alert(response.message);
		    	if(response.success){
		    		$('#roletable').refreshtable();
		    		web_role_treeinit();
				}
			});  
	   }else{
		   layer.alert('请先选择一个角色');
	   }
	}
</script>
</body>
</html>