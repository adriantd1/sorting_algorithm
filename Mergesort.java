import java.util.*;

/*This class is an implementation of the mergesort sorting algorithm. The main class
  tests the algorithm on a randomized array of 30 elements between 0 and 100 and
  prints the sorted array*/

public class Mergesort{
	public static void main(String args[]){
		int[] arr = new int[30];
		Random a = new Random();
		for(int i = 0; i<30; i++){
			arr[i] = a.nextInt(100);
		}
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	public static int[] mergeSort(int[] list){
		if(list.length==1){
			
		}
		else if(list.length == 2){
			if(list[0]>list[1]){
				int temp = list[1];
				list[1] = list[0];
				list[0] = temp;
			}
		}else {
			int mid = list.length/2;
			int[] l1 = new int[mid];
			int[] l2 = new int[list.length-mid];
			for(int i=0;i<l1.length;i++){
				l1[i]=list[i];
			}
			for(int i=0;i<l2.length;i++){
				l2[i]=list[mid+i];
			}
			l1 = mergeSort(l1);
			l2 = mergeSort(l2);
			return merge(l1,l2);
		}
		return list;
	}
	
	public static int[] merge(int[] l1,int[] l2){
		int index1=0;
		int index2=0;
		int[] list = new int[l1.length + l2.length];
		for(int i=0;i<list.length;i++){
			//if the 2 pointers are still within the array
			if((index1<l1.length) && (index2<l2.length)){
				if(l1[index1]<l2[index2]){
					list[i]=l1[index1];
					index1++;
				} else {
					list[i]=l2[index2];
					index2++;
				}
			}else {
				if(index2<l2.length){
					list[i]=l2[index2];
					index2++;
				} else {
					list[i]=l1[index1];
					index1++;
				}
			}
		}
		return list;
	}
}
