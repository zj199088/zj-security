package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysMenuDao;
import com.zj.entity.SysMenu;
import com.zj.service.SysMenuService;

@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysMenu> page = this.page(
                new Query<SysMenu>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}