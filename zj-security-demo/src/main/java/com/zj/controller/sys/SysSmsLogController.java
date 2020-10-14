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

import com.zj.entity.SysSmsLog;
import com.zj.service.SysSmsLogService;

/**
 * 短信发送日志
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "短信发送日志 管理")
@RestController
@RequestMapping("zj/syssmslog")
public class SysSmsLogController {
    @Autowired
    private SysSmsLogService sysSmsLogService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:syssmslog:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysSmsLogService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:syssmslog:info')")
    public Resp<SysSmsLog> info(@PathVariable("id") String id){
		SysSmsLog sysSmsLog = sysSmsLogService.getById(id);

        return Resp.ok(sysSmsLog);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:syssmslog:save')")
    public Resp<Object> save(@RequestBody SysSmsLog sysSmsLog){
		sysSmsLogService.save(sysSmsLog);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:syssmslog:update')")
    public Resp<Object> update(@RequestBody SysSmsLog sysSmsLog){
		sysSmsLogService.updateById(sysSmsLog);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:syssmslog:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysSmsLogService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
