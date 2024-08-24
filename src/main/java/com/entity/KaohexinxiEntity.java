package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 考核信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@TableName("kaohexinxi")
public class KaohexinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaohexinxiEntity() {
		
	}
	
	public KaohexinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 考核月份
	 */
					
	private String kaoheyuefen;
	
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
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
	 * 员工考勤
	 */
					
	private Integer yuangongkaoqin;
	
	/**
	 * 工作态度
	 */
					
	private Integer gongzuotaidu;
	
	/**
	 * 业务技能
	 */
					
	private Integer yewujineng;
	
	/**
	 * 工作效率
	 */
					
	private Integer gongzuoxiaolv;
	
	/**
	 * 绩效总分
	 */
					
	private Integer jixiaozongfen;
	
	/**
	 * 评价等级
	 */
					
	private String pingjiadengji;
	
	/**
	 * 考核日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaoheriqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：考核月份
	 */
	public void setKaoheyuefen(String kaoheyuefen) {
		this.kaoheyuefen = kaoheyuefen;
	}
	/**
	 * 获取：考核月份
	 */
	public String getKaoheyuefen() {
		return kaoheyuefen;
	}
	/**
	 * 设置：员工工号
	 */
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
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
	 * 设置：员工考勤
	 */
	public void setYuangongkaoqin(Integer yuangongkaoqin) {
		this.yuangongkaoqin = yuangongkaoqin;
	}
	/**
	 * 获取：员工考勤
	 */
	public Integer getYuangongkaoqin() {
		return yuangongkaoqin;
	}
	/**
	 * 设置：工作态度
	 */
	public void setGongzuotaidu(Integer gongzuotaidu) {
		this.gongzuotaidu = gongzuotaidu;
	}
	/**
	 * 获取：工作态度
	 */
	public Integer getGongzuotaidu() {
		return gongzuotaidu;
	}
	/**
	 * 设置：业务技能
	 */
	public void setYewujineng(Integer yewujineng) {
		this.yewujineng = yewujineng;
	}
	/**
	 * 获取：业务技能
	 */
	public Integer getYewujineng() {
		return yewujineng;
	}
	/**
	 * 设置：工作效率
	 */
	public void setGongzuoxiaolv(Integer gongzuoxiaolv) {
		this.gongzuoxiaolv = gongzuoxiaolv;
	}
	/**
	 * 获取：工作效率
	 */
	public Integer getGongzuoxiaolv() {
		return gongzuoxiaolv;
	}
	/**
	 * 设置：绩效总分
	 */
	public void setJixiaozongfen(Integer jixiaozongfen) {
		this.jixiaozongfen = jixiaozongfen;
	}
	/**
	 * 获取：绩效总分
	 */
	public Integer getJixiaozongfen() {
		return jixiaozongfen;
	}
	/**
	 * 设置：评价等级
	 */
	public void setPingjiadengji(String pingjiadengji) {
		this.pingjiadengji = pingjiadengji;
	}
	/**
	 * 获取：评价等级
	 */
	public String getPingjiadengji() {
		return pingjiadengji;
	}
	/**
	 * 设置：考核日期
	 */
	public void setKaoheriqi(Date kaoheriqi) {
		this.kaoheriqi = kaoheriqi;
	}
	/**
	 * 获取：考核日期
	 */
	public Date getKaoheriqi() {
		return kaoheriqi;
	}

}
