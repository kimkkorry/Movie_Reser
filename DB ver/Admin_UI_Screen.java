package TeamC_Movie;

import java.util.Scanner;

public class Admin_UI_Screen{
	Scanner sc = new Scanner(System.in);
	
	public void PromptScreen() { //상영 프롬프트
	Admin_Screen Screen = new Admin_Screen();
	String ScreenPrompt = """
			[30VI8]
			상영 관리
			=========================
			=  1. 새 상영 등록 \t= 
			=  2. 기존 상영 삭제\t=
			=  3. 관리자 메뉴로 돌아가기\t=
			=========================
			원하는 메뉴를 선택하세요. : """;
	outer:
		while(true){
			System.out.println("\n");
			System.out.print(ScreenPrompt);
			int num = sc.nextInt();
			switch(num) {
			case 1:
				Screen.add();
				break;
			case 2:
				Screen.delete();
				break;
			case 3:
				break outer;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;	
			}
		}
	}
	
	public void PromptMoviecenter() { //지점 프롬프트
	Admin_Moviecenter Moviecenter = new Admin_Moviecenter();	
	String MoviecenterPrompt = """
			[30VI8]
			지점 관리
			=========================
			=  1. 새 지점 등록 \t=
			=  2. 지점 정보 수정\t=
			=  3. 기존 지점 삭제\t=
			=  4. 관리자 메뉴로 돌아가기\t=
			=========================
			원하는 메뉴를 선택하세요. : """;
	outer:
		while(true){
			System.out.println("\n");
			System.out.print(MoviecenterPrompt);
			int num = sc.nextInt();
			switch(num) {
			case 1:
				Moviecenter.add();
				break;
			case 2:
				Moviecenter.change();
				break;
			case 3:
				Moviecenter.delete();
				break;
			case 4:
				break outer;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;	
			}
		}
	}
}
