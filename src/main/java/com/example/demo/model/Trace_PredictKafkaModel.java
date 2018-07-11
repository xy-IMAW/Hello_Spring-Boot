/**
 * 轨迹情报kafka模型
 */
package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 *
 */
public class Trace_PredictKafkaModel {
	@ApiModelProperty("姓名")
	private String name;
	@ApiModelProperty("性别")
	private String gender;
	@ApiModelProperty("民族")
	private String nation;
	@ApiModelProperty("证件类型")
	private String credType;
	@ApiModelProperty("证件号码")
	private String credNo;
	@ApiModelProperty("详细地址")
	private String addressDetial;
	@ApiModelProperty("起点")
	private String startPoint;
	@ApiModelProperty("终点")
	private String endPoint;
	@ApiModelProperty("座位号")
	private String seatNo;
	@ApiModelProperty("开始时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private Date startTime;
	@ApiModelProperty("结束时间")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private Date endTime;
	@ApiModelProperty("经度")
	private BigDecimal longitude;
	@ApiModelProperty("纬度")
	private BigDecimal latitude;
	@ApiModelProperty("告警产生时间")
	private String createTime;
	@ApiModelProperty("轨迹类型")
	private String traceType;
	@ApiModelProperty("告警来源")
	private String alarmSource;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCredType() {
		return credType;
	}
	public void setCredType(String credType) {
		this.credType = credType;
	}
	public String getCredNo() {
		return credNo;
	}
	public void setCredNo(String credNo) {
		this.credNo = credNo;
	}
	public String getAddressDetial() {
		return addressDetial;
	}
	public void setAddressDetial(String addressDetial) {
		this.addressDetial = addressDetial;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getTraceType() {
		return traceType;
	}
	public void setTraceType(String traceType) {
		this.traceType = traceType;
	}
	public String getAlarmSource() {
		return alarmSource;
	}
	public void setAlarmSource(String alarmSource) {
		this.alarmSource = alarmSource;
	}
	
	
}
