package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_role")
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "roleId",value = "")
	private String roleId;
	/**
	 * 角色名称
	 */
	@ApiModelProperty(name = "roleName",value = "角色名称")
	private String roleName;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "remark",value = "备注")
	private String remark;
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(name = "createUserId",value = "创建者ID")
	private String createUserId;
	/**
	 * 创建者所属机构
	 */
	@ApiModelProperty(name = "createUserOrgNo",value = "创建者所属机构")
	private String createUserOrgNo;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;

}
