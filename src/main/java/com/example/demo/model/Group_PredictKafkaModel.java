/**
 * 群体事件预警kafka模型
 * 
 */
package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 */
public class Group_PredictKafkaModel {
	@ApiModelProperty("事件名")
	private String eventName;
	@ApiModelProperty("事件描述")
	private String eventDesc;
	@ApiModelProperty("事件类型")
	private String eventType;
	@ApiModelProperty("管辖单位代码")
	private String dutyOrgCode;
	@ApiModelProperty("告警时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private Date alartTime;
	@ApiModelProperty("告警地点")
	private String alartAddress;
	@ApiModelProperty("人数")
	private int participantCnt;
	@ApiModelProperty("是否敏感区域")
	private boolean isSensitiveArea;
	
	public String getEventname() {
		return eventName;
	}
	public void setEventname(String eventname) {
		this.eventName = eventname;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getDutyOrgCode() {
		return dutyOrgCode;
	}
	public void setDutyOrgCode(String dutyOrgCode) {
		this.dutyOrgCode = dutyOrgCode;
	}
	public Date getAlartTime() {
		return alartTime;
	}
	public void setAlartTime(Date alartTime) {
		this.alartTime = alartTime;
	}
	public String getAlartAddress() {
		return alartAddress;
	}
	public void setAlartAddress(String alartAddress) {
		this.alartAddress = alartAddress;
	}
	public int getParticipantCnt() {
		return participantCnt;
	}
	public void setParticipantCnt(int participantCnt) {
		this.participantCnt = participantCnt;
	}
	public boolean isSensitiveArea() {
		return isSensitiveArea;
	}
	public void setSensitiveArea(boolean isSensitiveArea) {
		this.isSensitiveArea = isSensitiveArea;
	}
	
	
}
