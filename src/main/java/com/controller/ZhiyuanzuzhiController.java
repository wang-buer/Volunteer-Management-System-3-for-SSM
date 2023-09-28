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

import com.entity.ZhiyuanzuzhiEntity;
import com.entity.view.ZhiyuanzuzhiView;

import com.service.ZhiyuanzuzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.entity.EmailregistercodeEntity;
import com.service.EmailregistercodeService;

/**
 * 志愿组织
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-18 17:36:25
 */
@RestController
@RequestMapping("/zhiyuanzuzhi")
public class ZhiyuanzuzhiController {
    @Autowired
    private ZhiyuanzuzhiService zhiyuanzuzhiService;

    @Autowired
    private EmailregistercodeService emailregistercodeService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("zuzhibianhao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"zhiyuanzuzhi",  "志愿组织" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZhiyuanzuzhiEntity zhiyuanzuzhi, @RequestParam(required = false) String emailcode){
    	//ValidatorUtils.validateEntity(zhiyuanzuzhi);
    	ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("zuzhibianhao", zhiyuanzuzhi.getZuzhibianhao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		//校验邮箱验证码
		user =zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("email", zhiyuanzuzhi.getEmail()));
		if(user!=null) {
			return R.error("邮箱已被注册");
		}
		List<EmailregistercodeEntity> emailregistercodeList = emailregistercodeService.selectList(
										new EntityWrapper<EmailregistercodeEntity>().eq("role", "用户")
										.eq("email", zhiyuanzuzhi.getEmail()).orderBy("addtime", false));
		boolean emailValidate = false;
		if(emailregistercodeList!=null && emailregistercodeList.size()>0) {
			if(emailregistercodeList.get(0).getCode().equals(emailcode)) {
				emailValidate = true;
			}
		}
		if(!emailValidate) return R.error("邮箱验证码不正确");
		Long uId = new Date().getTime();
		zhiyuanzuzhi.setId(uId);
        zhiyuanzuzhiService.insert(zhiyuanzuzhi);
        return R.ok();
    }

	/**
     * 发送邮件
     */
	@IgnoreAuth
    @RequestMapping("/sendemail")
    public R sendemail(@RequestParam String email){
		String code = CommonUtil.getRandomNumber(4);
		EmailregistercodeEntity emailregistercode = new EmailregistercodeEntity();
		emailregistercode.setCode(code);
		emailregistercode.setRole("用户");
		emailregistercode.setEmail(email);
		emailregistercodeService.insert(emailregistercode);
		CommonUtil.sendEmail(email, "用户注册","您的注册验证码是【"+code+"】，请不要把验证码泄漏给其他人，如非本人请勿操作。");
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("zuzhibianhao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        zhiyuanzuzhiService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanzuzhiEntity zhiyuanzuzhi, 
		HttpServletRequest request){

        EntityWrapper<ZhiyuanzuzhiEntity> ew = new EntityWrapper<ZhiyuanzuzhiEntity>();
		PageUtils page = zhiyuanzuzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzuzhi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanzuzhiEntity zhiyuanzuzhi, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzuzhiEntity> ew = new EntityWrapper<ZhiyuanzuzhiEntity>();
		PageUtils page = zhiyuanzuzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzuzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanzuzhiEntity zhiyuanzuzhi){
       	EntityWrapper<ZhiyuanzuzhiEntity> ew = new EntityWrapper<ZhiyuanzuzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanzuzhi, "zhiyuanzuzhi")); 
        return R.ok().put("data", zhiyuanzuzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanzuzhiEntity zhiyuanzuzhi){
        EntityWrapper< ZhiyuanzuzhiEntity> ew = new EntityWrapper< ZhiyuanzuzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanzuzhi, "zhiyuanzuzhi")); 
		ZhiyuanzuzhiView zhiyuanzuzhiView =  zhiyuanzuzhiService.selectView(ew);
		return R.ok("查询志愿组织成功").put("data", zhiyuanzuzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanzuzhiEntity zhiyuanzuzhi = zhiyuanzuzhiService.selectById(id);
        return R.ok().put("data", zhiyuanzuzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanzuzhiEntity zhiyuanzuzhi = zhiyuanzuzhiService.selectById(id);
        return R.ok().put("data", zhiyuanzuzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanzuzhiEntity zhiyuanzuzhi, HttpServletRequest request){
    	zhiyuanzuzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzuzhi);
    	ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("zuzhibianhao", zhiyuanzuzhi.getZuzhibianhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		zhiyuanzuzhi.setId(new Date().getTime());
        zhiyuanzuzhiService.insert(zhiyuanzuzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanzuzhiEntity zhiyuanzuzhi, HttpServletRequest request){
    	zhiyuanzuzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzuzhi);
    	ZhiyuanzuzhiEntity user = zhiyuanzuzhiService.selectOne(new EntityWrapper<ZhiyuanzuzhiEntity>().eq("zuzhibianhao", zhiyuanzuzhi.getZuzhibianhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		zhiyuanzuzhi.setId(new Date().getTime());
        zhiyuanzuzhiService.insert(zhiyuanzuzhi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanzuzhiEntity zhiyuanzuzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanzuzhi);
        zhiyuanzuzhiService.updateById(zhiyuanzuzhi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanzuzhiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhiyuanzuzhiEntity> wrapper = new EntityWrapper<ZhiyuanzuzhiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zhiyuanzuzhiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
