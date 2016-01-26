
public class BSTToDLL {
	
	public NodePtr convertBSTtoDLL(BST root) {
		if(root == null) {
			return new NodePtr(null,null);
		}
		else if(root.left == null && root.right == null) {
			NodePtr ret = new NodePtr(root,root);
			return ret;
		}
		else {
			NodePtr left = null, right = null;
			BST end;
			BST start;
			
			if(root.left != null)
				left = convertBSTtoDLL(root.left);
			
			if(root.right != null)
				right = convertBSTtoDLL(root.right);
			
			if(left == null) {
				root.left = null;
				start = root;
			}else {
				left.end.right = root;
				root.left = left.end;
				start = left.start;
			}
			
			if(right == null) {
				root.right = null;
				end = root;
			} else {
				root.right = right.start;
				right.start.left = root;
				end = right.end;
			}
			
			NodePtr ret = new NodePtr(start, end);
			return ret;
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

		System.out.println("Inorder Traversal for the tree is:");
		bst.inOrder(root);
		
		BSTToDLL b = new BSTToDLL();
		NodePtr n = b.convertBSTtoDLL(root);
		
		System.out.println("\nOutput DLL is from start:");
		while(n.start != null) {
			System.out.print(n.start.item+ " ");
			n.start = n.start.right;
		}
		
		System.out.println("\nOutput DLL is from end:");
		while(n.end != null) {
			System.out.print(n.end.item+" ");
			n.end = n.end.left;
		}
	}

}

class NodePtr{
	BST start = null;
	BST end = null;
	NodePtr(BST root, BST root2) {
		start = root; 
		end = root2;
	}
}

class Node {
	public int item;
	Node next;
	Node prev;
}