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


import com.dao.ZuzhixinxiDao;
import com.entity.ZuzhixinxiEntity;
import com.service.ZuzhixinxiService;
import com.entity.vo.ZuzhixinxiVO;
import com.entity.view.ZuzhixinxiView;

@Service("zuzhixinxiService")
public class ZuzhixinxiServiceImpl extends ServiceImpl<ZuzhixinxiDao, ZuzhixinxiEntity> implements ZuzhixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuzhixinxiEntity> page = this.selectPage(
                new Query<ZuzhixinxiEntity>(params).getPage(),
                new EntityWrapper<ZuzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuzhixinxiEntity> wrapper) {
		  Page<ZuzhixinxiView> page =new Query<ZuzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuzhixinxiVO> selectListVO(Wrapper<ZuzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuzhixinxiVO selectVO(Wrapper<ZuzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuzhixinxiView> selectListView(Wrapper<ZuzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuzhixinxiView selectView(Wrapper<ZuzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
