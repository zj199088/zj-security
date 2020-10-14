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

import com.zj.entity.SysMenu;
import com.zj.service.SysMenuService;

/**
 * 菜单管理
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "菜单管理 管理")
@RestController
@RequestMapping("zj/sysmenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysmenu:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysMenuService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{menuId}")
    @PreAuthorize("hasAuthority('zj:sysmenu:info')")
    public Resp<SysMenu> info(@PathVariable("menuId") String menuId){
		SysMenu sysMenu = sysMenuService.getById(menuId);

        return Resp.ok(sysMenu);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysmenu:save')")
    public Resp<Object> save(@RequestBody SysMenu sysMenu){
		sysMenuService.save(sysMenu);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysmenu:update')")
    public Resp<Object> update(@RequestBody SysMenu sysMenu){
		sysMenuService.updateById(sysMenu);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysmenu:delete')")
    public Resp<Object> delete(@RequestBody String[] menuIds){
		sysMenuService.removeByIds(Arrays.asList(menuIds));

        return Resp.ok(null);
    }

}
