/**
 * 
 */
package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.model.RoleExample;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.serializer.Serializer;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserMapper;

/**
 * JPA方式操作数据库
 * @author 谢意
 *
 */
@Api(tags="用户接口")
@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userservice;
	@Autowired
	private UserMapper user;

	
	@GetMapping("/list")
	@ApiOperation(value = "返回所有数据")
	public List<UserEntity> list(){
	
		return user.userList();
	}
	
	@PostMapping(value="/save")
	@ApiOperation(value = "存储一个信息")
	public String save(@Valid@RequestBody UserEntity userEntity,BindingResult result) {
		log.info("存储一条数据：" + JSON.toJSONString(userEntity));
		return userservice.save(userEntity, result);
	}
	
	
	
	@DeleteMapping(value="delete")
	@ApiOperation(value = "删除一条账户信息")
	public List<UserEntity> delete(String id) {
		return userservice.deleteOne(id);
	}
	
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "根据id查询user信息")
	public UserEntity getUserList(@ApiParam(value = "id",required = true)@PathVariable String id){
		log.info("接收到id：" + id + "查询到结果为：" + JSON.toJSONString(userservice.getUserInfoById(id)));
		return userservice.getUserInfoById(id);
	}
	@GetMapping("/info/{name}")
	@ApiOperation(value = "根据用户id获取用户信息")
	public List<User> getRoles(@ApiParam(value = "name")@PathVariable String name){
		log.info("接收到id：" + name + "查询到结果为：" + JSON.toJSONString(userservice.getUserByName(name)));
		return userservice.getUserByName(name);
	}
	
	@GetMapping("/getCount/{name}")
	@ApiOperation(value = "根据id返回信息统计")
	public long getCountById(@ApiParam(value = "id")@PathVariable String name) {
		return userservice.getCountById(name);
	}
}
