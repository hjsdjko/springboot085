package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GangweiEntity;
import com.entity.view.GangweiView;

import com.service.GangweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 岗位
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
@RestController
@RequestMapping("/gangwei")
public class GangweiController {
    @Autowired
    private GangweiService gangweiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweiEntity gangwei,
		HttpServletRequest request){
        EntityWrapper<GangweiEntity> ew = new EntityWrapper<GangweiEntity>();

		PageUtils page = gangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweiEntity gangwei, 
		HttpServletRequest request){
        EntityWrapper<GangweiEntity> ew = new EntityWrapper<GangweiEntity>();

		PageUtils page = gangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangwei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweiEntity gangwei){
       	EntityWrapper<GangweiEntity> ew = new EntityWrapper<GangweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangwei, "gangwei")); 
        return R.ok().put("data", gangweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweiEntity gangwei){
        EntityWrapper< GangweiEntity> ew = new EntityWrapper< GangweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangwei, "gangwei")); 
		GangweiView gangweiView =  gangweiService.selectView(ew);
		return R.ok("查询岗位成功").put("data", gangweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweiEntity gangwei = gangweiService.selectById(id);
        return R.ok().put("data", gangwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweiEntity gangwei = gangweiService.selectById(id);
        return R.ok().put("data", gangwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweiEntity gangwei, HttpServletRequest request){
        if(gangweiService.selectCount(new EntityWrapper<GangweiEntity>().eq("gangwei", gangwei.getGangwei()))>0) {
            return R.error("岗位已存在");
        }
    	//ValidatorUtils.validateEntity(gangwei);
        gangweiService.insert(gangwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweiEntity gangwei, HttpServletRequest request){
        if(gangweiService.selectCount(new EntityWrapper<GangweiEntity>().eq("gangwei", gangwei.getGangwei()))>0) {
            return R.error("岗位已存在");
        }
    	//ValidatorUtils.validateEntity(gangwei);
        gangweiService.insert(gangwei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GangweiEntity gangwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangwei);
        if(gangweiService.selectCount(new EntityWrapper<GangweiEntity>().ne("id", gangwei.getId()).eq("gangwei", gangwei.getGangwei()))>0) {
            return R.error("岗位已存在");
        }
        gangweiService.updateById(gangwei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
