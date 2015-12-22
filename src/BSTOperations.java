public class BSTOperations {	
	public BST insert(BST root, int item) {
		if(root == null) {
			BST newnode = new BST();
			newnode.item = item;
			newnode.left = null;
			newnode.right = null;
			root = newnode;
			return root;
		}
		
		else if(item <= root.item) {
			root.left = insert(root.left, item);
			return root;
		}
		
		else {
			root.right = insert(root.right,item);
			return root;
		}
		
	}
	
	public void preOrder(BST root) {
		if(root != null) {
			System.out.println(root.item);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(BST root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.item);
		}
	}
	
	public void inOrder(BST root) {
		if(root != null) {
			inOrder(root.left);
			System.out.println(root.item);
			inOrder(root.right);
		}
	}
	
	public void search(BST root, int item) {
		if(root == null) {
			System.out.println("Item does not exist.");
			return;
		}
		
		if(root.item == item) {
			System.out.println("Item found in BST");
		}
		else if(item <= root.item) {
			search(root.left, item);
		}
		else {
			search(root.right, item);
		}
	}
	
	public int lengthBST(BST root) {
		if(root == null) {
			return 0;
		}
		return max(lengthBST(root.left), lengthBST(root.right)) + 1;	
	}

	private int max(int length1, int length2) {
		if(length1 >= length2) 
			return length1;
		else
			return length2;
	}
}

