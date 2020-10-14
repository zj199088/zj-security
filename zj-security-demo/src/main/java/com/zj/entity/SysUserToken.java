package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统用户Token
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_user_token")
public class SysUserToken implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "userId",value = "")
	private String userId;
	/**
	 * token
	 */
	@ApiModelProperty(name = "token",value = "token")
	private String token;
	/**
	 * 过期时间
	 */
	@ApiModelProperty(name = "expireTime",value = "过期时间")
	private Date expireTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime",value = "更新时间")
	private Date updateTime;

}
