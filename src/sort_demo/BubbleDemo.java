package sort_demo;

import java.util.Arrays;

public class BubbleDemo {

	public static void main(String[] args) {
		int arr[] = new int[] { 7, 8, 3, 5, 1, 4, 0, 9 };
		System.out.println(Arrays.toString(arr));
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length -x- 1; y++) {
				if (arr[y] > arr[y + 1]) {
					int temp = arr[y+1];
					arr[y+1] = arr[y];
					arr[y] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
