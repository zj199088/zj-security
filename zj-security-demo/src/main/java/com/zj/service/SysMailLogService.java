package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysMailLog;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 邮件发送日志
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysMailLogService extends IService<SysMailLog> {

    PageVo queryPage(QueryCondition params);
}

