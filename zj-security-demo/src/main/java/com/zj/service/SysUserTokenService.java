package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysUserToken;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 系统用户Token
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysUserTokenService extends IService<SysUserToken> {

    PageVo queryPage(QueryCondition params);
}

