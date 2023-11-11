package Trees;


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
}