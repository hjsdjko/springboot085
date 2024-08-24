package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhengzhaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhengzhaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengzhaoxinxiView;


/**
 * 证照信息
 *
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
public interface ZhengzhaoxinxiService extends IService<ZhengzhaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengzhaoxinxiVO> selectListVO(Wrapper<ZhengzhaoxinxiEntity> wrapper);
   	
   	ZhengzhaoxinxiVO selectVO(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);
   	
   	List<ZhengzhaoxinxiView> selectListView(Wrapper<ZhengzhaoxinxiEntity> wrapper);
   	
   	ZhengzhaoxinxiView selectView(@Param("ew") Wrapper<ZhengzhaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengzhaoxinxiEntity> wrapper);

   	

}

