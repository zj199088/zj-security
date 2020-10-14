package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysDictGroup;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 数据字典分组
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysDictGroupService extends IService<SysDictGroup> {

    PageVo queryPage(QueryCondition params);
}

