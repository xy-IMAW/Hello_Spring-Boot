/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

/**
 * 
 *
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private MessageSource messagesource;
	@Override
	@Cacheable
	public List<UserEntity> getUserList() {
		// TODO 自动生成的方法存根
		
		return userDao.findAll();
	}
	@Override
	@Cacheable
	public String save(UserEntity userEntity,BindingResult result) {
		if(result.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			//获取错误集合
			List<FieldError> fieldErrors = result.getFieldErrors();
			//获取本地locale,zh_CN
			Locale currentLocale = LocaleContextHolder.getLocale();
			//遍历错误字段获取错误消息
			for(FieldError fieldError:fieldErrors) {
				//获取错误信息
				String errorMessage = messagesource.getMessage(fieldError, currentLocale);
				//添加到错误消息集合内
				msg.append(fieldError.getField()+":"+errorMessage+",");
			}
			return msg.toString();
		}
		userDao.save(userEntity);
		return "验证通过，id："+userEntity.getId()+"名称："+userEntity.getName()+"密码："+userEntity.getPassword();
	}
	@Override
	@Cacheable
	public List<UserEntity> deleteOne(String id) {
		userDao.delete(id);
		return userDao.findAll();
	}

}
