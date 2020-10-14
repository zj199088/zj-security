package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysConfigDao;
import com.zj.entity.SysConfig;
import com.zj.service.SysConfigService;

@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfig> implements SysConfigService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysConfig> page = this.page(
                new Query<SysConfig>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}