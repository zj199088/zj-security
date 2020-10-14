package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysRole;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 角色
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysRoleService extends IService<SysRole> {

    PageVo queryPage(QueryCondition params);
}

