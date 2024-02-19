package MovieReservationDB;

import java.util.ArrayList;
import java.util.Scanner;

class Admin_Moviecenter extends Admin_Class {
	Scanner sc = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	ArrayList<String> centercodes = new ArrayList<>();

	public String makecode() {
	      ArrayList<MOVIECENTER> centers = db.getmoviecenter();
	      String tmp = "";
	      if(centers.size()>=1) {
	    	  tmp = centers.get(0).getCentercode();
	      }  
	      String centercode = ""; // 지점 코드 생성
	      if (tmp.equals(""))
	    	  centercode = "C001"; 
	      else {
	         int centercod = Integer.parseInt(tmp.substring(1));
	         centercod ++;
	         if ( centercod < 10 ) { centercode = "C00" + centercod; }
	         else if ( 10 <= centercod && centercod < 100 ) { centercode = "C0" + centercod; }
	         else { centercode = "C" + centercod; }
	      }  
	      return centercode;
	   } 	
	
	public void add() {
		String centercode = makecode();
		System.out.println("\n");
		System.out.println("< 새 지점 등록 >");
		System.out.println("================================");
		System.out.print("지점명 : ");
		String centername = sc.nextLine();
		System.out.print("지점 주소 : ");
		String address = sc.nextLine();
		System.out.printf("해당 지점의 CODE는 '%s'로 등록됩니다\n", centercode);
		System.out.println("================================");
		System.out.println("1. 확인 | 2. 뒤로가기");
		System.out.print("원하는 메뉴를 선택하세요. : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			db.insertMoviecenter(centercode, centername, address);
			break;
		case 2:
			System.out.println("지점 등록이 취소되었습니다.");
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요.");
			break;
		}
	}
	public void change() {
		ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();
		System.out.println("\n");
		System.out.println("< 지점 정보 수정 >");
		System.out.println("============================");
		if (moviecenters.size() == 0) {
			System.out.println("등록된 지점이 없습니다.");
		} 
		for (int i = 0; i < moviecenters.size(); i++) {
			System.out.println(i+1 + ". 30VI8 " + moviecenters.get(i).getCentername());
		}
		System.out.println("============================");
		System.out.print("수정할 지점의 번호를 선택하세요. :");
		int num = sc.nextInt();
		sc.nextLine();// 개행처리
		
		System.out.println("\n========== 수정전 ==========");
		System.out.println("지점명 : " + moviecenters.get(num-1).getCentername());
		System.out.println("지점 주소 : " + moviecenters.get(num-1).getAddress());
		System.out.println("============================\n");
		System.out.print("수정할 지점명을 입력하세요. : ");
		String modifyname = sc.nextLine();
		String cname = moviecenters.get(num-1).getCentername();
		if (modifyname != "308") {
			cname = modifyname;
		}
		System.out.print("수정할 지점 주소를 입력하세요. : ");
		String modifyaddress = sc.nextLine();
		String caddress = moviecenters.get(num-1).getAddress();
		if (modifyaddress != "308") {
			caddress = modifyaddress;
		}
		System.out.printf("\n해당 수정 내용으로 수정하시겠습니까? 1. 예 | 2. 아니요");
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		int numb = sc.nextInt();
		sc.nextLine();// 개행처리
		switch (numb) {
		case 1:
			db.updateMoviecenter(moviecenters.get(num-1).getCentercode(), cname, caddress);
			break;
		case 2:
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요.");
			break;		
		}
	}
	public void delete() {
		ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();
		System.out.println("\n");
		System.out.println("< 기존 지점 삭제 >");
		System.out.println("===========================");
		for (int i = 0; i < moviecenters.size(); i++) {
			System.out.println(i+1 + ". 30VI8 " + moviecenters.get(i).getCentername());
		}
		System.out.println("===========================");
		System.out.print("삭제할 지점의 번호를 선택하세요 : ");
		int num = sc.nextInt();
		System.out.printf("\n해당 지점을 삭제하시겠습니까? 1. 예 | 2. 아니요");
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		int numb = sc.nextInt();
		switch (numb) {
		case 1:
			db.deleteMoviecenter(moviecenters.get(num-1).getCentercode(), moviecenters.get(num-1).getCentername());
			break;
		case 2:
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요.");
			break;		
		}
	}
}