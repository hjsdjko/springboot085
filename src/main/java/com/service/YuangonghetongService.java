package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangonghetongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuangonghetongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangonghetongView;


/**
 * 员工合同
 *
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface YuangonghetongService extends IService<YuangonghetongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangonghetongVO> selectListVO(Wrapper<YuangonghetongEntity> wrapper);
   	
   	YuangonghetongVO selectVO(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);
   	
   	List<YuangonghetongView> selectListView(Wrapper<YuangonghetongEntity> wrapper);
   	
   	YuangonghetongView selectView(@Param("ew") Wrapper<YuangonghetongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangonghetongEntity> wrapper);

   	

}

