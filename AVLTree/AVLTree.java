package AVLTree;


class AVLNode {
    public int value;
    public AVLNode leftChild;
    public AVLNode rightChild;

    public AVLNode(int value) {
        this.value = value;
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

        return root;
    }

    public void insert(int value) {
        root = insert(this.root, value);
    }

}
