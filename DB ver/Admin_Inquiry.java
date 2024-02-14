package TeamC_Movie;

import java.io.IOException;
import java.util.Scanner;

public class Admin_Inquiry {
	public void PromptInquiry() throws IOException{
		Scanner scanner = new Scanner(System.in);
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
		int num = scanner.nextInt();
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
