class Main {
    public static void main(String[] args) {
        // Preorder array representation of the binary tree
        // -1 represents a null node
        int[] pre = new int[]{1, 2, -1, -1, 3, -1, -1};

        // Build tree from preorder array
        Node root = buildTree(pre);

        // Print the tree nodes (currently in Preorder due to print order)
        InOrderTree(root);  // Note: This is actually Preorder due to current order of prints
    }

    static int index = -1; // Keeps track of the current index in the array during recursion

    // Builds the binary tree from preorder traversal (with -1 as null indicator)
    public static Node buildTree(int[] pre) {
        index++;  // Move to the next element

        // If current element is -1, it's a null node
        if (pre[index] == -1) {
            return null;
        }

        // Create a new node with current value
        Node root = new Node(pre[index]);

        // Recursively build the left and right subtrees
        root.left = buildTree(pre);
        root.right = buildTree(pre);

        return root;
    }

    // Prints the tree nodes - but this is actually Preorder traversal due to the order
    public static void InOrderTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);    // Visit root (Preorder print)
        InOrderTree(root.left);          // Traverse left subtree
        InOrderTree(root.right);         // Traverse right subtree
    }
}

// Class representing a binary tree node
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize node with value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
