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

import com.entity.ZhengzhaoxinxiEntity;
import com.entity.view.ZhengzhaoxinxiView;

import com.service.ZhengzhaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 证照信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@RestController
@RequestMapping("/zhengzhaoxinxi")
public class ZhengzhaoxinxiController {
    @Autowired
    private ZhengzhaoxinxiService zhengzhaoxinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhengzhaoxinxiEntity zhengzhaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			zhengzhaoxinxi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhengzhaoxinxiEntity> ew = new EntityWrapper<ZhengzhaoxinxiEntity>();

		PageUtils page = zhengzhaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengzhaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhengzhaoxinxiEntity zhengzhaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<ZhengzhaoxinxiEntity> ew = new EntityWrapper<ZhengzhaoxinxiEntity>();

		PageUtils page = zhengzhaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengzhaoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhengzhaoxinxiEntity zhengzhaoxinxi){
       	EntityWrapper<ZhengzhaoxinxiEntity> ew = new EntityWrapper<ZhengzhaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhengzhaoxinxi, "zhengzhaoxinxi")); 
        return R.ok().put("data", zhengzhaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhengzhaoxinxiEntity zhengzhaoxinxi){
        EntityWrapper< ZhengzhaoxinxiEntity> ew = new EntityWrapper< ZhengzhaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhengzhaoxinxi, "zhengzhaoxinxi")); 
		ZhengzhaoxinxiView zhengzhaoxinxiView =  zhengzhaoxinxiService.selectView(ew);
		return R.ok("查询证照信息成功").put("data", zhengzhaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhengzhaoxinxiEntity zhengzhaoxinxi = zhengzhaoxinxiService.selectById(id);
        return R.ok().put("data", zhengzhaoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhengzhaoxinxiEntity zhengzhaoxinxi = zhengzhaoxinxiService.selectById(id);
        return R.ok().put("data", zhengzhaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhengzhaoxinxiEntity zhengzhaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengzhaoxinxi);
        zhengzhaoxinxiService.insert(zhengzhaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhengzhaoxinxiEntity zhengzhaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhengzhaoxinxi);
        zhengzhaoxinxiService.insert(zhengzhaoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhengzhaoxinxiEntity zhengzhaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhengzhaoxinxi);
        zhengzhaoxinxiService.updateById(zhengzhaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhengzhaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
