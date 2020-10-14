package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysOss;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 文件上传
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysOssService extends IService<SysOss> {

    PageVo queryPage(QueryCondition params);
}

