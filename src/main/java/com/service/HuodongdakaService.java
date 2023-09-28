package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongdakaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongdakaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongdakaView;


/**
 * 活动打卡
 *
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
public interface HuodongdakaService extends IService<HuodongdakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongdakaVO> selectListVO(Wrapper<HuodongdakaEntity> wrapper);
   	
   	HuodongdakaVO selectVO(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
   	
   	List<HuodongdakaView> selectListView(Wrapper<HuodongdakaEntity> wrapper);
   	
   	HuodongdakaView selectView(@Param("ew") Wrapper<HuodongdakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongdakaEntity> wrapper);
   	

}

