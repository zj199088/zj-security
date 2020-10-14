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

import com.zj.entity.SysRoleMenu;
import com.zj.service.SysRoleMenuService;

/**
 * 角色与菜单对应关系
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "角色与菜单对应关系 管理")
@RestController
@RequestMapping("zj/sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysrolemenu:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysRoleMenuService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysrolemenu:info')")
    public Resp<SysRoleMenu> info(@PathVariable("id") String id){
		SysRoleMenu sysRoleMenu = sysRoleMenuService.getById(id);

        return Resp.ok(sysRoleMenu);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysrolemenu:save')")
    public Resp<Object> save(@RequestBody SysRoleMenu sysRoleMenu){
		sysRoleMenuService.save(sysRoleMenu);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysrolemenu:update')")
    public Resp<Object> update(@RequestBody SysRoleMenu sysRoleMenu){
		sysRoleMenuService.updateById(sysRoleMenu);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysrolemenu:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysRoleMenuService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
