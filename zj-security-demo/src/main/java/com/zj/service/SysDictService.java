package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysDict;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 数据字典
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysDictService extends IService<SysDict> {

    PageVo queryPage(QueryCondition params);
}

