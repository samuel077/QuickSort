package quickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QuickSort {
	
	public static List<Integer> recursiveSort( List<Integer> a ) {
		
		// end of recursive condition.
		if( a.size() < 2)
			return a;
		
		// create quick sort
		List<Integer> returnArray = new ArrayList<>();
		List<Integer> smaller = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();
		
		int pivot = a.get(0);
		
		for(int i = 1; i < a.size() ; i++ ) {
			if(a.get(i) > pivot) {
				higher.add(a.get(i));
			} else 
				smaller.add(a.get(i));
		}
		
		// add all the result.
		returnArray.addAll(recursiveSort(smaller));
		returnArray.add(pivot);
		returnArray.addAll(recursiveSort(higher));
		
		return returnArray;
		
	}
	
	public static List<Integer> nonRecursive( List<Integer> a ) {
		
		// we use stack to mark two different subArray begin and end point.
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(a.size());
		
		while(!stack.isEmpty()) {
			System.out.println(a.toString());
			int end = (int) stack.pop();
			int start = (int) stack.pop();
			
			if(end - start  <= 1)
				continue;
			
			// pick a location in the middle
			int p = start + ((end-start)/2);
			// get the partition of next subset.
			p = partition(a, p , start, end);
			
			System.out.println("pivot = " + p);
			
			// large 
			stack.push(p+1);
			stack.push(end);
			
			// small, we'll take care of smaller subset first. 
			stack.push(start);
			stack.push(p);
		}
		
		return a;
	}
	
	public static int partition(List<Integer> a, int p, int start, int end ) {
		
		// get the pivot , and move it to the end of the array
		int pivot = a.get(p);
		int low = start;
		int high = end-2;
		
		swap(a, p, end-1);
		
		// compare indexes, we swap element if low element is bigger than 
		// pivot and high element is smaller than pivot
		while( low < high ) {
			if( a.get(low) < pivot ) {
				// shifting elements.
				low++;
			} else if ( a.get(high) >= pivot) {
				// find the last one exception. 
				high--;
			} else {
				System.out.println("before swap" + a.toString());
				swap(a, low, high);
				System.out.println("After swap" + a.toString());
			}
		}
		
		// we can find the last pivot
		int newPivot = high;
		if(a.get(high) < pivot ) {
			newPivot ++;
		}
		// switch back with pivot 
		swap(a, end -1, newPivot);
		
		return newPivot;
	}
	
	// basic swap function. 
	public static void swap(List<Integer> a, int frontIndex, int endIndex ) {
		int temp = a.get(frontIndex);
		a.set(frontIndex, a.get(endIndex));
		a.set(endIndex, temp);
	}
}
