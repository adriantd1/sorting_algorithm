import java.util.*;


/*This class is an implementation of the heapsort sorting algorithm. The main class
  tests the algorithm on a randomized array of 30 elements between 0 and 100 and
  prints the sorted array*/

public class HeapSort{
	
	public static void main(String args[]){
		int[] arr = new int[30];
		Random a = new Random();
		for(int i = 0; i<30; i++){
			arr[i] = a.nextInt(100);
		}
		heapsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapsort(int[] array){
		int count = array.length;
		heapify(array, count);

		int end = count - 1;
		while(end>0){
			swap(array,end, 0);
			end = end - 1;
			siftDown(array, 0, end);
		}
	}

	//heapify order and array such that it represents a heap
	public static void heapify(int[] array, int count){
		int start = (int)Math.floor((count - 2)/2);
		while(start>=0){
			siftDown(array, start, count - 1);
			start = start - 1;
		}
	}

	//siftDown reposition an element accordingly after a swap in order to restore the heap property of the array
	public static void siftDown(int[] array, int start, int end){
		int root = start;
		while(root*2+1 <= end){
			int child = root*2 + 1;
			int to_swap = root;

			if(array[to_swap] < array[child]){
				to_swap = child;
			}

			if((child+1)<=end && array[to_swap] < array[child+1]){
				to_swap = child +1;
			}

			if(to_swap == root){
				return;
			} else{
				swap(array,root, to_swap);
				root = to_swap;
			}
		}
	}

	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}