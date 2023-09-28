package com.dao;

import com.entity.DiscusszhiyuanhuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhiyuanhuodongVO;
import com.entity.view.DiscusszhiyuanhuodongView;


/**
 * 志愿活动评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface DiscusszhiyuanhuodongDao extends BaseMapper<DiscusszhiyuanhuodongEntity> {
	
	List<DiscusszhiyuanhuodongVO> selectListVO(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
	
	DiscusszhiyuanhuodongVO selectVO(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
	
	List<DiscusszhiyuanhuodongView> selectListView(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);

	List<DiscusszhiyuanhuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
	
	DiscusszhiyuanhuodongView selectView(@Param("ew") Wrapper<DiscusszhiyuanhuodongEntity> wrapper);
	

}
