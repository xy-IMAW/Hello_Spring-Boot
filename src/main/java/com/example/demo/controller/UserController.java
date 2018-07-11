/**
 * 
 */
package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserDao;

/**
 * JPA方式操作数据库
 * @author 谢意
 *
 */
@Api(tags="用户接口")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userservice;

	
	@GetMapping("/list")
	@ApiOperation(value = "返回所有数据")
	public List<UserEntity> list(){
	
		return userDao.findAll();
	}
	
	@PostMapping(value="/save")
	@ApiOperation(value = "存储一个信息")
	public String save(@Valid@RequestBody UserEntity userEntity,BindingResult result) {
		return userservice.save(userEntity, result);
	}
	
	
	
	@DeleteMapping(value="delete")
	@ApiOperation(value = "删除一条账户信息")
	public List<UserEntity> delete(String id) {
		return userservice.deleteOne(id);
	}
	
	
	@GetMapping("/user")
	@ApiOperation(value = "Redis缓存测试")
	public List<UserEntity> getUserList(){
		
		return userservice.getUserList();
	}
}
