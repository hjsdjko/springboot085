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

import com.entity.MianshianpaiEntity;
import com.entity.view.MianshianpaiView;

import com.service.MianshianpaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 面试安排
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
@RestController
@RequestMapping("/mianshianpai")
public class MianshianpaiController {
    @Autowired
    private MianshianpaiService mianshianpaiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshianpaiEntity mianshianpai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mianshianpai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MianshianpaiEntity> ew = new EntityWrapper<MianshianpaiEntity>();

		PageUtils page = mianshianpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshianpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshianpaiEntity mianshianpai, 
		HttpServletRequest request){
        EntityWrapper<MianshianpaiEntity> ew = new EntityWrapper<MianshianpaiEntity>();

		PageUtils page = mianshianpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshianpai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshianpaiEntity mianshianpai){
       	EntityWrapper<MianshianpaiEntity> ew = new EntityWrapper<MianshianpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshianpai, "mianshianpai")); 
        return R.ok().put("data", mianshianpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshianpaiEntity mianshianpai){
        EntityWrapper< MianshianpaiEntity> ew = new EntityWrapper< MianshianpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshianpai, "mianshianpai")); 
		MianshianpaiView mianshianpaiView =  mianshianpaiService.selectView(ew);
		return R.ok("查询面试安排成功").put("data", mianshianpaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MianshianpaiEntity mianshianpai = mianshianpaiService.selectById(id);
        return R.ok().put("data", mianshianpai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MianshianpaiEntity mianshianpai = mianshianpaiService.selectById(id);
        return R.ok().put("data", mianshianpai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshianpaiEntity mianshianpai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mianshianpai);
        mianshianpaiService.insert(mianshianpai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshianpaiEntity mianshianpai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mianshianpai);
        mianshianpaiService.insert(mianshianpai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MianshianpaiEntity mianshianpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshianpai);
        mianshianpaiService.updateById(mianshianpai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshianpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
