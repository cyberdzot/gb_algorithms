package Homework04;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(13);
        tree.add(20);

        System.out.println("До поворота влево:");
        printTree(tree);

        tree.root = tree.rotateLeft(tree.root);

        // После поворота влево:
        System.out.println("После поворота влево:");
        printTree(tree);

        // Вернем дерево к исходному состоянию
        tree = new RedBlackTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(13);
        tree.add(20);

        // До поворота:
        System.out.println("До поворота вправо:");
        printTree(tree);

        tree.root = tree.rotateRight(tree.root);

        // После поворота вправо:
        System.out.println("После поворота вправо:");
        printTree(tree);

        // Вернем дерево к исходному состоянию
        tree = new RedBlackTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(13);
        tree.add(20);

        // До смены цветов:
        System.out.println("До смены цветов:");
        printTree(tree);

        tree.flipColors(tree.root);

        // После смены цветов:
        System.out.println("После смены цветов:");
        printTree(tree);
    }

    private static void printTree(RedBlackTree tree) {
        printTree(tree.root);
    }

    private static void printTree(RedBlackTree.Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.key + "(" + (node.isRed ? "R" : "B") + ")");
            printTree(node.right);
        }

    }
}
