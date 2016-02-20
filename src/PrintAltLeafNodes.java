//if there are two trees, print the alternate leaf nodes of the two trees.
//sol: write a tree leaf iterator and then keep on printing the alt leaves using iterator.
public class PrintAltLeafNodes {
	BST root1, root2;
	LeafIterator li_1;
	LeafIterator li_2;
	
	public PrintAltLeafNodes() {
		BSTOperations bst = new BSTOperations();
		root1 = new BST();
		root1 = null;
		
		root1 = bst.insert(root1, 10);
		root1 = bst.insert(root1, 8);
		root1 = bst.insert(root1,15);
		root1 = bst.insert(root1, 6);
		root1 = bst.insert(root1,9);
		root1 = bst.insert(root1, 90);
		
		root2 = new BST();
		root2 = null;
		
		root2 = bst.insert(root2, 11);
		root2 = bst.insert(root2, 9);
		root2 = bst.insert(root2,7);
		root2 = bst.insert(root2, 12);
		root2 = bst.insert(root2,13);
		
		li_1 = new LeafIterator(root1);
		li_2 = new LeafIterator(root2);
		
	}
	
	public void printLeafAlternate() {
		BST first = li_1.next();
		BST second = li_2.next();
		
		while(first != null && second != null) {
			System.out.println(first.item);
			System.out.println(second.item);
			first = li_1.next();
			second = li_2.next();
		}
		
		while(first != null) {
			System.out.println(first.item);
			first = li_1.next();
		}
		
		while(second != null) {
			System.out.println(second.item);
			second = li_2.next();
		}
	}
	
	public static void main(String args[]) {
		PrintAltLeafNodes p = new PrintAltLeafNodes();
		p.printLeafAlternate();
	}
}
