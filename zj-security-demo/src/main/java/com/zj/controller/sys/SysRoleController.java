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

import com.zj.entity.SysRole;
import com.zj.service.SysRoleService;

/**
 * 角色
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "角色 管理")
@RestController
@RequestMapping("zj/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysrole:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysRoleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{roleId}")
    @PreAuthorize("hasAuthority('zj:sysrole:info')")
    public Resp<SysRole> info(@PathVariable("roleId") String roleId){
		SysRole sysRole = sysRoleService.getById(roleId);

        return Resp.ok(sysRole);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysrole:save')")
    public Resp<Object> save(@RequestBody SysRole sysRole){
		sysRoleService.save(sysRole);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysrole:update')")
    public Resp<Object> update(@RequestBody SysRole sysRole){
		sysRoleService.updateById(sysRole);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysrole:delete')")
    public Resp<Object> delete(@RequestBody String[] roleIds){
		sysRoleService.removeByIds(Arrays.asList(roleIds));

        return Resp.ok(null);
    }

}
