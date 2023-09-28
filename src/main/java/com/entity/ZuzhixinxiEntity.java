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
 * 组织信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@TableName("zuzhixinxi")
public class ZuzhixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZuzhixinxiEntity() {
		
	}
	
	public ZuzhixinxiEntity(T t) {
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
	@TableId
	private Long id;
	/**
	 * 组织编号
	 */
					
	private String zuzhibianhao;
	
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
