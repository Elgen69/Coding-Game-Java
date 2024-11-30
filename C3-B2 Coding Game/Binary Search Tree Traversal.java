import java.util.*;

class Solution {

    // Node class representing each element in the tree
    static class Node {
        int value;
        Node left, right;
        
        // Constructor to initialize the node
        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Method to insert a value into the Binary Search Tree
    static Node insert(Node root, int value) {
        // Base case: if the tree is empty, create a new node
        if (root == null) {
            return new Node(value);
        }
        
        // Recursive case: compare the value and insert in the correct subtree
        if (value < root.value) {
            root.left = insert(root.left, value); // Insert into left subtree
        } else {
            root.right = insert(root.right, value); // Insert into right subtree
        }
        
        return root;
    }

    // Pre-Order Traversal: Root, Left, Right
    static void preOrder(Node root) {
        List<String> result = new ArrayList<>();
        preOrderHelper(root, result);
        System.out.println(String.join(" ", result));
    }

    // Helper method for Pre-Order
    static void preOrderHelper(Node root, List<String> result) {
        if (root == null) {
            return;
        }
        result.add(String.valueOf(root.value));  // Add current value to result
        preOrderHelper(root.left, result);  // Visit left subtree
        preOrderHelper(root.right, result); // Visit right subtree
    }

    // In-Order Traversal: Left, Root, Right
    static void inOrder(Node root) {
        List<String> result = new ArrayList<>();
        inOrderHelper(root, result);
        System.out.println(String.join(" ", result));
    }

    // Helper method for In-Order
    static void inOrderHelper(Node root, List<String> result) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, result);  // Visit left subtree
        result.add(String.valueOf(root.value)); // Add current value to result
        inOrderHelper(root.right, result); // Visit right subtree
    }

    // Post-Order Traversal: Left, Right, Root
    static void postOrder(Node root) {
        List<String> result = new ArrayList<>();
        postOrderHelper(root, result);
        System.out.println(String.join(" ", result));
    }

    // Helper method for Post-Order
    static void postOrderHelper(Node root, List<String> result) {
        if (root == null) {
            return;
        }
        postOrderHelper(root.left, result); // Visit left subtree
        postOrderHelper(root.right, result); // Visit right subtree
        result.add(String.valueOf(root.value)); // Add current value to result
    }

    // Level-Order Traversal: Top to bottom, left to right
    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Get node at the front of the queue
            result.add(String.valueOf(current.value));
            
            if (current.left != null) {
                queue.offer(current.left);  // Add left child to queue
            }
            
            if (current.right != null) {
                queue.offer(current.right);  // Add right child to queue
            }
        }

        // Join results with spaces and print
        System.out.println(String.join(" ", result));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading the number of elements to insert into the tree
        int N = sc.nextInt();
        
        // Reading the elements to be inserted into the tree
        int[] elements = new int[N];
        for (int i = 0; i < N; i++) {
            elements[i] = sc.nextInt();
        }
        
        // Construct the tree by inserting nodes one by one
        Node root = null;
        for (int value : elements) {
            root = insert(root, value);
        }
        
        // Output all the required traversals with custom methods
        preOrder(root);  // Pre-Order Traversal
        inOrder(root);   // In-Order Traversal
        postOrder(root); // Post-Order Traversal
        levelOrder(root); // Level-Order Traversal
        
        sc.close();
    }
}
