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

import com.zj.entity.SysConfig;
import com.zj.service.SysConfigService;

/**
 * 系统配置信息表
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "系统配置信息表 管理")
@RestController
@RequestMapping("zj/sysconfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysconfig:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysConfigService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysconfig:info')")
    public Resp<SysConfig> info(@PathVariable("id") String id){
		SysConfig sysConfig = sysConfigService.getById(id);

        return Resp.ok(sysConfig);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysconfig:save')")
    public Resp<Object> save(@RequestBody SysConfig sysConfig){
		sysConfigService.save(sysConfig);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysconfig:update')")
    public Resp<Object> update(@RequestBody SysConfig sysConfig){
		sysConfigService.updateById(sysConfig);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysconfig:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysConfigService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
