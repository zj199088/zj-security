package com.zj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据字典
 * @author zj
 * @since 2020-10-14 10:58:49
 */
@ApiModel
@Data
@TableName("sys_dict")
public class SysDict implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private String id;
	/**
	 * 所属分组ID
	 */
	@ApiModelProperty(name = "groupId",value = "所属分组ID")
	private String groupId;
	/**
	 * 字典名称
	 */
	@ApiModelProperty(name = "name",value = "字典名称")
	private String name;
	/**
	 * 字典值
	 */
	@ApiModelProperty(name = "value",value = "字典值")
	private String value;
	/**
	 * 排序号
	 */
	@ApiModelProperty(name = "sort",value = "排序号")
	private Integer sort;
	/**
	 * 状态码
	 */
	@ApiModelProperty(name = "status",value = "状态码")
	private Integer status;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "remark",value = "备注")
	private String remark;

}
