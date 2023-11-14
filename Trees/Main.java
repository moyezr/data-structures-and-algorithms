package Trees;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
//        MyBinarySearchTree tree2 = new MyBinarySearchTree();
        int[] nums = {7, 8, 1, 3, 2, 5, 10, 4};

        for(int num: nums) {
            tree.insert(num);
        }

//        for(int num: nums) {
//            tree2.insert(num);
//        }

//        System.out.println(tree.findNode(-24));
//        tree.inOrderTraversal();
//        System.out.println(tree.findDepth(3));
//        System.out.println(tree.heightOfNode(8));


//        System.out.println(tree.getMin());
//        System.out.println(tree.isEquals(tree2));


//        tree.nodesAtKDistance(2);

//        var ans = tree.levelOrderTraversalList();
//        System.out.println(ans);

//        tree.levelOrderTraversal();

//        Printing the diameter of the tree
//        System.out.println(tree.diameter());

//        tree.zigzagTraversal();
        tree.boundaryTraversal();
    }

}
