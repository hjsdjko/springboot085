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

import com.entity.LuyongxinxiEntity;
import com.entity.view.LuyongxinxiView;

import com.service.LuyongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 录用信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
@RestController
@RequestMapping("/luyongxinxi")
public class LuyongxinxiController {
    @Autowired
    private LuyongxinxiService luyongxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuyongxinxiEntity luyongxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			luyongxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LuyongxinxiEntity> ew = new EntityWrapper<LuyongxinxiEntity>();

		PageUtils page = luyongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luyongxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuyongxinxiEntity luyongxinxi, 
		HttpServletRequest request){
        EntityWrapper<LuyongxinxiEntity> ew = new EntityWrapper<LuyongxinxiEntity>();

		PageUtils page = luyongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luyongxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuyongxinxiEntity luyongxinxi){
       	EntityWrapper<LuyongxinxiEntity> ew = new EntityWrapper<LuyongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luyongxinxi, "luyongxinxi")); 
        return R.ok().put("data", luyongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuyongxinxiEntity luyongxinxi){
        EntityWrapper< LuyongxinxiEntity> ew = new EntityWrapper< LuyongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luyongxinxi, "luyongxinxi")); 
		LuyongxinxiView luyongxinxiView =  luyongxinxiService.selectView(ew);
		return R.ok("查询录用信息成功").put("data", luyongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuyongxinxiEntity luyongxinxi = luyongxinxiService.selectById(id);
        return R.ok().put("data", luyongxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuyongxinxiEntity luyongxinxi = luyongxinxiService.selectById(id);
        return R.ok().put("data", luyongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuyongxinxiEntity luyongxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luyongxinxi);
        luyongxinxiService.insert(luyongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LuyongxinxiEntity luyongxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luyongxinxi);
        luyongxinxiService.insert(luyongxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuyongxinxiEntity luyongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luyongxinxi);
        luyongxinxiService.updateById(luyongxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luyongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
