package DSA.HW2;

import java.util.Scanner;

public class Tree {
	TreeNode root;
	int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// public TreeNode insert(TreeNode root, int data) {
	// if (root == null) {
	// root = new TreeNode(data);
	// } else {
	// if (data <= root.getData()) {
	// root.left = insert(root.getLeft(), data);
	// } else {
	// root.right = insert(root.getRight(), data);
	// }
	// }
	// return root;
	// }

	public void insert(int data) {

		TreeNode node = new TreeNode(data);
		node.setLeft(null);
		node.setRight(null);
		if (root == null) {
			root = node;
		} else {
			TreeNode rootPtr = root;// current node pointer
			TreeNode temp;// temp Node to point prev

			while (true) {

				temp = rootPtr;
				if (data <= rootPtr.getData()) {
					// System.out.println("in <=");
					rootPtr = rootPtr.getLeft();
					if (rootPtr == null) {
						temp.setLeft(node);
						break;
					}
				} else {
					// System.out.println("in >");
					rootPtr = rootPtr.getRight();
					if (rootPtr == null) {
						temp.setRight(node);
						break;
					}
				}
			}
		}
	}

	// public void delete(TreeNode root, int element) {
	// if (root == null) {
	// System.out.println("Tree is Empty.");
	// } else {
	//
	// }
	// }

	public boolean search(TreeNode root, int element) {
		boolean found = false;
		while (root != null && found == false) {
			if (element == root.getData()) {
				found = true;
				break;
			} else if (element < root.getData()) {
				root = root.getLeft();
			} else {// element > root.getData()
				root = root.getRight();
			}
		}
		return found;
	}

	public int height(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int leftSubHeight = height(node.getLeft());
			int rightSubHeight = height(node.getRight());

			if (leftSubHeight > rightSubHeight)
				return leftSubHeight + 1;// left subtree height + root
			else
				return rightSubHeight + 1;// right subtree height + root
		}
	}

	public boolean isEmpty() {// checks Tree is Empty or not
		return root == null;
	}

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);

		Tree tree = new Tree();
		int i;
		System.out.println("Enter no.of elements:");
		int n = sc.nextInt();
		for (i = 0; i < n; i++) {
			System.out.println("Enter element:");
			int element = sc.nextInt();
			tree.insert(element);
		}

		TreeTraversals traverse = new TreeTraversals();
		System.out.println();
		System.out.println("InOrder:");
		traverse.inOrder(tree.root);

		System.out.println();
		System.out.println("PreOrder:");
		traverse.preOrder(tree.root);

		System.out.println();
		System.out.println("PostOrder:");
		traverse.postOrder(tree.root);

	}
}
