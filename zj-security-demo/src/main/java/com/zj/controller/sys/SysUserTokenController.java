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

import com.zj.entity.SysUserToken;
import com.zj.service.SysUserTokenService;

/**
 * 系统用户Token
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "系统用户Token 管理")
@RestController
@RequestMapping("zj/sysusertoken")
public class SysUserTokenController {
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysusertoken:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysUserTokenService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('zj:sysusertoken:info')")
    public Resp<SysUserToken> info(@PathVariable("userId") String userId){
		SysUserToken sysUserToken = sysUserTokenService.getById(userId);

        return Resp.ok(sysUserToken);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysusertoken:save')")
    public Resp<Object> save(@RequestBody SysUserToken sysUserToken){
		sysUserTokenService.save(sysUserToken);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysusertoken:update')")
    public Resp<Object> update(@RequestBody SysUserToken sysUserToken){
		sysUserTokenService.updateById(sysUserToken);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysusertoken:delete')")
    public Resp<Object> delete(@RequestBody String[] userIds){
		sysUserTokenService.removeByIds(Arrays.asList(userIds));

        return Resp.ok(null);
    }

}
