package com.zj.dao;

import com.zj.entity.SysRoleOrg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与机构对应关系
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysRoleOrgDao extends BaseMapper<SysRoleOrg> {
	
}
