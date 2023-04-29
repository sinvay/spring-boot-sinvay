package com.sinvay.boot.response.tree;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 扁平数组元素
 *
 * @param <I> 节点ID类型
 * @author pizzalord
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class FlatArrayElement<I> {
    @ApiModelProperty(value = "节点ID")
    private I id;

    @ApiModelProperty(value = "节点名称")
    private String name;

    @ApiModelProperty(value = "节点处于树的层级")
    private int level;

    @ApiModelProperty(value = "父节点ID")
    private I parentId;
}
