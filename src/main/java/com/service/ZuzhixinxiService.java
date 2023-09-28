package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuzhixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuzhixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuzhixinxiView;


/**
 * 组织信息
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZuzhixinxiService extends IService<ZuzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhixinxiVO> selectListVO(Wrapper<ZuzhixinxiEntity> wrapper);
   	
   	ZuzhixinxiVO selectVO(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
   	
   	List<ZuzhixinxiView> selectListView(Wrapper<ZuzhixinxiEntity> wrapper);
   	
   	ZuzhixinxiView selectView(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhixinxiEntity> wrapper);
   	

}

