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


import com.dao.ZhengzhaoxinxiDao;
import com.entity.ZhengzhaoxinxiEntity;
import com.service.ZhengzhaoxinxiService;
import com.entity.vo.ZhengzhaoxinxiVO;
import com.entity.view.ZhengzhaoxinxiView;

@Service("zhengzhaoxinxiService")
public class ZhengzhaoxinxiServiceImpl extends ServiceImpl<ZhengzhaoxinxiDao, ZhengzhaoxinxiEntity> implements ZhengzhaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengzhaoxinxiEntity> page = this.selectPage(
                new Query<ZhengzhaoxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhengzhaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengzhaoxinxiEntity> wrapper) {
		  Page<ZhengzhaoxinxiView> page =new Query<ZhengzhaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhengzhaoxinxiVO> selectListVO(Wrapper<ZhengzhaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhengzhaoxinxiVO selectVO(Wrapper<ZhengzhaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhengzhaoxinxiView> selectListView(Wrapper<ZhengzhaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengzhaoxinxiView selectView(Wrapper<ZhengzhaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
