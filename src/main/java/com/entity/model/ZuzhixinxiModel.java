package com.entity.model;

import com.entity.ZuzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 组织信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public class ZuzhixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 组织名称
	 */
	
	private String zuzhimingcheng;
		
	/**
	 * 组织宣言
	 */
	
	private String zuzhixuanyan;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 组织介绍
	 */
	
	private String zuzhijieshao;
		
	/**
	 * 组织图片
	 */
	
	private String zuzhitupian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
				
	
	/**
	 * 设置：组织宣言
	 */
	 
	public void setZuzhixuanyan(String zuzhixuanyan) {
		this.zuzhixuanyan = zuzhixuanyan;
	}
	
	/**
	 * 获取：组织宣言
	 */
	public String getZuzhixuanyan() {
		return zuzhixuanyan;
	}
				
	
	/**
	 * 设置：负责人
	 */
	 
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：组织介绍
	 */
	 
	public void setZuzhijieshao(String zuzhijieshao) {
		this.zuzhijieshao = zuzhijieshao;
	}
	
	/**
	 * 获取：组织介绍
	 */
	public String getZuzhijieshao() {
		return zuzhijieshao;
	}
				
	
	/**
	 * 设置：组织图片
	 */
	 
	public void setZuzhitupian(String zuzhitupian) {
		this.zuzhitupian = zuzhitupian;
	}
	
	/**
	 * 获取：组织图片
	 */
	public String getZuzhitupian() {
		return zuzhitupian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
