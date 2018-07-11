/**
 * 
 */
package com.example.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.UserEntity;
/**
 * @author 谢意
 *
 */
public interface UserDao extends JpaRepository<UserEntity, String>,JpaSpecificationExecutor<UserEntity>,Serializable {

}
