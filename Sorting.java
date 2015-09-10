import java.util.*;
public class Sorting{
	public static void main(String[] args){
	int[] array = {9,7,8,5,6,4,2,3,1,};
		System.out.println(Arrays.toString(mergeSort(array)));
	}
	
	public static void bubbleSort(int[] list){
		boolean sorted = true;
		int tmp =0;
		while(sorted){
			sorted=false;
			for(int i=1;i<list.length;i++){
				if(list[i-1]>list[i]){
					tmp = list[i];
					list[i]=list[i-1];
					list[i-1]=tmp;
					sorted=true;
				}
			}
		}
	}

	public static int[] mergeSort(int[] list){
		if(list.length<=1){
			return list;
		}
		else{
			int mid = list.length/2;
			int[] l1 = new int[mid];
			int[] l2 = new int[list.length-mid];
			for(int i=0;i<l1.length;i++){
				l1[i]=list[i];
			}
			for(int i=0;i<l2.length;i++){
				l2[i]=list[mid+i];
			}
			list = merge(mergeSort(l1),mergeSort(l2));
			return list;
		}
	}
	
	public static int[] merge(int[] l1,int[] l2){
		int index1=0;
		int index2=0;
		int[] list = new int[l1.length + l2.length];
		for(int i=0;i<list.length;i++){
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
