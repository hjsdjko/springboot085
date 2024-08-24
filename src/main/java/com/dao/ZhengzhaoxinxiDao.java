package com.dao;

import com.entity.ZhengzhaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhengzhaoxinxiVO;
import com.entity.view.ZhengzhaoxinxiView;


/**
 * 证照信息
 * 
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface ZhengzhaoxinxiDao extends BaseMapper<ZhengzhaoxinxiEntity> {
	
	List<ZhengzhaoxinxiVO> selectListVO(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);
	
	ZhengzhaoxinxiVO selectVO(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);
	
	List<ZhengzhaoxinxiView> selectListView(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);

	List<ZhengzhaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);

	
	ZhengzhaoxinxiView selectView(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);
	

}
