package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhiyuanhuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhiyuanhuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhiyuanhuodongView;


/**
 * 志愿活动评论表
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface DiscusszhiyuanhuodongService extends IService<DiscusszhiyuanhuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhiyuanhuodongVO> selectListVO(Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
   	
   	DiscusszhiyuanhuodongVO selectVO(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
   	
   	List<DiscusszhiyuanhuodongView> selectListView(Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
   	
   	DiscusszhiyuanhuodongView selectView(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
   	

}

