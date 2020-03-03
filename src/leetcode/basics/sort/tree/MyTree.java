package leetcode.basics.sort.tree;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class MyTree {
    private class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }

    // 根据链表生成二叉树
    private TreeNode generateTree(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        Integer data = linkedList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.left = generateTree(linkedList);
            treeNode.right = generateTree(linkedList);
        }
        return treeNode;
    }

    // 前序遍历
    private void preOrderTraversal(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.data + "\t");
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }

    // 中序遍历
    private void inOrderTraversal(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrderTraversal(tree.left);
        System.out.print(tree.data + "\t");
        inOrderTraversal(tree.right);
    }

    // 后序遍历
    private void postOrderTraversal(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        System.out.print(tree.data + "\t");
    }

    // 层序遍历
    private void levelOrderTraversal(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + "\t");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = generateTree(linkedList);
        System.out.println("前序遍历：");
        preOrderTraversal(treeNode);
        System.out.println("\n中序遍历：");
        inOrderTraversal(treeNode);
        System.out.println("\n后序遍历：");
        postOrderTraversal(treeNode);
        System.out.println("\n层序遍历：");
        levelOrderTraversal(treeNode);
    }

    // 上浮（插入）
    private void upAdjust(List<Integer> list) {
        int childrenIndex = list.size() - 1;
        int parentIndex = childrenIndex / 2;
        int temp = list.get(childrenIndex);
        while (childrenIndex > 0 && temp < list.get(parentIndex)) {
            list.set(childrenIndex, list.get(parentIndex));
            childrenIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        list.set(childrenIndex, temp);
    }

    // 下沉（删除）
    private void downAdjust(List<Integer> list, int parentIndex, int size) {
        int temp = list.get(parentIndex);
        int childrenIndex = 2 * parentIndex + 1;
        while (childrenIndex < size) {
            if (childrenIndex + 1 < size && list.get(childrenIndex + 1) < list.get(childrenIndex)) {
                childrenIndex++;
            }
            if (temp <= list.get(childrenIndex)) {
                break;
            }
            list.set(parentIndex, list.get(childrenIndex));
            parentIndex = childrenIndex;
            childrenIndex = 2 * childrenIndex + 1;
        }
        list.set(parentIndex, temp);
    }

    // 构建堆
    private void buildHeap(List<Integer> list) {
        for (int i = (list.size() - 2) / 2; i >= 0; i--) {
            downAdjust(list, i, list.size());
        }
    }

    @Test
    public void test2() {
        System.out.println("list上浮0");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 6, 5, 7, 8, 9, 10, 0));
        upAdjust(list);
        list.forEach(integer -> {
            System.out.print(integer + "\t");
        });

        list = new ArrayList<>(Arrays.asList(7, 1, 3, 10, 5, 2, 8, 9, 6));
        buildHeap(list);
        System.out.println("\nlist下沉7");
        list.forEach(integer -> {
            System.out.print(integer + "\t");
        });

    }
}
