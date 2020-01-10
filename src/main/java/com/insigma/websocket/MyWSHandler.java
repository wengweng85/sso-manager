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
	public static final ArrayList<WebSocketSession> users;//���������������⣬�����Map���洢��key��userid
    static {
        users = new ArrayList<WebSocketSession>();
    }
    
    /**
     * ���ӳɹ�ʱ�򣬻ᴥ��ҳ����onopen����
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
    	System.out.println(session.getPrincipal().getName());
        users.add(session);
        System.out.println("connect to the websocket success......��ǰ����:"+users.size());
        //����ʵ���Լ�ҵ�񣬱��磬���û���¼�󣬻��������Ϣ���͸��û�
        //TextMessage returnMessage = new TextMessage("�㽫�յ�������");
        //session.sendMessage(returnMessage);
    }
    
    /**
     * �ر�����ʱ����
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    	log.info("websocket connection closed......");
    	SysUser sysuser= (SysUser) session.getAttributes().get(SysUserUtil.SHIRO_CURRENT_USER_INFO);
        System.out.println("�û�"+sysuser.getUsername()+"���˳���");
        users.remove(session);
        System.out.println("ʣ�������û�"+users.size());
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
     * ��ĳ���û�������Ϣ
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
     * �����������û�������Ϣ(���Լ���)
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