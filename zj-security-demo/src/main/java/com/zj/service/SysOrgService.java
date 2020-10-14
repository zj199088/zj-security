package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysOrg;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 组织机构
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysOrgService extends IService<SysOrg> {

    PageVo queryPage(QueryCondition params);
}

