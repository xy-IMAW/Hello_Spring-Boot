/**
 * 轨迹情报预警
 * 原始数据模型
 */
package com.example.demo.model;


import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class Trace_Predict_FengHuoModel {
	
	@ApiModelProperty("姓名")
	private String XM;
	@ApiModelProperty("性别")
	private String XB;
	@ApiModelProperty("民族")
	private String MZ;
	@ApiModelProperty("证件类型")
	private String ZJLX;
	@ApiModelProperty("证件号码")
	private String ZJHM;
	@ApiModelProperty("详细地址")
	private String XZ;
	@ApiModelProperty("起点")
	private String QD;
	@ApiModelProperty("终点")
	private String ZD;
	@ApiModelProperty("座位号")
	private String ZWH;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	@ApiModelProperty("开始时间")
	private Date START_TIME;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	@ApiModelProperty("结束时间")
	private Date END_TIME;
	@ApiModelProperty("经度")
	private BigDecimal X;
	@ApiModelProperty("纬度")
	private BigDecimal Y;
	@ApiModelProperty("告警产生时间")
	private String CREATETIME;
	@ApiModelProperty("轨迹类型")
	private String GJLX;
	@ApiModelProperty("告警来源")
	private String SOURCE_FROM;
	@ApiModelProperty("代码")
	private String DM;
	@ApiModelProperty("名称")
	private String MC;
	@ApiModelProperty("相似度")
	private String SIMILARITY;
	@ApiModelProperty("人脸图片路径")
	private String FACEBKPATH;
	@ApiModelProperty("冗余字段1")
	private String EXT1;
	@ApiModelProperty("冗余字段2")
	private String EXT2;
	public String getXM() {
		return XM;
	}
	public void setXM(String xM) {
		XM = xM;
	}
	public String getXB() {
		return XB;
	}
	public void setXB(String xB) {
		XB = xB;
	}
	public String getMZ() {
		return MZ;
	}
	public void setMZ(String mZ) {
		MZ = mZ;
	}
	public String getZJLX() {
		return ZJLX;
	}
	public void setZJLX(String zJLX) {
		ZJLX = zJLX;
	}
	public String getZJHM() {
		return ZJHM;
	}
	public void setZJHM(String zJHM) {
		ZJHM = zJHM;
	}
	public String getXZ() {
		return XZ;
	}
	public void setXZ(String xZ) {
		XZ = xZ;
	}
	public String getQD() {
		return QD;
	}
	public void setQD(String qD) {
		QD = qD;
	}
	public String getZD() {
		return ZD;
	}
	public void setZD(String zD) {
		ZD = zD;
	}
	public String getZWH() {
		return ZWH;
	}
	public void setZWH(String zWH) {
		ZWH = zWH;
	}
	public Date getSTART_TIME() {
		return START_TIME;
	}
	public void setSTART_TIME(Date sTART_TIME) {
		START_TIME = sTART_TIME;
	}
	public Date getEND_TIME() {
		return END_TIME;
	}
	public void setEND_TIME(Date eND_TIME) {
		END_TIME = eND_TIME;
	}
	public BigDecimal getX() {
		return X;
	}
	public void setX(BigDecimal x) {
		X = x;
	}
	public BigDecimal getY() {
		return Y;
	}
	public void setY(BigDecimal y) {
		Y = y;
	}
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getGJLX() {
		return GJLX;
	}
	public void setGJLX(String gJLX) {
		GJLX = gJLX;
	}
	public String getSOURCE_FROM() {
		return SOURCE_FROM;
	}
	public void setSOURCE_FROM(String sOURCE_FROM) {
		SOURCE_FROM = sOURCE_FROM;
	}
	public String getDM() {
		return DM;
	}
	public void setDM(String dM) {
		DM = dM;
	}
	public String getMC() {
		return MC;
	}
	public void setMC(String mC) {
		MC = mC;
	}
	public String getSIMILARITY() {
		return SIMILARITY;
	}
	public void setSIMILARITY(String sIMILARITY) {
		SIMILARITY = sIMILARITY;
	}
	public String getFACEBKPATH() {
		return FACEBKPATH;
	}
	public void setFACEBKPATH(String fACEBKPATH) {
		FACEBKPATH = fACEBKPATH;
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

	
	
}
