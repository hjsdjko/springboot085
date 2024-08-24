package com.entity.model;

import com.entity.YuangongzhuanzhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 员工转正
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public class YuangongzhuanzhengModel  implements Serializable {
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
	 * 转正说明
	 */
	
	private String zhuanzhengshuoming;
		
	/**
	 * 转正日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zhuanzhengriqi;
				
	
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
	 * 设置：转正说明
	 */
	 
	public void setZhuanzhengshuoming(String zhuanzhengshuoming) {
		this.zhuanzhengshuoming = zhuanzhengshuoming;
	}
	
	/**
	 * 获取：转正说明
	 */
	public String getZhuanzhengshuoming() {
		return zhuanzhengshuoming;
	}
				
	
	/**
	 * 设置：转正日期
	 */
	 
	public void setZhuanzhengriqi(Date zhuanzhengriqi) {
		this.zhuanzhengriqi = zhuanzhengriqi;
	}
	
	/**
	 * 获取：转正日期
	 */
	public Date getZhuanzhengriqi() {
		return zhuanzhengriqi;
	}
			
}
