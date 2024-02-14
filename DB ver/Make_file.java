package TeamC_Movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Make_file {
public void movielist() throws IOException{
	Scanner scanner = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	ArrayList<MOVIE> movies = db.getmovie();
	PrintWriter pw = new PrintWriter("c://works//movie_list.csv", "euc-kr");
	String prompt = """
			[30VI8]
			상영 영화 조회 및 출력
			=========================
			=  1. 영화제목순 (오름차순)\t=
			=  2. 영화제목순 (내림차순)\t=
			=  3. 영화코드순 (오름차순)\t=
			=  4. 영화코드순 (내림차순)\t=
			=  5. 예매율순 (오름차순)\t=
			=  6. 예매율순 (내림차순)\t=
			=  7. 끝내기\t\t=
			=========================
			원하는 메뉴를 선택하세요. : """;
	ArrayList<String> movienames = new ArrayList<>();
	ArrayList<String> moviecodes = new ArrayList<>();
	ArrayList<String> resrates = new ArrayList<>();
	outer:
		while(true) {
			System.out.println("\n");
			System.out.print(prompt);
			int num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.println("\n영화제목순(오름차순)으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					movienames.add(movie.getMoviename()+movie.getMoviecode());
				movienames.sort(Comparator.naturalOrder());
				pw.println("영화코드,영화 제목,장르,런타임,연령가,예매율");
				for (String moviename : movienames) {
				for (MOVIE movie : movies) {
					 String moviecode = moviename.substring(moviename.length()-4,moviename.length());	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 2:
				System.out.println("\n영화제목순(내림차순)'으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					movienames.add(movie.getMoviename()+movie.getMoviecode());
				movienames.sort(Comparator.reverseOrder());
				pw.println("영화코드,영화 제목,장르,런타임,연령가,예매율");
				for (String moviename : movienames) {
				for (MOVIE movie : movies) {
					 String moviecode = moviename.substring(moviename.length()-4,moviename.length());	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 3:
				System.out.println("\n영화코드순(오름차순)으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					moviecodes.add(movie.getMoviecode());
				moviecodes.sort(Comparator.naturalOrder());
				pw.println("영화코드,영화이름,영화장르,런타임,연령가,예매율");
				for (String moviecode : moviecodes) {
				for (MOVIE movie : movies) {	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 4:
				System.out.println("\n영화코드순(내림차순)으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					moviecodes.add(movie.getMoviecode());
				moviecodes.sort(Comparator.reverseOrder());
				pw.println("영화코드,영화이름,영화장르,런타임,연령가,예매율");
				for (String moviecode : moviecodes) {
				for (MOVIE movie : movies) {	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 5:
				System.out.println("\n예매율순(오름차순)으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					resrates.add(movie.getSalesrate()+movie.getMoviecode());
				resrates.sort(Comparator.naturalOrder());
				pw.println("영화코드,영화이름,영화장르,런타임,연령가,예매율");
				for (String resrate : resrates) {
				for (MOVIE movie : movies) {
					 String moviecode = resrate.substring(resrate.length()-4,resrate.length());	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 6:
				System.out.println("\n예매율순(내림차순)으로 파일이 생성됩니다.");
				for (MOVIE movie : movies)
					resrates.add(movie.getSalesrate()+movie.getMoviecode());
				resrates.sort(Comparator.reverseOrder());
				pw.println("영화코드,영화이름,영화장르,런타임,연령가,예매율");
				for (String resrate : resrates) {
				for (MOVIE movie : movies) {
					 String moviecode = resrate.substring(resrate.length()-4,resrate.length());	
					if (moviecode.equals(movie.getMoviecode()))
							pw.printf("%s,%s,%s,%s,%s,%s\n",
									movie.getMoviecode(),movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", movie.getAgegroup()+"세",
									movie.getSalesrate()+"%");
					}
				}
				pw.close();
				System.out.println("\n'c://works'에 'movie_list.csv'파일이 생성되었습니다.");
				break;
			case 7:
				System.out.println("\n상영 영화 조회 및 출력이 종료됩니다.");
				break outer;
			default:
				System.out.println("올바른 번호를 입력해 주세요.");
				break;
			}
		}
}
public void reserlist() throws IOException{
	Scanner scanner = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	ArrayList<MOVIE> movies = db.getmovie();
	ArrayList<RESERVATION> reservations = db.getreservations();
	ArrayList<THEATER> theaters = db.gettheater();
	ArrayList<MOVIECENTER> centers = db.getmoviecenter();
	ArrayList<String> theatercodes = new ArrayList<>();
	PrintWriter pw = new PrintWriter("c://works//movie_reservation_list.csv", "euc-kr");
	
	System.out.println("\n\n<예매 내역 조회 및 출력>");
	System.out.println("\n영화 선택");
	System.out.println("=========================");
	System.out.println("번호\t영화 제목");
	System.out.println("=========================");
	System.out.println("0\t모든 영화");
	for (int i=0; i<movies.size();i++) 
		System.out.printf("%s\t%s\n", i+1, movies.get(i).getMoviename());
	System.out.println("=========================");
	System.out.print("조회할 영화를 선택하세요. : ");
	int movnum = scanner.nextInt()-1;
	
	System.out.println("\n지점 선택");
	System.out.println("=========================");
	System.out.println("번호\t지점명");
	System.out.println("=========================");
	System.out.println("0\t모든 지점");
	for (int i=0; i<centers.size();i++) 
		System.out.printf("%s\t%s\n", i+1, "30VI8 " + centers.get(i).getCentername());
	System.out.println("=========================");
	System.out.print("조회할 지점을 선택하세요. : ");
	int movcen = scanner.nextInt()-1;
	
	if (movnum == 0) {
		if (movcen == 0) {
			pw.println("예매번호,영화코드,상영관코드,상영코드,선택좌석,생년월일,전화번호,비밀번호,회원여부");
			for (RESERVATION reservation : reservations) {
				pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", reservation.getReservenumber(),
						reservation.getMoviecode(), reservation.getTheatercode(), reservation.getScreencode(), reservation.getSelectseat(),
						reservation.getBirth(), reservation.getPhone(), reservation.getPw(), reservation.getUsercheck());
			}
			pw.close();
			System.out.println("\n예매 내역이 'c://works'의 'movie_reservation_list.csv' 파일에 저장되었습니다.");
		}
		else {
			String centercode = centers.get(movcen).getCentercode();
			for (THEATER theater : theaters) {
				if (theater.getCentercode().equals(centercode))
					theatercodes.add(theater.getTheatercode());
			}
			pw.println("예매번호,영화코드,상영관코드,상영코드,선택좌석,생년월일,전화번호,비밀번호,회원여부");
			for (RESERVATION reservation : reservations) {
				
				for (String theatercode : theatercodes) {
					if (reservation.getTheatercode().equals(theatercode)) {
						pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", reservation.getReservenumber(), 
								reservation.getMoviecode(), reservation.getTheatercode(), reservation.getScreencode(), reservation.getSelectseat(),
								reservation.getBirth(), reservation.getPhone(), reservation.getPw(), reservation.getUsercheck());
					
				}
		}
	}
			pw.close();
			System.out.println("\n예매 내역이 'c://works'의 'movie_reservation_list.csv' 파일에 저장되었습니다.");
		}
	}
	else {
		String moviecode = movies.get(movnum).getMoviecode();
		if (movcen == 0) {
			pw.println("예매번호,영화코드,상영관코드,상영코드,선택좌석,생년월일,전화번호,비밀번호,회원여부");
			for (RESERVATION reservation : reservations) {
				if (reservation.getMoviecode().equals(moviecode)) {
				pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", reservation.getReservenumber(),
						reservation.getMoviecode(), reservation.getTheatercode(), reservation.getScreencode(), reservation.getSelectseat(),
						reservation.getBirth(), reservation.getPhone(), reservation.getPw(), reservation.getUsercheck());
				}
			}
			pw.close();
			System.out.println("\n예매 내역이 'c://works'의 'movie_reservation_list.csv' 파일에 저장되었습니다.");
		}
		else {
			String centercode = centers.get(movcen).getCentercode();
			for (THEATER theater : theaters) {
				if (theater.getCentercode().equals(centercode))
					theatercodes.add(theater.getTheatercode());
			}
			pw.println("예매번호,영화코드,상영관코드,상영코드,선택좌석,생년월일,전화번호,비밀번호,회원여부");
			for (RESERVATION reservation : reservations) {
				if (reservation.getMoviecode().equals(moviecode)) {
					for (String theatercode : theatercodes) {
						if (reservation.getTheatercode().equals(theatercode)) {
							pw.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", reservation.getReservenumber(), 
								reservation.getMoviecode(), reservation.getTheatercode(), reservation.getScreencode(), reservation.getSelectseat(),
								reservation.getBirth(), reservation.getPhone(), reservation.getPw(), reservation.getUsercheck());
						}
					}
				}
			}
			pw.close();
			System.out.println("\n예매 내역이 'c://works'의 'movie_reservation_list.csv' 파일에 저장되었습니다.");
		}
	}
}
}
