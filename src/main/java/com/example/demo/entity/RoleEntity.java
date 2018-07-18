/**
 * 
 */
package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

/**
 * 
 *
 */
@Table(name = "role")
@Entity
@ApiModel(value = "role")
public class RoleEntity implements Serializable {
	@Id
	@Column(name = "id")
	private String ID;
	@Column(name = "role_name")
	private String role_name;

	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
}
