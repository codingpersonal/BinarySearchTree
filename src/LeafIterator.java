import java.util.Stack;

public class LeafIterator {
	Stack<BST>leafQ = new Stack<>();
	BST node;
	BST leafNode;
	
	public LeafIterator(BST node) {
		this.node = node;
		leafNode = null;
		leafQ.push(node);
	}
	
	public BST next() {
		leafNode = null;
		BST currNode;
		
		while(leafNode == null && !leafQ.isEmpty()) {
			currNode = leafQ.pop();
			if(currNode.right != null) {
				leafQ.push(currNode.right);
			} 
			
			if(currNode.left != null) {
				leafQ.push(currNode.left);
			} 
			
			if(currNode.left == null && currNode.right == null){
				leafNode = currNode;
			}
		}
		return leafNode;
	}
}

