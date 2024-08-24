package com.entity.view;

import com.entity.GangweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 岗位
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 17:46:28
 */
@TableName("gangwei")
public class GangweiView  extends GangweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweiView(){
	}
 
 	public GangweiView(GangweiEntity gangweiEntity){
 	try {
			BeanUtils.copyProperties(this, gangweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
