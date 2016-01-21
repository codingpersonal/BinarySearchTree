import java.util.Stack;

public class PostOrderIterator {
	Stack<BST>treeNodes = new Stack<>();
	public PostOrderIterator(BST root) {
		if(root != null) {
			treeNodes.push(root);
		}
	}
	
	public boolean hasNext() {
		return !treeNodes.isEmpty();
	}
	
	public BST next() {
		BST currNode = null;
		
		return currNode;
	}
	
}
