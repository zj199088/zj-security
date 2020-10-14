package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysLog;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 系统日志
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysLogService extends IService<SysLog> {

    PageVo queryPage(QueryCondition params);
}

