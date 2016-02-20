import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelWise {
	Queue<BST>tree = new LinkedList<>();
	
	public void printAlternating(BST root) {
		if (root == null) 
			return;
		
		Stack<BST> ltr = new Stack<>();
		Stack<BST> rtl = new Stack<>();
		ltr.push(root);
		boolean isFound = true;
		while (isFound) {
			isFound = false;
			while (!ltr.empty()) {
				isFound = true;
				BST currNode = ltr.pop();
				System.out.printf("%d ", currNode.item);
				if (currNode.left != null)
					rtl.push(currNode.left);
				if (currNode.right != null)
					rtl.push(currNode.right);
			}
			
			System.out.println("\n");
			while (!rtl.empty()) {
				isFound = true;
				BST currNode = rtl.pop();
				System.out.printf("%d ", currNode.item);
				if (currNode.right != null)
					ltr.push(currNode.right);
				if (currNode.left != null)
					ltr.push(currNode.left);
			}
		}
	}
	
	public void printLevelWise(BST root) {
		int count = 0;
		if(root != null) {
			tree.add(root);
			tree.add(null);
		}	
		
		while(!tree.isEmpty()) {
			BST currNode = tree.remove();
			if(currNode != null) {
				System.out.print(currNode.item+" ");
				if(currNode.left != null) {
					tree.add(currNode.left);
				}
				if(currNode.right != null) {
					tree.add(currNode.right);
				}
			}
			
			else {
				System.out.println("\n");
				if(!tree.isEmpty())
					tree.add(null);
			}
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
		
		PrintLevelWise p = new PrintLevelWise();
		p.printLevelWise(root);
	}

}
