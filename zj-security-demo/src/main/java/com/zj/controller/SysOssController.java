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

import com.zj.entity.SysOss;
import com.zj.service.SysOssService;

/**
 * 文件上传
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "文件上传 管理")
@RestController
@RequestMapping("zj/sysoss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysoss:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysOssService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysoss:info')")
    public Resp<SysOss> info(@PathVariable("id") String id){
		SysOss sysOss = sysOssService.getById(id);

        return Resp.ok(sysOss);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysoss:save')")
    public Resp<Object> save(@RequestBody SysOss sysOss){
		sysOssService.save(sysOss);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysoss:update')")
    public Resp<Object> update(@RequestBody SysOss sysOss){
		sysOssService.updateById(sysOss);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysoss:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysOssService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
