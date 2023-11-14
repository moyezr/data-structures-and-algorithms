package Trees;


import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public String toString() {
        return "Value = " + this.data;
    }
}

public class MyBinarySearchTree {
    private TreeNode root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
//        TreeNode node = new TreeNode(value);
//        if (root == null) {
//            root = node;
//            return;
//        }
//
//        TreeNode current = root;
//
//        while (true) {
//            if (value <= current.data) { // Go left
//                if (current.leftChild == null) {
//                    current.leftChild = node;
//                    break;
//                }
//
//                current = current.leftChild;
//            } else { // Go Right
//                if (current.rightChild == null) {
//                    current.rightChild = node;
//                    break;
//                }
//                current = current.rightChild;
//            }
//        }
        root = insert(this.root, value);
    }

    private TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value <= root.data) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        return root;
    }

    public boolean findNode(int value) {
        return findNode(this.root, value);
    }

    private boolean findNode(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return findNode(root.leftChild, value);
        } else {
            return findNode(root.rightChild, value);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        // Pre-Order: Root -> Left -> Right

        System.out.print(root.data + "  ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        // Post-Order: Left -> Right -> Root
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + "  ");
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        // InOrder: Left -> Root -> Right
        inOrderTraversal(root.leftChild);
        System.out.print(root.data + "  ");
        inOrderTraversal(root.rightChild);
    }

    public int findDepth(int value) {
        return findDepth(root, value, 0);
    }

    private int findDepth(TreeNode root, int value, int depth) {
        if (root == null) {
            return -1;
        }

        if (root.data == value) {
            return depth;
        } else if (value < root.data) {
            return findDepth(root.leftChild, value, depth + 1);
        } else return findDepth(root.rightChild, value, depth + 1);
    }

    public int heightOfTree() {
        return heightOfTree(root);
    }

    private int heightOfTree(TreeNode root) {
        if (root == null) return -1;

        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }

        int myHeight = Math.max(heightOfTree(root.leftChild), heightOfTree(root.rightChild)) + 1;

        return myHeight;
    }

    public int heightOfNode(int value) {
        return heightOfNode(root, value);
    }


    private int heightOfNode(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }

        if (root.data == value) {
            return heightOfTree(root);
        } else if (value < root.data) {
            return heightOfNode(root.leftChild, value);
        } else {
            return heightOfNode(root.rightChild, value);
        }
    }

    private TreeNode getMin(TreeNode root) {
        if (root.leftChild == null) {
            return root;
        }
        return getMin(root.leftChild);
    }

    public TreeNode getMin() {
        if (root == null) return null;
        return getMin(root);
    }

    private boolean isEquals(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null) return false;
        if (r2 == null) return false;
        return r1.data == r2.data && isEquals(r1.leftChild, r2.leftChild) && isEquals(r1.rightChild, r2.rightChild);
    }

    public boolean isEquals(MyBinarySearchTree tree) {
        return isEquals(root, tree.root);
    }

    private void nodesAtKDistance(TreeNode root, int k, ArrayList<TreeNode> ans, int depth) {
        if (k <= 0) {
            ans.add(root);
            return;
        }

        if (depth == k) {
            ans.add(root);
        }

        if (root.leftChild != null) {
            nodesAtKDistance(root.leftChild, k, ans, depth + 1);
        }

        if (root.rightChild != null) {
            nodesAtKDistance(root.rightChild, k, ans, depth + 1);
        }
    }

    public void nodesAtKDistance(int k) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        nodesAtKDistance(root, k, ans, 0);
        System.out.println(ans);
    }

    public void levelOrderTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.data + " ");

            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public List<List<Integer>> levelOrderTraversalList() {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.data);

                if (node.rightChild != null)
                    queue.offer(node.rightChild);

                if (node.leftChild != null)
                    queue.offer(node.leftChild);
            }

            ans.add(temp);
        }

        return ans;
    }

    public int diameter() {
        return diameter(root);
    }

    private int diameter(TreeNode root) {
        if (root == null) return 0;

        int leftDia = diameter(root.leftChild);
        int rightDia = diameter(root.rightChild);


        int myDia = heightOfTree(root.leftChild) + 1 + heightOfTree(root.rightChild) + 1 + 1;

        return Math.max(leftDia, Math.max(rightDia, myDia));
    }

    public void zigzagTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean goRight = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.data + " ");
            goRight = !goRight;

            if (goRight) {
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
            } else {
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
            }

        }
    }

    void traverseLeaf(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        if (root.leftChild == null && root.rightChild == null) {
            result.add(root.data);
            return;
        }

        traverseLeaf(root.leftChild, result);
        traverseLeaf(root.rightChild, result);
    }

    void traverseLeft(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        if (root.leftChild == null && root.rightChild == null) {
            return;
        }

        result.add(root.data);

        if (root.leftChild != null) {
            traverseLeft(root.leftChild, result);
        } else {
            traverseLeft(root.rightChild, result);
        }
    }

    void traverseRight(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        if (root.leftChild == null && root.rightChild == null) {
            return;
        }

        if (root.rightChild != null) {
            traverseRight(root.rightChild, result);
        } else {
            traverseRight(root.leftChild, result);
        }
        result.add(root.data);
    }

    public void boundaryTraversal() {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) return;

        result.add(root.data);
        traverseLeft(root.leftChild, result);
        traverseLeaf(root.leftChild, result);
        traverseLeaf(root.rightChild, result);
        traverseRight(root.rightChild, result);

        System.out.println(result);
    }

    // Vertical Order Traversal
    public void verticalTraversalSolver(TreeNode root, Map<Integer, List<Integer>> map, int x) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }

        map.get(x).add(root.data);
        if (root.leftChild != null) {
             verticalTraversalSolver(root.leftChild, map, x - 1);
        }
         verticalTraversalSolver(root.rightChild, map, x + 1);
    }

    public void verticalTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

         verticalTraversalSolver(root, map, 0);

        for(int key: map.keySet()) {
            Collections.sort(map.get(key));
            result.add(map.get(key));
        }

        System.out.println(map);

        System.out.println(result);
    }

}