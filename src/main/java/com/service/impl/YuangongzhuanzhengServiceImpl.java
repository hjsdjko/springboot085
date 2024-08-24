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


import com.dao.YuangongzhuanzhengDao;
import com.entity.YuangongzhuanzhengEntity;
import com.service.YuangongzhuanzhengService;
import com.entity.vo.YuangongzhuanzhengVO;
import com.entity.view.YuangongzhuanzhengView;

@Service("yuangongzhuanzhengService")
public class YuangongzhuanzhengServiceImpl extends ServiceImpl<YuangongzhuanzhengDao, YuangongzhuanzhengEntity> implements YuangongzhuanzhengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongzhuanzhengEntity> page = this.selectPage(
                new Query<YuangongzhuanzhengEntity>(params).getPage(),
                new EntityWrapper<YuangongzhuanzhengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongzhuanzhengEntity> wrapper) {
		  Page<YuangongzhuanzhengView> page =new Query<YuangongzhuanzhengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuangongzhuanzhengVO> selectListVO(Wrapper<YuangongzhuanzhengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongzhuanzhengVO selectVO(Wrapper<YuangongzhuanzhengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongzhuanzhengView> selectListView(Wrapper<YuangongzhuanzhengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongzhuanzhengView selectView(Wrapper<YuangongzhuanzhengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
