/*How many BSTs can be formed from a sorted array of integers*/
public class CountBST {
	
	//this function will take an array and returns the no of trees which 
	//can be formed between elements from beg to end
	public int makeBST(int arr[], int beg, int end) {
		int tot_for_curr_root = 0;
		
		//if there is only one element in the array
		if(end - beg == 0) {
			return 1;
		}
		else if(beg < 0 || end < 0) {
			return 1;
		}
		
		for(int i = beg; i <= end ; i++) {
			int leftCount = makeBST(arr, 0, beg-1);
			int rightCount = makeBST(arr,beg+1, end);
			tot_for_curr_root += leftCount * rightCount;
		}
		return tot_for_curr_root;
	}

	public static void main(String[] args) {
		CountBST c = new CountBST();
		int arr[] = {1,2,3};
		System.out.println(c.makeBST(arr, 0, 2));
	}

}
