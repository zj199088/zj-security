package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysConfig;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 系统配置信息表
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysConfigService extends IService<SysConfig> {

    PageVo queryPage(QueryCondition params);
}

