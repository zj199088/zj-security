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

import com.zj.entity.SysDict;
import com.zj.service.SysDictService;

/**
 * 数据字典
 * @author zj
 * @since  2020-10-14 10:58:49
 */
@Api(tags = "数据字典 管理")
@RestController
@RequestMapping("zj/sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('zj:sysdict:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = sysDictService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('zj:sysdict:info')")
    public Resp<SysDict> info(@PathVariable("id") String id){
		SysDict sysDict = sysDictService.getById(id);

        return Resp.ok(sysDict);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('zj:sysdict:save')")
    public Resp<Object> save(@RequestBody SysDict sysDict){
		sysDictService.save(sysDict);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('zj:sysdict:update')")
    public Resp<Object> update(@RequestBody SysDict sysDict){
		sysDictService.updateById(sysDict);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('zj:sysdict:delete')")
    public Resp<Object> delete(@RequestBody String[] ids){
		sysDictService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
