import java.util.Stack;

public class PreOrderIterator {

	Stack<BST>treeNodes = new Stack<>();
	public PreOrderIterator(BST root) {
		treeNodes.push(root);
	}
	
	public boolean hasNext() {
		return !treeNodes.isEmpty();
	}
	
	public BST next() {
		BST currNode = null;
		if(treeNodes.isEmpty()) {
			return currNode;
		} else {
			currNode = treeNodes.pop();
			if(currNode.right != null) {
				treeNodes.push(currNode.right);
			}
			
			if(currNode.left != null) {
				treeNodes.push(currNode.left);
			}
			
			return currNode;
		}
	}
}
