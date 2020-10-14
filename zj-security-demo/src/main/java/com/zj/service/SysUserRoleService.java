package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysUserRole;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 用户与角色对应关系
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    PageVo queryPage(QueryCondition params);
}

