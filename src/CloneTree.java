


public class CloneTree {
	public BST cloneBST(BST root) {
		BST newroot = new BST();
		if(root != null) {
			newroot.item = root.item;
		}
		
		if(root.left != null) {
			newroot.left = cloneBST(root.left);
		}
		
		if(root.right != null) {
			newroot.right = cloneBST(root.right);
		}
		
		return newroot;
	}
	
	public static void main(String args[]) {
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

		System.out.println("Preorder for origial tree is:");
		bst.preOrder(root);
		
		CloneTree ct = new CloneTree();
		BST newnode = new BST();
		newnode = ct.cloneBST(root);
		
		System.out.println("\n\nPre order of the clone tree is:");
		bst.preOrder(newnode);
		
		System.out.println("\n\nPreorder for origial tree is:(to ensure that root is not modified)");
		bst.preOrder(root);
		
	}
}
