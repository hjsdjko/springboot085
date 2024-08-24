package com.dao;

import com.entity.YuangongzhuanzhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuangongzhuanzhengVO;
import com.entity.view.YuangongzhuanzhengView;


/**
 * 员工转正
 * 
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface YuangongzhuanzhengDao extends BaseMapper<YuangongzhuanzhengEntity> {
	
	List<YuangongzhuanzhengVO> selectListVO(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);
	
	YuangongzhuanzhengVO selectVO(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);
	
	List<YuangongzhuanzhengView> selectListView(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);

	List<YuangongzhuanzhengView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);

	
	YuangongzhuanzhengView selectView(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);
	

}
