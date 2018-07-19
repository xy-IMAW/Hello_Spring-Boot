/**
 * 
 */
package com.example.demo.utils;

//import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import com.example.demo.entity.ExceptionResultEntity;

/**
 * 
 *
 */
public class ExceptionUtils {
	/**
	 * 创建普通消息方法
	 * @param flag
	 * @param msg
	 * @param result
	 * @param jumpUrl
	 * @param rows
	 * @param throwable
	 * @return
	 */
	
	public static ExceptionResultEntity exceptionUtils(boolean flag,
			String msg,Object result,String jumpUrl,int rows,Throwable throwable) {
		//创建返回对象
		ExceptionResultEntity exceptionResultEntity = ExceptionResultEntity.newInstance();
		exceptionResultEntity.setFlag(flag);
		exceptionResultEntity.setJumpUrl(jumpUrl);
		exceptionResultEntity.setMsg(msg == "" ? "执行成功" : msg);
		exceptionResultEntity.setResult(result);
		exceptionResultEntity.setRows(rows);
		exceptionResultEntity.setTime(System.currentTimeMillis());
				
		return exceptionResultEntity;
	}
	
	public static ExceptionResultEntity success(Object result) {
		int rows = 0;
		if(result instanceof List) {
			//获取总数量
			rows = ((List)result).size();
		}
		return exceptionUtils(true,"",result,"",rows,null);
		
	}
	
	public static ExceptionResultEntity error(String msg,Throwable throwable) {
		return exceptionUtils(false, msg, "", "", 0, throwable);
		
	}
}
