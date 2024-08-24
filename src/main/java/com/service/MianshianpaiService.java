package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshianpaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshianpaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshianpaiView;


/**
 * 面试安排
 *
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
public interface MianshianpaiService extends IService<MianshianpaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshianpaiVO> selectListVO(Wrapper<MianshianpaiEntity> wrapper);
   	
   	MianshianpaiVO selectVO(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);
   	
   	List<MianshianpaiView> selectListView(Wrapper<MianshianpaiEntity> wrapper);
   	
   	MianshianpaiView selectView(@Param("ew") Wrapper<MianshianpaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshianpaiEntity> wrapper);

   	

}

