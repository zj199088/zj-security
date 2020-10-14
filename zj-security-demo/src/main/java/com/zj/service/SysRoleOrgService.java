package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysRoleOrg;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 角色与机构对应关系
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysRoleOrgService extends IService<SysRoleOrg> {

    PageVo queryPage(QueryCondition params);
}

