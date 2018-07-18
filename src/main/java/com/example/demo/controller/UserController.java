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

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return userservice.save(userEntity, result);
	}
	
	
	
	@DeleteMapping(value="delete")
	@ApiOperation(value = "删除一条账户信息")
	public List<UserEntity> delete(String id) {
		return userservice.deleteOne(id);
	}
	
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "根据id查询user信息")
	public UserEntity getUserList(@ApiParam(value = "id",required = true) String id){
		
		return userservice.getUserInfoById(id);
	}
	@GetMapping("/user/roles/{id}")
	@ApiOperation(value = "")
	public User getRoles(@ApiParam(value = "id") Integer id){
		return userservice.getRolesById(id);
	}
}
