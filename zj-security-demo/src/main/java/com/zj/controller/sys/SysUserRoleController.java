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

import com.zj.entity.SysUserRole;
import com.zj.service.SysUserRoleService;

/**
 * 用户与角色对应关系
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "用户与角色对应关系 管理")
@RestController
@RequestMapping("zj/sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysuserrole:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysUserRoleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysuserrole:info')")
    public Resp<SysUserRole> info(@PathVariable("id") String id){
		SysUserRole sysUserRole = sysUserRoleService.getById(id);

        return Resp.ok(sysUserRole);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysuserrole:save')")
    public Resp<Object> save(@RequestBody SysUserRole sysUserRole){
		sysUserRoleService.save(sysUserRole);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysuserrole:update')")
    public Resp<Object> update(@RequestBody SysUserRole sysUserRole){
		sysUserRoleService.updateById(sysUserRole);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysuserrole:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysUserRoleService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
