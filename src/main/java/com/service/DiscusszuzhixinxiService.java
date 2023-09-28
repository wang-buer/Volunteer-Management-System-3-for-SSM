package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszuzhixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszuzhixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszuzhixinxiView;


/**
 * 组织信息评论表
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface DiscusszuzhixinxiService extends IService<DiscusszuzhixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszuzhixinxiVO> selectListVO(Wrapper<DiscusszuzhixinxiEntity> wrapper);
   	
   	DiscusszuzhixinxiVO selectVO(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
   	
   	List<DiscusszuzhixinxiView> selectListView(Wrapper<DiscusszuzhixinxiEntity> wrapper);
   	
   	DiscusszuzhixinxiView selectView(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszuzhixinxiEntity> wrapper);
   	

}

