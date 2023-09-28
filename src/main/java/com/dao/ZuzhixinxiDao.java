package com.dao;

import com.entity.ZuzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuzhixinxiVO;
import com.entity.view.ZuzhixinxiView;


/**
 * 组织信息
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZuzhixinxiDao extends BaseMapper<ZuzhixinxiEntity> {
	
	List<ZuzhixinxiVO> selectListVO(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
	
	ZuzhixinxiVO selectVO(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
	
	List<ZuzhixinxiView> selectListView(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);

	List<ZuzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
	
	ZuzhixinxiView selectView(@Param("ew") Wrapper<ZuzhixinxiEntity> wrapper);
	

}
