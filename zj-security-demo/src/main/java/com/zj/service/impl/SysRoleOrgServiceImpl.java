package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysRoleOrgDao;
import com.zj.entity.SysRoleOrg;
import com.zj.service.SysRoleOrgService;

@Service("sysRoleOrgService")
public class SysRoleOrgServiceImpl extends ServiceImpl<SysRoleOrgDao, SysRoleOrg> implements SysRoleOrgService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysRoleOrg> page = this.page(
                new Query<SysRoleOrg>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}