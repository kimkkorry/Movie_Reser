package  TeamC_Movie;

import java.util.Scanner;

public class Admin_UI_Theater {
	Scanner sc = new Scanner(System.in);
	public void PromptTheater() {
		Admin_Theater AT = new Admin_Theater();

		String TheaterPrompt = """
			[30VI8]
			상영관 관리
			=========================
			=  1. 새 상영관 등록\t=
			=  2. 상영관 정보 수정\t=
			=  3. 기존 상영관 삭제\t=
			=  4. 관리자 메뉴로 돌아가기\t=
			=========================
			원하는 메뉴를 선택하세요 : """ ;
		
		out: while(true) {
			System.out.println("\n");
			System.out.print(TheaterPrompt);
			int num = sc.nextInt();
			sc.nextLine();
			switch(num) {
				case 1:
					AT.add();
					break;
				case 2:
					AT.change();
					break;
				case 3:
					AT.delete();
					break;
				case 4:
					break out;
				default :
					System.out.println("입력이 잘못되었습니다.");
					break;
			}
		}
	}
}


