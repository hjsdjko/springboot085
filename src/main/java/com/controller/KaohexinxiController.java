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

import com.entity.KaohexinxiEntity;
import com.entity.view.KaohexinxiView;

import com.service.KaohexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 考核信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@RestController
@RequestMapping("/kaohexinxi")
public class KaohexinxiController {
    @Autowired
    private KaohexinxiService kaohexinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaohexinxiEntity kaohexinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			kaohexinxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaohexinxiEntity> ew = new EntityWrapper<KaohexinxiEntity>();

		PageUtils page = kaohexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaohexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaohexinxiEntity kaohexinxi, 
		HttpServletRequest request){
        EntityWrapper<KaohexinxiEntity> ew = new EntityWrapper<KaohexinxiEntity>();

		PageUtils page = kaohexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaohexinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaohexinxiEntity kaohexinxi){
       	EntityWrapper<KaohexinxiEntity> ew = new EntityWrapper<KaohexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaohexinxi, "kaohexinxi")); 
        return R.ok().put("data", kaohexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaohexinxiEntity kaohexinxi){
        EntityWrapper< KaohexinxiEntity> ew = new EntityWrapper< KaohexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaohexinxi, "kaohexinxi")); 
		KaohexinxiView kaohexinxiView =  kaohexinxiService.selectView(ew);
		return R.ok("查询考核信息成功").put("data", kaohexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaohexinxiEntity kaohexinxi = kaohexinxiService.selectById(id);
        return R.ok().put("data", kaohexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaohexinxiEntity kaohexinxi = kaohexinxiService.selectById(id);
        return R.ok().put("data", kaohexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaohexinxiEntity kaohexinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaohexinxi);
        kaohexinxiService.insert(kaohexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaohexinxiEntity kaohexinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaohexinxi);
        kaohexinxiService.insert(kaohexinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaohexinxiEntity kaohexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaohexinxi);
        kaohexinxiService.updateById(kaohexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaohexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
