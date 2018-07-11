/**
 * 群体事件预警
 * 原始数据模型
 */
package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 */
public class Group_Predict_FengHuoModel {
	@ApiModelProperty("事件名")
	private String EVENT_NAME;
	@ApiModelProperty("事件描述")
	private String EVENT_DESC;
	@ApiModelProperty("事件类型")
	private String TYPE;
	@ApiModelProperty("管辖单位代码")
	private String GXDWDM;
	@ApiModelProperty("告警时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private Date HAPPEN_TIME;
	@ApiModelProperty("告警地点")
	private String ADDR;
	@ApiModelProperty("人数")
	private int PERSON_NUM;
	@ApiModelProperty("是否敏感区域")
	private boolean IS_SENSITIVE_AREA;
	@ApiModelProperty("冗余字段1")
	private String EXT1;
	@ApiModelProperty("冗余字段2")
	private String EXT2;
	@ApiModelProperty("冗余字段3")
	private String EXT3;
	@ApiModelProperty("冗余字段4")
	private String EXT4;
	public String getEVENT_NAME() {
		return EVENT_NAME;
	}
	public void setEVENT_NAME(String eVENT_NAME) {
		EVENT_NAME = eVENT_NAME;
	}
	public String getEVENT_DESC() {
		return EVENT_DESC;
	}
	public void setEVENT_DESC(String eVENT_DESC) {
		EVENT_DESC = eVENT_DESC;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getGXDWDM() {
		return GXDWDM;
	}
	public void setGXDWDM(String gXDWDM) {
		GXDWDM = gXDWDM;
	}
	public Date getHAPPEN_TIME() {
		return HAPPEN_TIME;
	}
	public void setHAPPEN_TIME(Date hAPPEN_TIME) {
		HAPPEN_TIME = hAPPEN_TIME;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	public int getPERSON_NUM() {
		return PERSON_NUM;
	}
	public void setPERSON_NUM(int pERSON_NUM) {
		PERSON_NUM = pERSON_NUM;
	}
	public boolean isIS_SENSITIVE_AREA() {
		return IS_SENSITIVE_AREA;
	}
	public void setIS_SENSITIVE_AREA(boolean iS_SENSITIVE_AREA) {
		IS_SENSITIVE_AREA = iS_SENSITIVE_AREA;
	}
	public String getEXT1() {
		return EXT1;
	}
	public void setEXT1(String eXT1) {
		EXT1 = eXT1;
	}
	public String getEXT2() {
		return EXT2;
	}
	public void setEXT2(String eXT2) {
		EXT2 = eXT2;
	}
	public String getEXT3() {
		return EXT3;
	}
	public void setEXT3(String eXT3) {
		EXT3 = eXT3;
	}
	public String getEXT4() {
		return EXT4;
	}
	public void setEXT4(String eXT4) {
		EXT4 = eXT4;
	}
	
}
