package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성

public class WantCalendarApp {
	public static void main(String[] args) {
		
		Calendar calendar=Calendar.getInstance();
		Scanner scanner=new Scanner(System.in);
			System.out.println("년도를 입력하세요 : ");
			int year=scanner.nextInt();
			System.out.println("월을 입력하세요 : ");
			int month=scanner.nextInt();
			
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(year,month-1,1);
			
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("         "+calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월");
		System.out.println("==============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("==============================");
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			//날짜 출력 >> 자릿수 맞춤
			if(i <= 9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;
			
			if(week % 7 == 1) {//다음 출력값(일)이 일요일인 경우
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("============================");
	
	
	}
}
//Scanner scanner=new Scanner(System.in);