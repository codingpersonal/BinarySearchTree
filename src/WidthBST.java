import java.util.LinkedList;
import java.util.Queue;

public class WidthBST {
	public int findWidth(BST root) {
		int width = 0;
		Queue<BST> tree = new LinkedList<>();

		tree.add(root);

		while (!tree.isEmpty()) {
			int count = tree.size();
			width = Math.max(width, count);

			while (count != 0) {
				BST currNode = tree.remove();
				if (currNode.left != null) {
					tree.add(currNode.left);
				}
				if (currNode.right != null) {
					tree.add(currNode.right);
				}
				count--;
			}
		}

		return width;
	}

	public static void main(String[] args) {
		BSTOperations bst = new BSTOperations();
		BST root = new BST();
		root = null;

		root = bst.insert(root, 10);
		root = bst.insert(root, 8);
		root = bst.insert(root, 15);
		root = bst.insert(root, 6);
		root = bst.insert(root, 9);
		root = bst.insert(root, 90);
//		root = bst.insert(root, 14);
//		root = bst.insert(root, 25);
//		root = bst.insert(root, 9);
//		root = bst.insert(root, 5);
//		root = bst.insert(root, 3);
//		root = bst.insert(root, 14);
//		root = bst.insert(root, 40);
//		root = bst.insert(root, 42);
//		root = bst.insert(root, 41);
//		root = bst.insert(root, 39);
//		root = bst.insert(root, 24);
//		root = bst.insert(root, 26);
//		root = bst.insert(root, 2);
//		root = bst.insert(root, 4);

		WidthBST w = new WidthBST();
		//System.out.println("Width of the tree is:" + w.findWidth(root));
		w.printTreeLevelWise(root);
	}

	//Print the nodes of the tree level wise left to right.
	//Also find the width of the tree.
	public void printTreeLevelWise(BST root) {
		Queue<BST> queue = new LinkedList<>();
		int maxCount = 1;
		int count = 0;
		
		if (root != null) {
			queue.add(root);
			queue.add(null);
		}

		while (!queue.isEmpty()) {
			BST currElem = queue.remove();

			if (currElem == null) {
				if (queue.size() == 0) {
					break;
				} else {
					queue.add(null);
					System.out.println("\n");
					if(maxCount < count) {
						maxCount = count;
					}
					count = 0;
				}
			} else {
				System.out.print(currElem.item + " ");
				if (currElem.left != null) {
					queue.add(currElem.left);
					count ++;
				}
				if (currElem.right != null) {
					queue.add(currElem.right);
					count ++;
				}
			}
		}
		System.out.println("\n\nWidth is:"+maxCount);

	}

}
