package step3_01.arrayAdvanced;

import java.util.Arrays;

// 배열의 주소 
public class ArrayEx34 {

	public static void main(String[] args) {
// 1과 2 비교!
// 1.		
		int var1 = 10;
		int var2 = var1; // 데이터를 대입
		
		var1 = 777;
		
		System.out.println("Var1 : " + var1);
		System.out.println("Var2 : " + var2);
		System.out.println();
		
// 2. 		
		int[] arr = {87, 100, 24, 11,79};
		int[] temp = arr; // 주소를 대입
		
		System.out.println("arr :" + arr);
		System.out.println("temp :" + temp);
		
		arr[0] = -1;
		temp[1] = -1;
		arr[2] = -1;
		temp[3] = -1;
		arr[4] = -1;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(temp));
	}

}
