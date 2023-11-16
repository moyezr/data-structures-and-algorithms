package AVLTree;


class AVLNode {
    public int value;
    public AVLNode leftChild;
    public AVLNode rightChild;

    public int height;

    public AVLNode(int value) {
        this.value = value;
        this.height = 0;
    }

    public String toString() {
        return "Value = " + this.value;
    }
}

public class AVLTree {

    private AVLNode root;

    private AVLNode insert(AVLNode root, int value) {

        if (root == null) {
            return new AVLNode(value);
        }

        if (root.value == value) {
            return root;
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;

        // Check for Imbalance
        // BalanceFactor = H(L) - H(R)
        // B.F < -1 || B.F > 1 --> It means that the tree is imbalanced.

        if (!isBalanced(root)) {
            if (isLeftHeavy(root)) {
                if (getBalanceFactor(root.leftChild) < 0) {
                    root.leftChild = leftRotate(root.leftChild);
                }

                root = rightRotate(root);
            } else if (isRightHeavy(root)) {
                if (getBalanceFactor(root.rightChild) > 0) {
                    root.rightChild = rightRotate(root.rightChild);
                }

                root = leftRotate(root);
            }
        }

        return root;
    }

    public void insert(int value) {
        root = insert(this.root, value);
    }

    private int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    private int getHeight(AVLNode node) {
        if (node == null) return -1;

        return node.height;
    }

    private boolean isBalanced(AVLNode node) {
        if (node == null) return true;

        int balanceFactor = getBalanceFactor(node);

        return balanceFactor >= -1 && balanceFactor <= 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        if (node == null) return false;

        int balanceFactor = getBalanceFactor(node);

        return balanceFactor > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        if (node == null) return false;

        int balanceFactor = getBalanceFactor(node);

        return balanceFactor < -1;
    }

    private AVLNode leftRotate(AVLNode root) {
        if (root == null) return null;
        AVLNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        return newRoot;
    }

    private AVLNode rightRotate(AVLNode root) {
        if (root == null) return null;

        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        return newRoot;
    }
}

