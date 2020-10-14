package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysRoleMenuDao;
import com.zj.entity.SysRoleMenu;
import com.zj.service.SysRoleMenuService;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysRoleMenu> page = this.page(
                new Query<SysRoleMenu>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}