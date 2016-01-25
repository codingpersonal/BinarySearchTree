


public class CloneMirrorTree {
	public BST cloneBST(BST root) {
		BST newroot = new BST();
		if(root != null) {
			newroot.item = root.item;
		}
		
		if(root.right != null) {
			newroot.left = cloneBST(root.right);
		}
		
		if(root.left != null) {
			newroot.right = cloneBST(root.left);
		}
		
		return newroot;
	}
	

	//returns true if BST is a mirror image of other
	public boolean isBSTClone(BST root1, BST root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		else if(root1 != null && root2 !=null) {
			return (root1.item == root2.item) 
					&& isBSTClone(root1.left, root2.right)
						&& isBSTClone(root1.right, root2.left);
		}
		else 
			return false;
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

		BST root1 = new BST();
		root1 = bst.insert(root1, 5);
		root1 = bst.insert(root1, 3);
		root1 = bst.insert(root1, 14);
		root1 = bst.insert(root1,40);
		root1= bst.insert(root1, 42);
		root1 = bst.insert(root1, 41);
		root1 = bst.insert(root1, 39);
		root1 = bst.insert(root1, 24);
		root1 = bst.insert(root1, 26);
		root1 = bst.insert(root1, 2);
		root1 = bst.insert(root1, 4);
		
		System.out.println("Preorder for origial tree is:");
		bst.preOrder(root);
		
		CloneMirrorTree ct = new CloneMirrorTree();
		BST newnode = new BST();
		newnode = ct.cloneBST(root);
		
		System.out.println("\n\nPre order of the clone tree is:");
		bst.preOrder(newnode);
		
		//System.out.println("\n\nPreorder for origial tree is:(to ensure that root is not modified)");
		//bst.preOrder(root);
		
		System.out.println("\n\nAre two trees are mirror clones? "+ ct.isBSTClone(root, root1));
		
	}
}
