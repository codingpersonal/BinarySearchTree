import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
		
		
		System.out.println("Pre-order traversal:");
		bst.preOrder(root);
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
		
//		bst.findWidth(root);
		
//		Stack<BST> l = new Stack<>();
//		bst.printPaths(root,l);
		
//		bst.printLevelWise(root);
//		bst.printLevelWiseAlt(root);
		
//		bst.treeMirror(root);
//		bst.printLevelWise(root);
		
//		BST temp = new BST();
//		temp.item = 10;
//		
//		BST left = new BST();
//		left.item = 1;
//		temp.left = left;
//		
//		BST right = new BST();
//		right.item = 5;
//		temp.right = right;
		
//		System.out.println(bst.isBST(root));
		
//		System.out.println("\n");
//		bst.inorder_nonrec(root);
		
//		LevelWiseTreeIterator lt = new LevelWiseTreeIterator(root);
//		System.out.println(lt.hasNext());
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.hasNext());
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.getNext().item);
//		System.out.println(lt.hasNext());
		
		
		PreOrderIterator pre = new PreOrderIterator(root);
		System.out.println("\nPreorder using iterator:");
		while(pre.hasNext()) {
			System.out.print(pre.next().item + " ");
		}

	}

}
