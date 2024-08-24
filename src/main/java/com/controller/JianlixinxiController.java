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

import com.entity.JianlixinxiEntity;
import com.entity.view.JianlixinxiView;

import com.service.JianlixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 简历信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
@RestController
@RequestMapping("/jianlixinxi")
public class JianlixinxiController {
    @Autowired
    private JianlixinxiService jianlixinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianlixinxiEntity jianlixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianlixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianlixinxiEntity> ew = new EntityWrapper<JianlixinxiEntity>();

		PageUtils page = jianlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianlixinxiEntity jianlixinxi, 
		HttpServletRequest request){
        EntityWrapper<JianlixinxiEntity> ew = new EntityWrapper<JianlixinxiEntity>();

		PageUtils page = jianlixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlixinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianlixinxiEntity jianlixinxi){
       	EntityWrapper<JianlixinxiEntity> ew = new EntityWrapper<JianlixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianlixinxi, "jianlixinxi")); 
        return R.ok().put("data", jianlixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianlixinxiEntity jianlixinxi){
        EntityWrapper< JianlixinxiEntity> ew = new EntityWrapper< JianlixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianlixinxi, "jianlixinxi")); 
		JianlixinxiView jianlixinxiView =  jianlixinxiService.selectView(ew);
		return R.ok("查询简历信息成功").put("data", jianlixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianlixinxiEntity jianlixinxi = jianlixinxiService.selectById(id);
        return R.ok().put("data", jianlixinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianlixinxiEntity jianlixinxi = jianlixinxiService.selectById(id);
        return R.ok().put("data", jianlixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianlixinxiEntity jianlixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlixinxi);
        jianlixinxiService.insert(jianlixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianlixinxiEntity jianlixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianlixinxi);
        jianlixinxiService.insert(jianlixinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianlixinxiEntity jianlixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianlixinxi);
        jianlixinxiService.updateById(jianlixinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JianlixinxiEntity> list = new ArrayList<JianlixinxiEntity>();
        for(Long id : ids) {
            JianlixinxiEntity jianlixinxi = jianlixinxiService.selectById(id);
            jianlixinxi.setSfsh(sfsh);
            jianlixinxi.setShhf(shhf);
            list.add(jianlixinxi);
        }
        jianlixinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianlixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
