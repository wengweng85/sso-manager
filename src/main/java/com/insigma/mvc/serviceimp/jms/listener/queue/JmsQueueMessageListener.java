package com.insigma.mvc.serviceimp.jms.listener.queue;


import javax.annotation.Resource;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import com.insigma.mvc.model.SysLog;
import com.insigma.mvc.service.sysmanager.log.SysLogService;

/**
 * 消息接收服务
 * @author admin
 *
 */
@Component
public class JmsQueueMessageListener  implements MessageListener {
	
    @Resource
	private SysLogService logservice;
     
    /**
     * 接收消息
     */
    public void onMessage(Message message) {
        try{
	        // 如果是文本消息
	        if (message instanceof TextMessage) {
	            TextMessage tm = (TextMessage) message;
	            SysLog slog=new SysLog();
	    		logservice.saveLogInfo(slog);
	        }
	
	        // 如果是Map消息
	        if (message instanceof MapMessage) {
	            MapMessage mm = (MapMessage) message;
	            System.out.println("从默认队列中获取MapMessage：\t" + mm.getString("msgId"));
	        }
	
	        // 如果是Object消息
	        if (message instanceof ObjectMessage) {
	            ObjectMessage om = (ObjectMessage) message;
	            Object exampleUser = (Object) om.getObject();
	            System.out.println("从默认队列中获取 ObjectMessage：\t" + ToStringBuilder.reflectionToString(exampleUser));
	        }
	
	        // 如果是bytes消息
	        if (message instanceof BytesMessage) {
	            byte[] b = new byte[1024];
	            int len = -1;
	            BytesMessage bm = (BytesMessage) message;
	            while ((len = bm.readBytes(b)) != -1) {
	                System.out.println(new String(b, 0, len));
	            }
	        }
	
	        // 如果是Stream消息
	        if (message instanceof StreamMessage) {
	            StreamMessage sm = (StreamMessage) message;
	            System.out.println(sm.readString());
	            System.out.println(sm.readInt());
	        }
        }catch(JMSException e){
        	e.printStackTrace();
        }
    }
}
