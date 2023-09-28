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


import com.dao.DiscusszuzhixinxiDao;
import com.entity.DiscusszuzhixinxiEntity;
import com.service.DiscusszuzhixinxiService;
import com.entity.vo.DiscusszuzhixinxiVO;
import com.entity.view.DiscusszuzhixinxiView;

@Service("discusszuzhixinxiService")
public class DiscusszuzhixinxiServiceImpl extends ServiceImpl<DiscusszuzhixinxiDao, DiscusszuzhixinxiEntity> implements DiscusszuzhixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszuzhixinxiEntity> page = this.selectPage(
                new Query<DiscusszuzhixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusszuzhixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszuzhixinxiEntity> wrapper) {
		  Page<DiscusszuzhixinxiView> page =new Query<DiscusszuzhixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszuzhixinxiVO> selectListVO(Wrapper<DiscusszuzhixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszuzhixinxiVO selectVO(Wrapper<DiscusszuzhixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszuzhixinxiView> selectListView(Wrapper<DiscusszuzhixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszuzhixinxiView selectView(Wrapper<DiscusszuzhixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
