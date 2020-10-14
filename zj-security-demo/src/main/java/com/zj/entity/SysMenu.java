package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 菜单管理
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_menu")
public class SysMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "menuId",value = "")
	private String menuId;
	/**
	 * 父菜单ID，一级菜单为0
	 */
	@ApiModelProperty(name = "parentId",value = "父菜单ID，一级菜单为0")
	private String parentId;
	/**
	 * 菜单名称
	 */
	@ApiModelProperty(name = "name",value = "菜单名称")
	private String name;
	/**
	 * 菜单URL
	 */
	@ApiModelProperty(name = "url",value = "菜单URL")
	private String url;
	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	@ApiModelProperty(name = "perms",value = "授权(多个用逗号分隔，如：user:list,user:create)")
	private String perms;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
	 */
	@ApiModelProperty(name = "type",value = "类型   0：目录   1：菜单   2：按钮")
	private Integer type;
	/**
	 * 菜单图标
	 */
	@ApiModelProperty(name = "icon",value = "菜单图标")
	private String icon;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "orderNum",value = "排序")
	private Integer orderNum;

}
