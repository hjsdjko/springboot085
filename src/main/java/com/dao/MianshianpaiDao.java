package com.dao;

import com.entity.MianshianpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshianpaiVO;
import com.entity.view.MianshianpaiView;


/**
 * 面试安排
 * 
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
public interface MianshianpaiDao extends BaseMapper<MianshianpaiEntity> {
	
	List<MianshianpaiVO> selectListVO(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);
	
	MianshianpaiVO selectVO(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);
	
	List<MianshianpaiView> selectListView(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);

	List<MianshianpaiView> selectListView(Pagination page,@Param("ew") Wrapper<MianshianpaiEntity> wrapper);

	
	MianshianpaiView selectView(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);
	

}
