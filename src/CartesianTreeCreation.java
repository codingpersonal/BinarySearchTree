/*Create a cartesian tree with the following properties:
 * Tree from a array list
 * 1. the tree is binary
 * 2. the tree should be min heap. root is less than both children
 * 3. the inorder of the tree should be same as original array*/

public class CartesianTreeCreation {

	public static void main(String[] args) {
		int []arr = {3,4,1,2,9,7,6};
		int beg = 0;
		int end = 6;
		BST newNode = createCartesianTree(arr, beg, end);
		printInorder(newNode);
	}
	
	public static BST createCartesianTree(int[]arr, int beg, int end) {
		if(beg < 0 || end > arr.length - 1 || end < 0 || beg > end)
			return null;
		
		int minIndex = findMin(arr, beg, end);		
		BST newNode = new BST();
		newNode.item = arr[minIndex];
		
		newNode.left = createCartesianTree(arr, beg, minIndex - 1);
		newNode.right = createCartesianTree(arr, minIndex + 1, end);
		
		return newNode;
	}
	
	public static int findMin(int[]arr, int beg, int end) {
		int min = 9999;
		int minId = -1;
		for(int i = beg; i <= end; i++) {
			if(arr[i] < min) {
				min = arr[i];
				minId = i;
			}
		}
		
		return minId;
	}

	public static void printInorder(BST node) {
		if(node == null) {
			return;
		}
		
		printInorder(node.left);
		System.out.println(node.item);
		printInorder(node.right);
	}
}
