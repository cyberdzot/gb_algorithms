package Homework04;

public class RedBlackTree {
    Node root;

    public class Node {
        int key;
        Node left;
        Node right;
        boolean isRed;

        Node(int key, boolean isRed) {
            this.key = key;
            this.isRed = isRed;
        }
    }

    public void add(int key) {
        root = addNode(root, key);
        root.isRed = false; // Корень всегда черный
    }

    private Node addNode(Node node, int key) {
        if (node == null) {
            return new Node(key, true); // Новая нода всегда красная
        }

        if (key < node.key) {
            node.left = addNode(node.left, key);
        } else if (key > node.key) {
            node.right = addNode(node.right, key);
        } else {
            // Если ключ уже существует, ничего не делаем
            return node;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    public Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    public Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    public void flipColors(Node node) {
        node.isRed = !node.isRed;
        node.left.isRed = !node.left.isRed;
        node.right.isRed = !node.right.isRed;
    }
}
