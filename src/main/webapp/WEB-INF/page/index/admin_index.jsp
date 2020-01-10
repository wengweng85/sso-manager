<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>${SYS_TITLE }</title>
    <meta name="keywords" content="xxx">
    <meta name="description" content="xxxx">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link href="<c:url value='/webjars/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/webjars/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/webjars/css/animate.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/webjars/css/style.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/webjars/css/rc.css'/>" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg fixed-nav" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <shiro:authenticated>
                    <c:forEach items="${permlist}" var="perm" >
                    <li class="fa-hover">
                        <a href="#" >
                            <i class="fa fa-detail <c:if test="${ empty perm.iconcss}" >fa-bookmark-o </c:if>
                            <c:if test="${not empty perm.iconcss}" >${perm.iconcss}</c:if> "></i>
                            <span class="nav-label">${perm.permname}</span>
                            <c:if test="${not empty perm.child}" >
                                 <span class="fa arrow"></span>
                            </c:if>
                        </a>
                        <c:if test="${not empty perm.child}" >
                        <ul class="nav nav-second-level collapse">
                              <c:forEach items="${perm.child}" var="secondperm" >
						      <li>
							      <c:choose>
	                                 <c:when test="${not empty secondperm.child}">
		                                 <a <c:if test="${secondperm.isblanktarget=='0'}"> class="J_menuItem" </c:if>  href="<c:url value='${secondperm.url}'/>" <c:if test="${secondperm.isblanktarget=='1'}"> target='_blank'</c:if>>
		                                 <i class="fa fa-detail ${secondperm.iconcss}"></i>${secondperm.permname}<span class="fa arrow"></span>
		                                 </a>
		                                 <ul class="nav nav-third-level">
			                                 <c:forEach items="${secondperm.child}" var="thirdperm" >
			                                 <li>
			                                      <a <c:if test="${thirdperm.isblanktarget=='0'}"> class="J_menuItem" </c:if> href="<c:url value='${thirdperm.url}'/>" <c:if test="${thirdperm.isblanktarget=='1'}"> target='_blank'</c:if>>
			                                      <i class="fa fa-detail ${thirdperm.iconcss}"></i>${thirdperm.permname}
			                                      </a>
			                                 </li>
			                                 </c:forEach>
		                                 </ul>
	                                 </c:when>
		                             <c:otherwise>
		                                 <a <c:if test="${secondperm.isblanktarget=='0'}"> class="J_menuItem" </c:if>   href="<c:url value='${secondperm.url}'/>" <c:if test="${secondperm.isblanktarget=='1'}"> target='_blank'</c:if>>
		                                 <i class="fa fa-detail ${secondperm.iconcss}"></i>${secondperm.permname}</a>
		                             </c:otherwise>
	                              </c:choose>
						      </li>
                            </c:forEach>
                         </ul>
                         </c:if>
                     </li>
                    </c:forEach>
                    </shiro:authenticated>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1" >
            <div class="row border-bottom">
                <nav class="navbar navbar-fixed-top" style="border: 0px;margin: 0px;" >
                    <div class="navbar-header">
					    <a class="navbar-brand" href="#">
					        <!--  
					        <img style="max-width:120px;margin-top:-10px;" src="<c:url value='/webjars/img/logo.jpg'/>">
					        -->
					        <!--  
					        <h3>${SYS_TITLE}</h3>
					        -->
					        <h3>浙大网新公共服务管理平台</h3>
					    </a>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-envelope"></i> <span class="label label-warning">0</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                               
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-bell"></i> <span class="label label-primary">0</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                               
                            </ul>
                        </li>
                        <li class="dropdown hidden-xs" style="font-weight: bold;">
                                                                                            欢迎你:
                            <span style="color: #39aef5;">                                                            
                            <c:choose>
							     <c:when test="${empty suser.cnname}">
							     ${suser.groupname}-${suser.username}
							     </c:when>
							     <c:otherwise> 
							     ${suser.aab301name}-${suser.groupname}-${suser.cnname}
							     </c:otherwise>
						    </c:choose>
						    </span>    
						    <ul class="dropdown-menu dropdown-alerts">
                               
                            </ul>
                        </li>
                        <li class="dropdown hidden-xs">
                            <a href="<c:url value='/loginout'/>" >
                                <i class="fa fa fa-sign-out"></i> 退出
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs" style="overflow: hidden;">
                <!-- 切换按钮 -->
	            <button class="roll-nav roll-left J_tabLeft"> 
	                <a class="navbar-minimalize" style="display: block;color: #39aef5;font-size: 18px;" href="#" ><i class="fa fa-bars"></i> </a>
	            </button>
                <!-- 左滚动 -->
                <button class="roll-nav roll-left-backword J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab"  data-id="index_v1.html" >首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight" style="right: 0px;"><i class="fa fa-forward"></i>
                </button>
            </div>
            <div class="row J_mainContent" id="content-main" >
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<c:url value='/index'/>" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
        </div>
	    <!-- 右键菜单 -->
	        <div id="context-menu">
	          <ul role="menu" class="dropdown-menu ">
	               <li class="J_tabShowActive"><a>定位当前选项卡</a>
	               </li>
	               <li class="divider"></li>
	               <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
	               </li>
	               <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
	               </li>
	          </ul>
	        </div>
        </div>
        <!--右侧边栏结束-->
        
    </div>
    <script src="<c:url value='/webjars/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/webjars/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/webjars/js/plugins/metisMenu/jquery.metisMenu.js'/>"></script>
    <script src="<c:url value='/webjars/js/plugins/slimscroll/jquery.slimscroll.min.js'/>"></script>
    <script src="<c:url value='/webjars/js/plugins/layer/layer.min.js'/>"></script>
    <script src="<c:url value='/webjars/js/hplus.min.js'/>"></script>
    <script src="<c:url value='/webjars/js/bootstrap-contextmenu.js'/>"></script>
    <script src="<c:url value='/webjars/js/contabs.js'/>"></script>
    <script src="<c:url value='/webjars/js/jQuery/jquery.marquee.min.js'/>"></script>
     <script type="text/javascript">
    $(function(){
    	//$('.navbar-minimalize').click();
    })
    
    $('.J_menuTabs').contextmenu({
      target: '#context-menu',
      before: function (e) {
        e.preventDefault();
        return true;
      }
    });
    </script>
</body>

</html>
