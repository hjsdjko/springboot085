package com.entity.view;

import com.entity.JiangchengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 奖惩信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 17:46:29
 */
@TableName("jiangchengxinxi")
public class JiangchengxinxiView  extends JiangchengxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiangchengxinxiView(){
	}
 
 	public JiangchengxinxiView(JiangchengxinxiEntity jiangchengxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiangchengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
