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

import com.entity.YuangongzhuanzhengEntity;
import com.entity.view.YuangongzhuanzhengView;

import com.service.YuangongzhuanzhengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工转正
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@RestController
@RequestMapping("/yuangongzhuanzheng")
public class YuangongzhuanzhengController {
    @Autowired
    private YuangongzhuanzhengService yuangongzhuanzhengService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongzhuanzhengEntity yuangongzhuanzheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongzhuanzheng.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongzhuanzhengEntity> ew = new EntityWrapper<YuangongzhuanzhengEntity>();

		PageUtils page = yuangongzhuanzhengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongzhuanzheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongzhuanzhengEntity yuangongzhuanzheng, 
		HttpServletRequest request){
        EntityWrapper<YuangongzhuanzhengEntity> ew = new EntityWrapper<YuangongzhuanzhengEntity>();

		PageUtils page = yuangongzhuanzhengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongzhuanzheng), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongzhuanzhengEntity yuangongzhuanzheng){
       	EntityWrapper<YuangongzhuanzhengEntity> ew = new EntityWrapper<YuangongzhuanzhengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongzhuanzheng, "yuangongzhuanzheng")); 
        return R.ok().put("data", yuangongzhuanzhengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongzhuanzhengEntity yuangongzhuanzheng){
        EntityWrapper< YuangongzhuanzhengEntity> ew = new EntityWrapper< YuangongzhuanzhengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongzhuanzheng, "yuangongzhuanzheng")); 
		YuangongzhuanzhengView yuangongzhuanzhengView =  yuangongzhuanzhengService.selectView(ew);
		return R.ok("查询员工转正成功").put("data", yuangongzhuanzhengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongzhuanzhengEntity yuangongzhuanzheng = yuangongzhuanzhengService.selectById(id);
        return R.ok().put("data", yuangongzhuanzheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongzhuanzhengEntity yuangongzhuanzheng = yuangongzhuanzhengService.selectById(id);
        return R.ok().put("data", yuangongzhuanzheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongzhuanzhengEntity yuangongzhuanzheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongzhuanzheng);
        yuangongzhuanzhengService.insert(yuangongzhuanzheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongzhuanzhengEntity yuangongzhuanzheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongzhuanzheng);
        yuangongzhuanzhengService.insert(yuangongzhuanzheng);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongzhuanzhengEntity yuangongzhuanzheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongzhuanzheng);
        yuangongzhuanzhengService.updateById(yuangongzhuanzheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongzhuanzhengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
