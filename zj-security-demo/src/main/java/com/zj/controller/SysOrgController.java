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

import com.zj.entity.SysOrg;
import com.zj.service.SysOrgService;

/**
 * 组织机构
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "组织机构 管理")
@RestController
@RequestMapping("zj/sysorg")
public class SysOrgController {
    @Autowired
    private SysOrgService sysOrgService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysorg:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysOrgService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{orgNo}")
    @PreAuthorize("hasAuthority('zj:sysorg:info')")
    public Resp<SysOrg> info(@PathVariable("orgNo") String orgNo){
		SysOrg sysOrg = sysOrgService.getById(orgNo);

        return Resp.ok(sysOrg);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysorg:save')")
    public Resp<Object> save(@RequestBody SysOrg sysOrg){
		sysOrgService.save(sysOrg);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysorg:update')")
    public Resp<Object> update(@RequestBody SysOrg sysOrg){
		sysOrgService.updateById(sysOrg);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysorg:delete')")
    public Resp<Object> delete(@RequestBody String[] orgNos){
		sysOrgService.removeByIds(Arrays.asList(orgNos));

        return Resp.ok(null);
    }

}
