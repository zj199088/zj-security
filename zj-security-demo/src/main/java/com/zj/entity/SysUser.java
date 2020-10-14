package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_user")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(name = "userName",value = "用户名")
	private String userName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "realName",value = "")
	private String realName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "sex",value = "")
	private Integer sex;
	/**
	 * 机构编码
	 */
	@ApiModelProperty(name = "orgNo",value = "机构编码")
	private String orgNo;
	/**
	 * 盐
	 */
	@ApiModelProperty(name = "salt",value = "盐")
	private String salt;
	/**
	 * 邮件服务器地址
	 */
	@ApiModelProperty(name = "emailHost",value = "邮件服务器地址")
	private String emailHost;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(name = "email",value = "邮箱")
	private String email;
	/**
	 * 用户邮箱密码
	 */
	@ApiModelProperty(name = "emailPw",value = "用户邮箱密码")
	private String emailPw;
	/**
	 * 手机号
	 */
	@ApiModelProperty(name = "mobile",value = "手机号")
	private String mobile;
	/**
	 * 状态  0：禁用   1：正常
	 */
	@ApiModelProperty(name = "status",value = "状态  0：禁用   1：正常")
	private Integer status;
	/**
	 * 密码
	 */
	@ApiModelProperty(name = "password",value = "密码")
	private String password;
	/**
	 * 创建者ID
	 */
	@ApiModelProperty(name = "createUserId",value = "创建者ID")
	private String createUserId;
	/**
	 * 创建人所属机构
	 */
	@ApiModelProperty(name = "createUserOrgNo",value = "创建人所属机构")
	private String createUserOrgNo;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;

}
