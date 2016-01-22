
public class DiameterBST {

	public int findDia(BST root) {
		HeightBST h = new HeightBST();
		int dia = h.heightBST(root.left) + h.heightBST(root.right) + 2;
		return dia;
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
		
		DiameterBST d = new DiameterBST();
		System.out.println(d.findDia(root));
		
		BSTOperations b = new BSTOperations();
		System.out.println(b.getDiameter(root));
	}

}
