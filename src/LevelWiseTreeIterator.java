import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseTreeIterator {

	Queue<BST>treeNodes = new LinkedList();

	public LevelWiseTreeIterator(BST node) {
		treeNodes.add(node);
	}
	
	public boolean hasNext() {
		return !treeNodes.isEmpty();
	}

	public BST getNext() {
		if(!hasNext())
			return null;

		BST curr_pos = treeNodes.remove();
		if(curr_pos.left != null) {
			treeNodes.add(curr_pos.left);
		}

		if(curr_pos.right != null) {
			treeNodes.add(curr_pos.right);
		}

		return curr_pos;
	}
}
