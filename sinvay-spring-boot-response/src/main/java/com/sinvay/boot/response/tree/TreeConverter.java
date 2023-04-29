package com.sinvay.boot.response.tree;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 树形结构转换器
 *
 * @author pizzalord
 * @since 1.0
 */
public class TreeConverter {
    /**
     * 扁平数组转树形结构
     *
     * @param flatArrayElements 扁平数组转树形结构
     * @param parentId          父级ID
     * @param level             层级
     * @param <I>               ID类型
     * @return 树形结构
     */
    public static <I> List<TreeNode<I>> toTree(List<FlatArrayElement<I>> flatArrayElements, I parentId, int level) {
        return flatArrayElements
                .stream()
                .filter(x -> x.getParentId().equals(parentId))
                .map(x -> {
                    TreeNode<I> treeNode = new TreeNode<>();
                    return treeNode.toBuilder()
                            .id(x.getId())
                            .name(x.getName())
                            .level(level)
                            .parentId(x.getParentId())
                            .children(toTree(flatArrayElements, x.getId(), level + 1))
                            .build();
                })
                .collect(Collectors.toList());
    }

    /**
     * 树形结构转扁平数组
     *
     * @param treeNodes 树形结构
     * @param <I>       ID类型
     * @return 扁平数组
     */
    public static <I> List<FlatArrayElement<I>> toFlatArray(List<TreeNode<I>> treeNodes) {
        if (CollectionUtils.isEmpty(treeNodes)) {
            return Lists.newArrayList();
        }

        List<FlatArrayElement<I>> retList = Lists.newArrayList();
        treeNodes.forEach(x -> {
            retList.add(new FlatArrayElement<I>().toBuilder()
                    .id(x.getId())
                    .name(x.getName())
                    .level(x.getLevel())
                    .parentId(x.getParentId())
                    .build());
            retList.addAll(toFlatArray(x.getChildren()));
        });

        return retList;
    }

    /**
     * 扁平数组转树形结构, 带选择状态
     *
     * @param flatArrayElements 扁平数组转树形结构
     * @param parentId          父级ID
     * @param level             层级
     * @param <I>               ID类型
     * @return 树形结构
     */
    public static <I> List<SelectedTreeNode<I>> toTreeWithSelected(List<SelectedFlatArrayElement<I>> flatArrayElements, I parentId, int level) {
        return flatArrayElements
                .stream()
                .filter(x -> x.getParentId().equals(parentId))
                .map(x -> {
                    SelectedTreeNode<I> treeNode = new SelectedTreeNode<>();
                    return treeNode.toBuilder()
                            .id(x.getId())
                            .name(x.getName())
                            .level(level)
                            .selected(x.isSelected())
                            .parentId(x.getParentId())
                            .children(toTreeWithSelected(flatArrayElements, x.getId(), level + 1))
                            .build();
                }).collect(Collectors.toList());
    }

    /**
     * 扁平数组转树形结构, 带选择状态
     *
     * @param flatArrayElements 扁平数组转树形结构
     * @param parentId          父级ID
     * @param level             层级
     * @param <I>               ID类型
     * @return 树形结构
     */
    public static <I> List<MixedTypeTreeNode<I>> toTreeWithMixedType(List<MixedTypeFlatArrayElement<I>> flatArrayElements, I parentId, int level) {
        return flatArrayElements
                .stream()
                .filter(x -> x.getParentId().equals(parentId))
                .map(x -> {
                    MixedTypeTreeNode<I> treeNode = new MixedTypeTreeNode<>();
                    return treeNode.toBuilder()
                            .id(x.getId())
                            .name(x.getName())
                            .level(level)
                            .type(x.getType())
                            .parentId(x.getParentId())
                            .children(toTreeWithMixedType(flatArrayElements, x.getId(), level + 1))
                            .build();
                }).collect(Collectors.toList());
    }

    public static <I> TreeNode<I> findById(List<TreeNode<I>> tree, I id) {
        for (TreeNode<I> iTreeNode : tree) {
            if (iTreeNode.getId().equals(id)) {
                return iTreeNode;
            } else {
                TreeNode<I> child = findById(iTreeNode.getChildren(), id);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
