import java.util.ArrayList;

public class LeastCommonAscendant {

	public BST findLCA(BST node1, BST node2, BST root) {
		ArrayList<BST> path1 = new ArrayList<>();
		ArrayList<BST> path2 = new ArrayList<>();
		
		path1 = findPathfromRoot(root, node1);
		path2 = findPathfromRoot(root, node2);
		
		int beg = path1.size() - 1;
		for(int i = beg; i >= 0; i--) {
			BST currNode = path1.get(i);
			if(path2.indexOf(currNode) != -1) {
				return currNode;
			}
		}
		
		return root;
	}
	
	public ArrayList<BST> findPathfromRoot(BST root, BST node) {
		ArrayList<BST>path = new ArrayList<>();
		path.add(root);
		BST currNode = root;
		
		while(currNode != node) {
			if(node.item > currNode.item) {
				path.add(currNode.right);
				currNode = currNode.right;
			}
			else {
				path.add(currNode.left);
				currNode = currNode.left;
			}
		}
		
		return path;
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
		root = bst.insert(root, 90);
		root = bst.insert(root, 14);
		root = bst.insert(root, 25);
		root = bst.insert(root, 9);
		root = bst.insert(root, 5);
		root = bst.insert(root, 3);
		root = bst.insert(root, 14);
		root = bst.insert(root,40);
		root = bst.insert(root, 42);
		root = bst.insert(root, 41);
		root = bst.insert(root, 39);
		root = bst.insert(root, 24);
		root = bst.insert(root, 26);
		root = bst.insert(root, 2);
		root = bst.insert(root, 4);
		
		LeastCommonAscendant l = new LeastCommonAscendant();

		//node1 = 24
		BST node1 = new BST();
		node1 = root.right.right.left.right;
		System.out.println("Node1 is:" + node1.item);
		
		//node2 = 40
		BST node2 = new BST();
		node2 = root.right.right.left.right.right.left;
		System.out.println("\nNode2 is:" + node2.item);

		System.out.println("\nCommon Parent is:"+ l.findLCA(node1, node2, root).item);
	}

}
