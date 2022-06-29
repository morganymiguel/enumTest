package kr.or.ddit.basic.enumTest;

public class EnumTest {

   /*
    * - enum(열거형) ==> 서로 관련있는 상수들의 집합
    *       ==> 클래스처럼 보이게 하는 상수 
    *       ==> 열거형은 클래스처럼 '독립된 java파일'에 만들수있고
    *          하나의 java파일에 클래스와 같이 들 수있다
    *          클래스 안에 내부클래스처럼 만들 수 있다.
    * 
    * -열거형의 속성 및 메서드
    * 1. name() ==> 열거형 상수의 이름을 문자열로 반환
    * 2. ordinal() ==> 열거형 상수가 정의된 순서값을 방문
    * 3. valueOf() ==> 지정된 열거형에서 '열거상수명'과 일치하는 열거형 상수를 반환
    * 4. 열거형이름.상수명 ==> valueof()메서드와 같다 
    * 5. 열거형이름.values() ==> 모든 상수들을 배열에 담아서 반환
    * 
    * - 열거형 선언하기
    *    방법1) 
    *       enum 열거형이름 {상수명1, 상수명2,....,상수명n}
    * 
    *    방법2) 각 상수에 임의의 값을 설정할 수 있다.
    *       enum 열거형 이름{
    *         상수명1(값들....),
    *         상수명2(값들....),
    *         상수명3(값들....),
    *         ....
    *         상수명n(값들....); //마지막에 세미콜론을 붙인다
    *
    *      //'값들'이 저장될 변수들을 선언한다(private로 한다.)
    *      //'값들'의 개수에 맞게 변수 선언을 한다.
    *      private 자료형 이름 변수명;
    *      ...
    *      ...
    *
    *      // 열거형의 생성자를 만든다.
    *      // 열거형의 생성자는 '열거형상수'에 '값들'을 셋팅하는 역할을 수행한다.
    *      // 열거형 생성자는 묵시적으로 'private'이다
    *
    *      //'변수명'은 '값들'의 개수와  같고, 각각의 자료형이 맞아야 한다.      
    *      private 열거형이름(자료형 이름 변수명,....){
    *         //위에 선언된 변수들을 초기화한다.
    *         ...
    *
    *      }
    *      
    *      // 구성된 '값들'을 외부에서 불러올 수 있도록 getter메서드를
    *      // 작성한다
    *   }   
    * 
    */
   
   public enum Color {RED, GREEN, BLUE}
   public enum Count {ONE, TWO, THREE}
   
   public enum Season{
      봄("3월부터 5월까지"), //상수명(값들) 형식의 상수 선언
      여름("6월부터 8월까지"),
      가을("9월부터 11월까지"),
      겨울("12월부터 2월까지");
      
      //값들이 저장될 변수 선언
      private String span;
      
      //생성자
      Season(String months){ // private Season(String months)과 같다
       //값들이 저장될 변수를 초기화 
         span= months;   
      }
      
      //getter메서드를 작성
      public String getSpan() {
         return span;
      }
      
      
   }
   
   public static void main(String[] args) {
      
      
   /*
      //final 상수 사용하기
      System.out.println("RED : "+ ConstTest.RED);
      System.out.println("THREE : "+ ConstTest.THREE);
      
      if(ConstTest.RED==ConstTest.THREE) {
         System.out.println("ㅋㅋㅋㅋㅋㅋ");
      }else {
         System.out.println("ㅎㅎㅎㅎㅎㅎ");
      }
    */
      Color mycol = Color.valueOf("GREEN");// == Color.GREEN과 같다
      Count mycnt = Count.ONE; // Count.valueOf("ONE")과 같다
      
      System.out.println("myCol : "+mycol.name());
      System.out.println("myCnt : "+mycnt.name());
      System.out.println();
      
      System.out.println("myCol ordinal : "+mycol.ordinal());//인덱스를 가져옴
      System.out.println("myCnt ordinal : "+mycnt.ordinal());
   
      /*
       * 서로 다른 종류의 일거형끼리의 비교는 불가!!
      if(Color.BLUE==Count.TWO) {
         System.out.println("&&&&&&&&&&");
      }
      */
      
      if(mycol == Color.BLUE) {
         System.out.println("같다...");
      }
      
      //열거형을 switch문으로 비교할때는
      //case문에 지정하는 상수는 '열거형이름.상수명'에서
      //'열거형이름'을 생략한 '상수명'만 기술
      switch(mycol) {
         case RED : 
            System.out.println("red..."); 
            break;
         case GREEN : 
            System.out.println("green...");
            break;
         case BLUE : 
            System.out.println("blue...");
            break;
      
      }
      System.out.println("--------------------------------");
   
      Season ss = Season.valueOf("봄");
      System.out.println("name : "+ss.name());
      System.out.println("ordinal : "+ ss.ordinal());
      System.out.println("span : "+ss.getSpan());
      System.out.println();
   
      for(Season time : Season.values()) {
         System.out.println(time.name()+" == "+time+"--->"+time.getSpan());
      }
      System.out.println();
      
      for(Color col : Color.values()) {
         System.out.println("col ==>"+col.ordinal());
      }
   }
}