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


import com.dao.JianlixinxiDao;
import com.entity.JianlixinxiEntity;
import com.service.JianlixinxiService;
import com.entity.vo.JianlixinxiVO;
import com.entity.view.JianlixinxiView;

@Service("jianlixinxiService")
public class JianlixinxiServiceImpl extends ServiceImpl<JianlixinxiDao, JianlixinxiEntity> implements JianlixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianlixinxiEntity> page = this.selectPage(
                new Query<JianlixinxiEntity>(params).getPage(),
                new EntityWrapper<JianlixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianlixinxiEntity> wrapper) {
		  Page<JianlixinxiView> page =new Query<JianlixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JianlixinxiVO> selectListVO(Wrapper<JianlixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianlixinxiVO selectVO(Wrapper<JianlixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianlixinxiView> selectListView(Wrapper<JianlixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianlixinxiView selectView(Wrapper<JianlixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
