/**
 * 
 */
package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 谢意
 *
 */
@Entity
@Table(name = "policeinfo")
public class PoliceInfo {
	@Id
	@Column(name = "jy_ID")
	private String jy_ID;//警员身份证
	@Column(name = "jy_name")
	private String jy_name;//警员姓名
	@Column(name = "workplace")
	private String workplace;//工作单位
	@Column(name = "jh")
	private String jh;//警号
	@Column(name = "wp_ID")
	private String wpID;//单位编码
	
	public PoliceInfo() {
		
	}
	/**
	 * @param jy_ID
	 * @param jy_name
	 * @param workplace
	 * @param jh
	 * @param wpID
	 */
	public PoliceInfo(String jy_ID, String jy_name, String workplace, String jh, String wpID) {
		super();
		this.jy_ID = jy_ID;
		this.jy_name = jy_name;
		this.workplace = workplace;
		this.jh = jh;
		this.wpID = wpID;
	}
	/**
	 * @return jy_ID
	 */
	public String getJy_ID() {
		return jy_ID;
	}
	/**
	 * @param jy_ID 要设置的 jy_ID
	 */
	public void setJy_ID(String jy_ID) {
		this.jy_ID = jy_ID;
	}
	/**
	 * @return jy_name
	 */
	public String getJy_name() {
		return jy_name;
	}
	/**
	 * @param jy_name 要设置的 jy_name
	 */
	public void setJy_name(String jy_name) {
		this.jy_name = jy_name;
	}
	/**
	 * @return workplace
	 */
	public String getWorkplace() {
		return workplace;
	}
	/**
	 * @param workplace 要设置的 workplace
	 */
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	/**
	 * @return jh
	 */
	public String getJh() {
		return jh;
	}
	/**
	 * @param jh 要设置的 jh
	 */
	public void setJh(String jh) {
		this.jh = jh;
	}
	/**
	 * @return wpID
	 */
	public String getWpID() {
		return wpID;
	}
	/**
	 * @param wpID 要设置的 wpID
	 */
	public void setWpID(String wpID) {
		this.wpID = wpID;
	}
	
}
