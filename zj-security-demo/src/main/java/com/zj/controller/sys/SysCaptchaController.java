package com.zj.controller.sys;

import java.util.Arrays;

import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;
import com.zj.common.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.zj.entity.SysCaptcha;
import com.zj.service.SysCaptchaService;

/**
 * 系统验证码
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "系统验证码 管理")
@RestController
@RequestMapping("zj/syscaptcha")
public class SysCaptchaController {
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:syscaptcha:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysCaptchaService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{uuid}")
    @PreAuthorize("hasAuthority('zj:syscaptcha:info')")
    public Resp<SysCaptcha> info(@PathVariable("uuid") String uuid){
		SysCaptcha sysCaptcha = sysCaptchaService.getById(uuid);

        return Resp.ok(sysCaptcha);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:syscaptcha:save')")
    public Resp<Object> save(@RequestBody SysCaptcha sysCaptcha){
		sysCaptchaService.save(sysCaptcha);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:syscaptcha:update')")
    public Resp<Object> update(@RequestBody SysCaptcha sysCaptcha){
		sysCaptchaService.updateById(sysCaptcha);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:syscaptcha:delete')")
    public Resp<Object> delete(@RequestBody String[] uuids){
		sysCaptchaService.removeByIds(Arrays.asList(uuids));

        return Resp.ok(null);
    }

}
