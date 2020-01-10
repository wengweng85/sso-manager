package com.insigma.mvc.jpa.dao.log;

import com.insigma.mvc.model.SysLog;
import org.springframework.data.repository.CrudRepository;

import com.insigma.mvc.model.SLog;



/**
 * @author admin
 *
 */
public interface SysLogDao extends CrudRepository <SysLog, String> {
	
}
