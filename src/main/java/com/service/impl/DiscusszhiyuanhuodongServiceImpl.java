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


import com.dao.DiscusszhiyuanhuodongDao;
import com.entity.DiscusszhiyuanhuodongEntity;
import com.service.DiscusszhiyuanhuodongService;
import com.entity.vo.DiscusszhiyuanhuodongVO;
import com.entity.view.DiscusszhiyuanhuodongView;

@Service("discusszhiyuanhuodongService")
public class DiscusszhiyuanhuodongServiceImpl extends ServiceImpl<DiscusszhiyuanhuodongDao, DiscusszhiyuanhuodongEntity> implements DiscusszhiyuanhuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiyuanhuodongEntity> page = this.selectPage(
                new Query<DiscusszhiyuanhuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiyuanhuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiyuanhuodongEntity> wrapper) {
		  Page<DiscusszhiyuanhuodongView> page =new Query<DiscusszhiyuanhuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhiyuanhuodongVO> selectListVO(Wrapper<DiscusszhiyuanhuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhiyuanhuodongVO selectVO(Wrapper<DiscusszhiyuanhuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhiyuanhuodongView> selectListView(Wrapper<DiscusszhiyuanhuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiyuanhuodongView selectView(Wrapper<DiscusszhiyuanhuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
