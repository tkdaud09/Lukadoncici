package xyz.itwill.util;

import java.util.Calendar; 

//현재 년월에 대한 달력을 출력하는 프로그램 작성
public class CurrentCalendarApp {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		
		calendar.set(Calendar.DATE, 1);
		
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		//System.out.println("week = "+week);
		
		System.out.println("          "+calendar.get(calendar.YEAR)+"년"
				+(calendar.get(calendar.MONTH)+1)+"월");
		System.out.println("==============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("==============================");
		
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		for(int i=1;i<=calendar.getActualMaximum(calendar.DATE);i++) {
			if(i<=9) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;
			
			if(week % 7 == 1 ) {
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println("==============================");
		
	}
}
