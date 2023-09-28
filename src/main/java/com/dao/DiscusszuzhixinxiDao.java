package com.dao;

import com.entity.DiscusszuzhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszuzhixinxiVO;
import com.entity.view.DiscusszuzhixinxiView;


/**
 * 组织信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface DiscusszuzhixinxiDao extends BaseMapper<DiscusszuzhixinxiEntity> {
	
	List<DiscusszuzhixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
	
	DiscusszuzhixinxiVO selectVO(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
	
	List<DiscusszuzhixinxiView> selectListView(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);

	List<DiscusszuzhixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
	
	DiscusszuzhixinxiView selectView(@Param("ew") Wrapper<DiscusszuzhixinxiEntity> wrapper);
	

}
