/**
 * 
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 谢意
 *
 */
@Entity
@Table(name="user")
@ApiModel(value = "userInfo")
public class UserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591622927928434728L;

	@Id
	@Column(name="id")
	@ApiModelProperty(value = "id",required = true)
	@NotNull
	private String id;
	
	@ApiModelProperty(value = "姓名",required = true)
	@Column(name="name")
	@NotBlank
	@Length(min = 2,max = 6)
	private String name;

	@ApiModelProperty(value = "密码",required = true)
	@Column(name="password")
	@Length(min=4)
	@NotBlank
	private String password;



	
	public UserEntity() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param password
	 */
	public UserEntity(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	







	
	

}
