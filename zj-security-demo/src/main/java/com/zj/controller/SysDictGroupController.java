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

import com.zj.entity.SysDictGroup;
import com.zj.service.SysDictGroupService;

/**
 * 数据字典分组
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "数据字典分组 管理")
@RestController
@RequestMapping("zj/sysdictgroup")
public class SysDictGroupController {
    @Autowired
    private SysDictGroupService sysDictGroupService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysdictgroup:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysDictGroupService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysdictgroup:info')")
    public Resp<SysDictGroup> info(@PathVariable("id") String id){
		SysDictGroup sysDictGroup = sysDictGroupService.getById(id);

        return Resp.ok(sysDictGroup);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysdictgroup:save')")
    public Resp<Object> save(@RequestBody SysDictGroup sysDictGroup){
		sysDictGroupService.save(sysDictGroup);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysdictgroup:update')")
    public Resp<Object> update(@RequestBody SysDictGroup sysDictGroup){
		sysDictGroupService.updateById(sysDictGroup);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysdictgroup:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysDictGroupService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
