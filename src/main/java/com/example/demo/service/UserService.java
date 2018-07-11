/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.example.demo.entity.UserEntity;

/**
 * 
 *
 */
public interface UserService  {
	public List<UserEntity> getUserList();
	public String save(UserEntity userEntity,BindingResult result);
	public List<UserEntity> deleteOne(String id);
	
}
