package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianlixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianlixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianlixinxiView;


/**
 * 简历信息
 *
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
public interface JianlixinxiService extends IService<JianlixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianlixinxiVO> selectListVO(Wrapper<JianlixinxiEntity> wrapper);
   	
   	JianlixinxiVO selectVO(@Param("ew") Wrapper<JianlixinxiEntity> wrapper);
   	
   	List<JianlixinxiView> selectListView(Wrapper<JianlixinxiEntity> wrapper);
   	
   	JianlixinxiView selectView(@Param("ew") Wrapper<JianlixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianlixinxiEntity> wrapper);

   	

}

