package com.entity.model;

import com.entity.HuodongdakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 活动打卡
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public class HuodongdakaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动名称
	 */
	
	private String huodongmingcheng;
		
	/**
	 * 活动地点
	 */
	
	private String huodongdidian;
		
	/**
	 * 打卡时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dakashijian;
		
	/**
	 * 活动时长
	 */
	
	private String huodongshizhang;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 组织编号
	 */
	
	private String zuzhibianhao;
		
	/**
	 * 组织名称
	 */
	
	private String zuzhimingcheng;
				
	
	/**
	 * 设置：活动名称
	 */
	 
	public void setHuodongmingcheng(String huodongmingcheng) {
		this.huodongmingcheng = huodongmingcheng;
	}
	
	/**
	 * 获取：活动名称
	 */
	public String getHuodongmingcheng() {
		return huodongmingcheng;
	}
				
	
	/**
	 * 设置：活动地点
	 */
	 
	public void setHuodongdidian(String huodongdidian) {
		this.huodongdidian = huodongdidian;
	}
	
	/**
	 * 获取：活动地点
	 */
	public String getHuodongdidian() {
		return huodongdidian;
	}
				
	
	/**
	 * 设置：打卡时间
	 */
	 
	public void setDakashijian(Date dakashijian) {
		this.dakashijian = dakashijian;
	}
	
	/**
	 * 获取：打卡时间
	 */
	public Date getDakashijian() {
		return dakashijian;
	}
				
	
	/**
	 * 设置：活动时长
	 */
	 
	public void setHuodongshizhang(String huodongshizhang) {
		this.huodongshizhang = huodongshizhang;
	}
	
	/**
	 * 获取：活动时长
	 */
	public String getHuodongshizhang() {
		return huodongshizhang;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：组织编号
	 */
	 
	public void setZuzhibianhao(String zuzhibianhao) {
		this.zuzhibianhao = zuzhibianhao;
	}
	
	/**
	 * 获取：组织编号
	 */
	public String getZuzhibianhao() {
		return zuzhibianhao;
	}
				
	
	/**
	 * 设置：组织名称
	 */
	 
	public void setZuzhimingcheng(String zuzhimingcheng) {
		this.zuzhimingcheng = zuzhimingcheng;
	}
	
	/**
	 * 获取：组织名称
	 */
	public String getZuzhimingcheng() {
		return zuzhimingcheng;
	}
			
}
