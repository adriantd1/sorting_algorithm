public class InPlaceMergeSort{
	
	public int array[];
	
	public InPlaceMergeSort(int size){
		array = new int[size];
	}
	
	public InPlaceMergeSort(int a[]){
		array = a;
	}
	
	public void mergeSort(int start, int end){
		if(start == end){
			return;
		}
		
		if(start + 1 == end) {
			if(array[start]>array[end]){
				swap(start, end);
			}
			return;
		}
		
		mergeSort(start, (start + end)/2);
		mergeSort((start + end)/2 + 1, end);

		rotate(start, end);
		rotate(start, (start + end)/2);
		rotate((start + end)/2 + 1, end);
	}
	
	//rotate takes 2 sorted, adjacent sub-array of equal length
	public void rotate(int start, int stop){
		
		if(start==stop){
			return;
		}
		
		if(start + 1 == stop){
				if(array[start] > array[stop]){
					swap(start,stop);
				}
				return;
		}
		
		int index1 = (start+stop)/2;
		int index2 = index1+1;
		
		//if the array has even length
		if( (start+stop) % 2 == 1){
			//if the smallest element of the left sub-array is smaller than the largest element of the right sub-array
			if(array[start]<array[stop]){
				while(array[index1]>array[index2]){
					index1--;
					index2++;
				}
			
				for(int i = (start+stop)/2 + 1; i<index2; i++){
					swap(index1 + 1, i);
					index1++;
				}
			} else{
				for(int i = start; i<(start+stop)/2 + 1; i++){
					swap(i, index2);
					index2++;
				}
			}
			rotate(start, (start + stop)/2);
			rotate((start + stop)/2 + 1, stop);
		} else{

			if( array[(start+stop)/2] > array[(start+stop)/2 + 1]  ){
				if(array[stop]<array[(start+stop)/2]){
					swap((start+stop)/2,stop);
				}
			} else if(array[(start+stop)/2 - 1] > array[stop]){
				swap((start+stop)/2 - 1,stop);
			}
			rotate(start, stop - 1);
			rotate(start, (start + stop - 1)/2);
			rotate((start + stop - 1)/2 + 1, stop-1);
		}
	}
	
	public void swap(int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}