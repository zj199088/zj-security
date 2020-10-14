package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysRoleDao;
import com.zj.entity.SysRole;
import com.zj.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysRole> page = this.page(
                new Query<SysRole>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}