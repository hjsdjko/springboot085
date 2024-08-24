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

import com.entity.RenshidiaodongEntity;
import com.entity.view.RenshidiaodongView;

import com.service.RenshidiaodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 人事调动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@RestController
@RequestMapping("/renshidiaodong")
public class RenshidiaodongController {
    @Autowired
    private RenshidiaodongService renshidiaodongService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenshidiaodongEntity renshidiaodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			renshidiaodong.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenshidiaodongEntity> ew = new EntityWrapper<RenshidiaodongEntity>();

		PageUtils page = renshidiaodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshidiaodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenshidiaodongEntity renshidiaodong, 
		HttpServletRequest request){
        EntityWrapper<RenshidiaodongEntity> ew = new EntityWrapper<RenshidiaodongEntity>();

		PageUtils page = renshidiaodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renshidiaodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenshidiaodongEntity renshidiaodong){
       	EntityWrapper<RenshidiaodongEntity> ew = new EntityWrapper<RenshidiaodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renshidiaodong, "renshidiaodong")); 
        return R.ok().put("data", renshidiaodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenshidiaodongEntity renshidiaodong){
        EntityWrapper< RenshidiaodongEntity> ew = new EntityWrapper< RenshidiaodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renshidiaodong, "renshidiaodong")); 
		RenshidiaodongView renshidiaodongView =  renshidiaodongService.selectView(ew);
		return R.ok("查询人事调动成功").put("data", renshidiaodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenshidiaodongEntity renshidiaodong = renshidiaodongService.selectById(id);
        return R.ok().put("data", renshidiaodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenshidiaodongEntity renshidiaodong = renshidiaodongService.selectById(id);
        return R.ok().put("data", renshidiaodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenshidiaodongEntity renshidiaodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(renshidiaodong);
        renshidiaodongService.insert(renshidiaodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenshidiaodongEntity renshidiaodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(renshidiaodong);
        renshidiaodongService.insert(renshidiaodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenshidiaodongEntity renshidiaodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renshidiaodong);
        renshidiaodongService.updateById(renshidiaodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renshidiaodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
