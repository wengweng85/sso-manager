package com.insigma.mvc.service.common.suggest;

import java.util.HashMap;
import java.util.List;

import com.insigma.mvc.model.SysSuggestKey;


/**

 * @author admin
 *
 */
public interface SuggestSearchService {
	
	HashMap<String,List<SysSuggestKey>> searchByKey(SysSuggestKey key);
	
}
