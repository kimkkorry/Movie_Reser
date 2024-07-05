package MovieReservationDB;

import java.io.IOException;
import java.util.Scanner;

public class Movie_main_v2 {
public static void main(String[] args) throws IOException{
	Scanner scanner = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	Account_Main account = new Account_Main();
	Add_reser reser = new Add_reser();
	See_mov_cen see = new See_mov_cen();
	Reservation_cancel cancel = new Reservation_cancel();
	Admin_UI adminUI = new Admin_UI();
	String ID = "";
	String moviecode = "";
	String centercode = "";
	
	outer:
		while (true) {
			String prompt = """
				[30VI8]
				영화 예매 관리 시스템
				=========================
				=  1. 영화별 조회   \t\t=
				=  2. 극장별 조회   \t\t=
				=  3. 빠른 예매   \t\t=
				=  4. 예매 조회 및 취소   \t=
				""";
			if (ID.equals("")) {
				prompt += """
				=  5. 로그인 및 회원 가입   \t=
				=  6. 프로그램 종료   \t=
				=========================
				원하는 메뉴를 선택하세요 : """;
			}
				//비회원예매
			else {
				prompt += """
				=  5. 마이페이지   \t=
				=  6. 로그아웃   \t\t=
				=  7. 프로그램 종료   \t=
				=========================
				원하는 메뉴를 선택하세요 : """;
			}
			System.out.print(prompt);
			int num = scanner.nextInt();
			switch(num) {
			
			case 1:
				moviecode = see.seemovie();
				//영화별 조회
				break;
			case 2:
				centercode = see.seecenter();
				//극장별 조회
				break;
			case 3:
				//빠른 예매
				reser.addreser(ID, moviecode, centercode);
				break;
			case 4:
			System.out.println("예매 조회는 '1'번\n예매취소는 '2'번을 눌러주세요.");
			int numm = scanner.nextInt();
			if (numm == 1)
			cancel.lookreser(ID);
			else if (numm==2)
				cancel.cancelreser(ID);
			else
				System.out.println("올바른 번호를 입력해주세요.");
				//예매 조회 및 취소
				break;
			case 5:
				if (ID.equals("")) 
				ID = account.account_main();
				
				else 
					ID = see.seemypage(ID);
					//마이페이지 함수
				//비회원 - 로그인 및 회원가입
				//회원 - 마이페이지
				break;
			case 6:
				if (ID.equals("")) 
					break outer;
				else {
					ID = "";
				break;
				}
			case 7:
				if (ID.equals("")) {
					System.out.println("올바른 번호를 입력해주세요.");
				break;
				}
				else
					break outer;
			case 501:
				adminUI.PromptAdmin();
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;
			}
			
		}
}
}
