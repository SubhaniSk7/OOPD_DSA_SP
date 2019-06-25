package DSA.HW2;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalsChar {

	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.getDataElement() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getDataElement() + " ");
			inOrder(root.getRight());
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getDataElement() + " ");
		}
	}

	// public void levelOrder(TreeNode root) {
	// Queue<TreeNode> visit = new LinkedList<>();
	//
	// if (root == null) {
	// return;
	// }
	//
	// visit.add(root);
	// while (!visit.isEmpty()) {
	// TreeNode temp = visit.remove();
	// if (temp.getLeft() != null) {
	// visit.add(temp.getLeft());
	// }
	// if (temp.getRight() != null) {
	// visit.add(temp.getRight());
	// }
	// System.out.print(temp.getDataElement() + " ");
	// }
	// }

	public void levelOrder(TreeNode root) {

		if (root == null) {
			return;
		}
		Queue<TreeNode> visit = new LinkedList<>();

		visit.add(root);

		while (true) {
			int nodeCount = visit.size();

			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {

				TreeNode temp = visit.peek();
				System.out.print(temp.getDataElement() + " ");
				visit.remove();

				if (temp.getLeft() != null) {
					visit.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					visit.add(temp.getRight());
				}
				nodeCount--;
			}
			System.out.println();
		}
	}
}
