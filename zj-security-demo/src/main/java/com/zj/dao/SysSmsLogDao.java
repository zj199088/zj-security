package com.zj.dao;

import com.zj.entity.SysSmsLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信发送日志
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysSmsLogDao extends BaseMapper<SysSmsLog> {
	
}
