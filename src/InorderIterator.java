import java.util.Stack;

public class InorderIterator {
	Stack<BST_mod> treeNodes = new Stack<>();

	public InorderIterator(BST root) {
		BST_mod node = new BST_mod();
		node.node = root;
		node.flag = false;
		treeNodes.push(node);
	}

	public boolean hasNext() {
		return !treeNodes.isEmpty();
	}

	public BST next() {
		BST_mod currNode;

		while (true) {
			currNode = treeNodes.pop();

			if ((currNode.node.left == null && currNode.node.right == null) || currNode.flag) {
				return currNode.node;
			}

			else {
				if (currNode.node.right != null) {
					BST_mod temp = new BST_mod();
					temp.node = currNode.node.right;
					temp.flag = false;
					treeNodes.push(temp);
				}

				currNode.flag = true;
				treeNodes.push(currNode);

				if (currNode.node.left != null) {
					BST_mod temp = new BST_mod();
					temp.node = currNode.node.left;
					temp.flag = false;
					treeNodes.push(temp);
				}

			}
		}

	}
}
