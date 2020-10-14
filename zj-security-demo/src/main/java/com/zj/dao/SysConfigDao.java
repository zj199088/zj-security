package com.zj.dao;

import com.zj.entity.SysConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统配置信息表
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfig> {
	
}
