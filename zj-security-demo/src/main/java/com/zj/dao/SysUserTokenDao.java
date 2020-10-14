package com.zj.dao;

import com.zj.entity.SysUserToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserToken> {
	
}
