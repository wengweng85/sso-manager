package com.insigma.mvc.service.demo;

import java.util.HashMap;

import com.insigma.dto.AjaxReturnMsg;
import com.insigma.mvc.model.DemoAc01;





/**
 * demo ac01 service
 * @author admin
 *
 */
public interface DemoService {
	
	 HashMap<String,Object> getDemoAc01List( DemoAc01 ac01 );
	
	 AjaxReturnMsg<String> deleteDemoById(String aac001);
	
	 AjaxReturnMsg<String> batDeleteDemoData(DemoAc01 ac01);
	
	 DemoAc01 getDemoById(String aac001);
	
	 DemoAc01 getDemoNameById(String aac001);
	
	 AjaxReturnMsg<String>saveDemoData(DemoAc01 ac01);
	
	 AjaxReturnMsg<String> updateDemoAc01DemBusUuid(DemoAc01 ac01);
	
	 AjaxReturnMsg<String> deletefile(DemoAc01 ac01);

}
