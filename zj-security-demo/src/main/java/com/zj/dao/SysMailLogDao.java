package com.zj.dao;

import com.zj.entity.SysMailLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件发送日志
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysMailLogDao extends BaseMapper<SysMailLog> {
	
}
