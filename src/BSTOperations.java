import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
			System.out.println("Tree is empty. No item found.");
			return;
		}
		
		boolean flag = false;
		while(!flag) {
			if(root == null) {
				System.out.println("Item not found.");
				return;
			}

			if(root.item == item) {
				System.out.println("Item found in BST");
				flag = true;
			}
			else if(item <= root.item) {
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
	}
	
	public int lengthBST(BST root) {
		if(root == null) {
			return 0;
		}
		return max(lengthBST(root.left), lengthBST(root.right)) + 1;	
	}

	public int getDiameter(BST root){
		return lengthBST(root.left) + lengthBST(root.right) + 1;
	}
	
	private int max(int length1, int length2) {
		if(length1 >= length2) 
			return length1;
		else
			return length2;
	}

	public void bfs(BST root){
		Queue<BST> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BST node = q.remove();
			if(node != null) {
				System.out.println(node.item);
			}
			
			if(node.left != null)
				q.add(node.left);
			
			if(node.right != null)
				q.add(node.right);
		}
	}

	public void findMax(BST root) {
		int max = root.item;
		
		while(root.right != null) {
			max = root.right.item;
			root = root.right;
		}
		
		System.out.println("Maximum element in the BST is:" + max);
	}
	
	public void findMin(BST root) {
		int min = root.item;
		
		while(root.left != null) {
			min = root.left.item;
			root = root.left;
		}
		
		System.out.println("Maximum element in the BST is:" + min);
	}

}


