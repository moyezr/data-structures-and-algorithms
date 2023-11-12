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

    public boolean findNode(int value) {
        return findNode(this.root, value);
    }
    private boolean findNode(TreeNode root, int value) {
        if(root == null) {
            return false;
        }

        if(value == root.data) {
            return true;
        } else if(value < root.data) {
         return findNode(root.leftChild, value);
        } else {
            return findNode(root.rightChild, value);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }
    private void preOrderTraversal(TreeNode root) {
        if(root == null) return;

        // Pre-Order: Root -> Left -> Right

        System.out.print(root.data + "  ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode root) {
        if(root == null) return;

        // Post-Order: Left -> Right -> Root
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + "  ");
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null) return;

        // InOrder: Left -> Root -> Right
        inOrderTraversal(root.leftChild);
        System.out.print(root.data + "  ");
        inOrderTraversal(root.rightChild);
    }

    public int findDepth(int value) {
        return findDepth(root, value, 0);
    }
    private int findDepth(TreeNode root, int value, int depth){
        if(root == null) {
            return -1;
        }

        if(root.data == value) {
            return depth;
        } else if(value < root.data) {
            return findDepth(root.leftChild, value, depth + 1);
        } else return findDepth(root.rightChild, value, depth + 1);
    }

    public int heightOfTree(int value) {
        return heightOfTree(root, value);
    }

    private int heightOfTree(TreeNode root, int value) {
        if(root == null) return -1;

        if(root.leftChild == null && root.rightChild == null) {
            return 0;
        }

        int myHeight = Math.max(heightOfTree(root.leftChild, value), heightOfTree(root.rightChild, value)) + 1;

        return myHeight;
    }

    public int heightOfNode(int value) {
        return heightOfNode(root, value);
    }


    private int heightOfNode(TreeNode root, int value) {
        if(root == null) {
            return -1;
        }

        if(root.data == value) {
            return heightOfTree(root, value);
        } else if(value < root.data) {
            return heightOfTree(root.leftChild, value);
        } else {
            return heightOfTree(root.rightChild, value);
        }
    }

    private TreeNode getMin(TreeNode root) {
        if(root.leftChild == null) {
            return root;
        }
        return getMin(root.leftChild);
    }
    public TreeNode getMin() {
        if(root == null) return null;
        return getMin(root);
    }

    private boolean isEquals(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true;
        }
        if(r1 == null) return false;
        if(r2 == null) return false;
        return r1.data == r2.data && isEquals(r1.leftChild, r2.leftChild) && isEquals(r1.rightChild, r2.rightChild);
    }

    public boolean isEquals(MyBinarySearchTree tree) {
        return isEquals(root, tree.root);
    }

}