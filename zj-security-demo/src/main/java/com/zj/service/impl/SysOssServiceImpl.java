package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysOssDao;
import com.zj.entity.SysOss;
import com.zj.service.SysOssService;

@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOss> implements SysOssService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysOss> page = this.page(
                new Query<SysOss>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}