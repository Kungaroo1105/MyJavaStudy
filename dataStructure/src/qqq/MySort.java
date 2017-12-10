package qqq;

public class MySort {
	//不知道是啥排序，凭感觉写的
	public static void sort(int[] array){
		for(int i = 0;i<array.length;i++){
			for(int j = i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
	//选择排序
	public static void selectedSort2(int[] array){
		for(int i = 0;i < array.length;i++){
			int tmp = i;
			for(int j = i+1;j<array.length;j++){
				if(array[tmp] > array[j]){
					tmp = j;
				}
			}
			int tmp1 = array[i];
			array[i] = array[tmp];
			array[tmp] = tmp1;
			System.out.print("第"+(i+1)+"趟排序结果： ");
			for(int k = 0;k<array.length;k++){
				System.out.print(array[k]+" ");
			}
			System.out.println();
		}
	}

	//插入排序
	public static void insertSort(int[] array){
		if(array!= null){
			for(int i = 1;i<array.length;i++){
				int tmp = array[i];
				int j = i;
				while(j>0 && tmp < array[j-1] ){
					array[j] =  array[j-1];
					j--;
				}
				array[j] = tmp;
				System.out.print("第"+(i)+"趟排序结果： ");
				for(int k = 0;k<array.length;k++){
					System.out.print(array[k]+" ");
				}
				System.out.println();
				
			}
		}
	}
	//冒泡排序
	public static void bubbleSort(int[] array){
		for(int i = 0;i<array.length;i++){
			for(int j= 0;j<array.length-i-1;j++){
				if(array[j] > array[j+1])
				{
					int tmp  = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp; 
				}
			}
			System.out.print("第"+(i+1)+"趟排序结果： ");
			for(int k = 0;k<array.length;k++){
				System.out.print(array[k]+" ");
			}
			System.out.println();
		}
	}
	//归并排序
	 public static void merge(int[] array,int p,int q,int r){
		 int len1 = q-p+1;
		 int len2 = r-q;
		 int[] tmp_array1 = new int[len1];
		 int[] tmp_array2 = new int[len2];
		 for(int i =0,j = p;i<len1;i++,j++){ 
			 tmp_array1[i] = array[j];
		 }
		 for(int i =0,j = q+1;i<len2;i++,j++){
			 tmp_array2[i] = array[j];
		 }
		 int k = p;
		 int i = 0,j = 0;
		 for(;i<len1 && j <len2;k++){
			 if(tmp_array1[i] < tmp_array2[j]){
				 array[k] = tmp_array1[i];
				 i++;
			 }else{
				 array[k] = tmp_array2[j];
				 j++;
			 }
		 }
		 if(i <len1){
			 for(;i<len1;i++){
				 array[k] = tmp_array1[i];
				 k++;
			 }
		 }
		 if(j <len2){
			 for(;j<len2;j++){
				 array[k] = tmp_array2[j];
				 k++;
			 }
		 }
	 }
	 public static void mergeSort(int[] array,int start,int end){
		 if(start <end){
			 int tmp = (start + end)/2;
			 mergeSort(array, start, tmp);
			 mergeSort(array, tmp+1, end);
			 merge(array, start, tmp, end);
		 }
	 }
	 //快速排序
	 public static void quickSort(int[] array,int start,int end){
		 if(start >end)
			 return;
		 int i = start;
		 int j = end;
		 int tmp = array[i];
		 while(i<j){
			 while(i<j && array[j]> tmp){
				 j--;
			 }
			 if(i <j)
				 array[i] = array[j];
			 while(i<j&& array[i] <tmp){
				 i++;
			 }
			 if(i<j){
				 array[j] = array[i];
			 }
		 }
		 array[i] = tmp;
		 quickSort(array,start,i-1);
		 quickSort(array,i+1,end);
	 }
	 
	 //希尔排序
	 public static void shellSort(int[] array){
		 int length = array.length;
		 int temp,i,j;
		 int h;//步长
		 for(h=length/2;h>0;h/=2){
			 for(i = h;i<length;i++){
				 temp = array[i];
				 for(j = i-h;j>=0;j= j-h){
					 if(temp < array[j])
						 array[j+h] = array[j];
					 else break;
				 }
				 array[j+h] = temp;
			 }
		 }
	 
	 }
	 
	 public static void adjustMaxHeap(int[] array,int pos,int len){
		 int temp ;
		 int child;
		 
		 for(temp = array[pos];2*pos+1 <=len;pos = child){
			 child = 2*pos+1;
			 if(child <len&&array[child] < array[child+1])
				child++;
			 if(array[child] > temp){
				 array[pos] = array[child];
			 }else break;
			
		 }
		 array[pos] = temp;
	 }
	  public static void heapSort(int[] array){
		  int len = array.length;
		  //初始化堆
		  for(int i = len/2 -1;i>=0;i--){
			  adjustMaxHeap(array, i, len-1);
		  }
		  //堆排序  每次把堆的最后一个数和堆顶元素交换，然后在调整堆
		  for(int i = len-1;i>=0;i--){
			  int tmp = array[0];
			  array[0] =  array[i];
			  array[i] = tmp;
			  adjustMaxHeap(array,0,i-1);
		  }
	  }
	  
	  //求最大子数组之和-蛮力法
	  public static int getMaxSubArray1(int[] array){
		  int max = array[0];
		  for(int i = 0;i<array.length;i++){
			  if(array[i] >max)
				  max = array[i];
		  }
		  for(int i= 0;i <array.length;i++){
			  int sum =0;
			  for(int j = i;j<array.length;j++){
				  sum += array[j];
				  if(sum > max)
					  max = sum;
			  }
		  }
		  return max;
	  }
	  //求最大子数组之和-动态规划
//	  public static int getMaxSubArray2(int[] array){
//		  int
//		  int max = array[0];
//		  for(int i = 0;i<array.length;i++){
//			  if(array[i] >max)
//				  max = array[i];
//		  }
//		  for(int i= 0;i <array.length;i++){
//			  int sum =0;
//			  for(int j = i;j<array.length;j++){
//				  sum += array[j];
//				  if(sum > max)
//					  max = sum;
//			  }
//		  }
//		  return max;
//	  } 
	 
		public static void main(String[] args) {
			int[] array = {1,-2,4,8,-4,7,-1,-5};
			int result = getMaxSubArray1(array);
//			for(int i = 0;i<array.length;i++){
//				System.out.print(array[i]+" ");
//			}
			System.out.print(result);
			System.exit(0);
			
//			int a = 0,c =0;
//			do{
//				--c;
//				a = a-1;
//			}while(a>0);
//			System.out.println(c);
		}
}
