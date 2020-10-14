package com.zj.dao;

import com.zj.entity.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDict> {
	
}
