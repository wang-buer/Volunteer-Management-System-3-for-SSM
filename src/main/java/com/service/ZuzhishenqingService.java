package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuzhishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuzhishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuzhishenqingView;


/**
 * 组织申请
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface ZuzhishenqingService extends IService<ZuzhishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuzhishenqingVO> selectListVO(Wrapper<ZuzhishenqingEntity> wrapper);
   	
   	ZuzhishenqingVO selectVO(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
   	
   	List<ZuzhishenqingView> selectListView(Wrapper<ZuzhishenqingEntity> wrapper);
   	
   	ZuzhishenqingView selectView(@Param("ew") Wrapper<ZuzhishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuzhishenqingEntity> wrapper);
   	

}

