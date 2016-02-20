/*In a BST find two nodes which are having min difference in the item values.
 * Sol: Inorder traversal gives the tree in a sorted form.
 * So, you can either write an iterator and then find the difference in the nodes.
 * or pass on a struct where you can pass a prev node, then the min value.*/

class NodeInfo{
	BST prev_node;
	int min;
	public NodeInfo(BST node, int min) {
		this.prev_node = node;
		this.min = min;
	}
}


public class FindMinDifferenceNodes {
	public static void findMinDiff(BST root, NodeInfo n) {
		if(root.left != null) {
			n.prev_node = root;
			findMinDiff(root.left, n);
		}
		
		if(n.prev_node != null) {
			int currMin = Math.abs(root.item - n.prev_node.item);
			if(n.min > currMin && currMin != 0) {
				n.min = currMin;
			} 
		}
		
		if(root.right != null) {
			n.prev_node = root;
			findMinDiff(root.right, n);
		}
	}
	
	public static void main(String[] args) {
		BSTOperations bst = new BSTOperations();
		BST root = new BST();
		root = null;
		
		root = bst.insert(root, 10);
		root = bst.insert(root, 8);
		root = bst.insert(root,15);
		root = bst.insert(root, 6);
		root = bst.insert(root,9);
		root = bst.insert(root,90);
		root = bst.insert(root, 42);
		root = bst.insert(root, 48);
		root = bst.insert(root, 30);
		
		NodeInfo n = new NodeInfo(null, 9999);
		findMinDiff(root, n);
		System.out.println(n.min);
		
	}

}
