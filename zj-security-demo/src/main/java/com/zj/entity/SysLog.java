package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统日志
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_log")
public class SysLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 用户名
	 */
	@ApiModelProperty(name = "userName",value = "用户名")
	private String userName;
	/**
	 * 用户操作
	 */
	@ApiModelProperty(name = "operation",value = "用户操作")
	private String operation;
	/**
	 * 请求方法
	 */
	@ApiModelProperty(name = "method",value = "请求方法")
	private String method;
	/**
	 * 请求参数
	 */
	@ApiModelProperty(name = "params",value = "请求参数")
	private String params;
	/**
	 * 执行时长(毫秒)
	 */
	@ApiModelProperty(name = "time",value = "执行时长(毫秒)")
	private Long time;
	/**
	 * IP地址
	 */
	@ApiModelProperty(name = "ip",value = "IP地址")
	private String ip;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;

}
