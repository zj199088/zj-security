package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 邮件发送日志
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_mail_log")
public class SysMailLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 发送人
	 */
	@ApiModelProperty(name = "sender",value = "发送人")
	private String sender;
	/**
	 * 接收人
	 */
	@ApiModelProperty(name = "receiver",value = "接收人")
	private String receiver;
	/**
	 * 邮件主题
	 */
	@ApiModelProperty(name = "subject",value = "邮件主题")
	private String subject;
	/**
	 * 发送内容
	 */
	@ApiModelProperty(name = "content",value = "发送内容")
	private String content;
	/**
	 * 发送时间
	 */
	@ApiModelProperty(name = "sendDate",value = "发送时间")
	private Date sendDate;
	/**
	 * 0：系统发送邮件 1：用户发送邮件
	 */
	@ApiModelProperty(name = "type",value = "0：系统发送邮件 1：用户发送邮件")
	private Integer type;
	/**
	 * 发送结果 0:发送成功 1:发送失败
	 */
	@ApiModelProperty(name = "sendResult",value = "发送结果 0:发送成功 1:发送失败")
	private Integer sendResult;
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

}
