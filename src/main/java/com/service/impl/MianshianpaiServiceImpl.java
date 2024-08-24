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


import com.dao.MianshianpaiDao;
import com.entity.MianshianpaiEntity;
import com.service.MianshianpaiService;
import com.entity.vo.MianshianpaiVO;
import com.entity.view.MianshianpaiView;

@Service("mianshianpaiService")
public class MianshianpaiServiceImpl extends ServiceImpl<MianshianpaiDao, MianshianpaiEntity> implements MianshianpaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshianpaiEntity> page = this.selectPage(
                new Query<MianshianpaiEntity>(params).getPage(),
                new EntityWrapper<MianshianpaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshianpaiEntity> wrapper) {
		  Page<MianshianpaiView> page =new Query<MianshianpaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MianshianpaiVO> selectListVO(Wrapper<MianshianpaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshianpaiVO selectVO(Wrapper<MianshianpaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshianpaiView> selectListView(Wrapper<MianshianpaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshianpaiView selectView(Wrapper<MianshianpaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
