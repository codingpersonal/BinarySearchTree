//Left view is the first element in the tree on each level
//right view is the last element in the tree on each level.
import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftRightView {
	Queue<BST>tree = new LinkedList<>();

	//below code prints the tree level wise using the marker in the queue.
	//it means on completing one level, it will insert a null node in the queue.
	public void printLevelWise_NodeMarker(BST root){
		if(root != null) {
			tree.add(root);
			tree.add(null);
		} else
			return;
		
		while(!(tree.size() == 1 && tree.peek()== null)) {
			BST currNode = tree.remove();
			if(currNode == null) {
				tree.add(null);
				System.out.println("");
			}
			else {
				System.out.print(currNode.item + " ");
				if(currNode.left != null)
					tree.add(currNode.left);
				if(currNode.right != null)
					tree.add(currNode.right);
			}
			
		}
	}
	
	public void printLeftView(BST root) {
		if(root != null) {
			System.out.println(root.item);
			tree.add(root);
			tree.add(null);
		} else
			return;
		
		while(!(tree.size() == 1 && tree.peek()== null)) {
			BST currNode = tree.remove();
			if(currNode == null) {
				tree.add(null);
				System.out.println(tree.peek().item);
			}
			else {
				if(currNode.left != null)
					tree.add(currNode.left);
				if(currNode.right != null)
					tree.add(currNode.right);
			}
			
		}
	}
	
	public void printRightView(BST root) {
		if(root != null) {
			tree.add(root);
			tree.add(null);
		} else
			return;
		
		while(!(tree.size() == 1 && tree.peek()== null)) {
			BST currNode = tree.remove();
			if(tree.peek() == null) {
				System.out.print(currNode.item+" ");
			}
			if(currNode == null) {
				tree.add(null);
			}
			else {
				if(currNode.left != null)
					tree.add(currNode.left);
				if(currNode.right != null)
					tree.add(currNode.right);
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
		
		PrintLeftRightView p = new PrintLeftRightView();
		//p.printLeftView(root);
		p.printRightView(root);
	}

}
