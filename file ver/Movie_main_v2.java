package Movie_Reservation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Movie_main_v2 {
public static void main(String[] args) throws IOException{
	Scanner scanner = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	Account_Main account = new Account_Main();
	Admin_menu_v2 admin = new Admin_menu_v2();
	String prompt = """
			==========================
			=                        =
			=      영화 예매 프로그램     =
			=                        =
			=        1. 영화 예매       =
			=      2. 예매 내역 조회     =
			=        3. 예매 취소       =
			=    4. 전체 영화 자리 조회   =
			=    5. 회원가입 및 로그인     =
			=        6. 끝내기         =
			=                        =
			==========================
			""";
	String id = "";
	outer:
		while (true) {
			System.out.println(prompt);
			int num = scanner.nextInt();
			switch(num) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
			
				break;
			case 5:
				id = account.account_main();
				break;
			case 6:
				break outer;
			case 501:
				admin.admin_menu();
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				break;
			}
			
		}
}
}
