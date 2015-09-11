public class Bubblesort{
	public static void main(String args[]){
		int[] arr = new int[30];
		Random a = new Random();
		for(int i = 0; i<30; i++){
			arr[i] = a.nextInt(100);
		}
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
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
}