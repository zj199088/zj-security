package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysUserTokenDao;
import com.zj.entity.SysUserToken;
import com.zj.service.SysUserTokenService;

@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserToken> implements SysUserTokenService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysUserToken> page = this.page(
                new Query<SysUserToken>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}