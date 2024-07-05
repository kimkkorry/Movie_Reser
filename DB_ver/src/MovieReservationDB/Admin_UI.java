package MovieReservationDB;

import java.io.IOException;
import java.util.Scanner;


public class Admin_UI {
	Scanner sc = new Scanner(System.in);
	
	public void PromptAdmin() throws IOException{
		
		String Admin_Prompt = """
				[30VI8]
				관리자모드
				=========================
				=  1. 상영 영화 관리  \t=
				=  2. 지점 관리  \t\t=
				=  3. 상영관 관리  \t\t=
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
						PromptMoviecenter();
						break;
					case "3" :
						PromptTheater();	
						break;
					case "4" :
						PromptScreen();
						break;
					case "5" :
						PromptInquiry();
						break;
					case "6" :
						break outer;
					default :
						System.out.print("올바른 번호를 입력해주세요 : ");
						break;
				}	
			}	
	}	
	
	public void PromptMovie() {
		Admin_Movie Movie = new Admin_Movie();
		
		String Admin_Movie_Prompt = """
				[30VI8]
				< 상영 영화 관리 >
				=========================
				=  1. 새 영화 등록  \t\t=
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
				}	
			}	
		
	}	
	public void PromptScreen() { 
		Admin_Screen Screen = new Admin_Screen();
		String ScreenPrompt = """
				[30VI8]
				상영 관리
				=========================
				=  1. 새 상영 등록 \t\t= 
				=  2. 기존 상영 삭제\t\t=
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
				=  1. 새 지점 등록 \t\t=
				=  2. 지점 정보 수정\t\t=
				=  3. 기존 지점 삭제\t\t=
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
		public void PromptTheater() {
			Admin_Theater AT = new Admin_Theater();

			String TheaterPrompt = """
				[30VI8]
				상영관 관리
				=========================
				=  1. 새 상영관 등록\t\t=
				=  2. 상영관 정보 수정\t\t=
				=  3. 기존 상영관 삭제\t\t=
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
		public void PromptInquiry() throws IOException{
			Make_file file = new Make_file();
		
			String Admin_Prompt = """
				[30VI8]
				데이터 조회 및 출력
				=========================
				=  1. 상영 영화 조회 / 출력\t=
				=  2. 예매 내역 조회 / 출력\t=
				=  3. 관리자 메뉴로 돌아가기 \t=
				=========================      
				원하는 메뉴를 선택하세요 : """;
		
		outer : 
		while(true) {
			System.out.println("\n");
			System.out.print(Admin_Prompt);
			int num = sc.nextInt();
			switch(num) {
			case 1:
				file.movielist();
				break;
			case 2:
				file.reserlist();
				break;
			case 3:
				break outer;
				default:
					break;
			}
		}
	}
	
}