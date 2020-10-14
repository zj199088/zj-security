package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysLogDao;
import com.zj.entity.SysLog;
import com.zj.service.SysLogService;

@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysLog> page = this.page(
                new Query<SysLog>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}