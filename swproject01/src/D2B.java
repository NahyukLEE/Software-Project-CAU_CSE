/**
* 강의 및 교수 : 소프트웨어프로젝트 03 분반 / 박창윤 교수님
* 작성자 : 이나혁_20194538 (nahyuk0113@cau.ac.kr)
* 소속 : 중앙대학교 소프트웨어학부 2 학년
* 코드 작성일 : 2020 년 3 월 25 일
* 설명 : int 타입의 10 진수 정수를 입력 받아 2 진수 표기로 변환시키는 프로그램
*/

public class D2B {
	
    // main 메소드
    public static void main(String args[]) {
		
        // 프로그램 동작 확인 테스트
        System.out.println("Decimal 0 -> " + d2b(0));
        System.out.println("Decimal 1 -> " + d2b(1));
        System.out.println("Decimal 7 -> " + d2b(7));
        System.out.println("Decimal 16 -> " + d2b(16));
        System.out.println("Decimal 255 -> " + d2b(255));
        }
		
    // Decimal to Binary 계산 메소드
    static String d2b(int n) {
		
        int i, k; // for 문 동작에 필요한 변수 선언
        int result[] = new int[20]; // 2 진수 변환 결과를 역순으로 저장할 배열 선언
		
        String s=""; // d2b 메소드에서 반환할 결과를 String 형으로 선언
		
        // 10 진수가 0 이 아닌 경우
        if (n != 0) {
			
            // 10 진수 n 을 2 로 나눈 나머지를 result 배열에, 몫을 n 에 저장
            for (i=0; n>0; i++) {
                result[i] = n % 2;
                n = n / 2;
            }
            // result 배열 요소를 역순으로 문자열 s 에 저장
            for (k=i-1; k>=0; k--) {
                s = s + result[k] + " ";
            }
        }
		
        // 10 진수가 0 인 경우
        else
            s = "0";
		
        // d2b 메소드 리턴(2 진수 나열 결과)
        return s;
    }
}