package MovieReservationDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation_cancel {
DBconnectMov db = new DBconnectMov();
ArrayList<RESERVATION> reservations = db.getreservations();
Scanner scanner = new Scanner(System.in);
ArrayList<THEATER> theaters = db.gettheater();
ArrayList<SCREEN> screens = db.getscreen();
ArrayList<MOVIE> movies = db.getmovie();
ArrayList<USERINFO> userinfos = db.getuserinfo();

public void cancelreser(String ID) {
	ArrayList<String> reservenumbers = new ArrayList<>();
	ArrayList<String> phones = new ArrayList<>();
	ArrayList<String> births = new ArrayList<>();
	ArrayList<RESERVATION> ress = new ArrayList<>();
	String phone = "";
	String birth = "";
	String pw = "";

	ArrayList<Integer> resindex = new ArrayList<>();
	for (int i=0; i<reservations.size();i++) {
		reservenumbers.add(reservations.get(i).getReservenumber());
		phones.add(reservations.get(i).getPhone());
		births.add(reservations.get(i).getBirth());
	}
	ArrayList<String> resmov = new ArrayList<>();
	ArrayList<String> resthe = new ArrayList<>();
	ArrayList<String> resscr = new ArrayList<>();
	ArrayList<String> thecen = new ArrayList<>();
	String reservenumber = "";
		if (ID.equals("")) {
		System.out.println("예매 번호로 조회하려면 '1'번\n핸드폰번호 및 생년월일로 조회하려면 '2'번을 눌러주세요.");
		int num = scanner.nextInt();
		switch(num) {
		case 1:
			System.out.println("예매번호를 입력해주세요.");
			reservenumber = scanner.next();
			if (!reservenumbers.contains(reservenumber))
				System.out.println("등록된 예매번호가 아닙니다.");
			else {
				resmov = db.joinresmov(reservenumber);
				 resthe = db.joinresthe(reservenumber);
				 resscr = db.joinresscr(reservenumber);
				for (int i=0; i<reservations.size();i++) {
					if (reservenumber.equals(reservations.get(i).getReservenumber())) {
						resindex.add(i);
					ress.add(reservations.get(i));
					}
				}
				thecen = db.jointhmc(ress.get(0).getTheatercode());
				System.out.println("고객님의 예매 내역입니다.");
				System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
				System.out.println("=======================================================================");
				System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
						resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
				System.out.println("위 예매 내역을 취소하시려면 '1'번\n 뒤로 돌아가려면 '2'번을 눌러주세요.");
				int numm = scanner.nextInt();
				if (numm == 1) {
					db.deletescreen(reservenumber);
					break;
			}else if (numm == 2){
				System.out.println("뒤로 돌아갑니다.");
				break;
			}else {
				System.out.println("올바른 번호를 입력해주세요.");
				break;
			}
			}
			 break;
		case 2:
			System.out.println("먼저 핸드폰 번호를 양식에 맞게 입력해주세요.\nex)010-8251-6374");
			phone = scanner.next();
			if (!phones.contains(phone))
				System.out.println("등록된 번호가 아닙니다.");
			else {
				System.out.println("다음으로는 생년월일을 양식에 맞게 입력해주세요.\nex)2000-05-01");
				birth = scanner.next();
				if (!births.contains(birth))
					System.out.println("등록된 생년 월일이 아닙니다");
				else {
					System.out.println("마지막으로 비밀번호를 입력해주세요.");
					pw = scanner.next();
					for (RESERVATION reservation : reservations) {
						if (phone.equals(reservation.getPhone())&&birth.equals(reservation.getBirth())&&
								pw.equals(reservation.getPw()))
							ress.add(reservation);
					}
					if (ress.size()==0)
						System.out.println("올바른 비밀번호가 아닙니다.");
					else if (ress.size()==1) {
						reservenumber = ress.get(0).getReservenumber();
						resmov = db.joinresmov(reservenumber);
						 resthe = db.joinresthe(reservenumber);
						 resscr = db.joinresscr(reservenumber);
						 thecen = db.jointhmc(ress.get(0).getTheatercode());
							System.out.println("고객님의 예매 내역입니다.");
							System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
							System.out.println("=======================================================================");
							System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
									resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
						
						System.out.println("위 예매 내역을 취소하시려면 '1'번\n 뒤로 돌아가려면 '2'번을 눌러주세요.");
						int numm = scanner.nextInt();
						if (numm == 1) {
							db.deletescreen(reservenumber);
							break;
					}else if (numm == 2){
						System.out.println("뒤로 돌아갑니다.");
						break;
					}else {
						System.out.println("올바른 번호를 입력해주세요.");
						break;
					}
					}
					else {
						 System.out.println("고객님의 예매 내역들입니다.");
							System.out.println("순번 영화제목\t\t지점\t\t상영관 이름\t상영시간\t\t예약좌석");
							System.out.println("=======================================================================");
						
						for (int i=0; i<ress.size();i++) {
							reservenumber = ress.get(i).getReservenumber();
							resmov = db.joinresmov(reservenumber);
							 resthe = db.joinresthe(reservenumber);
							 resscr = db.joinresscr(reservenumber);
							 thecen = db.jointhmc(ress.get(0).getTheatercode());
							//	System.out.println("고객님의 예매 내역들입니다.");
							//	System.out.println("순번 영화제목\t\t지점\t\t상영관 이름\t상영시간\t\t예약좌석");
							//	System.out.println("=======================================================================");
								System.out.printf("%s. %s\t %s\t\t%s\t%s~%s\t%s\n", i+1, resmov.get(8), thecen.get(5), resthe.get(8), 
										resscr.get(9), resscr.get(10),reservations.get(resindex.get(i)).getSelectseat().replaceAll(";", " "));
							}
						System.out.println("예매 취소하실 내역의 번호를 입력해주세요.\n뒤로 돌아가시려면 '0'을 눌러주세요.");
						int numm = scanner.nextInt()-1;
						if (numm == -1) {
							System.out.println("뒤로 돌아갑니다.");
							break;
					}
						else if (numm>=ress.size()) {
							db.deletereservations(ress.get(numm).getReservenumber());
							break;
						}
						else {
							System.out.println("올바른 번호가 아닙니다.");
							break;
						}
				}
			}
			}
			break;
			default:
				System.out.println("올바른 번호가 아닙니다.");
				break;
		}
	}
	else {
		for (USERINFO userinfo : userinfos) {
			if (userinfo.getID().equals(ID)) {
				phone = userinfo.getPhone();
				birth = userinfo.getBirth();
				pw = userinfo.getUserpw();
			}
		}
		for (int i=0; i<reservations.size();i++) {
			if (phone.equals(reservations.get(i).getPhone())&&birth.equals(reservations.get(i).getBirth())&&
					pw.equals(reservations.get(i).getPw())) {
				ress.add(reservations.get(i));
			resindex.add(i);
			}
		}
		if (ress.size()==0)
			System.out.println("올바른 비밀번호가 아닙니다.");
		else if (ress.size()==1) {
			reservenumber = ress.get(0).getReservenumber();
			resmov = db.joinresmov(reservenumber);
			 resthe = db.joinresthe(reservenumber);
			 resscr = db.joinresscr(reservenumber);
			 thecen = db.jointhmc(ress.get(0).getTheatercode());
				System.out.println("고객님의 예매 내역입니다.");
				System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
				System.out.println("=======================================================================");
				System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
						resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
			
			System.out.println("위 예매 내역을 취소하시려면 '1'번\n 뒤로 돌아가려면 '2'번을 눌러주세요.");
			int numm = scanner.nextInt();
			if (numm == 1) {
				db.deletescreen(reservenumber);
				
		}else if (numm == 2){
			System.out.println("뒤로 돌아갑니다.");
			
		}else {
			System.out.println("올바른 번호를 입력해주세요.");
			
		}
		}
		else {
			for (int i=0; i<ress.size();i++) {
				reservenumber = ress.get(i).getReservenumber();
				resmov = db.joinresmov(reservenumber);
				 resthe = db.joinresthe(reservenumber);
				 resscr = db.joinresscr(reservenumber);
				 thecen = db.jointhmc(ress.get(0).getTheatercode());
					System.out.println("고객님의 예매 내역들입니다.");
					System.out.println("순번 영화제목\t\t지점\t\t상영관 이름\t상영시간\t\t예약좌석");
					System.out.println("=======================================================================");
					System.out.printf("%s. %s\t %s\t\t%s\t%s~%s\t%s\n", i+1, resmov.get(8), thecen.get(5), resthe.get(8), 
							resscr.get(9), resscr.get(10),reservations.get(resindex.get(i)).getSelectseat().replaceAll(";", " "));
				}
			System.out.println("예매 취소하실 내역의 번호를 입력해주세요.\n뒤로 돌아가시려면 '0'을 눌러주세요.");
			int numm = scanner.nextInt()-1;
			if (numm == -1) {
				System.out.println("뒤로 돌아갑니다.");
				
		}
			else if (numm>=ress.size()) {
				db.deletereservations(ress.get(numm).getReservenumber());
				
			}
			else {
				System.out.println("올바른 번호가 아닙니다.");
				
			}
	}
}
		}
	

public void lookreser(String ID) {
ArrayList<String> reservenumbers = new ArrayList<>();
ArrayList<String> phones = new ArrayList<>();
ArrayList<String> births = new ArrayList<>();
ArrayList<RESERVATION> ress = new ArrayList<>();
String phone = "";
String birth = "";
String pw = "";

ArrayList<Integer> resindex = new ArrayList<>();
for (int i=0; i<reservations.size();i++) {
	reservenumbers.add(reservations.get(i).getReservenumber());
	phones.add(reservations.get(i).getPhone());
	births.add(reservations.get(i).getBirth());
}
ArrayList<String> resmov = new ArrayList<>();
ArrayList<String> resthe = new ArrayList<>();
ArrayList<String> resscr = new ArrayList<>();
ArrayList<String> thecen = new ArrayList<>();
String reservenumber = "";
	if (ID.equals("")) {
	System.out.println("예매 번호로 조회하려면 '1'번\n핸드폰번호 및 생년월일로 조회하려면 '2'번을 눌러주세요.");
	int num = scanner.nextInt();
	switch(num) {
	case 1:
		System.out.println("예매번호를 입력해주세요.");
		reservenumber = scanner.next();
		if (!reservenumbers.contains(reservenumber))
			System.out.println("등록된 예매번호가 아닙니다.");
		else {
			resmov = db.joinresmov(reservenumber);
			 resthe = db.joinresthe(reservenumber);
			 resscr = db.joinresscr(reservenumber);
			for (int i=0; i<reservations.size();i++) {
				if (reservenumber.equals(reservations.get(i).getReservenumber())) {
					ress.add(reservations.get(i));
				}
			}
			thecen = db.jointhmc(ress.get(0).getTheatercode());
			System.out.println("고객님의 예매 내역입니다.");
			System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
			System.out.println("=======================================================================");
			System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
					resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
		}
		break;
	case 2:
		System.out.println("먼저 핸드폰 번호를 양식에 맞게 입력해주세요.\nex)010-8251-6374");
		phone = scanner.next();
		if (!phones.contains(phone))
			System.out.println("등록된 번호가 아닙니다.");
		else {
			System.out.println("다음으로는 생년월일을 양식에 맞게 입력해주세요.\nex)2000-05-01");
			birth = scanner.next();
			if (!births.contains(birth))
				System.out.println("등록된 생년 월일이 아닙니다");
			else {
				System.out.println("마지막으로 비밀번호를 입력해주세요.");
				pw = scanner.next();
				for (RESERVATION reservation : reservations) {
					if (phone.equals(reservation.getPhone())&&birth.equals(reservation.getBirth())&&
							pw.equals(reservation.getPw()))
						ress.add(reservation);
				}
				if (ress.size()==0)
					System.out.println("올바른 비밀번호가 아닙니다.");
				else if (ress.size()==1) {
					reservenumber = ress.get(0).getReservenumber();
					resmov = db.joinresmov(reservenumber);
					 resthe = db.joinresthe(reservenumber);
					 resscr = db.joinresscr(reservenumber);
					 thecen = db.jointhmc(ress.get(0).getTheatercode());
						System.out.println("고객님의 예매 내역입니다.");
						System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
						System.out.println("=======================================================================");
						System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
								resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
					}
				else {
					for (int i=0; i<ress.size();i++) {
						reservenumber = ress.get(i).getReservenumber();
						resmov = db.joinresmov(reservenumber);
						 resthe = db.joinresthe(reservenumber);
						 resscr = db.joinresscr(reservenumber);
						 thecen = db.jointhmc(ress.get(0).getTheatercode());
							System.out.println("고객님의 예매 내역들입니다.");
							System.out.println("순번 영화제목\t\t지점\t\t상영관 이름\t상영시간\t\t예약좌석");
							System.out.println("=======================================================================");
							System.out.printf("%s. %s\t %s\t\t%s\t%s~%s\t%s\n", i+1, resmov.get(8), thecen.get(5), resthe.get(8), 
									resscr.get(9), resscr.get(10),reservations.get(resindex.get(i)).getSelectseat().replaceAll(";", " "));
						}
				}
			}
		}
		break;
		default:
			System.out.println("올바른 번호가 아닙니다.");
			break;
	}
}
else {
	for (USERINFO userinfo : userinfos) {
		if (userinfo.getID().equals(ID)) {
			phone = userinfo.getPhone();
			birth = userinfo.getBirth();
			pw = userinfo.getUserpw();
		}
	}
	for (int i=0; i<reservations.size();i++) {
		if (phone.equals(reservations.get(i).getPhone())&&birth.equals(reservations.get(i).getBirth())&&
				pw.equals(reservations.get(i).getPw())) {
			ress.add(reservations.get(i));
		resindex.add(i);
		}
	}
	if (ress.size()==0)
		System.out.println("올바른 비밀번호가 아닙니다.");
	else if (ress.size()==1) {
		reservenumber = ress.get(0).getReservenumber();
		resmov = db.joinresmov(reservenumber);
		 resthe = db.joinresthe(reservenumber);
		 resscr = db.joinresscr(reservenumber);
thecen = db.jointhmc(ress.get(0).getTheatercode());
		System.out.println("고객님의 예매 내역입니다.");
		System.out.println("영화제목\t\t지점\t\t상영관 이름\t상영날짜\t상영시간\t\t예약좌석");
		System.out.println("=======================================================================");
		System.out.printf("%s\t %s\t\t%s\t%s\t%s~%s\t%s\n", resmov.get(8), thecen.get(5),resthe.get(8), 
				resscr.get(9), resscr.get(10),resscr.get(11),ress.get(0).getSelectseat().replaceAll(";", " "));
	}
	else {
		for (int i=0; i<ress.size();i++) {
			reservenumber = ress.get(i).getReservenumber();
			resmov = db.joinresmov(reservenumber);
			 resthe = db.joinresthe(reservenumber);
			 resscr = db.joinresscr(reservenumber);
			 thecen = db.jointhmc(ress.get(0).getTheatercode());
			System.out.println("고객님의 예매 내역들입니다.");
			System.out.println("순번 영화제목\t\t지점\t\t상영관 이름\t상영시간\t\t예약좌석");
			System.out.println("=======================================================================");
			System.out.printf("%s. %s\t %s\t\t%s\t%s~%s\t%s\n", i+1, resmov.get(8), thecen.get(5), resthe.get(8), 
					resscr.get(9), resscr.get(10),reservations.get(resindex.get(i)).getSelectseat().replaceAll(";", " "));
		}
	}
}
}
}
