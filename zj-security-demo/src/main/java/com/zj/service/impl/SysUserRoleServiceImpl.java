package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysUserRoleDao;
import com.zj.entity.SysUserRole;
import com.zj.service.SysUserRoleService;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysUserRole> page = this.page(
                new Query<SysUserRole>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}