package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysUserDao;
import com.zj.entity.SysUser;
import com.zj.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysUser> page = this.page(
                new Query<SysUser>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}