package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuzhixinxiEntity;
import com.entity.view.ZuzhixinxiView;

import com.service.ZuzhixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 组织信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@RestController
@RequestMapping("/zuzhixinxi")
public class ZuzhixinxiController {
    @Autowired
    private ZuzhixinxiService zuzhixinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuzhixinxiEntity zuzhixinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzuzhi")) {
			zuzhixinxi.setZuzhibianhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuzhixinxiEntity> ew = new EntityWrapper<ZuzhixinxiEntity>();
		PageUtils page = zuzhixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuzhixinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuzhixinxiEntity zuzhixinxi, 
		HttpServletRequest request){
        EntityWrapper<ZuzhixinxiEntity> ew = new EntityWrapper<ZuzhixinxiEntity>();
		PageUtils page = zuzhixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuzhixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuzhixinxiEntity zuzhixinxi){
       	EntityWrapper<ZuzhixinxiEntity> ew = new EntityWrapper<ZuzhixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuzhixinxi, "zuzhixinxi")); 
        return R.ok().put("data", zuzhixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuzhixinxiEntity zuzhixinxi){
        EntityWrapper< ZuzhixinxiEntity> ew = new EntityWrapper< ZuzhixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuzhixinxi, "zuzhixinxi")); 
		ZuzhixinxiView zuzhixinxiView =  zuzhixinxiService.selectView(ew);
		return R.ok("查询组织信息成功").put("data", zuzhixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuzhixinxiEntity zuzhixinxi = zuzhixinxiService.selectById(id);
        return R.ok().put("data", zuzhixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuzhixinxiEntity zuzhixinxi = zuzhixinxiService.selectById(id);
        return R.ok().put("data", zuzhixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuzhixinxiEntity zuzhixinxi, HttpServletRequest request){
    	zuzhixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuzhixinxi);

        zuzhixinxiService.insert(zuzhixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuzhixinxiEntity zuzhixinxi, HttpServletRequest request){
    	zuzhixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuzhixinxi);

        zuzhixinxiService.insert(zuzhixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZuzhixinxiEntity zuzhixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuzhixinxi);
        zuzhixinxiService.updateById(zuzhixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuzhixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZuzhixinxiEntity> wrapper = new EntityWrapper<ZuzhixinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzuzhi")) {
			wrapper.eq("zuzhibianhao", (String)request.getSession().getAttribute("username"));
		}

		int count = zuzhixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
