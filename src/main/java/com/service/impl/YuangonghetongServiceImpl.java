package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuangonghetongDao;
import com.entity.YuangonghetongEntity;
import com.service.YuangonghetongService;
import com.entity.vo.YuangonghetongVO;
import com.entity.view.YuangonghetongView;

@Service("yuangonghetongService")
public class YuangonghetongServiceImpl extends ServiceImpl<YuangonghetongDao, YuangonghetongEntity> implements YuangonghetongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangonghetongEntity> page = this.selectPage(
                new Query<YuangonghetongEntity>(params).getPage(),
                new EntityWrapper<YuangonghetongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangonghetongEntity> wrapper) {
		  Page<YuangonghetongView> page =new Query<YuangonghetongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuangonghetongVO> selectListVO(Wrapper<YuangonghetongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangonghetongVO selectVO(Wrapper<YuangonghetongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangonghetongView> selectListView(Wrapper<YuangonghetongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangonghetongView selectView(Wrapper<YuangonghetongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
