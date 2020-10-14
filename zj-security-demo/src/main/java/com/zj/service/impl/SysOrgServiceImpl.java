package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysOrgDao;
import com.zj.entity.SysOrg;
import com.zj.service.SysOrgService;

@Service("sysOrgService")
public class SysOrgServiceImpl extends ServiceImpl<SysOrgDao, SysOrg> implements SysOrgService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysOrg> page = this.page(
                new Query<SysOrg>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}