import java.util.Stack;

class NodeLL {
	int item;
	NodeLL next;
}

class NodeIter {
	BST n;
	boolean flag;

	NodeIter(BST n, boolean flag) {
		this.n = n;
		this.flag = flag;
	}
}

public class MergeTwoBSTToSortedLL {
	public NodeLL createNode(int item) {
		NodeLL newnode = new NodeLL();
		newnode.item = item;
		newnode.next = null;
		return newnode;
	}

	public NodeLL mergeBSTs(BST root1, BST root2) {
		Iterator it1 = new Iterator(root1);
		Iterator it2 = new Iterator(root2);
		NodeLL newnode = null;
		NodeLL start = null;
		NodeLL currNode = null;

		int currItem = 0;
		int item1 = it1.next().item;
		int item2 = it2.next().item;

		while (true) {
			if (item1 <= item2) {
				currItem = item1;

				newnode = createNode(currItem);
				// this is the first node.
				if (start == null) {
					start = newnode;
					currNode = newnode;
				} else {
					currNode.next = newnode;
					currNode = newnode;
				}

				if (it1.hasNext()) {
					item1 = it1.next().item;
				}

				else {
					it1 = null;
					break;

				}
			}

			else {
				currItem = item2;
				newnode = createNode(currItem);

				// this is the first node.
				if (start == null) {
					start = newnode;
					currNode = newnode;
				} else {
					currNode.next = newnode;
					currNode = newnode;
				}

				if (it2.hasNext()) {
					item2 = it2.next().item;
				} else {
					it2 = null;
					break;
				}
			}

		}
		if (it1 != null) {
			newnode = createNode(item1);
			if (start == null) {
				start = newnode;
				currNode = newnode;
			} else {
				currNode.next = newnode;
				currNode = newnode;
			}

			while (it1.hasNext()) {
				currItem = it1.next().item;
				newnode = createNode(currItem);
				currNode.next = newnode;
				currNode = newnode;
			}
		}

		if (it2 != null) {
			newnode = createNode(item2);
			if (start == null) {
				start = newnode;
				currNode = newnode;
			} else {
				newnode = createNode(currItem);
				currNode.next = newnode;
				currNode = newnode;
			}

			while (it2.hasNext()) {
				currItem = it2.next().item;
				newnode = createNode(currItem);
				currNode.next = newnode;
				currNode = newnode;
			}	
		}

		return start;

	}

	public static void main(String[] args) {
		BSTOperations bst = new BSTOperations();
		BST root1 = new BST();
		root1 = null;

		BST root2 = new BST();
		root2 = null;

		root1 = bst.insert(root1, 10);
		root1 = bst.insert(root1, 8);
		root1 = bst.insert(root1, 15);
		root1 = bst.insert(root1, 6);
		root1 = bst.insert(root1,9);
		root1 = bst.insert(root1, 90);
		root1 = bst.insert(root1, 14);
		root1 = bst.insert(root1, 25);
		root2 = bst.insert(root2, 9);
		root2 = bst.insert(root2, 5);
		root2 = bst.insert(root2, 3);
		root2 = bst.insert(root2, 14);
		root2 = bst.insert(root2,40);
		root2 = bst.insert(root2, 42);
		root2 = bst.insert(root2, 41);
		root2 = bst.insert(root2, 39);
		root2 = bst.insert(root2, 24);
		root2 = bst.insert(root2, 26);
		root2 = bst.insert(root2, 2);
		root2 = bst.insert(root2, 4);

		// expected output:
		// 2 3 4 5 6 8 9 9 10 14 14 15 24 25 26 39 40 41 42 90

		MergeTwoBSTToSortedLL m = new MergeTwoBSTToSortedLL();
		NodeLL start = m.mergeBSTs(root1, root2);

		while (start != null) {
			System.out.print(start.item + " ");
			start = start.next;
		}

	}

}

class Iterator {
	NodeIter currNode;
	Stack<NodeIter> s = new Stack<NodeIter>();

	Iterator(BST n) {
		currNode = null;
		if (n != null) {
			NodeIter nn = new NodeIter(n, false);
			s.push(nn);
		}
	}

	public boolean hasNext() {
		if (s.isEmpty())
			return false;
		else
			return true;
	}

	public BST next() {
		if (hasNext()) {
			currNode = s.pop();
			while (!(currNode.flag)) {
				if (currNode.n.right != null) {
					NodeIter nn = new NodeIter(currNode.n.right, false);
					s.push(nn);
				}

				NodeIter nn = new NodeIter(currNode.n, true);
				s.push(nn);

				if (currNode.n.left != null) {
					NodeIter nn1 = new NodeIter(currNode.n.left, false);
					s.push(nn1);
				}

				currNode = s.pop();
			}

			// now the curr popped node can be sent back, since it is being
			// traversed.
			return currNode.n;
		}
		return null;
	}
}
