package com.insigma.websocket;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.insigma.mvc.model.SysUser;
import com.insigma.mvc.model.WebsocketMessage;
import com.insigma.shiro.realm.SysUserUtil;


/**
 * MyWSHandler
 */
public class MyWSHandler implements WebSocketHandler {  
	  
	private Log log=LogFactory.getLog(MyWSHandler.class);
	public static final ArrayList<WebSocketSession> users;//这个会出现性能问题，最好用Map来存储，key用userid
    static {
        users = new ArrayList<WebSocketSession>();
    }
    
    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
    	System.out.println(session.getPrincipal().getName());
        users.add(session);
        System.out.println("connect to the websocket success......当前数量:"+users.size());
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
        //TextMessage returnMessage = new TextMessage("你将收到的离线");
        //session.sendMessage(returnMessage);
    }
    
    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    	log.info("websocket connection closed......");
    	SysUser sysuser= (SysUser) session.getAttributes().get(SysUserUtil.SHIRO_CURRENT_USER_INFO);
        System.out.println("用户"+sysuser.getUsername()+"已退出！");
        users.remove(session);
        System.out.println("剩余在线用户"+users.size());
    }



    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){session.close();}
        log.debug("websocket connection closed......");
        users.remove(session);
    }

    
    public boolean supportsPartialMessages() {
        return false;
    }
    
    /**
     * 给某个用户发送消息
     *
     * @param websocketMessage
     * @param message
     */
    public void sendMessageToUser(WebsocketMessage websocketMessage,TextMessage message) {
        for (WebSocketSession user : users) {
            if (((SysUser)user.getAttributes().get(SysUserUtil.SHIRO_CURRENT_USER_INFO)).getUsername().equals(websocketMessage.getTo_username())) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    
    /**
     * 给所有在线用户发送消息(除自己外)
     *
     * @param message
     */
    public void sendMessageToUsers(WebsocketMessage websocketMessage,TextMessage message) {
        for (WebSocketSession user : users) {
        	  if (!((SysUser)user.getAttributes().get(SysUserUtil.SHIRO_CURRENT_USER_INFO)).getUsername().equals(websocketMessage.getSend_username())) {
        		  try {
                      if (user.isOpen()) {
                          user.sendMessage(message);
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
        	  }
        }
    }

	@Override
	public void handleMessage(WebSocketSession session,WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		session.sendMessage(message);  
	}
}