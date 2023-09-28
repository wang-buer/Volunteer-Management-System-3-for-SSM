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


import com.dao.ZuzhishenqingDao;
import com.entity.ZuzhishenqingEntity;
import com.service.ZuzhishenqingService;
import com.entity.vo.ZuzhishenqingVO;
import com.entity.view.ZuzhishenqingView;

@Service("zuzhishenqingService")
public class ZuzhishenqingServiceImpl extends ServiceImpl<ZuzhishenqingDao, ZuzhishenqingEntity> implements ZuzhishenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhishenqingEntity> page = this.selectPage(
                new Query<ZuzhishenqingEntity>(params).getPage(),
                new EntityWrapper<ZuzhishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhishenqingEntity> wrapper) {
		  Page<ZuzhishenqingView> page =new Query<ZuzhishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhishenqingVO> selectListVO(Wrapper<ZuzhishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhishenqingVO selectVO(Wrapper<ZuzhishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhishenqingView> selectListView(Wrapper<ZuzhishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhishenqingView selectView(Wrapper<ZuzhishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
