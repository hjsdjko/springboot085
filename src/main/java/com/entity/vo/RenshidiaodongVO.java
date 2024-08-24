package com.entity.vo;

import com.entity.RenshidiaodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 人事调动
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public class RenshidiaodongVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 部门
	 */
	
	private String bumen;
		
	/**
	 * 岗位
	 */
	
	private String gangwei;
		
	/**
	 * 新岗位
	 */
	
	private String xingangwei;
		
	/**
	 * 薪资调整
	 */
	
	private String xinzidiaozheng;
		
	/**
	 * 调动详情
	 */
	
	private String diaodongxiangqing;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：部门
	 */
	 
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	
	/**
	 * 获取：部门
	 */
	public String getBumen() {
		return bumen;
	}
				
	
	/**
	 * 设置：岗位
	 */
	 
	public void setGangwei(String gangwei) {
		this.gangwei = gangwei;
	}
	
	/**
	 * 获取：岗位
	 */
	public String getGangwei() {
		return gangwei;
	}
				
	
	/**
	 * 设置：新岗位
	 */
	 
	public void setXingangwei(String xingangwei) {
		this.xingangwei = xingangwei;
	}
	
	/**
	 * 获取：新岗位
	 */
	public String getXingangwei() {
		return xingangwei;
	}
				
	
	/**
	 * 设置：薪资调整
	 */
	 
	public void setXinzidiaozheng(String xinzidiaozheng) {
		this.xinzidiaozheng = xinzidiaozheng;
	}
	
	/**
	 * 获取：薪资调整
	 */
	public String getXinzidiaozheng() {
		return xinzidiaozheng;
	}
				
	
	/**
	 * 设置：调动详情
	 */
	 
	public void setDiaodongxiangqing(String diaodongxiangqing) {
		this.diaodongxiangqing = diaodongxiangqing;
	}
	
	/**
	 * 获取：调动详情
	 */
	public String getDiaodongxiangqing() {
		return diaodongxiangqing;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
			
}
