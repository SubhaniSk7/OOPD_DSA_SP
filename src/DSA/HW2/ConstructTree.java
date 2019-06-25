package DSA.HW2;

import java.util.Scanner;

public class ConstructTree {

	static int preOrderIndex = 0;
	static int postOrderIndex = 0;

	public static void main(String subhani[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("\n1.Inorder and PreOrder\n2.Inorder and PostOrder.\nselect choice:");
		int choice = sc.nextInt();
		int n, i;
		String[] inOrderElements, preOrderElements, postOrderElements;

		switch (choice) {
		case 1:
			System.out.println("no.of nodes:");
			n = sc.nextInt();
			System.out.println("Enter InOrder elements:");
			inOrderElements = new String[n];
			for (i = 0; i < n; i++) {
				inOrderElements[i] = sc.next();
			}

			System.out.println("Enter PreOrder elements:");
			preOrderElements = new String[n];
			for (i = 0; i < n; i++) {
				preOrderElements[i] = sc.next();
			}

			ConstructTree constructTree = new ConstructTree();
			TreeNode root = constructTree.constructFromInorderPreorder(inOrderElements, preOrderElements, 0, n - 1);
			TreeTraversalsChar traverse = new TreeTraversalsChar();
			// traverse.inOrder(root);
			System.out.println();
			System.out.println("postOrder:");
			traverse.postOrder(root);
			System.out.println();
			System.out.println("Level order:");
			traverse.levelOrder(root);
			break;

		case 2:
			System.out.println("no.of nodes:");
			n = sc.nextInt();
			System.out.println("Enter InOrder elements:");
			inOrderElements = new String[n];
			for (i = 0; i < n; i++)
				inOrderElements[i] = sc.next();

			System.out.println("Enter PostOrder elements:");
			postOrderElements = new String[n];
			for (i = 0; i < n; i++)
				postOrderElements[i] = sc.next();

			ConstructTree constructTree2 = new ConstructTree();
			postOrderIndex = n - 1;
			TreeNode root2 = constructTree2.constructFromInorderPostorder(inOrderElements, postOrderElements, 0, n - 1);
			TreeTraversalsChar traverse2 = new TreeTraversalsChar();
			System.out.println("preOrder:");
			traverse2.preOrder(root2);
			System.out.println();
			System.out.println("Level Order:");
			traverse2.levelOrder(root2);
			break;

		default:
			System.out.println("Choose correct choice.");
		}
	}

	public TreeNode constructFromInorderPreorder(String[] inOrderElements, String[] preOrderElements, int start,
			int end) {

		if (start > end) {
			return null;
		}

		TreeNode newNode = new TreeNode(preOrderElements[preOrderIndex]);
		// System.out.println("-->" + preOrderElements[preOrderIndex]);
		preOrderIndex++;

		if (start == end)
			return newNode;

		int inOrderIndex = searchElement(inOrderElements, newNode.getDataElement(), start, end);

		// System.out.println("index:" + inOrderIndex);

		newNode.left = constructFromInorderPreorder(inOrderElements, preOrderElements, start, inOrderIndex - 1);
		// System.out.println("left:" + newNode.left.getDataElement());

		newNode.right = constructFromInorderPreorder(inOrderElements, preOrderElements, inOrderIndex + 1, end);
		// System.out.println("right:" + newNode.right.getDataElement());

		return newNode;
	}

	public TreeNode constructFromInorderPostorder(String[] inOrderElements, String[] postOrderElements, int start,
			int end) {

		if (start > end) {
			return null;
		}

		TreeNode newNode = new TreeNode(postOrderElements[postOrderIndex]);
		// System.out.println("-->" + preOrderElements[preOrderIndex]);
		postOrderIndex--;

		if (start == end)
			return newNode;

		int inOrderIndex = searchElement(inOrderElements, newNode.getDataElement(), start, end);

		// System.out.println("index:" + inOrderIndex);

		newNode.right = constructFromInorderPostorder(inOrderElements, postOrderElements, inOrderIndex + 1, end);
		// System.out.println("right:" + newNode.right.getDataElement());

		newNode.left = constructFromInorderPostorder(inOrderElements, postOrderElements, start, inOrderIndex - 1);
		// System.out.println("left:" + newNode.left.getDataElement());

		return newNode;
	}

	public int searchElement(String array[], String element, int start, int end) {
		int i;
		for (i = start; i <= end; i++) {
			if (array[i].equals(element))
				return i;
		}
		return i;
	}
}
