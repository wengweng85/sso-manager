<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>服务事项发布管理</title>
<!-- css头文件  -->
<rc:csshead />
<style type="text/css">

div#rMenu {
	position:absolute; 
	visibility:hidden; top:0;text-align: left;padding: 2px;
}

div#rDetailMenu {
	position:absolute; 
	visibility:hidden; top:0;text-align: left;padding: 2px;
}

</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
	<!-- 导航 -->
	<ol class="breadcrumb">
	  <li><a href="#">首页</a></li>
	  <li><a href="#">服务事项管理</a></li>
	  <li class="active">事项发布</li>
	</ol>
		<div class="col-sm-3">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>事项树</h5>
					<div class="ibox-tools">
					    <a onclick="_reflash()" class="btn btn-primary btn-xs"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                    </div>
				</div>
				<div class="ibox-content">
					<div id="cata-div" class="ztree" style="overflow: auto; height: 700px; "></div>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<!-- 此处是相关代码 -->
		    <ul class="nav nav-tabs" role="tablist">
		    </ul>
		    <div class="tab-content" style="width:100%;height: 1000px;">
		    </div>
		    <!-- 相关代码结束 -->
		</div>
	</div>
</div>


<div id="rMenu">
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
        <rc:hidden property="rmenu_bus_type_id"/>
	    <li id="m_add" onclick="addCata();"><a tabindex="-1" href="#"><i class="fa fa-plus"></i>&nbsp;新增事项</a></li>
	</ul>
</div>

<div id="rDetailMenu">
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
        <rc:hidden property="rDetailMenu_cata_id"/>
	    <li id="m_detail_add" onclick="addCataDetail();"><a  tabindex="-1" href="#"><i class="fa fa-plus"></i>&nbsp;新增事项详情</a></li>
	</ul>
</div>   

<rc:jsfooter />
<script type="text/javascript">
var zTree, rMenu,zDetailTree,rDetailMenu;
$(function() {
	 $.fn.zTree.init($("#cata-div"), cata_setting);
	 zTree = $.fn.zTree.getZTreeObj("cata-div");
	 rMenu = $("#rMenu");
	 rDetailMenu = $("#rDetailMenu");
	 var item = {
		'id':'0',
		'name':'操作区',
		'url':"javascript:void(0);",
		'closable':false
	 };
	 closableTab.addTab(item);
})

//刷新
function _reflash(){
	$.fn.zTree.init($("#cata-div"), cata_setting);
}

//树配置
var cata_setting = {
	  edit: {
		 drag:{
			prev: true,
			next: true,
			inner:false
		 },
		 enable: true,
		 showRemoveBtn: false,
		 showRenameBtn: false
	  },
	  view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: true,
        nameIsHTML: true
	  },	
	  check: {
		enable: false
	  },
	  data: {
		  simpleData: {
				enable: true,
				pIdKey: "pid"
			}
	  },
	  callback: {
		onClick: onClick,
		onRightClick: onRightClick
	  },
	  async: {
		 enable: true,
		 url: "<c:url value='/cata/publish/treedata'/>",
		 autoParam:["id"]
	  }
};

//新增服务事项
function addCata(){
	var rmenu_bus_type_id=$('#rmenu_bus_type_id').val();
	var item = {
		'id':'cata',
		'name':'新增服务事项',
		'url':"<c:url value='/cata/publish/add/'/>"+rmenu_bus_type_id,
		'closable':true
   	};
	closableTab.addTab(item);
}

//新增服务事项详情
function addCataDetail(){
	var rDetailMenu_cata_id=$('#rDetailMenu_cata_id').val();
	var item = {
		'id':'cata_detail',
		'name':'新增服务事项详情',
		'url':"<c:url value='/cata/publish/detail/add/'/>"+rDetailMenu_cata_id,
		'closable':true
   	};
	closableTab.addTab(item);
}


/**
 * 点击code_type树,调用树结点查询对应的code_value值
 */
function onClick(event, treeId, treeNode, clickFlag) {
	var cata_type=treeNode.type;
	var id=treeNode.id;
	var name=treeNode.name;
	console.log(id);
	console.log(cata_type);
	
	//服务事项大类
	if(cata_type=='2'){
		var item = {
	 			'id':id,
	 			'name':'服务事项:'+name,
	 			'url':"<c:url value='/cata/publish/edit/'/>"+id,
	 			'closable':true
	   	};
		closableTab.addTab(item);
	}
	//服务事项明细
	if(cata_type=='3'){
		var item = {
	 			'id':id,
	 			'name':'事项详情:'+name,
	 			'url':"<c:url value='/cata/publish/detail/edit/'/>"+id,
	 			'closable':true
	   	};
		closableTab.addTab(item);
	}
}

/**
 * 右键编辑
 */
function onRightClick(event, treeId, treeNode) {
	if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
		return false;
	} else if (treeNode && !treeNode.noR) {
		var cata_type=treeNode.type;
		var id=treeNode.id;
		zTree.selectNode(treeNode);
		showRMenu(cata_type,id, event.clientX, event.clientY);
	}
}

/**
 * 显示右键菜单
 */
function showRMenu(cata_type,id, x, y) {
	console.log(cata_type+' '+id);
	y += document.body.scrollTop;
    x += document.body.scrollLeft;
	if(cata_type=='1'){
		$("#rMenu ul").show();
		$('#rmenu_bus_type_id').val(id);
		rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});
	}else if(cata_type=='2'){
		$("#rDetailMenu ul").show();
		$('#rDetailMenu_cata_id').val(id);
		rDetailMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});
	}
	$("body").bind("mousedown", onBodyMouseDown);
}

function onBodyMouseDown(event){
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
		rMenu.css({"visibility" : "hidden"});
	}
	if (!(event.target.id == "rDetailMenu" || $(event.target).parents("#rDetailMenu").length>0)) {
		rDetailMenu.css({"visibility" : "hidden"});
	}
}

</script>
</body>
</html>