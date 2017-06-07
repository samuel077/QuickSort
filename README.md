# QuickSort
I want to implement QuickSort both in recursive and non-recursive method

The time complexity of QuickSort in general should be O(nlogn)
But the worst case of it should be O(n^2), even though we divide array into two subArrays, if we choose not that proper pivot, it won't help to reduce the computing process.

Here's my Sample call of this function.

<pre>

public class QuickSortTest {

	public static void main(String[] args) {
		
		
		int [] input = {3,8,7,6,3,0,3,8,7,6,3,0,3,8,7,6,3,0};
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> arrayListOutput = new ArrayList<>();
		for(int i = 0 ; i < input.length ; i++) {
			arrayList.add(input[i]);
		}
		
		// arrayListOutput = QuickSort.recursiveSort(arrayL;ist)
		arrayListOutput = QuickSort.nonRecursive(arrayList);
		for(Integer intValue : arrayListOutput ) {
			System.out.print(" " + intValue);
		}
	}

}
</pre>

And the expected output should be as below <br/>
0 0 0 3 3 3 3 3 3 6 6 6 7 7 7 8 8 8
