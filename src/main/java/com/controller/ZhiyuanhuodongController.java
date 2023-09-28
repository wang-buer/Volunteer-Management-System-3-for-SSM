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

import com.entity.ZhiyuanhuodongEntity;
import com.entity.view.ZhiyuanhuodongView;

import com.service.ZhiyuanhuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 志愿活动
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@RestController
@RequestMapping("/zhiyuanhuodong")
public class ZhiyuanhuodongController {
    @Autowired
    private ZhiyuanhuodongService zhiyuanhuodongService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzuzhi")) {
			zhiyuanhuodong.setZuzhibianhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanhuodongEntity zhiyuanhuodong){
       	EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
        return R.ok().put("data", zhiyuanhuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanhuodongEntity zhiyuanhuodong){
        EntityWrapper< ZhiyuanhuodongEntity> ew = new EntityWrapper< ZhiyuanhuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanhuodong, "zhiyuanhuodong")); 
		ZhiyuanhuodongView zhiyuanhuodongView =  zhiyuanhuodongService.selectView(ew);
		return R.ok("查询志愿活动成功").put("data", zhiyuanhuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
		zhiyuanhuodong.setClicknum(zhiyuanhuodong.getClicknum()+1);
		zhiyuanhuodong.setClicktime(new Date());
		zhiyuanhuodongService.updateById(zhiyuanhuodong);
        return R.ok().put("data", zhiyuanhuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanhuodongEntity zhiyuanhuodong = zhiyuanhuodongService.selectById(id);
		zhiyuanhuodong.setClicknum(zhiyuanhuodong.getClicknum()+1);
		zhiyuanhuodong.setClicktime(new Date());
		zhiyuanhuodongService.updateById(zhiyuanhuodong);
        return R.ok().put("data", zhiyuanhuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
    	zhiyuanhuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanhuodong);

        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
    	zhiyuanhuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanhuodong);

        zhiyuanhuodongService.insert(zhiyuanhuodong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanhuodong);
        zhiyuanhuodongService.updateById(zhiyuanhuodong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanhuodongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhiyuanhuodongEntity> wrapper = new EntityWrapper<ZhiyuanhuodongEntity>();
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

		int count = zhiyuanhuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhiyuanhuodongEntity zhiyuanhuodong, HttpServletRequest request,String pre){
        EntityWrapper<ZhiyuanhuodongEntity> ew = new EntityWrapper<ZhiyuanhuodongEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = zhiyuanhuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanhuodong), params), params));
        return R.ok().put("data", page);
    }







}
