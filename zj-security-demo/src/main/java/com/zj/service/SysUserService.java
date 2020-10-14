package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysUser;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 系统用户
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysUserService extends IService<SysUser> {

    PageVo queryPage(QueryCondition params);
}

