package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 用户
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-18 17:36:24
 */
public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 所在学院
	 */
	
	private String suozaixueyuan;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 学院信息
	 */
	
	private String xueyuanxinxi;
		
	/**
	 * 志愿时
	 */
	
	private String zhiyuanshi;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 邮箱
	 */
	
	private String email;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：所在学院
	 */
	 
	public void setSuozaixueyuan(String suozaixueyuan) {
		this.suozaixueyuan = suozaixueyuan;
	}
	
	/**
	 * 获取：所在学院
	 */
	public String getSuozaixueyuan() {
		return suozaixueyuan;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：学院信息
	 */
	 
	public void setXueyuanxinxi(String xueyuanxinxi) {
		this.xueyuanxinxi = xueyuanxinxi;
	}
	
	/**
	 * 获取：学院信息
	 */
	public String getXueyuanxinxi() {
		return xueyuanxinxi;
	}
				
	
	/**
	 * 设置：志愿时
	 */
	 
	public void setZhiyuanshi(String zhiyuanshi) {
		this.zhiyuanshi = zhiyuanshi;
	}
	
	/**
	 * 获取：志愿时
	 */
	public String getZhiyuanshi() {
		return zhiyuanshi;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
			
}
