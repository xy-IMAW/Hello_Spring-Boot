/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.RoleExample;
import com.example.demo.model.User;

/**
 * 
 *
 */
public interface UserService  {
	public List<UserEntity> getUserList();
	public String save(UserEntity userEntity,BindingResult result);
	public List<UserEntity> deleteOne(String id);
	public UserEntity getUserInfoById(String id);
	public List<User> getUserByName(String name);
	public long getCountById(String name);
	
}
