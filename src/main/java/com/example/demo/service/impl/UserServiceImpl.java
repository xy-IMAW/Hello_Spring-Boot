/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import com.example.demo.service.UserService;

/**
 * 
 *
 */
@Service
//@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper rolemapper;
	@Autowired
	private MessageSource messagesource;
	@Override
	//@Cacheable
	public List<UserEntity> getUserList() {
		// TODO 自动生成的方法存根
		
		return userDao.findAll();
	}
	@Override
	//@Cacheable
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
		log.info("验证通过，id："+userEntity.getId()+"名称："+userEntity.getName()+"密码："+userEntity.getPassword());
		return "验证通过，id："+userEntity.getId()+"名称："+userEntity.getName()+"密码："+userEntity.getPassword();
	}
	@Override
	//@Cacheable
	public List<UserEntity> deleteOne(String id) {
		userDao.delete(id);
		return userDao.findAll();
	}
	@Override
	public UserEntity getUserInfoById(String id) {
		return userDao.findById(id);
		//return userDao.findById(id);
	}
	@Override
	public List<User> getUserByName(String name) {
		// TODO 自动生成的方法存根
		UserExample userExample = new UserExample();
		userExample.createCriteria().andNameEqualTo(name);
		List<User> user = userMapper.selectByExample(userExample);
		return user;
		//return rolemapper.selectRolesById(id);
		//return null;
	}
	@Override
	public long getCountById(String name) {
		// TODO 自动生成的方法存根
		UserExample userExample = new UserExample();
		userExample.createCriteria().andNameEqualTo(name);
		return userMapper.countByExample(userExample);
	}


}
