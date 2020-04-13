import java.util.NoSuchElementException;

public class BST {
    private Node root; // root of BST
    private class Node{
        private int key; // sorted by key
        private Node left, right, p;
        private int size; // number of nodes
    
        public Node(int key, int size){
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
        }
    }
    public BST(){
        root = null;
    }
    public void printInOrder(Node node){
        if(node == null){
            return;
        }
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    public void printPreOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.key + " ");
        printInOrder(node.left);
        printInOrder(node.right);
    }
    public void printPostOrder(Node node){
        if(node == null)
            return;
        printInOrder(node.left);
        printInOrder(node.right);
        System.out.print(node.key + " ");
    }
    void printPostOrder()  {     printPostOrder(root);  } 
    void printInOrder()    {     printInOrder(root);   } 
    void printPreOrder()   {     printPreOrder(root);  }
    void checkBST()   {     printPreOrder(root);  }

    public boolean checkBST(Node node){
        if(node == null)
            return true;
        checkBST(node.left);
        checkBST(node.right);
        if(node.key > node.left.key && node.key < node.left.key)
            return false;
        return false;
        
    }
    // Driver method 
    public static void main(String[] args) 
    { 
        BST tree = new BST();
        tree.root = new Node(1, 2); 
        tree.root.left = new Node(2, 2); 
        tree.root.right = new Node(3, 0); 
        tree.root.left.left = new Node(4, 0); 
        tree.root.left.right = new Node(5, 0); 
  
        System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreOrder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInOrder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostOrder(); 

        System.out.println("\nPostorder traversal of binary tree is "); 
        system.out.println(tree.checkBST()); 
    } 
    
}