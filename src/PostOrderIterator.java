import java.util.Stack;

public class PostOrderIterator {
	Stack<BST_mod>treeNodes = new Stack<>();
	
	public PostOrderIterator(BST root) {
		if(root != null) {
			BST_mod temp = new BST_mod();
			temp.node = root;
			temp.flag = false;
			treeNodes.push(temp);
		}
	}
	
	public boolean hasNext() {
		return !treeNodes.isEmpty();
	}
	
	public BST next() {
		BST_mod currNode = null;
		BST ret_node = null;

		while (ret_node == null) {

			currNode = treeNodes.peek();

			if ((currNode.node.left == null && currNode.node.right == null) || (currNode.flag)) {
				ret_node = treeNodes.pop().node;
				return ret_node;
			} else {
				currNode.flag = true;

				if (currNode.node.right != null) {
					BST_mod temp = new BST_mod();
					temp.node = currNode.node.right;
					temp.flag = false;
					treeNodes.push(temp);
				}

				if (currNode.node.left != null) {
					BST_mod temp = new BST_mod();
					temp.node = currNode.node.left;
					temp.flag = false;
					treeNodes.push(temp);
				}
			}
		}

		return ret_node;
	}
	
}
