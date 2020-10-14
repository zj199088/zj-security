package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据字典分组
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_dict_group")
public class SysDictGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 分组编码
	 */
	@ApiModelProperty(name = "code",value = "分组编码")
	private String code;
	/**
	 * 分组名称
	 */
	@ApiModelProperty(name = "name",value = "分组名称")
	private String name;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "remark",value = "备注")
	private String remark;

}
