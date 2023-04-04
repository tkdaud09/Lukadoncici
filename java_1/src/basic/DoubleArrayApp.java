package basic;

//2차원 배열 : 1차원 배열의 모임
public class DoubleArrayApp {
	public static void main(String[] args) {
		//형식) 자료형[][] 참조변수 = new 자료형 [행갯수][열갯수];
		// => 행갯수 : 2차원 배열에 생성되는 1차원 배열의 갯수
		// => 열갯수 : 1차원 배열에 생성되는 요소의 갯수 
		int[][] num=new int[2][3];
		
		System.out.println("num = "+num);
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1]= "+num[1]);
		System.out.println("==================================================================");
		//2차원 배열에서는 값이 저장된 요소에 접근하기 위해 첨자를 2개 사용
		System.out.println("num[0][0] = "+num[0][0]);
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);
		
		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("==================================================================");
		System.out.println("num.length = "+num.length);
		System.out.println("num[0].length = "+num[0].length);
		System.out.println("num[1].length = "+num[1].length);
		System.out.println("==================================================================");
		for(int i=0;i<num.length;i++) {//1차원 배열(행)을 일괄처리 하기 위한 반복문
			for(int j=0;j<num[i].length;j++) {//요소(열)를 일괄처리 하기 위한 반복문
				System.out.print(num[i][j]+"\t");
			}
			System.out.println();//일괄처리! for문 2개
		}
		System.out.println("==================================================================");
		//int[][] su=new int[][] {{10,20,30},{40,50,60},{70,80,90}}; >> 정석
		int[][] su={{10,20,30},{40,50,60},{70,80,90}}; // >> 간편
		
		for(int[] array : su) {
			for(int temp : array) {
				System.out.print(temp+"\t");
			}
			System.out.println();
		}
		System.out.println("==================================================================");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
}
