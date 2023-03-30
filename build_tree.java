import java.util.*;

public class build_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public Node buildTree(int nodes[]) {
            index++; // creating first element => index = 0
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            // recursive function => = jodne ka kaam karega
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // traversing the tree
        // 1. PREORDER
        public void preorder(Node root) {
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // 2. INORDER
        public void inorder(Node root) {
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // 3. POSTORDER
        public void postorder(Node root) {
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // 4. LEVEL ORDER
        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int height = Math.max(lh, rh) + 1;
            return height;
        }
        
        // count of nodes
        public int countNodes(Node root){
            if (root == null){
                return 0;
            }
            int lcount = countNodes(root.left); 
            int rcount = countNodes(root.right); 
            int treeCount = lcount + rcount + 1;
            return treeCount; 
        }

        // sum of nodes
        public int sum(Node root){
            if (root == null){
                return 0;
            }
            int lsum = sum(root.left);
            int rsum = sum(root.right);
            int sum = lsum + rsum + root.data;
            return sum;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.levelOrder(root);
        System.out.println(height(root));
    }

}
