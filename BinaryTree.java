public class BinaryTree {
    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);

            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);

            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNode(50, "CEO");
        tree.addNode(20, "CTO");
        tree.addNode(15, "Project Manager");
        tree.addNode(30, "Fullstack Lead");
        tree.addNode(75, "Frontend dev");
        tree.addNode(40, "Backend dev");

        tree.postOrderTraverseTree(tree.root);
    }

}

class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }
}