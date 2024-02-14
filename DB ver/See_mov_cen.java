package TeamC_Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class See_mov_cen {
public String seemovie() {
	DBconnectMov db = new DBconnectMov();
	ArrayList<MOVIE> movies = db.getmovie();
	Scanner scanner = new Scanner(System.in);
	String moviecode = "";
	while(true) {
		System.out.println("\n\n< 영화별 조회 >");
		System.out.println("=========================");
		System.out.println("번호\t영화 제목");
		System.out.println("=========================");
		for (int i=0; i<movies.size();i++) 
			System.out.printf("%s\t%s\n",i+1, movies.get(i).getMoviename());
		System.out.println("=========================");
		System.out.print("원하는 영화를 선택하세요. : ");
		int num = scanner.nextInt()-1;
	
		String ageprint = "";
		if (movies.get(num).getAgegroup() == 0)
			ageprint = "전체이용가";
		else if (movies.get(num).getAgegroup() == 19)
			ageprint = "청소년 관람 불가";
		else
			ageprint = (movies.get(num).getAgegroup()+"") +"세 이상 관람가";
		System.out.println("\n영화 상세 정보");
		System.out.println("=========================");
		System.out.println("영화 제목 : " + movies.get(num).getMoviename());
		System.out.println("장르 : " + movies.get(num).getThema());
		System.out.println("런타임 : " + movies.get(num).getRuntime());
		System.out.println("연령가 : " + ageprint);
		System.out.println("개봉일 : " + movies.get(num).getOpendate());
		System.out.println("=========================");
	
	System.out.println("위 정보가 맞으면 '1'번\n다시 선택하시려면 '2'번을 눌러주세요.");
	int numm = scanner.nextInt();
	if (numm==1) {
		moviecode = movies.get(num).getMoviecode();
		
		break;
	}
	else if (numm == 2) {
			System.out.println("영화 선택이 다시 진행됩니다.");
			continue;
	}
			else {
				System.out.println("올바른 번호를 선택해주세요.");
			break;
			}
	}
	return moviecode;
}
public String seecenter() {
	DBconnectMov db = new DBconnectMov();
	Scanner scanner = new Scanner(System.in);
	ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();
	String centercode = "";
	
	while(true){
		System.out.println("번호 영화관 이름");
		System.out.println("===================");
		for (int i=0; i<moviecenters.size();i++)
		System.out.printf("%s. %s\n", i+1, moviecenters.get(i).getCentername());
		
		System.out.println("원하는 지점의 번호를 입력해주세요.");
		int num = scanner.nextInt()-1;
		
		System.out.println("지점명\t주소");
		System.out.println("=======================================");
		System.out.printf("%s\t%s\n", moviecenters.get(num).getCentername(), moviecenters.get(num).getAddress());
		
		System.out.println("위 정보가 맞으면 '1'번\n다시 선택하시려면 '2'번을 눌러주세요.");
		int numm = scanner.nextInt();
		if (numm==1) {
			centercode = moviecenters.get(num).getCentercode();
			break;
		}
		else if (numm == 2) {
				System.out.println("영화 선택이 다시 진행됩니다.");
				continue;
		}
				else {
					System.out.println("올바른 번호를 선택해주세요.");
				break;	
				}
	}
	
	return centercode;
}
public String seemypage(String ID) {
	DBconnectMov db = new DBconnectMov();
	ArrayList<USERINFO> userinfos = db.getuserinfo();
	Scanner scanner = new Scanner(System.in);
	int userindex = 0;
	String userpw = "";
	
	for (int i=0; i<userinfos.size();i++) {
		if (userinfos.get(i).getID().equals(ID))
			userindex = i;
	}
	USERINFO user = userinfos.get(userindex);
	
	System.out.println("포인트 조회는 '1'번\n비밀번호 변경은 '2'번\n회원탈퇴는 '3'번\n뒤로 돌아가시려면 '4'번을 눌러주세요.");
	int num = scanner.nextInt();
	switch(num) {
	case 1:
		System.out.printf("%s님이 현재 보유하신 포인트는 %s포인트입니다.\n", user.getUsername(), user.getUserpoint());
		return ID;
	case 2:
		System.out.println("비밀번호 변경 페이지 입니다.");
		System.out.println("현재 비밀번호를 입력해주세요.");
		userpw = scanner.next();
		if (!userpw.equals(user.getUserpw()))
			System.out.println("올바른 비밇번호를 입력해주세요.");
		else {
			System.out.println("변경하실 비밀번호를 입력해주세요.");
			String newpw = scanner.next();
			System.out.println("비밀번호를 다시한번 입력해주세요.");
			String newpwcheck = scanner.next();
			if (!newpw.equals(newpwcheck))
				System.out.println("비밀번호가 틀립니다.");
			else {
				db.updateuserinfo(ID, newpw, user.getUsername(), user.getPhone(), user.getBirth(), user.getNinkname(), user.getUserpoint());
				System.out.println("비밀번호 변경이 완료되었습니다.");
			}
			
		}
		return ID;
	case 3:
		System.out.println("회원탈퇴 페이지 입니다.");
		System.out.println("현재 비밀번호를 입력해주세요.");
		userpw = scanner.next();
		if (!userpw.equals(user.getUserpw()))
			System.out.println("올바른 비밇번호를 입력해주세요.");
		else {
			db.deleteuserinfo(user.getUsername(), ID);
			System.out.println("회원 탈퇴가 완료되었습니다.");
		}
		return "";
	case 4:
		System.out.println("메인화면으로 돌아갑니다.");
		return ID;
		default:
			System.out.println("올바른 번호를 입력해주세요.");
			return ID;
	}
	
}
}
