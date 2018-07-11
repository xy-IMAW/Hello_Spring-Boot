/**
 * 
 */
package com.example.demo.controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 谢意
 *
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private UserDao userDao;
	
	@ApiOperation(value = "登录检测")
	@PostMapping("/login")
	public String login(@RequestBody UserEntity user,HttpServletRequest request) {
		//登录成功
		boolean flag = true;
		String result = "登录成功";
		//根据用户名查询用户是否存在
		UserEntity userEntity = userDao.findOne(new Specification<UserEntity>() {
			
			@Override
			public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.equal(root.get("id"),user.getId()));
				return null;
			}
		});
		//用户不存在
		if(userEntity == null) {
			flag = false;
			result = "用户不存在，登录失败";
		}
		//密码错误
		else if (!userEntity.getPassword().equals(user.getPassword())) {
			flag = false;
			result = "密码错误！";
		}
		//登录成功
		if(flag) {
			//将用户写入session
			request.getSession().setAttribute("_session_user", userEntity);
		}
		return result;
	}
	
}
