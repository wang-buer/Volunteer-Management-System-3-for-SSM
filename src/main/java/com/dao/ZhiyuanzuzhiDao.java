package com.dao;

import com.entity.ZhiyuanzuzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzuzhiVO;
import com.entity.view.ZhiyuanzuzhiView;


/**
 * 志愿组织
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZhiyuanzuzhiDao extends BaseMapper<ZhiyuanzuzhiEntity> {
	
	List<ZhiyuanzuzhiVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
	
	ZhiyuanzuzhiVO selectVO(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
	
	List<ZhiyuanzuzhiView> selectListView(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);

	List<ZhiyuanzuzhiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
	
	ZhiyuanzuzhiView selectView(@Param("ew") Wrapper<ZhiyuanzuzhiEntity> wrapper);
	

}
