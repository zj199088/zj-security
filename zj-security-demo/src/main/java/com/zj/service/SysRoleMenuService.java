package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysRoleMenu;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 角色与菜单对应关系
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    PageVo queryPage(QueryCondition params);
}

