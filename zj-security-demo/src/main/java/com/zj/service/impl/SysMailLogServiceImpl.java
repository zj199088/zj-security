package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysMailLogDao;
import com.zj.entity.SysMailLog;
import com.zj.service.SysMailLogService;

@Service("sysMailLogService")
public class SysMailLogServiceImpl extends ServiceImpl<SysMailLogDao, SysMailLog> implements SysMailLogService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysMailLog> page = this.page(
                new Query<SysMailLog>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}