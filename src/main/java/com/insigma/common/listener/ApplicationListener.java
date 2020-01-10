package com.insigma.common.listener;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.insigma.common.util.DateUtil;
import com.insigma.common.util.EhCacheUtil;
import com.insigma.mvc.component.appcontext.MyApplicationContextUtil;
import com.insigma.mvc.model.CodeType;
import com.insigma.mvc.model.CodeValue;
import com.insigma.mvc.model.SysParam;
import com.insigma.mvc.service.sysmanager.codetype.SysCodeTypeService;
import com.insigma.mvc.service.sysmanager.param.SysParamService;
import com.insigma.redis.RedisManager;

/**
 * ��Ŀ��ʼ��
 * 
 * @author admin
 * 
 */
public class ApplicationListener implements   ServletContextListener  {
	Log log=LogFactory.getLog(ApplicationListener.class);


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	private static String redisswitch="off";
	
	static {
        Properties pro = new Properties();
        try {
            InputStream fis = ApplicationListener.class.getClassLoader().getResourceAsStream("/config/app/app.properties");
            pro.load(fis);
            redisswitch = pro.getProperty("redisswitch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public void contextInitialized2(ServletContextEvent sce) {
		
	}
	/**
	 * ����ehcache
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
        /* SysSenstiveWordService sysSenstiveWordService= MyApplicationContextUtil.getContext().getBean(SysSenstiveWordService.class);
         Set<String> sensitiveWordSet = new HashSet<>();
         List<SysSenstiveWord>  list=sysSenstiveWordService.getList();
         for(int i=0;i<list.size();i++){
        	 sensitiveWordSet.add(list.get(i).getWordname().replaceAll("\\s*", ""));
         }
         //��ʼ�����дʿ�
         SensitiveWordUtil.init(sensitiveWordSet);
         System.out.println("���дʵ�������" + SensitiveWordUtil.sensitiveWordMap.size());*/
		
		//ͨ��MyApplicationContextUtil��ȡbean
		SysParamService sysParamService= MyApplicationContextUtil.getContext().getBean(SysParamService.class);
		final SysCodeTypeService sysCodeTypeService= MyApplicationContextUtil.getContext().getBean(SysCodeTypeService.class);
		
		//s_paramͬ��
		List <SysParam> list_param=sysParamService.getList();
		for(SysParam sparam:list_param){
			EhCacheUtil.getManager().getCache("webcache").put(new Element(sparam.getParamtype(),sparam.getParamvalue()));
		}
		  //ʹ��redis
        if (redisswitch.equals("on")) {
            log.info("ʹ��redis���ز���");
          //ͨ��MyApplicationContextUtil��ȡbean
    		final RedisManager redismanager= MyApplicationContextUtil.getContext().getBean(RedisManager.class);
    		redismanager.init();
    		//�Ƿ�ͬ����־ �����һ��ͬ��ʱ����1Сʱ֮�ڣ���ͬ�����ش���
    		boolean syn_flag=true;
    		Date code_value_last_update_time=(Date)redismanager.get("code_value_last_update_time"); 
    		if(code_value_last_update_time!=null){
    			if(!DateUtil.compare(new Date(), code_value_last_update_time, 3600*1000)){
    				syn_flag=false;
    			}
    		}
    		
			//code_type code_valueͬ��
			List <CodeType> list_code_type=sysCodeTypeService.getInitcodetypeList();
			if(syn_flag){
				 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
				 for(int i = 0; i < list_code_type.size(); i++){
					 final CodeType codeType = list_code_type.get(i);
					 final String code_type = codeType.getCode_type();
					 fixedThreadPool.execute(new Runnable() {
						public void run() {
						  log.info("��������="+code_type+",��ǰ�߳�="+Thread.currentThread().getName());
						List<CodeValue> list_code_value =sysCodeTypeService.getInitCodeValueList(codeType);
						if (list_code_value.size() > 0) {
							//������μӼ��ص�redis������
							try{
								redismanager.set(code_type, list_code_value);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
              		    }
          		   });  
			}
			//��һ�θ���ʱ��
			redismanager.set("code_value_last_update_time", new Date());
			}else{
				for(CodeType codetype : list_code_type){
    				String code_type=codetype.getCode_type();
    				//������μӼ��ص�redis������
    				try{
    					//������μӼ��ص�ehcache������
    					EhCacheUtil.getManager().getCache("webcache").put(new Element(code_type,redismanager.get(code_type)));
    				}catch(Exception e){
    					e.printStackTrace();
    				}
    			}
			}
        }else{
    		//�Ƿ�ͬ����־ �����һ��ͬ��ʱ����1Сʱ֮�ڣ���ͬ�����ش���
    		boolean syn_flag=true;
    		if(syn_flag){
    			//code_type code_valueͬ��
    			List <CodeType> list_code_type=sysCodeTypeService.getInitcodetypeList();
    			
    			 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);  
                 for(int i = 0; i < list_code_type.size(); i++){  
                 	 final CodeType codeType = list_code_type.get(i);
                 	 final String code_type = codeType.getCode_type();  
                 	 fixedThreadPool.execute(new Runnable() {  
                 		    public void run() {  
                 		      log.info("��������="+code_type+",��ǰ�߳�="+Thread.currentThread().getName());  
             				  List<CodeValue> list_code_value =sysCodeTypeService.getInitCodeValueList(codeType);
             				  if (list_code_value.size() > 0) {
             					//������μӼ��ص�redis������
             					try{
             						//������μӼ��ص�ehcache������
             						EhCacheUtil.getManager().getCache("webcache").put(new Element(code_type,list_code_value));
		             		        }catch(Exception e){
		             		        	//e.printStackTrace();
		             		        }
             				}
                 		    }
             		   });  
                 }}}
	}
}