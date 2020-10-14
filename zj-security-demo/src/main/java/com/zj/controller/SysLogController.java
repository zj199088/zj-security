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

import com.zj.entity.SysLog;
import com.zj.service.SysLogService;

/**
 * 系统日志
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "系统日志 管理")
@RestController
@RequestMapping("zj/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:syslog:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysLogService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:syslog:info')")
    public Resp<SysLog> info(@PathVariable("id") String id){
		SysLog sysLog = sysLogService.getById(id);

        return Resp.ok(sysLog);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:syslog:save')")
    public Resp<Object> save(@RequestBody SysLog sysLog){
		sysLogService.save(sysLog);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:syslog:update')")
    public Resp<Object> update(@RequestBody SysLog sysLog){
		sysLogService.updateById(sysLog);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:syslog:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysLogService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
