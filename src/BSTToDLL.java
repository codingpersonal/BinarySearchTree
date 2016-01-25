
public class BSTToDLL {
	
	public NodePtr convertBSTtoDLL(BST root) {
		if(root == null) {
			return new NodePtr(null,null);
		}
		else if(root.left == null && root.right == null) {
			Node node = new Node();
			node.item = root.item;
			node.next = null;
			node.prev = null;
			NodePtr ret = new NodePtr(node, node);
			return ret;
		}
		else {
			NodePtr left = null, right = null;
			Node end, start;
			
			if(root.left != null)
				left = convertBSTtoDLL(root.left);
			
			if(root.right != null)
				right = convertBSTtoDLL(root.right);
			
			Node currNode = new Node();
			currNode.item = root.item;
			
			if(left == null) {
				currNode.prev = null;
				start = currNode;
			}else {
				left.end.next = currNode;
				currNode.prev = left.end;
				start = left.start;
			}
			
			if(right == null) {
				currNode.next = null;
				end = currNode;
			} else {
				currNode.next = right.start;
				right.start.prev = currNode;
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
			n.start = n.start.next;
		}
		
		System.out.println("\nOutput DLL is from end:");
		while(n.end != null) {
			System.out.print(n.end.item+" ");
			n.end = n.end.prev;
		}
	}

}

class NodePtr{
	Node start = null;
	Node end = null;
	NodePtr(Node s, Node e) {
		start = s; 
		end = e;
	}
}

class Node {
	public int item;
	Node next;
	Node prev;
}