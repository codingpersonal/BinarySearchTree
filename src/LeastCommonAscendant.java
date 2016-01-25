import java.awt.PageAttributes;
import java.util.ArrayList;

//It means finding the common parent for 2 nodes.
//This code is for BST - non recursion method.
//It is not efficient way or logic

public class LeastCommonAscendant {

	
	//Old way - inefficient logic
	/*public BST findLCA(BST node1, BST node2, BST root) {
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
	}*/
	
	
	public BST findLCA(BST node1, BST node2,BST root) {
		BST parent = new BST();
		parent = root;
		
		while(true) {
			if(node1.item <= parent.item && node2.item <= parent.item) {
				parent = parent.left;
			} else if(node1.item > parent.item && node2.item > parent.item) {
				parent = parent.right;
			}
			else {
				return parent;
			}
		}
	}
	
	
	class Ret_findLCA_BT {
		public Ret_findLCA_BT(BST inParent, boolean found_any) {
			this.parent = inParent;
			this.found_any_node = found_any;
		}
		BST parent = null;
		boolean found_any_node = false;
	}

	// it will return either the LCA found or either the node which is found. 
	public Ret_findLCA_BT findLCA_BT(BST node1, BST node2, BST root) {
		
		if (root == null) {
			return new Ret_findLCA_BT(null, false);
		}

		Ret_findLCA_BT ret_left = findLCA_BT(node1, node2, root.left);
		if (ret_left.parent != null) {
			return ret_left;
		}

		Ret_findLCA_BT ret_right = findLCA_BT(node1, node2, root.right);
		if (ret_right.parent != null) {
			return ret_right;
		}

		if (root.item == node1.item || root.item == node2.item) {
			// find the other item in either left or right. 
			
			if (ret_left.found_any_node || ret_right.found_any_node) {
				// if anything is found in left or right, it means root is the LCA
				return new Ret_findLCA_BT(root, false);
			} else {
				return new Ret_findLCA_BT(null, true);
			}
		} else {
			if (ret_left.found_any_node && ret_right.found_any_node) {
				return new Ret_findLCA_BT(root, false);
			} else if (ret_left.found_any_node || ret_right.found_any_node) {
				return new Ret_findLCA_BT(null, true);
			}
		}
		return new Ret_findLCA_BT(null, false);
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
		
		BST root_temp = new BST();
		root_temp = root;
		
		BST node1 = new BST();
		node1 = root.right.right.left.left;
		System.out.println("Node1 is:" + node1.item);
		
		BST node2 = new BST();
		node2 = root.right.right.left.right.right.left;
		System.out.println("\nNode2 is:" + node2.item);

		root = root_temp;
//		System.out.println("\nCommon Parent is:"+ l.findLCA(node1, node2, root).item);
		
		Ret_findLCA_BT ret = l.findLCA_BT(node1, node2, root);
		
	}

}
