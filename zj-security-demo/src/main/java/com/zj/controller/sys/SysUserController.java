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

import com.zj.entity.SysUser;
import com.zj.service.SysUserService;

/**
 * 系统用户
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "系统用户 管理")
@RestController
@RequestMapping("zj/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysuser:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysUserService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('zj:sysuser:info')")
    public Resp<SysUser> info(@PathVariable("userId") String userId){
		SysUser sysUser = sysUserService.getById(userId);

        return Resp.ok(sysUser);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysuser:save')")
    public Resp<Object> save(@RequestBody SysUser sysUser){
		sysUserService.save(sysUser);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysuser:update')")
    public Resp<Object> update(@RequestBody SysUser sysUser){
		sysUserService.updateById(sysUser);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysuser:delete')")
    public Resp<Object> delete(@RequestBody String[] userIds){
		sysUserService.removeByIds(Arrays.asList(userIds));

        return Resp.ok(null);
    }

}
