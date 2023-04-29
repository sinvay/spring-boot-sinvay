package com.sinvay.boot.response.tree;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 树形结构(带选择状态)
 *
 * @author pizzalord
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class SelectedTreeNode<I> implements Serializable {
    @ApiModelProperty(value = "节点ID")
    private I id;

    @ApiModelProperty(value = "节点名称")
    private String name;

    @ApiModelProperty(value = "节点处于树的层级")
    private int level;

    @ApiModelProperty(value = "父节点ID")
    private I parentId;

    @ApiModelProperty(value = "节点ID")
    private boolean selected;

    @ApiModelProperty(value = "子节点")
    private List<SelectedTreeNode<I>> children;
}
