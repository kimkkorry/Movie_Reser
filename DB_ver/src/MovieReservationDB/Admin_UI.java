package MovieReservationDB;

import java.io.IOException;
import java.util.Scanner;


public class Admin_UI {
	
	public void PromptAdmin() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		Admin_UI_Theater theater = new Admin_UI_Theater();
		Admin_UI_Screen screen = new Admin_UI_Screen();
		Admin_Inquiry inquiry = new Admin_Inquiry();
		
		String Admin_Prompt = """
				[30VI8]
				관리자모드
				=========================
				=  1. 상영 영화 관리  \t=
				=  2. 지점 관리  \t\t=
				=  3. 상영관 관리  \t=
				=  4. 상영 관리  \t\t=
				=  5. 데이터 조회 및 출력  \t=
				=  6. 메뉴 화면으로 돌아가기 \t=
				=========================      
				원하는 메뉴를 선택하세요. : """;

		outer:
			while ( true ) {
				System.out.println("\n");
				System.out.print(Admin_Prompt);
				String select = sc.next();
				sc.nextLine();
				
				switch(select) {
					case "1" :
						PromptMovie();
						break;
					case "2" :
						screen.PromptMoviecenter();
						break;
					case "3" :
						theater.PromptTheater();	
						break;
					case "4" :
						screen.PromptScreen();
						break;
					case "5" :
						inquiry.PromptInquiry();
						break;
					case "6" :
						break outer;
					default :
						System.out.print("올바른 번호를 입력해주세요 : ");
						break;
				}	// switch문의 끝
			}	// while문의 끝
	}	// PromptAdmin()의 끝
	
	public void PromptMovie() {
		
		Admin_Movie Movie = new Admin_Movie();
		Scanner sc = new Scanner(System.in);
		
		String Admin_Movie_Prompt = """
				[30VI8]
				< 상영 영화 관리 >
				=========================
				=  1. 새 영화 등록  \t=
				=  2. 영화 정보 수정  \t=
				=  3. 기존 영화 삭제  \t=
				=  4. 관리자 메뉴로 돌아가기\t=
				=========================      
				원하는 메뉴를 선택하세요 : """;
		
		outer:
			while ( true ) {
				System.out.println("\n");
				System.out.print(Admin_Movie_Prompt);
				String select = sc.next();
				sc.nextLine();
				
				switch(select) {
					case "1" :
						Movie.add();
						break;
					case "2" :
						Movie.change();
						break;
					case "3" :
						Movie.delete();
						break;
					case "4" : 
						break outer;
					default :
						System.out.println("올바른 번호를 입력해주세요.");
						break;
				}	// switch문의 끝
			}	// while문의 끝
		
	}	// PromptMovie()의 끝
	
}