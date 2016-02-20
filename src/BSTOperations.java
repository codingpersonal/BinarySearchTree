import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTOperations {
	public BST insert(BST root, int item) {
		if (root == null) {
			BST newnode = new BST();
			newnode.item = item;
			newnode.left = null;
			newnode.right = null;
			root = newnode;
			return root;
		}

		else if (item <= root.item) {
			root.left = insert(root.left, item);
			return root;
		}

		else {
			root.right = insert(root.right, item);
			return root;
		}

	}

	public void preOrder(BST root) {
		if (root != null) {
			System.out.print(root.item + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(BST root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.item + " ");
		}
	}

	public void inOrder(BST root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.item + " ");
			inOrder(root.right);
		}
	}

	public boolean search_recursion(BST root, int item) {
		if (root == null)
			return false;

		if (root.item == item)
			return true;

		if (root.item > item)
			return search_recursion(root.left, item);
		else
			return search_recursion(root.right, item);
	}

	public void search(BST root, int item) {
		if (root == null) {
			System.out.println("Tree is empty. No item found.");
			return;
		}

		boolean flag = false;
		while (!flag) {
			if (root == null) {
				System.out.println("Item not found.");
				return;
			}

			if (root.item == item) {
				System.out.println("Item found in BST");
				flag = true;
			} else if (item <= root.item) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
	}

	public int lengthBST(BST root) {
		if (root == null) {
			return 0;
		}
		return max(lengthBST(root.left), lengthBST(root.right)) + 1;
	}

	public int getDiameter(BST root) {
		return lengthBST(root.left) + lengthBST(root.right) + 1;
	}

	private int max(int length1, int length2) {
		if (length1 >= length2)
			return length1;
		else
			return length2;
	}

	public void bfs(BST root) {
		Queue<BST> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			BST node = q.remove();
			if (node != null) {
				System.out.println(node.item);
			}

			if (node.left != null)
				q.add(node.left);

			if (node.right != null)
				q.add(node.right);
		}
	}

	public void findMax(BST root) {
		int max = root.item;

		while (root.right != null) {
			max = root.right.item;
			root = root.right;
		}

		System.out.println("Maximum element in the BST is:" + max);
	}

	public void findMin(BST root) {
		int min = root.item;

		while (root.left != null) {
			min = root.left.item;
			root = root.left;
		}

		System.out.println("Maximum element in the BST is:" + min);
	}

	public void findWidth(BST root) {
		int count = 0;
		int loopCount = 0;
		int max = 0;

		Queue<BST> q = new LinkedList<>();

		q.add(root);
		count++;
		loopCount = count;
		max = count;
		count = 0;

		while (!q.isEmpty()) {
			if (loopCount == 0) {
				loopCount = count;
				if (count > max)
					max = count;

				count = 0;
			}
			BST node = q.remove();
			if (node.left != null) {
				count++;
				q.add(node.left);
			}

			if (node.right != null) {
				q.add(node.right);
				count++;
			}
			loopCount--;
		}

		System.out.println("The width of the tree is:" + max);
	}

	public void printPaths(BST root, Stack<BST> list) {
		if (root != null) {
			list.push(root);
		} else
			return;
		if (root.left == null && root.right == null) {
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				BST element = (BST) iterator.next();
				System.out.print(element.item + " ");
			}
			System.out.println("\n");
			list.pop();
		} else {
			printPaths(root.left, list);
			printPaths(root.right, list);
			list.pop();
		}
	}

	Stack<BST> s = new Stack<>();

	public void printPaths(BST root) {
		if (root != null) {
			s.push(root);
		}

		if (root.left != null)
			printPaths(root.left);
		if (root.right != null)
			printPaths(root.right);

		if (root.left == null && root.right == null) {
			Iterator<BST> iterator = s.iterator();
			while (iterator.hasNext()) {
				BST element = (BST) iterator.next();
				System.out.print(element.item + " ");
			}
			System.out.println("\n");
		}
		s.pop();
	}

	public void printLevelWise(BST root) {
		int loopCount = 1;
		int count = 0;

		Queue<BST> q = new LinkedList<>();

		q.add(root);
		System.out.println(root.item + "\n");

		while (!q.isEmpty()) {
			if (loopCount == 0) {
				System.out.println("\n\n");
				loopCount = count;
				count = 0;
			}
			BST node = q.remove();
			if (node.left != null) {
				count++;
				q.add(node.left);
				System.out.print(node.left.item + "-");
			}

			if (node.right != null) {
				q.add(node.right);
				count++;
				System.out.print(node.right.item + "-");
			}
			loopCount--;
		}

	}

	public void printLevelWiseAlt(BST root) {
		int loopCount = 1;
		int count = 0;
		boolean flag = true;

		Deque<BST> q = new LinkedList<>();

		q.add(root);
		System.out.println(root.item + "\n");

		while (!q.isEmpty()) {
			if (loopCount == 0) {
				loopCount = count;
				count = 0;
				flag = !flag;
				System.out.println("\n\n");

			}
			BST node;
			if (flag) {
				node = q.removeFirst();
				if (node.left != null) {
					count++;
					q.addLast(node.left);
					System.out.print(node.left.item + " ");

				}

				if (node.right != null) {
					count++;
					q.addLast(node.right);
					System.out.print(node.right.item + " ");

				}

			} else {
				node = q.removeLast();
				if (node.right != null) {
					count++;
					q.addFirst(node.right);
					System.out.print(node.right.item + " ");
				}
				if (node.left != null) {
					count++;
					q.addFirst(node.left);
					System.out.print(node.left.item + " ");

				}
			}

			loopCount--;
		}
	}

	public void treeMirror(BST node) {
		if (node.left == null && node.right == null) {
			return;
		}

		if (node.left != null) {
			treeMirror(node.left);
		}

		if (node.right != null) {
			treeMirror(node.right);
		}

		if (node.left != null && node.right != null) {
			BST temp = node.left;
			node.left = node.right;
			node.right = temp;
		} else if (node.left != null) {
			node.right = node.left;
			node.left = null;
		} else {
			node.left = node.right;
			node.right = null;
		}
	}

	// MOCK INTERVIEW QUESTION

	/// returns true if its a BST and every element is in the range from
	/// minRange and maxRange
	public boolean isBSTAndInRange(BST root, int minRange, int maxRange) {

		if (root == null)
			return true;

		return (root.item < maxRange && root.item >= minRange) && isBSTAndInRange(root.left, minRange, root.item)
				&& isBSTAndInRange(root.right, root.item, maxRange);
	}

	// this return if the tree from root is a BST or not
	public boolean isBST(BST root) {
		return isBSTAndInRange(root, -999999, 9999999);
	}

	// MOCK INTERVIEW QUESTION
	public void preOrder_nonrec(BST node) {

		Stack<BST> s = new Stack<>();
		if (node != null) {
			s.push(node);
		}

		while (!s.isEmpty()) {
			BST n = s.pop();
			System.out.print(n.item + " ");
			if (n.right != null) {
				s.push(n.right);
			}
			if (n.left != null) {
				s.push(n.left);
			}
		}
	}

	class NodeInfo {
		BST bst;
		int flag;
	}

	// MOCK INTERVIEW QUESTION
	public void inorder_nonrec(BST node) {
		Stack<NodeInfo> s = new Stack<>();
		NodeInfo ni = new NodeInfo();

		if (node != null) {
			ni.bst = node;
			ni.flag = 2;
			s.push(ni);
		}

		while (!s.isEmpty()) {
			NodeInfo currNi = s.pop();
			BST currNode = currNi.bst;
			int flag = currNi.flag;

			// It means its left child has been processed. So print it.
			if (flag == 1) {
				System.out.print(currNode.item + " ");
			} else if (flag == 2) {

				if (currNode.right != null) {
					currNi = new NodeInfo();
					currNi.bst = currNode.right;
					currNi.flag = 2;
					s.push(currNi);
				}

				currNi = new NodeInfo();
				currNi.bst = currNode;
				currNi.flag = 1;
				s.push(currNi);

				if (currNode.left != null) {
					currNi = new NodeInfo();
					currNi.bst = currNode.left;
					currNi.flag = 2;
					s.push(currNi);
				}
			}
		}

	}

}
