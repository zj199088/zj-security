package com.zj.dao;

import com.zj.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {
	
}
