package step3_01.arrayAdvanced;

import java.util.Scanner;

/*
 * 
 * # 배열 컨트롤러[2단계] : 어레이리스트(ArrayList)
 * 분석(이해) > 모방(타이핑)  프로그래밍(반복숙달)
 * 배열의 존재적 한계점: 크기가 불변함 ->(개선) : ArrayList 
 * 
 *
 * 
 *
 * 1. 추가
 * . 데이터를 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 데이터 삭제
 * 3. 삭제(데이터)
 * . 데이터를 입력받아 삭제
 * . 없는 데이터 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 데이터을 입력받아 삽입
 * 
 */



public class ArrayEx35 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // scanner 
		
		int[] arr = null;  // arr 배열 초기값 설정 
		int elementCnt = 0; // elementcnt = 요소 정의 
		
		while (true) {		// 규칙설정 
			
			for (int i = 0; i < elementCnt; i++) { // 규칙: 반복되는 i가 순차적으로 배열된다 
				System.out.print(arr[i] + " ");
			}
			System.out.println();				// 한칸띄고 
			
			System.out.println("[어레이리스트 컨트롤러]"); // 메뉴반복 1,2,3,4,0
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(데이터)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");			// 안내문구->입력값을 받는다 (메뉴선택)
			int sel = scan.nextInt();
			
			if (sel == 1) {					// 1번 메뉴선택을 한 경우 
				if (elementCnt == 0) {		// 요소가 0
					arr = new int[elementCnt + 1]; // 배열에서 요소 +1 
				}
				else if (elementCnt > 0){	//요소가 0보다 큰 경우
					int[] temp = arr;       // 배열 arr->temp
					arr = new int[elementCnt + 1];  // 배열 arr: 새로운 요소 + 1 
					
					for (int i = 0; i < elementCnt; i++) {  // 순차적으로 진행이됨 (i)
						arr[i] = temp[i];					// arr[i] 배열과 temp[i]배열 동일시 
					}
					
					temp = null; // temp 버린다 (초기화)  
				}
				System.out.print("[추가]데이터 입력 : ");  // 안내문구 -> 입력값을 받는다 (추가할 데이터) 
				int data = scan.nextInt();
				
				arr[elementCnt] = data; // 배열 arr[요소] data에 넣는다
				elementCnt++;			// 요소가 축적된다(저장됨)  
			}
			else if (sel == 2) {	// 2번메뉴선택
				System.out.print("[삭제]인덱스 입력 : "); // 안내문구 -> 입력값을 받는다 (삭제할 인덱스 입력) 
				int delIdx = scan.nextInt();
				
				if (elementCnt - 1 < delIdx || delIdx < 0) {  // 삭제할 인덱스가 -1보다 크거나 0보다 작은경우 
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다."); // 오류메세지 
					continue; // 위의 조건이 계속되는 경우 반복함 
				}
				
				if (elementCnt == 1) {  // 요소가 1인경우
					arr = null;			// arr을 초기화 
				}
				else if (elementCnt > 1) {	// 요소가 1보다 큰 경우
					int[] temp = arr;		// arr->temp 
					arr = new int[elementCnt - 1]; // arr: 요소 -1 
					
					for (int i = 0; i < delIdx; i++) { // 순차적으로 진행됨 (i)
						arr[i] = temp[i];				//  배열 arr[i], 배열 temp[i] 둘다 적용됨 
					}
					for (int i = delIdx; i < elementCnt - 1; i++) { // 순차적으로 삭제됨(i) , 입력하려고 했던 값이 적용됨 
						arr[i] = temp[i + 1];						// 배열 arr[i],배열temp[i+1] 둘다 적용됨 
					}
					temp = null;									//temp 버린다(초기화) 
				}
				
				elementCnt--;									//삭제처리함(삭제할 데이터는 축적이됨) 
			}
			else if (sel == 3) { //3번메뉴선택 
				System.out.print("[삭제]데이터 입력 : "); // 안내문구 -> 입력값을 받는다 
				int delData = scan.nextInt();
				
				int delIdx = -1;						// delIdx라는 요소를 정의 
				for (int i = 0; i < elementCnt; i++) {	// 순차적으로 진행이 됨 (i)
					if (arr[i] == delData) {			// 배열 arr[i]와 입력값이 같은 경우 
						delIdx = i;						// delIdx는 i
					}
				}
				
				if (delIdx == -1) {						// delIdx가 -1인 경우 
					System.out.println("[메세지]입력하신 데이터는 존재하지 않습니다."); // 오류메세지
					continue; 															// 위의 조건이 계속 반복되는 경우 반복함 
				}
				
				if (elementCnt == 1) {						// 요소가 1인경우 
					arr = null;								// arr을 버린다 (초기화) 
				}
				else if (elementCnt > 1) {				//요소가 1보다 큰경우 
					int[] temp = arr;					// arr -> temp 
					arr = new int[elementCnt - 1];		// arr : 요소 -1 
					
					int j = 0;							// j를 정의함 
					for (int i = 0; i<elementCnt; i++) { // 순차적으로 반복 (i)
						if (i != delIdx) {				// 반복되는 값(i)이 delIdx가 아닌 경우에는
							arr[j++] = temp[i];			// arr(j++)를 temp와 동일시
						}
					}
					
					temp = null;					//temp값을 버린다 (초기화) 
				}
				
				elementCnt--;						//데이터 삭제함 삭제할 데이터는 축적이됨) 
			}
			else if (sel == 4) { // 4번메뉴선택 
				System.out.print("[삽입]인덱스 입력 : "); // 안내문구 -> 입력값 받는다 (삽입할 인덱스) 
				int insertIdx = scan.nextInt();
				
				if (elementCnt < insertIdx || insertIdx < 0) { // insertIdx가 요소보다 크거나(or) insertIdx가 0보다 작은 경우에는 
					System.out.println("[메세지]해당 위치는 삽입할 수 없습니다."); // 오류메세지 
					continue;													// 위 조건이 반복되는 경우 메세지 반복함 
				}
				
				System.out.print("[삽입]데이터 입력 : "); // 안내문구 -> 입력값 받는다 (삽입할 데이터) 
				int insertData = scan.nextInt();
				
				if (elementCnt == 0) { 					// 요소가 0인경우 
					arr = new int[elementCnt + 1];		// arr: 요소 +1 
				}
				else if (elementCnt > 0) {			// 요소가 0보다 큰 경우
					int[] temp = arr;				// arr->temp 
					arr = new int[elementCnt + 1];	// arr: 요소 + 1 
					
					int j = 0;						// j값을 정의함 
					
					for (int i = 0; i < elementCnt + 1; i++) { // 순차적으로 반복함 (i)  
						if (i != insertIdx) { 				// 반복되는 i가 insertIDX가 아닌경우 (삽입할 데이터가 아닌경우에는)  
							arr[i] = temp[j++];				// arr[i]배열을 temp[j++]와 동일시
						}
					}
					temp = null;							// temp를 버린다 			
				}
				
				arr[insertIdx] = insertData;			// arr[inserIdx] 배열을 insertData와 동일시 
				elementCnt++;							// 데이터 값을 저장(축적)
			}
			else if (sel == 0) {						// 입력값이 0인경우
				break;									// 종료 
			}
		}

		scan.close();

	}

}