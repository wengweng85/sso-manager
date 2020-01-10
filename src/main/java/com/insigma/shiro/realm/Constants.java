package com.insigma.shiro.realm;


/**
 * redis cache key get
 * @author admin
 *
 */
public class Constants {

	public static String INVALID_CLIENT_DESCRIPTION="INVALID_CLIENT_DESCRIPTION";
	public static String RESOURCE_SERVER_NAME="RESOURCE_SERVER_NAME";
	/**
	 * getUserModuleCacheKey
	 * @param username
	 * @return
	 */
	public static String getUserInfoKey(String username){
		return "user_info_key_"+username;
	}
	
	/**
	 * getUserRolesCacheKey
	 * @param username
	 * @return
	 */
	public static String getUserRolesCacheKey(String username){
		return "user_roles_key_"+username;
	}
	
	/**
	 * getUserRolesCacheKey
	 * @param username
	 * @return
	 */
	public static String getUserPermissionCacheKey(String username){
		return "user_permissions_key_"+username;
	}

}
