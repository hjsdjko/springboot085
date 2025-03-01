package com.dao;

import com.entity.RenshidiaodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RenshidiaodongVO;
import com.entity.view.RenshidiaodongView;


/**
 * 人事调动
 * 
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface RenshidiaodongDao extends BaseMapper<RenshidiaodongEntity> {
	
	List<RenshidiaodongVO> selectListVO(@Param("ew") Wrapper<RenshidiaodongEntity> wrapper);
	
	RenshidiaodongVO selectVO(@Param("ew") Wrapper<RenshidiaodongEntity> wrapper);
	
	List<RenshidiaodongView> selectListView(@Param("ew") Wrapper<RenshidiaodongEntity> wrapper);

	List<RenshidiaodongView> selectListView(Pagination page,@Param("ew") Wrapper<RenshidiaodongEntity> wrapper);

	
	RenshidiaodongView selectView(@Param("ew") Wrapper<RenshidiaodongEntity> wrapper);
	

}
