package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysMenu;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 菜单管理
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysMenuService extends IService<SysMenu> {

    PageVo queryPage(QueryCondition params);
}

