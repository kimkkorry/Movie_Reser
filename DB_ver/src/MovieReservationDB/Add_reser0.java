package MovieReservationDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_reser0 {
public void addreser(String ID, String moviecode, String centercode) {
	DBconnectMov db = new DBconnectMov();
	ArrayList<MOVIE> movies = db.getmovie();
	ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();
	ArrayList<THEATER> theaters = db.gettheater();
	ArrayList<SCREEN> screens = db.getscreen();
	
	
	Look_tables0 look = new Look_tables0();
	reservation_seat0 reser = new reservation_seat0();
	Scanner scanner = new Scanner(System.in);
	String screencode = "";
	String theatercode = "";
	
	int count = 0;
	int num = 0;
	ArrayList<String> seats = new ArrayList<>();
	String selectseat = "";
	
	
	if (ID.equals("")&&moviecode.equals("")&&centercode.equals(""))
		num = 1; 
	else if (ID.equals("")&&centercode.equals(""))
		num = 2;
	else if (ID.equals("")&&moviecode.equals(""))
		num = 3;
	else if (ID.equals(""))
		num = 4;
	else if (moviecode.equals("")&&centercode.equals(""))
		num = 5;
	else if (centercode.equals(""))
		num = 6;
	else if (moviecode.equals(""))
		num = 7;
	else
		num = 8;
	
	switch(num) {
	case 1:
	look.look_movie_justfor();
	System.out.println("위 영화 중 선택하실 영화의 번호를 입력해주세요");
	moviecode = movies.get(scanner.nextInt()-1).getMoviecode();
	look.look_moviecenter_justfor();
	System.out.println("위 영화 중 선택하실 영화관의 번호를 입력해주세요.");
	centercode = moviecenters.get(scanner.nextInt()-1).getCentercode();
	System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
	for (THEATER theater : theaters) {
		if (theater.getCentercode().equals(centercode))
			theatercode = theater.getTheatercode();
	}
	look.look_screen_justfor(moviecode, theatercode);
	System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
	screencode = screens.get(scanner.nextInt()-1).getScreencode();
	System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
	count = scanner.nextInt();
	seats = reser.reservationseat(count, screencode);
	System.out.println("위 좌석으로 예매 진행됩니다.");

	for (String seat : seats)
		selectseat += seat+";";
	notmemres(selectseat, moviecode, screencode, theatercode);
		break;
	case 2:
		look.look_moviecenter_justfor();
		System.out.println("위 영화 중 선택하실 영화관의 번호를 입력해주세요.");
		centercode = moviecenters.get(scanner.nextInt()-1).getCentercode();
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");
	
		for (String seat : seats)
			selectseat += seat+";";
		notmemres(selectseat, moviecode, screencode, theatercode);
		break;
	case 3:
		look.look_movie_justfor();
		System.out.println("위 영화 중 선택하실 영화의 번호를 입력해주세요");
		moviecode = movies.get(scanner.nextInt()-1).getMoviecode();
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");

		for (String seat : seats)
			selectseat += seat+";";
		notmemres(selectseat, moviecode, screencode, theatercode);
		break;
	case 4:
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");

		for (String seat : seats)
			selectseat += seat+";";
		notmemres(selectseat, moviecode, screencode, theatercode);
		break;
	case 5:
		look.look_movie_justfor();
		System.out.println("위 영화 중 선택하실 영화의 번호를 입력해주세요");
		moviecode = movies.get(scanner.nextInt()-1).getMoviecode();
		look.look_moviecenter_justfor();
		System.out.println("위 영화 중 선택하실 영화관의 번호를 입력해주세요.");
		centercode = moviecenters.get(scanner.nextInt()-1).getCentercode();
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");

		for (String seat : seats)
			selectseat += seat+";";
		yesmemres(ID, selectseat, moviecode, screencode, theatercode);
		break;
	case 6:
		look.look_moviecenter_justfor();
		System.out.println("위 영화 중 선택하실 영화관의 번호를 입력해주세요.");
		centercode = moviecenters.get(scanner.nextInt()-1).getCentercode();
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");
	
		for (String seat : seats)
			selectseat += seat+";";
		yesmemres(ID, selectseat, moviecode, screencode, theatercode);
		break;
	case 7:
		look.look_movie_justfor();
		System.out.println("위 영화 중 선택하실 영화의 번호를 입력해주세요");
		moviecode = movies.get(scanner.nextInt()-1).getMoviecode();
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");
	
		for (String seat : seats)
			selectseat += seat+";";
		yesmemres(ID, selectseat, moviecode, screencode, theatercode);
		break;
	case 8:
		System.out.println("선택하신 영화 및 영화관이 포함 된 목록입니다.");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				theatercode = theater.getTheatercode();
		}
		
		look.look_screen_justfor(moviecode, theatercode);
		System.out.println("위 상영 정보들 중 선택하실 상영 정보의 번호를 입력해주세요.");
		screencode = screens.get(scanner.nextInt()-1).getScreencode();
		System.out.println("다음으로 예약하실 분들의 인원수를 입력해주세요.");
		count = scanner.nextInt();
		seats = reser.reservationseat(count, screencode);
		System.out.println("위 좌석으로 예매 진행됩니다.");
	
		for (String seat : seats)
			selectseat += seat+";";
		yesmemres(ID, selectseat, moviecode, screencode, theatercode);
		break;
	
	}
	
	
}
public void notmemres(String selectseat, String moviecode, String screencode, String theatercode) {
	DBconnectMov db = new DBconnectMov();
	Scanner scanner = new Scanner(System.in);
	System.out.println("고객님의 전화번호를 양식에 맞게 입력해주세요.\nex)010-8251-6374");
	String phone = scanner.next();
	System.out.println("고객님의 생년월일 6자리를 입력해주세요.");
	String birth = scanner.next();
	System.out.println("다음으로 비밀번호를 입력해주세요");
	String pw = scanner.next();
	System.out.println("비밀번호를 다시한번 입력해주세요.");
	String checkpw = scanner.next();
	if (!pw.equals(checkpw))
		System.out.println("비밀번호가 일치하지 않습니다.");
	else {
		String reservenumber = "";
		reservenumber += screencode + "-";
		reservenumber += selectseat.substring(0,3) + "-";
		reservenumber += phone.substring(10,13);
		db.insertreservations(reservenumber, selectseat, moviecode, screencode, theatercode, birth, phone, pw, "X");
	}
}
public void yesmemres(String ID, String selectseat, String moviecode, String screencode, String theatercode) {
	DBconnectMov db = new DBconnectMov();
	Scanner scanner = new Scanner(System.in);
	ArrayList<USERINFO> userinfos = db.getuserinfo();
	String phone = "";
	String birth = "";
	String pw = "";
	for (USERINFO userinfo : userinfos) {
		if (userinfo.getID().equals(ID)) {
			phone = userinfo.getPhone();
			birth = userinfo.getBirth();
			pw = userinfo.getUserpw();
		}
	}
	String reservenumber = "";
	reservenumber += screencode + "-";
	reservenumber += selectseat.substring(0,3) + "-";
	reservenumber += phone.substring(10,13);
	
	db.insertreservations(reservenumber, selectseat, moviecode, screencode, theatercode, birth, phone, pw, "O");
}
}
