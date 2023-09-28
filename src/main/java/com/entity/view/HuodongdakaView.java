package com.entity.view;

import com.entity.HuodongdakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动打卡
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@TableName("huodongdaka")
public class HuodongdakaView  extends HuodongdakaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongdakaView(){
	}
 
 	public HuodongdakaView(HuodongdakaEntity huodongdakaEntity){
 	try {
			BeanUtils.copyProperties(this, huodongdakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
