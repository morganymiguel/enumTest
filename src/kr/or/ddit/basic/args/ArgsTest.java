package kr.or.ddit.basic.args;

public class ArgsTest {
   //매개변수로 받는 정수의 개수는 실행할 때 마다 다를 수 있는데
   //메서드에서는 이 정수들의 합계를 구하고자 한다.
   
   
   //배열을 이용한 메서드
   public int sumArr(int[]data) {
      int sum = 0;
      for(int i =0; i<data.length;i++) {
         sum+=data[i];
      }
      
      return sum;
   }
   
//   public void myMetthod(int a) {
//      
//   }
   
   //가변형 인수 ==> 메서드의 인수값의 개수가 실행될 때 마다 다를 때 사용한다.
   //      - 가변형 인수는 메서드 안에서는 배열로 처리된다.
   //       - 가변형 인수는 한 메서드에서 한 자료형만 사용할 수 있다.
   
   
   
   //가변형 인수(파라미터)
   //데이터 타입 뒤에 '...'은 가변형 인수를 나타냄
   public int sumArg(int...data) {
      int sum = 0;
      for(int i =0; i<data.length;i++) {
         sum+=data[i];
      }
      return sum;
   }
   
   //가변형 인수와 일반적인 인수를 같이 사용할 경우에는 
   //가변형 인수를 제일 뒤쪽에 배치해야 한다.
   //==>가변형 인수가 앞에 있을 때, 그 안에 몇 개가 담길지 명확하기 않기 때문에.
   public String sumArg2(String name, int...data) {
      int sum = 0;
      for(int i =0; i<data.length;i++) {
         sum+=data[i];
      }
      return name+ "씨 점수 : " +sum;
   }
   
   
   public static void main(String[] args) {
      ArgsTest test = new ArgsTest();
      int [] nums = {100,200,300};
      
      int [] nums2;
      //nums2= = {100,200,300}; 잘못된 방법 이런형식은 선언과 동시에 초기화 할 때만 가능!
      nums2 = new int[]{100,200,300};
      
      
      System.out.println(test.sumArr(nums));
      System.out.println(test.sumArr(new int[]{1,2,3,4,5}));
      System.out.println();
      
      System.out.println(test.sumArg(100,200,300));
      System.out.println(test.sumArg(1,2,3,4,5));
      System.out.println();
      
      System.out.println(test.sumArg2("홍길동", 1,2,3,4,5));
      
      
      
      /*
      test.myMetthod(100);
      int b=200;
      test.myMetthod(b);
      */
      
      
      
      
      
   }

}