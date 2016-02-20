//in a bst , print the kth increasing number.
//sol : if you do an inorder of a bst, the numbers are arranged in the ascending order.
public class PrintKAscendingNumber {
	int count = 0;
	
	public int printKAscendingNumber(BST root, int k) {
		return -1;
	}
	
	public static void main(String[] args) {
		PrintKAscendingNumber p = new PrintKAscendingNumber();
		BSTOperations bst = new BSTOperations();
		BST root = new BST();
		root = null;
		
		root = bst.insert(root, 10);
		root = bst.insert(root, 8);
		root = bst.insert(root,15);
//		root = bst.insert(root, 6);
//		root = bst.insert(root,9);
//		root = bst.insert(root, 90);
//		root = bst.insert(root, 14);
//		root = bst.insert(root, 25);
//		root = bst.insert(root, 9);
//		root = bst.insert(root, 5);
//		root = bst.insert(root, 3);
//		root = bst.insert(root, 14);
//		root = bst.insert(root,40);
//		root = bst.insert(root, 42);
//		root = bst.insert(root, 41);
//		root = bst.insert(root, 39);
//		root = bst.insert(root, 24);
//		root = bst.insert(root, 26);
//		root = bst.insert(root, 2);
//		root = bst.insert(root, 4);
		
		p.printKAscendingNumber(root, 2);
	}

}
