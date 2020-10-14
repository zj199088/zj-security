package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysDictDao;
import com.zj.entity.SysDict;
import com.zj.service.SysDictService;

@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDict> implements SysDictService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysDict> page = this.page(
                new Query<SysDict>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}