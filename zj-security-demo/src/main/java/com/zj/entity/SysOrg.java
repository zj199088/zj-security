package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 组织机构
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_org")
public class SysOrg implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 机构编码
	 */
	@TableId
	@ApiModelProperty(name = "orgNo",value = "机构编码")
	private String orgNo;
	/**
	 * 部门名称
	 */
	@ApiModelProperty(name = "orgName",value = "部门名称")
	private String orgName;
	/**
	 * 上级部门ID，一级部门为0
	 */
	@ApiModelProperty(name = "parentNo",value = "上级部门ID，一级部门为0")
	private String parentNo;
	/**
	 * 级别
	 */
	@ApiModelProperty(name = "orgType",value = "级别")
	private Integer orgType;
	/**
	 * 状态  0：无效   1：有效
	 */
	@ApiModelProperty(name = "status",value = "状态  0：无效   1：有效")
	private Integer status;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(name = "createUserId",value = "创建者ID")
	private String createUserId;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;

}
