package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.HuodongdakaDao;
import com.entity.HuodongdakaEntity;
import com.service.HuodongdakaService;
import com.entity.vo.HuodongdakaVO;
import com.entity.view.HuodongdakaView;

@Service("huodongdakaService")
public class HuodongdakaServiceImpl extends ServiceImpl<HuodongdakaDao, HuodongdakaEntity> implements HuodongdakaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongdakaEntity> page = this.selectPage(
                new Query<HuodongdakaEntity>(params).getPage(),
                new EntityWrapper<HuodongdakaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongdakaEntity> wrapper) {
		  Page<HuodongdakaView> page =new Query<HuodongdakaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongdakaVO> selectListVO(Wrapper<HuodongdakaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongdakaVO selectVO(Wrapper<HuodongdakaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongdakaView> selectListView(Wrapper<HuodongdakaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongdakaView selectView(Wrapper<HuodongdakaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
