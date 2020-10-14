package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色与机构对应关系
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_role_org")
public class SysRoleOrg implements Serializable {
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
	 * 部门ID
	 */
	@ApiModelProperty(name = "orgNo",value = "部门ID")
	private String orgNo;

}
