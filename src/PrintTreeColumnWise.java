import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PrintTreeColumnWise {

	HashMap<Integer, ArrayList<Integer>>treeMap = new HashMap<>();
	public void fillTreeMap(BST root, int col) {
		if(root == null) {
			return;
		}
		
		if(treeMap.containsKey(col)) {
			ArrayList<Integer>child = treeMap.get(col);
			child.add(root.item);
		} else{
			ArrayList<Integer>child = new ArrayList<>();
			child.add(root.item);
			treeMap.put(col, child);
			
			fillTreeMap(root.left, col-1);
			fillTreeMap(root.right, col+1);
		}
		
	}
	
	public void printTreeColumnWise() {
		Iterator it = treeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			int currKey = (int) pair.getKey();
			ArrayList<Integer>currVal = treeMap.get(currKey);
			
			for(int j = 0; j < currVal.size(); j++) {
				System.out.print(currVal.get(j)+ " ");
			}
		}
	}
	
	public void setOffset() {
		Iterator it = treeMap.entrySet().iterator();
		int min = 9999;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			int currKey = (int) pair.getKey();
			if(currKey < min) {
				min = currKey;
			}
		}
		System.out.println("Smalledst Key is :" + min);
		
		//add the offset to all the keys and print all the values of the map.
		Iterator it1 = treeMap.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();
			int currKey = (int) pair.getKey();
			ArrayList<Integer> currVal = (ArrayList<Integer>) pair.getValue();
			
			currKey = currKey + Math.abs(min);
			treeMap.put(currKey, currVal);
		}
		System.out.println(treeMap);
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
		root = bst.insert(root, 7);
		
		PrintTreeColumnWise p = new PrintTreeColumnWise();
		p.fillTreeMap(root, 0);
		p.setOffset();
	}

}
