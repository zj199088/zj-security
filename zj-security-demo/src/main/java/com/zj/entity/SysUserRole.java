package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户与角色对应关系
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(name = "userId",value = "用户ID")
	private String userId;
	/**
	 * 角色ID
	 */
	@ApiModelProperty(name = "roleId",value = "角色ID")
	private String roleId;

}
