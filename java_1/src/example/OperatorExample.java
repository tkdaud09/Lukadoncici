package example;

public class OperatorExample {
   public static void main(String[] args) {
      //245678초를 일시분초 형식으로 변환하여 출력하세요.
      int sec=245678;
      int day=sec/(24*60*60);
      int hour=sec/(60*60);
      int minute=sec % (60*60)/60;
      int second=sec % 60;
      System.out.println(day+"일 "+hour+"시 "+minute+"분 "+second+"초");

      System.out.println("===============================================");
      //한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
      //단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
      int cnt=20;
      double exp=1.5;
      
      System.out.println("총금액 = "+(cnt>=15?(exp*cnt)*(75.0/100.0):(exp*cnt))+"억");      
      //System.out.println(cnt>=15?sum(exp*cnt)*(25/100):sum(exp*cnt));
   
      System.out.println("===============================================");
   }
}