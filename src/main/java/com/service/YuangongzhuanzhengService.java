package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongzhuanzhengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuangongzhuanzhengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongzhuanzhengView;


/**
 * 员工转正
 *
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface YuangongzhuanzhengService extends IService<YuangongzhuanzhengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongzhuanzhengVO> selectListVO(Wrapper<YuangongzhuanzhengEntity> wrapper);
   	
   	YuangongzhuanzhengVO selectVO(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);
   	
   	List<YuangongzhuanzhengView> selectListView(Wrapper<YuangongzhuanzhengEntity> wrapper);
   	
   	YuangongzhuanzhengView selectView(@Param("ew") Wrapper<YuangongzhuanzhengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongzhuanzhengEntity> wrapper);

   	

}

