package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色与菜单对应关系
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 角色ID
	 */
	@ApiModelProperty(name = "roleId",value = "角色ID")
	private String roleId;
	/**
	 * 菜单ID
	 */
	@ApiModelProperty(name = "menuId",value = "菜单ID")
	private String menuId;

}
