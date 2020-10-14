package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysSmsLogDao;
import com.zj.entity.SysSmsLog;
import com.zj.service.SysSmsLogService;

@Service("sysSmsLogService")
public class SysSmsLogServiceImpl extends ServiceImpl<SysSmsLogDao, SysSmsLog> implements SysSmsLogService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysSmsLog> page = this.page(
                new Query<SysSmsLog>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}