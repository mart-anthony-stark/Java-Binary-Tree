package PrintBinary;

public class Tree {
    public Node root;

    public Tree(Object[] array) {
        root = initDfs(array, 0);
    }

    public Node initDfs(Object[] array, int index) {
        /*
         * 0 1 2 3 4 5 6 n -> 2*n+1, 2*n+2
         */

        if (index >= array.length || array[index] == null) {
            return null;
        }

        Node newNode = new Node(array[index]);

        newNode.left = initDfs(array, index * 2 + 1);
        newNode.right = initDfs(array, index * 2 + 2);

        return newNode;
    }

    public String toString() {
        // inOrder(root);
        inOrderIndent(root, 0);
        return "";
    }

    private void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    private void inOrderIndent(Node root, int depth) {
        // rotate the tree. The deeper nodes have longer indentation
        if (root == null)
            return;

        inOrderIndent(root.left, depth + 1);
        System.out.println(new String(new char[depth]).replace("\0", "  ") + root.value);

        inOrderIndent(root.right, depth + 1);
    }
}
