package TeamC_Movie;

import java.util.ArrayList;
import java.util.Scanner;
public class Admin_Theater extends Admin_Class {
	
	Scanner sc = new Scanner(System.in);
	DAO_Theater dt = new DAO_Theater();
	ArrayList<String> thecodes = new ArrayList<>(); // theatercode 리스트
	Look_tables look = new Look_tables();
	DBconnectMov db = new DBconnectMov();
	
	public String makecode() { // 코드생성 메소드
		ArrayList<DTO_Theater> theaters = dt.getTheater();
		
		String tmp = "";
		if( theaters.size() >= 1 ) { tmp = theaters.get(theaters.size()-1).getTheatercode(); }
		String theatercode = "";
		if(tmp.equals(""))
			theatercode = "T001";
		else {
			int theacodenum = Integer.parseInt(tmp.substring(1));
			theacodenum ++;
			
			if(theacodenum < 10) {
				theatercode = "T00" + theacodenum; }
			else if(10 <= theacodenum && theacodenum < 100) {
				theatercode = "T0" + theacodenum;}
			else { theatercode = "T" + theacodenum; }
		}
		return theatercode;
	}

	public void add() { // Theater Table 데이터 추가
		System.out.println("\n\n< 새 상영관 등록 >");
		String thecode = makecode();
		
		look.look_moviecenter_foreach();
		
		System.out.print("상영관을 추가할 지점의 코드를 입력하세요. : ");
		String moviecenter = sc.nextLine();
		
		look.look_theater_justfor(moviecenter);
		System.out.println("선택한 지점에 등록된 상영관 목록입니다.");
		
		System.out.print("\n추가할 상영관 이름을 입력하세요. : ");
		String theatername = sc.nextLine();
		
		System.out.print("청소시간을 입력하세요. : ");
		int cleantime = sc.nextInt();
		sc.nextLine();
		
		System.out.print("좌석당 가격을 입력하세요. : ");
		int seatprice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상영관의 마지막 좌석을 입력하세요. (ex: I09) : ");
		String totalseats = sc.next();
		sc.nextLine();
		
		System.out.println();
		System.out.printf("[지점 코드 : %s | 상영관 코드 : %s | 상영관 이름 : %s | 마지막 좌석 : %s | 좌석당 가격 : %d원 | 상영관 청소시간 : %s분]\n"
				, moviecenter, thecode, theatername, totalseats, seatprice, cleantime);
		System.out.printf("\n위의 정보대로 상영관을 등록하시겠습니까? 1. 예 | 2. 아니요");
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		String in = sc.nextLine();
		
		switch(in) {
		case "1":
			dt.insertTheater(thecode, theatername, moviecenter, seatprice, cleantime, totalseats);
			//theaters.add(thecode, theatername, moviecenter, seatprice, cleantime, totalseats);
			break;
		case "2":
			System.out.println("상영관 등록을 취소하셨습니다. 새로운 등록을 원하시면 처음부터 다시 진행하세요.");
			break;
		default: 
			System.out.println("입력이 잘못되었습니다.");
		}
		
	} // add method

	public void change() { // Theater Table 데이터 수정
		System.out.println("\n\n< 상영관 정보 수정 >");
		
		// 3. 지점코드, 지점이름 출력 후 선택 >> 상영관이름 + 상영관 코드 중 선택 >> 상영관코드, 상영관이름, 좌석수, 가격, 청소시간 change
		// 4. 상영관 코드 출력 >> 바꿀 상영관코드 입력 >> change 진행
//		System.out.println("지점코드 \t 지점명 \t 지점주소");
//		for(int i = 0; i < moviecenters.size(); i++) {
//			System.out.println(moviecenters.get(i).getCentercode + " \t " + moviecenters.get(i).getCentername + " \t " + moviecenters.get(i).getAddress);
//		}
		dt.printTheater(dt.getTheater());
		System.out.print("수정할 상영관의 지점코드를 입력하세요. : ");
		String ccode = sc.nextLine();
		
		System.out.printf("\n선택한 지점 [%s]에 등록된 상영관 목록을 출력합니다.\n", ccode);
		dt.selectCentercode(ccode);
		
		System.out.print("수정할 상영관의 상영관코드를 입력하세요. : ");
		String tcode = sc.nextLine();
		
		System.out.printf("\n선택한 상영관 [%s]의 정보를 출력합니다.\n", tcode);
		dt.selectTheatercode(tcode);
		
		System.out.printf("\n선택한 상영관이 맞습니까? 1. 예 | 2. 아니요");
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		int a = sc.nextInt();
		sc.nextLine();

		switch(a) {
		case 1:
			System.out.println("\n선택하신 상영관의 정보 수정을 시작합니다.");
			System.out.print("변경할 상영관 이름을 입력하세요. : ");
			String tname = sc.nextLine();
			
			System.out.printf("변경할 마지막 좌석 번호를 입력하세요. : ", tname);
			String tseat = sc.next();
			sc.nextLine();
			
			System.out.printf("변경할 좌석당 가격을 입력하세요. : ", tname);
			int tp = sc.nextInt();
			sc.nextLine();
			
			System.out.printf("변경할 청소시간을 입력하세요. : ", tname);
			int ct = sc.nextInt();
			sc.nextLine();
			
			System.out.printf("\n[ 지점 코드 : %s | 상영관 코드 : %s | 상영관 이름 : %s | 마지막 좌석 : %s | 좌석당 가격 : %d원 | 청소 시간 : %d분 ]\n", 
								ccode, tcode, tname, tseat, tp, ct);
			System.out.printf("\n위의 정보대로 상영관의 정보를 수정하시겠습니까? 1. 예 | 2. 아니요");
			System.out.print("\n원하는 메뉴를 선택하세요. : ");
			String in = sc.nextLine();
			
			switch(in) {
				case "1":
					dt.changeTheater(tcode, tname, ccode, tp, ct, tseat);
					break;
				case "2":
					System.out.println("일치하지 않다를 선택하셨습니다. 다시 입력해주세요");
					break;
				default :
					System.out.println("입력이 잘못되었습니다.");
			}
		}
	} // change method

	public void delete() { // Theater Table 데이터 삭제
		ArrayList<DTO_Theater> theaters = dt.getTheater();
		ArrayList<MOVIECENTER> centers = db.getmoviecenter();
		System.out.println("\n\n< 기존 상영관 삭제 >");
		
		dt.printTheater(dt.getTheater());
		System.out.print("삭제할 상영관의 상영관 코드를 입력하세요. : ");
		String tcode = sc.nextLine();
		
		String theatername = "";
		String centercode = "";
		for (DTO_Theater theater : theaters) {
			if (tcode.equals(theater.getTheatercode())) {
				theatername = theater.getTheatername();
				centercode = theater.getCentercode();
			}
		}
		String centername = "";
		for (MOVIECENTER center : centers) {
			if (centercode.equals(center.getCentercode()))
				centername = center.getCentername();
		}
		
		System.out.printf("\n[%s] 상영관을 정말 삭제하시겠습니까? 1. 예 | 2. 아니요.", tcode);
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		int a = sc.nextInt();
		
		switch(a) {
		case 1:
//			System.out.println("일치를 선택하셨습니다.");
			//dt.deleteTheater(tcode);
			db.deleteTheater(centername, tcode, theatername);
			break;
		case 2:
			System.out.println("상영관 삭제가 취소되었습니다.");
			break;	
		}
		
	} // delete method
} // class
