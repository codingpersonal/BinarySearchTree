import java.util.Stack;

public class LeafIterator {
	Stack<BST> leafQ = new Stack<>();
	BST node;
	BST leafNode;

	public LeafIterator(BST node) {
		this.node = node;
		leafNode = null;
		leafQ.push(node);
	}

	public boolean hasNext() {
		return !leafQ.isEmpty();
	}

	public BST next() {
		leafNode = null;
		while (hasNext()) {
			BST currNode = leafQ.pop();
			if (currNode.left == null && currNode.right == null) {
				return currNode;
			}
			if (currNode.right != null) {
				leafQ.push(currNode.right);
			}
			if (currNode.left != null) {
				leafQ.push(currNode.left);
			}
		}
		return null;
	}

	public static void main(String args[]) {
		BSTOperations bst = new BSTOperations();
		BST root1 = new BST();
		root1 = null;

		root1 = bst.insert(root1, 10);
		root1 = bst.insert(root1, 8);
		root1 = bst.insert(root1, 15);
		root1 = bst.insert(root1, 6);
		root1 = bst.insert(root1, 9);
		root1 = bst.insert(root1, 90);

		LeafIterator l = new LeafIterator(root1);
		while (l.hasNext()) {
			System.out.println(l.next().item);
		}
	}
}
