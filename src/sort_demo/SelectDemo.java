package sort_demo;

import java.util.Arrays;

public class SelectDemo {
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 5, 3, 6, 8, 4, 9 };
		System.out.println(Arrays.toString(arr));
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if(arr[x]>arr[y]){	
					int temp = arr[y];
					arr[y] = arr [x];
					arr[x] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		}
	
}