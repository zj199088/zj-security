package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysSmsLog;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 短信发送日志
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysSmsLogService extends IService<SysSmsLog> {

    PageVo queryPage(QueryCondition params);
}

