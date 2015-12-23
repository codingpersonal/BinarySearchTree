import javax.annotation.Generated;
import javax.swing.text.AbstractDocument.LeafElement;

public class BSTDriver {

	public static void main(String[] args) {
		BSTOperations bst = new BSTOperations();
		BST root = new BST();
		root = null;
		
		root = bst.insert(root, 10);
		root = bst.insert(root, 8);
		root = bst.insert(root,15);
		root = bst.insert(root, 6);
		root = bst.insert(root,7);
		root = bst.insert(root, 90);
		root = bst.insert(root, 36);
		root = bst.insert(root, 25);
		root = bst.insert(root, 9);
		root = bst.insert(root, 5);
		root = bst.insert(root, 14);
		root = bst.insert(root,40);
		root = bst.insert(root, 42);
		root = bst.insert(root, 41);
		root = bst.insert(root, 3);
		
//		System.out.println("Pre-order traversal:");
//		bst.preOrder(root);
//		
//		System.out.println("Post order traversal:");
//		bst.postOrder(root);
//		
//		System.out.println("Inorder traversal:");
//		bst.inOrder(root);
//		
//		System.out.println("Searching an item now:");
//		bst.search(root, 41);
		
//		System.out.println("Length of the tree is:" + bst.lengthBST(root));
		
//		bst.bfs(root);
//		bst.findMax(root);
//		bst.findMin(root);
		
//		System.out.println("Diameter of the tree is :" + bst.getDiameter(root));
	}

}
