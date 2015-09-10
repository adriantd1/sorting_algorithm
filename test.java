import java.util.*;

public class test{
	public static void main(String args[]){
		int[] arr = new int[11];
		Random a = new Random();
		for(int i = 0; i<11; i++){
			arr[i] = a.nextInt(100);
		}
		InPlaceMergeSort b = new InPlaceMergeSort(arr);
		System.out.println(Arrays.toString(arr));
		b.mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(b.array));
	}
	
	// #### QUICKSORT ####
	public static void quicksort(int[] array,int lo, int hi){
		if(lo<hi){
			int p = partition(array, lo, hi);
			quicksort(array, lo, p-1);
			quicksort(array, p+1, hi);
		}
	}

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

	// ######### SWAP ###########
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// ######## HEAPSORT ###########
	public static void heapify(int[] array, int count){
		int start = (int)Math.floor((count - 2)/2);
		while(start>=0){
			siftDown(array, start, count - 1);
			start = start - 1;
		}
	}

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
}