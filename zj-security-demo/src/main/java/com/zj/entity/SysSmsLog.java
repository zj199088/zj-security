package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 短信发送日志
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_sms_log")
public class SysSmsLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "主键")
	private String id;
	/**
	 * 操作人ID
	 */
	@ApiModelProperty(name = "userId",value = "操作人ID")
	private String userId;
	/**
	 * 模板ID
	 */
	@ApiModelProperty(name = "templateId",value = "模板ID")
	private Integer templateId;
	/**
	 * 验证码
	 */
	@ApiModelProperty(name = "code",value = "验证码")
	private Integer code;
	/**
	 * 发送内容（1-500 个汉字）UTF-8编码
	 */
	@ApiModelProperty(name = "content",value = "发送内容（1-500 个汉字）UTF-8编码")
	private String content;
	/**
	 * 手机号码。多个以英文逗号隔开
	 */
	@ApiModelProperty(name = "mobile",value = "手机号码。多个以英文逗号隔开")
	private String mobile;
	/**
	 * 发送时间
	 */
	@ApiModelProperty(name = "stime",value = "发送时间")
	private Date stime;
	/**
	 * 必填参数。用户签名
	 */
	@ApiModelProperty(name = "sign",value = "必填参数。用户签名")
	private String sign;
	/**
	 * 0成功 1失败
	 */
	@ApiModelProperty(name = "sendStatus",value = "0成功 1失败")
	private Integer sendStatus;
	/**
	 * 发送编号
	 */
	@ApiModelProperty(name = "sendId",value = "发送编号")
	private String sendId;
	/**
	 * 成功提交数
	 */
	@ApiModelProperty(name = "successNum",value = "成功提交数")
	private Integer successNum;
	/**
	 * 返回消息
	 */
	@ApiModelProperty(name = "returnMsg",value = "返回消息")
	private String returnMsg;

}
