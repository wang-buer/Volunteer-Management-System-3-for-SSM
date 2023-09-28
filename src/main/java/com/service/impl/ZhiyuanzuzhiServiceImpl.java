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


import com.dao.ZhiyuanzuzhiDao;
import com.entity.ZhiyuanzuzhiEntity;
import com.service.ZhiyuanzuzhiService;
import com.entity.vo.ZhiyuanzuzhiVO;
import com.entity.view.ZhiyuanzuzhiView;

@Service("zhiyuanzuzhiService")
public class ZhiyuanzuzhiServiceImpl extends ServiceImpl<ZhiyuanzuzhiDao, ZhiyuanzuzhiEntity> implements ZhiyuanzuzhiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzuzhiEntity> page = this.selectPage(
                new Query<ZhiyuanzuzhiEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzuzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzuzhiEntity> wrapper) {
		  Page<ZhiyuanzuzhiView> page =new Query<ZhiyuanzuzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiyuanzuzhiVO> selectListVO(Wrapper<ZhiyuanzuzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanzuzhiVO selectVO(Wrapper<ZhiyuanzuzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanzuzhiView> selectListView(Wrapper<ZhiyuanzuzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzuzhiView selectView(Wrapper<ZhiyuanzuzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
