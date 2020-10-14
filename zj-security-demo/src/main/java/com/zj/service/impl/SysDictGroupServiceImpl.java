package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysDictGroupDao;
import com.zj.entity.SysDictGroup;
import com.zj.service.SysDictGroupService;

@Service("sysDictGroupService")
public class SysDictGroupServiceImpl extends ServiceImpl<SysDictGroupDao, SysDictGroup> implements SysDictGroupService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysDictGroup> page = this.page(
                new Query<SysDictGroup>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}