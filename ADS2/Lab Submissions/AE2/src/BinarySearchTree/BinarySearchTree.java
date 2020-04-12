package BinarySearchTree;

public class BinarySearchTree {
	Node root;

	// constructor
	public BinarySearchTree() {
		this.root = null;
	}

	// adds node to tree from root
	public void add(int value) {
		this.root = addRecursive(root, value);
	}

	// helper function to add to the tree
	private Node addRecursive(Node current, int key) {
		// if node
		if (current == null) {
			return new Node(key);
		} else if (key < current.key) {
			current.left = addRecursive(current.left, key);
		} else if (key > current.key) {
			current.right = addRecursive(current.right, key);
		} else {
			// value already exists
			return current;
		}
		return current;
	}

	// This method mainly calls deleteRec()
	public void deleteKey(int key) {
		this.root = deleteRec(this.root, key);
	}

	/* A recursive function to insert a new key in BST */
	private Node deleteRec(Node node, int key) {
		/* Base Case: If the tree is empty */
		if (node == null)
			return node;

		/* Otherwise, recur down the tree */
		if (key < node.key)
			node.left = deleteRec(node.left, key);
		else if (key > node.key)
			node.right = deleteRec(node.right, key);

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;

			// node with two children: Get the inorder successor (smallest
			// in the right subtree)
			node.key = minValue(node.right);

			// Delete the inorder successor
			node.right = deleteRec(node.right, node.key);
		}

		return node;
	}

	int minValue(Node node) {
		int minv = node.key;
		while (node.left != null) {
			minv = node.left.key;
			node = node.left;
		}
		return minv;
	}

	// checks if given value exists in tree.
	public boolean hasElement(int value) {
		return hasElementRecursive(this.root, value);
	}

	// helper function to hasElement to traverse tree
	private boolean hasElementRecursive(Node node, int value) {
		// checks if tree is empty
		if (node == null)
			return false;
		// checks if node has same value as the value that we're looking for
		if (node.key == value)
			return true;

		if (hasElementRecursive(node.left, value))
			return true;

		return hasElementRecursive(node.right, value);
	}

	// checks if tree is empty.
	public boolean isEmpty() {
		int t = getSize();
		if (t == 0)
			return true;
		return false;
	}

	public int getSize() {
		// adds root node
		if (root == null)
			return 0;
		else
			return getSizeRecursive(root) + 1;
	}

	// returns size of tree w/o counting root node.
	private int getSizeRecursive(Node root) {
		if (root == null)
			return 0;
		int res = 0;
		if (root.left != null)
			res++;
		if (root.right != null)
			res++;

		res += (getSizeRecursive(root.left) + getSizeRecursive(root.right));
		return res;
	}

	// wrapper method for recursive union of two trees
	public BinarySearchTree unionOfTrees(BinarySearchTree t1, BinarySearchTree t2) {
		BinarySearchTree t3 = t1;
		unionOfTreesRecursive(t3, t2.root);
		return t3;

	}

	// recursive union of two trees
	private void unionOfTreesRecursive(BinarySearchTree t3, Node node) {
		if (node == null)
			return;
		// first recur on left subtree
		unionOfTreesRecursive(t3, node.left);
		// then recur on right subtree
		unionOfTreesRecursive(t3, node.right);
		// now deal with the node
		t3.add(node.key);
	}

	public BinarySearchTree intersectionOfTrees(BinarySearchTree t1, BinarySearchTree t2) {
		BinarySearchTree t3 = new BinarySearchTree();
		intersectionOfTreesRecursive(t1, t2.root, t3);
		intersectionOfTreesRecursive(t2, t1.root, t3);
		return t3;

	}

	// recursive intersection of two trees
	private void intersectionOfTreesRecursive(BinarySearchTree t1, Node node2, BinarySearchTree t3) {
		if (node2 == null)
			return;

		// first recur on left subtree
		intersectionOfTreesRecursive(t1, node2.left, t3);
		intersectionOfTreesRecursive(t1, node2.right, t3);

		// now deal with the node
		if (t1.hasElement(node2.key))
			t3.add(node2.key);
	}

	public BinarySearchTree differenceOfTrees(BinarySearchTree t1, BinarySearchTree t2) {
		BinarySearchTree t3 = new BinarySearchTree();
		// Computes A - B and adds that to t3
		differenceOfTreesRecursive(t1, t2.root, t3);
		// Computes B - A and adds that to t3
		differenceOfTreesRecursive(t2, t1.root, t3);
		return t3;

	}

	// recursive intersection of two trees
	// computes A - B
	private void differenceOfTreesRecursive(BinarySearchTree t1, Node node2, BinarySearchTree t3) {
		if (node2 == null)
			return;
//        System.out.println(node2.key);
		// traversing tree recursively
		differenceOfTreesRecursive(t1, node2.left, t3);
		differenceOfTreesRecursive(t1, node2.right, t3);

		// now deal with the node
		if (!t1.hasElement(node2.key))
			t3.add(node2.key);
	}

	public boolean isSubset(BinarySearchTree t2) {
		return isSubsetRecursive(this.root, t2, true);
	}

	private boolean isSubsetRecursive(Node node1, BinarySearchTree t2, boolean breakOutOfRecursion) {
		if (node1 == null)
			return true;
		// if an element from the possibly subset tree isn't in the larger set tree, break the recursion
		if (!t2.hasElement(node1.key))
			return false;
		// if an element was found that wasn't in the larger set tree, break the recursion
		if (!isSubsetRecursive(node1.left, t2, true))
			return false;
		// if an element was found that wasn't in the larger set tree, break the recursion
		if (!isSubsetRecursive(node1.right, t2, true))
			return false;
	
		
		if (!breakOutOfRecursion)
			return false;
		else
			return true;
	}

	public void printInorder() {
		printInorderRecursive(root);
	}

	// A utility function to do inorder traversal of BST
	void printInorderRecursive(Node root) {
		if (root != null) {
			printInorderRecursive(root.left);
			System.out.print(root.key + " ");
			printInorderRecursive(root.right);
		}
	}
	public int maxDepth() {
		return maxDepthRecursive(this.root)-1;
	}
	private int maxDepthRecursive(Node root) {
		if(root == null) {
			return 0;
		}
		int LSum = maxDepthRecursive(root.left);
		int RSum = maxDepthRecursive(root.right);
		
		if(LSum > RSum) 
			return (LSum + 1);
		else
			return (RSum + 1);
	}

}
