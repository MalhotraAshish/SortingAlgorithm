package sorting;

public class CountingSort {
	public static int[] sort(int arr[]) {
		int size = arr.length;
		int output[] = new int[size];
		int count[] = new int[10];
		
		//Initializing count array to 0
		for(int i = 0; i<10; i++) {
			count[i] = 0; 
		}
		
		//Store count of each element in array arr
		for(int i = 0; i<size; i++) {
			++count[arr[i]];
		}
		
		//change count[i] so that count array now contains the actual index of the element
		for(int i = 1; i<10; i++) {
			count[i] = count[i] + count[i-1];
		}
		
		//Build the output array and reduce the count at each index by 1
		//To make the change stable we start from the last
		for(int i = size-1; i >= 0; i--) {
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		
		//coping the elements of output array to original array
		for(int i = 0; i<size; i++) {
			arr[i] = output[i];
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		int arr[] = {1,4,1,2,7,5,2};
		arr = sort(arr);
		System.out.println("After sorting ");
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
