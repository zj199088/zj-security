package com.zj.controller;

import java.util.Arrays;

import com.zj.common.bean.PageVo;
import com.zj.common.bean.QueryCondition;
import com.zj.common.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.zj.entity.SysMailLog;
import com.zj.service.SysMailLogService;

/**
 * 邮件发送日志
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "邮件发送日志 管理")
@RestController
@RequestMapping("zj/sysmaillog")
public class SysMailLogController {
    @Autowired
    private SysMailLogService sysMailLogService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysmaillog:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysMailLogService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysmaillog:info')")
    public Resp<SysMailLog> info(@PathVariable("id") String id){
		SysMailLog sysMailLog = sysMailLogService.getById(id);

        return Resp.ok(sysMailLog);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysmaillog:save')")
    public Resp<Object> save(@RequestBody SysMailLog sysMailLog){
		sysMailLogService.save(sysMailLog);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysmaillog:update')")
    public Resp<Object> update(@RequestBody SysMailLog sysMailLog){
		sysMailLogService.updateById(sysMailLog);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysmaillog:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysMailLogService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
