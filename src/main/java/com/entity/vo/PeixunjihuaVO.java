package com.entity.vo;

import com.entity.PeixunjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 培训计划
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public class PeixunjihuaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 培训图片
	 */
	
	private String peixuntupian;
		
	/**
	 * 培训时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date peixunshijian;
		
	/**
	 * 培训期
	 */
	
	private String peixunqi;
		
	/**
	 * 培训内容
	 */
	
	private String peixunneirong;
		
	/**
	 * 计划时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jihuashijian;
				
	
	/**
	 * 设置：培训图片
	 */
	 
	public void setPeixuntupian(String peixuntupian) {
		this.peixuntupian = peixuntupian;
	}
	
	/**
	 * 获取：培训图片
	 */
	public String getPeixuntupian() {
		return peixuntupian;
	}
				
	
	/**
	 * 设置：培训时间
	 */
	 
	public void setPeixunshijian(Date peixunshijian) {
		this.peixunshijian = peixunshijian;
	}
	
	/**
	 * 获取：培训时间
	 */
	public Date getPeixunshijian() {
		return peixunshijian;
	}
				
	
	/**
	 * 设置：培训期
	 */
	 
	public void setPeixunqi(String peixunqi) {
		this.peixunqi = peixunqi;
	}
	
	/**
	 * 获取：培训期
	 */
	public String getPeixunqi() {
		return peixunqi;
	}
				
	
	/**
	 * 设置：培训内容
	 */
	 
	public void setPeixunneirong(String peixunneirong) {
		this.peixunneirong = peixunneirong;
	}
	
	/**
	 * 获取：培训内容
	 */
	public String getPeixunneirong() {
		return peixunneirong;
	}
				
	
	/**
	 * 设置：计划时间
	 */
	 
	public void setJihuashijian(Date jihuashijian) {
		this.jihuashijian = jihuashijian;
	}
	
	/**
	 * 获取：计划时间
	 */
	public Date getJihuashijian() {
		return jihuashijian;
	}
			
}
