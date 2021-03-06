<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>权限管理</title>
<!-- css头文件  -->
<rc:csshead/>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
       <div class="col-sm-3">
			<div class="ibox ">
				<div class="ibox-title" style="height:70px;">
					<h5>权限树区</h5>
					<div class="ibox-tools">
					    <button  id="tree_expand"  class="btn btn-primary btn-xs"><i class="fa fa-plus"></i>&nbsp;展开树</button>
                        <a onclick="s_perm_addnewperm()" class="btn btn-primary btn-xs"><i class="fa fa-plus"></i>&nbsp;新增</a>
                        <a onclick="s_perm_deleteperm()" class="btn btn-danger btn-xs"><i class="fa fa-remove"></i>&nbsp;删除</a>
                    </div>
				</div>
				<div class="ibox-content">
					<ul id="tree-div" class="ztree" style="overflow: auto; height: 670px; "></<ul>
				</div>
			</div>
		</div>

		<div class="col-sm-9">
			<div class="ibox ">
				<div class="ibox-title">
					<h5>权限编辑区</h5>
					<div class="ibox-tools">
					   <a class="btn btn-primary btn-xs"  onclick="s_perm_savePermData()"><i class="fa fa-save"></i>&nbsp;保存</a>
					</div>
				</div>
				<div class="ibox-content">
				<form action="<c:url value='/web/perm/saveorupdate'/>"  class="form-horizontal" method="post" id="myform">
                     <rc:hidden property="permissionid"/>
                     <rc:hidden property="parentid" />
                     <div class="form-group">
                          <rc:textedit property="parentname" cols="2,8" label="上级权限名称 " readonly="true"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="permcode"  required="true"  cols="2,8" label="权限编码 " validate="{required:true,messages:{required:'请输入权限编码'}}"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="permname"  required="true"  cols="2,8" label="权限名称" validate="{required:true,messages:{required:'请输入权限名称'}}"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                         <rc:select codetype="TYPE" property="permtype"  label="权限类型" required="true"  cols="2,8" validate="{required:true,messages:{required:'请选择权限类型'}}"/> 
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="url"  required="true"  value="#" cols="2,8" label="权限地址"  validate="{required:true,messages:{required:'权限地址不能为空'}}" />
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="sortnum" type="number" required="true"  cols="2,8"   label="排序号" validate="{required:true,messages:{required:'排序号不能为空'}}"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:select label="是否有效" property="enabled" required="true"  cols="2,8" codetype="AAE100" validate="{required:true,messages:{required:'是否有效不能为空'}}"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:select label="是否空白窗口打开" property="isblanktarget"  cols="2,8" codetype="YESNO"  validate="{required:true,messages:{required:'是否空白窗口打开不能为空'}}"/>
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="permdescribe" cols="2,8" label="权限描述" />
                     </div>
                     <div class="hr-line-dashed"></div>
                     <div class="form-group">
                          <rc:textedit property="iconcss" cols="2,8" label="图标样式" readonly="true" onclick="open_font_css_iframe()" />
                     </div>
                 </form>
			</div>
		</div>		
</div>
<rc:jsfooter />
<script type="text/javascript">
$(function() {
	//验证 ajax
	rc.validAndAjaxSubmit($("#myform"),s_perm_callback);
	s_perm_treeinit();
})

$('#tree_expand').on('click',
    function(){
       if($(this).html()=='<i class="fa fa-plus"></i>&nbsp;展开树'){
    	    var treeObj = $.fn.zTree.getZTreeObj("tree-div");
	    	treeObj.expandAll(true);
	    	$(this).html('<i class="fa fa-minus"></i>&nbsp;收缩树');
       }else{
    		var treeObj = $.fn.zTree.getZTreeObj("tree-div");
	    	treeObj.expandAll(false);
	    	$(this).html('<i class="fa fa-plus"></i>&nbsp;展开树</a>');
       }
    }
);
function s_perm_treeinit(){
	$.fn.zTree.init($("#tree-div"), s_perm_setting);
	var treeObj = $.fn.zTree.getZTreeObj("tree-div");
	treeObj.expandAll(true);
}
//回调函数
function s_perm_callback(response){
	if(response.success){
       	alert(response.message);
       	s_perm_treeinit();
	}
	else{
		alert(response.message);
	}
}
//树配置
var s_perm_setting = {
	view: {
       showLine: true,
       nameIsHTML: true
	},
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true,
			pIdKey: "pid"
		}
	},
	callback: {
		onClick: s_perm_onClick
	},
	async: {
		enable: true,
		url: "<c:url value='/web/perm/treedata'/> ",
		autoParam:["id"],
	}
};

function s_perm_onClick(event, treeId, treeNode, clickFlag) {
	alert('test');
	console.log(treeNode);
	rc.ajaxQuery("<c:url value='/web/perm/getPermData/'/>"+treeNode.id);
}


//保存页面配置信息
function s_perm_savePermData(){
   $('#myform').submit();
}
//新增权限
function s_perm_addnewperm(){
	var permissionid=$('#permissionid').val()||'0';
	var name=$('#name').val()||'权限头结点';
	rc.clean();
	$('#parentid').val(permissionid);
	$('#parentname').val(name);
	$('#url').val('#');
}
//删除权限
function s_perm_deleteperm(){
	var permissionid=$('#permissionid').val();
	if(permissionid){
		layer.confirm('确定删除要此权限吗？', function(index){
			var url= "<c:url value='/web/perm/deletePermDataById/'/>"+permissionid;
			rc.ajax(url, null,function (response) {
				if(response.success){
					s_perm_treeinit();
					rc.clean();
				}else{
					alert(response.message);
				}
			});
			layer.close(index);
		});
	}else{
		layer.alert('请先选择一个你要删除的权限节点');
	}
}

//查看
function open_font_css_iframe(){
	layer.open({
   		  type: 2,
   		  title: '图标选择页面',
   		  shadeClose: false,
   		  maxmin:true,
   		  shade: 0.8,
   		  area: ['60%', '90%'],
   		  content: "<c:url value='/webjars/fontawesome.html'/>" //iframe的url
		});
}

function font_css_choose(font_css_class_name){
	$('#iconcss').val(font_css_class_name);
	layer.close(layer.index);
}
</script>
</body>
</html>