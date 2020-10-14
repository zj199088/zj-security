package com.zj.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.Query;
import com.zj.common.bean.QueryCondition;

import com.zj.dao.SysCaptchaDao;
import com.zj.entity.SysCaptcha;
import com.zj.service.SysCaptchaService;

@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptcha> implements SysCaptchaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SysCaptcha> page = this.page(
                new Query<SysCaptcha>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}