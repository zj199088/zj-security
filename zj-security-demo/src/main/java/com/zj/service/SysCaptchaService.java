package com.zj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.entity.SysCaptcha;
import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;

/**
 * 系统验证码
 *
 * @author zj
 * @since  2020-10-14 10:58:49
 */
public interface SysCaptchaService extends IService<SysCaptcha> {

    PageVo queryPage(QueryCondition params);
}

