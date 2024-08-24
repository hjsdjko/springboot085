package com.dao;

import com.entity.YuangonghetongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuangonghetongVO;
import com.entity.view.YuangonghetongView;


/**
 * 员工合同
 * 
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface YuangonghetongDao extends BaseMapper<YuangonghetongEntity> {
	
	List<YuangonghetongVO> selectListVO(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);
	
	YuangonghetongVO selectVO(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);
	
	List<YuangonghetongView> selectListView(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);

	List<YuangonghetongView> selectListView(Pagination page,@Param("ew") Wrapper<YuangonghetongEntity> wrapper);

	
	YuangonghetongView selectView(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);
	

}
