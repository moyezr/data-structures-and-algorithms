package AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = new int[]{10, 5 ,15, 2, 8, 12, 20};

        for(int val: values) {
            tree.insert(val);
        }
    }
}
