package com.entity.view;

import com.entity.ZhiyuanzuzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 志愿组织
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@TableName("zhiyuanzuzhi")
public class ZhiyuanzuzhiView  extends ZhiyuanzuzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiyuanzuzhiView(){
	}
 
 	public ZhiyuanzuzhiView(ZhiyuanzuzhiEntity zhiyuanzuzhiEntity){
 	try {
			BeanUtils.copyProperties(this, zhiyuanzuzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
