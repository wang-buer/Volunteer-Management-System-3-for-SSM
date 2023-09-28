package com.dao;

import com.entity.ZuzhishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuzhishenqingVO;
import com.entity.view.ZuzhishenqingView;


/**
 * 组织申请
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZuzhishenqingDao extends BaseMapper<ZuzhishenqingEntity> {
	
	List<ZuzhishenqingVO> selectListVO(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
	
	ZuzhishenqingVO selectVO(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
	
	List<ZuzhishenqingView> selectListView(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);

	List<ZuzhishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
	
	ZuzhishenqingView selectView(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
	

}
