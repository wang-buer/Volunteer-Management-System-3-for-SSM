package com.dao;

import com.entity.HuodongdakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongdakaVO;
import com.entity.view.HuodongdakaView;


/**
 * 活动打卡
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface HuodongdakaDao extends BaseMapper<HuodongdakaEntity> {
	
	List<HuodongdakaVO> selectListVO(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
	
	HuodongdakaVO selectVO(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
	
	List<HuodongdakaView> selectListView(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);

	List<HuodongdakaView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
	
	HuodongdakaView selectView(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
	

}
