package MovieReservationDB;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin_Movie {
		
	Scanner sc = new Scanner(System.in);
	DBconnectMov db = new DBconnectMov();
	
	public void add() {
			
		outer: while (true) {		
			System.out.println("\n< 새 영화 등록 >");
			System.out.println("=========================");
					
			System.out.print("제목 : ");
			String moviename = sc.nextLine();
					
			System.out.print("장르 : ");	
			String thema = sc.nextLine();
						
			System.out.print("런타임 : ");
			int runtime = sc.nextInt();
			sc.nextLine();
					
			System.out.print("최소 관람 연령 : ");
			int agegroup= sc.nextInt();
			sc.nextLine();	
				
			System.out.print("개봉일 : ");
			String opendate = sc.nextLine();
					
			System.out.println("=========================");
			System.out.println("1. 등록 | 2. 재입력 | 3. 뒤로가기");
			System.out.print("원하는 메뉴를 선택하세요. : ");
			
			while (true) {
				String select = sc.next();
				sc.nextLine();
				if (select.equals("1")) {
					String moviecode = makecode();
					db.insertMovie(moviecode, moviename, thema, runtime, agegroup, 0, opendate);
					System.out.println("\n영화 [" + moviename + "]이(가) 등록 완료 되었습니다.");
					System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
					break outer;
				}
				else if (select.equals("2")) {
					System.out.println("\n새 영화 등록을 다시 실행합니다.\n");
					break;
				}
				else if (select.equals("3")) {
					System.out.println("\n새 영화 등록이 취소되었습니다.");
					System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
					break outer;
				}
				else {
					System.out.print("올바른 번호를 입력해주세요. : ");
					continue;
				}			
			}	
		}	
	
	}	
	
	public String makecode() {
		
		ArrayList<MOVIE> movies = db.getmovie();
		ArrayList<String> moviecodes = new ArrayList<>();
		
		for ( int i = 0; i < movies.size(); i++) {
			moviecodes.add(movies.get(i).getMoviecode());
		}
		
		String moviecode = "";
		if (moviecodes.size() == 0)
			moviecode = "M001"; 
		else {
			int moviecodenum = Integer.parseInt(moviecodes.get(moviecodes.size()-1).substring(1));
			moviecodenum ++;
			if ( moviecodenum < 10 ) { moviecode = "M00" + moviecodenum; }
			else if ( 10 <= moviecodenum && moviecodenum < 100 ) { moviecode = "M0" + moviecodenum; }
			else { moviecode = "M" + moviecodenum; }
		}
		
		return moviecode;
		
	}	
	
	public void change() {
		Look_tables look = new Look_tables();
		
		outer: while(true) {
			System.out.println("\n< 영화 정보 수정 >");
			look.look_movie_justfor();
			System.out.print("수정할 영화를 선택하세요. : ");
			String selectMovie = sc.next();
			sc.nextLine();
			
			ArrayList<MOVIE> movies = db.getmovie();
			MOVIE movie = movies.get(Integer.parseInt(selectMovie)-1);
			String moviecode = movie.getMoviecode();
			
			System.out.printf("\n영화 [%s]의 수정 정보를 입력하세요. (변경사항이 없을 시 '308')", movie.getMoviename());
			System.out.print("\n=================================");
			System.out.printf("\n제목 : %s >> ", movie.getMoviename());
			String moviename = sc.nextLine();
			if ( moviename.equals("308") == true ) { moviename = movie.getMoviename(); }
					
			System.out.printf("장르 : %s >> ", movie.getThema());	
			String thema = sc.nextLine();
			if ( thema.equals("308") == true ) { thema = movie.getThema(); }
				
			System.out.printf("런타임 : %d >> ", movie.getRuntime());	
			int runtime = sc.nextInt();
			sc.nextLine();
			if ( runtime == 308 ) { runtime = movie.getRuntime(); }
				
			System.out.printf("최소 관람 연령 : %d >> ", movie.getAgegroup());
			int agegroup= sc.nextInt();
			sc.nextLine();	
			if ( agegroup == 308 ) { agegroup = movie.getAgegroup(); }
				
			System.out.printf("개봉일 : %s >> ", movie.getOpendate());
			String opendate = sc.nextLine();
			if ( opendate.equals("308") == true ) { opendate = movie.getOpendate(); }
			
			System.out.println("=================================");
			System.out.println("1. 수정 완료 | 2. 재입력 | 3. 뒤로가기");
			System.out.print("원하는 메뉴를 선택하세요. : ");
			
			while (true) {
				String select = sc.next();
				sc.nextLine();
				if (select.equals("1")) {
					db.updateMovie(moviecode, moviename, thema, runtime, agegroup, 0,opendate);
					System.out.println("\n영화 [" + moviename + "]의 정보가 수정 완료 되었습니다.");
					System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
					break outer;
				}
				else if (select.equals("2")) {
					System.out.println("\n영화 정보 수정을 다시 실행합니다.\n");
					break;
				}
				else if (select.equals("3")) {
					System.out.println("\n영화 정보 수정이 취소되었습니다.");
					System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
					break outer;
				}
				else {
					System.out.print("올바른 번호를 입력해주세요. : ");
					continue;
				}			
			}	
		}	
		
	}	
	
	public void delete() {
		Look_tables look = new Look_tables();
			
		System.out.println("\n< 기존 영화 삭제 >");
		look.look_movie_justfor();
		System.out.print("삭제할 영화를 입력하세요. : ");
		String selectMovie = sc.next();
		sc.nextLine();
			
		ArrayList<MOVIE> movies = db.getmovie();
		MOVIE movie = movies.get(Integer.parseInt(selectMovie)-1);
		String moviecode = movie.getMoviecode();
		
		String moviename = "";
		if(movies.size() >= 1) { moviename = movie.getMoviename(); }
		System.out.printf("\n영화 [%s]을(를) 정말로 삭제하시겠습니까? 1. 예 | 2. 아니요", moviename);
		System.out.print("\n원하는 메뉴를 선택하세요. : ");
		
		while (true) {
			String select = sc.next();
			sc.nextLine();
			if (select.equals("1")) {
				db.deleteMovie(moviecode, moviename);
				System.out.printf("\n영화 [%s]이(가) 삭제되었습니다.\n", moviename);
				System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
				break;
			}
			else if (select.equals("2")) {
				System.out.println("\n영화 삭제가 취소되었습니다.");
				System.out.println("상영 영화 관리 메뉴로 돌아갑니다.");
				break;
			}
			else {
				System.out.println("올바른 번호를 입력해주세요. : ");
				continue;
			}			
		}	
			
	}	
	
}	