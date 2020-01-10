<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.epsoft.com/rctag" prefix="rc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% 
	String path = request.getContextPath(); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统首页</title>
    <rc:csshead/>
</head>
<body class="gray-bg"  >
<div class="wrapper wrapper-content">
     <div class="col-sm-8">
                <div class="ibox chat-view">
                    <div class="ibox-title">
                                                                             聊天窗口
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-md-9 ">
                                <div class="chat-discussion" id="chat-discussion">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="chat-users">
                                    <div class="users-list">
                                        <c:forEach items="${alluser}" var="alluser">
                                         <div class="chat-user">
                                             <img class="chat-avatar" src="<%=request.getContextPath()%>/webjars/img/a1.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a href="javascript:void(0);" onclick="sendtouser('${alluser.principal.name}')">${alluser.principal.name}</a>
                                            </div>
                                        </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="chat-message-form">
                                    <div class="form-group">
                                        <input type="hidden" id="send_username" value="${suser.username}">
                                        <input type="hidden" id="to_username" >
                                        <textarea class="form-control message-input" name="message" id="message" placeholder="输入消息内容，按回车键发送，默认发送给所有在线人员"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </div>
<rc:jsfooter/>
<script id="tplfile_right" type="text/x-handlebars-template" >
               <div class="chat-message-right" >
<img class="message-avatar"  src="<%=request.getContextPath()%>/webjars/img/a2.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#">{{send_username}}</a>
                                            <span class="message-date">{{sysdate}}</span>
                                            <span class="message-content">
											{{msg}}
</div>
                                            </span>
                                        </div>
                                    </div>
            </script>
            
<script id="tplfile_left" type="text/x-handlebars-template" >
               <div class="chat-message-left" >
<img class="message-avatar"  src="<%=request.getContextPath()%>/webjars/img/a1.jpg" alt="">
                                        <div class="message">
                                            <a class="message-author" href="#">{{send_username}}</a>
                                            <span class="message-date">{{sysdate}}</span>
                                            <span class="message-content">
											{{msg}}
</div>
                                            </span>
                                        </div>
                                    </div>
            </script>            
<script src="<%=request.getContextPath()%>/webjars/js/sockjs.min.js"></script>
<script type="text/javascript">
    var websocket = null;
    var ws_websocket_url="ws://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/springws/websocket.ws";
    var http_websocket_url="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/springws/websocket.ws";
    if ('WebSocket' in window) {
        websocket = new WebSocket(ws_websocket_url);
    } 
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket(ws_websocket_url);
    } 
    else {
        websocket = new SockJS(http_websocket_url);
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;
              
    function onOpen(openEvt) {
        //layer.msg(openEvt.Data);
    }
    
    function onMessage(evt) {
    	var res=eval('(' + evt.data + ')');
        var tplfile_right = $("#tplfile_right").html();  
	  	//预编译模板  
	  	var template = Handlebars.compile(tplfile_right);
	  	var view=template(res);
        $('#chat-discussion').append(view)
    }
    
    //页面
    function appendtoscrren(msg){
    	var res={};
    	res.send_username=$('#send_username').val();
    	res.sysdate=new Date().Format("yyyy-MM-dd hh:mm:ss");
    	res.msg=msg;
        var tplfile_left = $("#tplfile_left").html();  
	  	//预编译模板  
	  	var template = Handlebars.compile(tplfile_left);
	  	var view=template(res);
        $('#chat-discussion').append(view)
    }
    function onError() {
    	//layer.msg('websocket error');
    }
    function onClose() {
    	layer.msg('websocket colse');
    }
    function doSend() {
    	if (websocket.readyState == websocket.OPEN) {          
            var msg = document.getElementById("message").value; 
            var send_username=$('#send_username').val();
            var to_username=$('#to_username').val();
            if(msg){
            	//如果接收人员为空  默认群发
            	if(to_username==''){
            		var url= "<c:url value='/websocket/sendall'/>";
            		rc.ajax(url, 
            				{
		            			send_username:send_username,
		                		sysdate:new Date().Format("yyyy-MM-dd hh:mm:ss"),
		                	    msg:msg
                	        },
                	        function (response) {
           				/* if(response.success){
           				}else{
           				} */
           			});
            		document.getElementById("message").value='';
            	}
            	else if(send_username!=to_username){
            		var url= "<c:url value='/websocket/send'/>";
            		rc.ajax(url, 
            				{
		            			send_username:send_username,
		            			to_username:to_username,
		                		sysdate:new Date().Format("yyyy-MM-dd hh:mm:ss"),
		                	    msg:msg
                	        },
                	        function (response) {
           				/* if(response.success){
           				}else{
           				} */
           			});
            		document.getElementById("message").value='';
            	}
           		//websocket.send(msg);//调用后台handleTextMessage方法
          		appendtoscrren(msg);
                document.getElementById("message").value='';
            }else{
            	layer.msg('内容不能为空');
            }
        } else {  
            layer.msg("连接失败!");  
        }  
    }
　　　 window.close=function(){
　　　　　websocket.onclose();
　　　}
 
    function sendtouser(username){
    	$('#message').attr('placeholder','发送给'+username+":");
    	$('#to_username').val(username);
    }

    //单击事件
	$(function(){
	    document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	doSend();
		        return false;
		    }
	    }
	});  

</script>
</body>
</html>