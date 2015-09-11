import java.util.*;


/*This class is an implementation of the quicksort algorithm. The main class
  tests the algorithm on a randomized array of 30 elements between 0 and 100
  and prints the sorted array*/

public class Quicksort{
	
	public static void main(String args[]){
		int[] arr = new int[30];
		Random a = new Random();
		for(int i = 0; i<30; i++){
			arr[i] = a.nextInt(100);
		}
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quicksort(int[] array, int lo, int hi){
		if(lo<hi){
			int p = partition(array, lo, hi);
			quicksort(array, lo, p-1);
			quicksort(array, p+1, hi);
		}
	}

	//takes the last element of the array as a pivot, and places every element smaller than the pivot before it and every element bigger after it
	public static int partition(int[] array, int lo, int hi){
		int pivot = array[hi];
		int i = lo - 1;
		for(int j = lo; j <= hi-1; j++){
			if(array[j] <= pivot){
				i++;
				swap(array,i,j);
			}
		}
		i++;
		swap(array,i,hi);
		return i;
	}

	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}