package com.zj.dao;

import com.zj.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {
	
}
