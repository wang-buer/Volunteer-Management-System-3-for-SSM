package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanzuzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanzuzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzuzhiView;


/**
 * 志愿组织
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZhiyuanzuzhiService extends IService<ZhiyuanzuzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzuzhiVO> selectListVO(Wrapper<ZhiyuanzuzhiEntity> wrapper);
   	
   	ZhiyuanzuzhiVO selectVO(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
   	
   	List<ZhiyuanzuzhiView> selectListView(Wrapper<ZhiyuanzuzhiEntity> wrapper);
   	
   	ZhiyuanzuzhiView selectView(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzuzhiEntity> wrapper);
   	

}

