package MovieReservationDB;

import java.util.ArrayList;

public class Look_tables0 {
	
	public void look_movie_foreach() {
		DBconnectMov db = new DBconnectMov();
		ArrayList<MOVIE> movies = db.getmovie();

		String ageprint = "";
		System.out.printf("\n%-6s\t%-16s\t%-8s\t%-8s\t%-16s\t%-15s", "영화코드", "영화제목", "장르", "러닝타임", "등급", "개봉일");
		System.out.println("\n===========================================================================================================");
		for (MOVIE movie : movies) {
			if (movie.getAgegroup() == 0)
				ageprint = "전체이용가";
			else if (movie.getAgegroup() == 19)
				ageprint = "청소년 관람 불가";
			else
				ageprint = (movie.getAgegroup()+"") +"세 이상 관람가"; 
			
			System.out.printf("%-6s\t%-16s\t%-8s\t%-8s\t%-16s\t%-15s\n",
					movie.getMoviecode(), movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", ageprint, movie.getOpendate().replace("-", "/"));
		}
		System.out.println("===========================================================================================================");
	}
	
	public void look_movie_justfor() {
		DBconnectMov db = new DBconnectMov();
		ArrayList<MOVIE> movies = db.getmovie();
		
		String ageprint = "";
		System.out.printf("\n%-6s%-6s\t%-16s\t%-8s\t%-8s\t%-16s\t%-15s", "번호", "영화코드", "영화제목", "장르", "러닝타임", "등급", "개봉일");
		System.out.println("\n===========================================================================================================");
		for (int i=0; i<movies.size();i++) {
			if (movies.get(i).getAgegroup() == 0)
				ageprint = "전체이용가";
			else if (movies.get(i).getAgegroup() == 19)
				ageprint = "청소년 관람 불가";
			else
				ageprint = (movies.get(i).getAgegroup()+"") +"세 이상 관람가"; 
			System.out.printf("%-6s %-6s\t%-16s\t%-8s\t%-8s\t%-16s\t%-15s\n",
					i+1, movies.get(i).getMoviecode(), movies.get(i).getMoviename(), movies.get(i).getThema(), movies.get(i).getRuntime()+"분", ageprint, movies.get(i).getOpendate().replaceAll("-", "/"));
		}
		System.out.println("===========================================================================================================");
	}
	
	public void look_moviecenter_foreach() {
		DBconnectMov db = new DBconnectMov();
		ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();

		System.out.printf("\n%-6s\t%-8s\t%-20s", "지점코드", "지점명", "주소");
		System.out.println("\n=======================================");
		for (MOVIECENTER moviecenter : moviecenters)
			System.out.printf("%-6s\t%-8s\t%-20s\n", moviecenter.getCentercode(), moviecenter.getCentername(), moviecenter.getAddress());
		System.out.println("=======================================");
	}
	
	public void look_moviecenter_justfor() {
		DBconnectMov db = new DBconnectMov();
		ArrayList<MOVIECENTER> moviecenters = db.getmoviecenter();

		System.out.printf("\n%-3s\t%-8s\t%-20s", "번호", "지점명", "주소");
		System.out.println("\n=====================================");
		for (int i=0; i<moviecenters.size();i++)
			System.out.printf("%-3s\t%-8s\t%-20s\n", i+1, moviecenters.get(i).getCentername(), moviecenters.get(i).getAddress());
		System.out.println("=====================================");
	}
	
	public void look_theater_foreach(String centercode) {
		DBconnectMov db = new DBconnectMov();
		ArrayList<THEATER> theaters = db.gettheater();
		
		System.out.println("상영관 코드\t상영관 이름\t상영관 가격\t청소시간\t맨끝좌석");
		System.out.println("====================================================");
		for (THEATER theater : theaters) {
			if (theater.getCentercode().equals(centercode))
				System.out.printf("%s\t\t%s\t%s\t%s\t%s\n", theater.getTheatercode(), theater.getTheatername(), 
						theater.getSeatprice()+"원", theater.getCleantime()+"분", theater.getTotalseats());
		}
		System.out.println("====================================================");
	}
	
	public void look_theater_justfor(String centercode) {
		DBconnectMov db = new DBconnectMov();
		ArrayList<THEATER> theaters = db.gettheater();
				
		System.out.printf("\n%-3s\t%-8s\t%-8s\t%-8s\t%-8s","번호", "상영관 이름", "마지막 좌석", "좌석당 가격", "청소시간");
		System.out.println("\n=================================================================");
		for (int i=0; i<theaters.size();i++) {
			if (theaters.get(i).getCentercode().equals(centercode))
				System.out.printf("%-3s\t%-8s\t%-8s\t%-8s\t%-8s\n",
						i+1, theaters.get(i).getTheatername(), theaters.get(i).getTotalseats(), theaters.get(i).getSeatprice()+"원", theaters.get(i).getCleantime()+"분");
		}
		System.out.println("=================================================================");
	}
	
	public void look_screen_foreach(String moviecode, String theatercode) {
		DBconnectMov db = new DBconnectMov();
		ArrayList<SCREEN> screens = db.getscreen();
		ArrayList<MOVIE> movies = db.getmovie();
		ArrayList<THEATER> theaters = db.gettheater();
		String moviename = "";
		String theatername = "";
		
		for (MOVIE movie : movies) {
			if (moviecode.equals(movie.getMoviecode()))
				moviename = movie.getMoviename();
		}
		
		for (THEATER theater : theaters) {
			if (theatercode.equals(theater.getTheatercode()))
				theatername = theater.getTheatername();
		}
		
		System.out.println("상영 코드\t상영 영화 이름\t\t상영관 이름\t상영 날짜\t상영 시각");
		System.out.println("=============================================================");
		for (SCREEN screen : screens) {
			if (screen.getMoviecode().equals(moviecode)&&screen.getTheatercode().equals(theatercode)) {
				String screencode = screen.getScreencode();
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\t%s ~ %s\n", screen.getScreencode(), moviename, 
						theatername, db.lookstartdate(screencode).replace("-","/"),
						db.lookstarttime(screencode), db.lookendtime(screencode));
			}
		}
	}
	
	public void look_screen_justfor(String moviecode, String theatercode) {
		DBconnectMov db = new DBconnectMov();
		ArrayList<SCREEN> screens = db.getscreen();
		ArrayList<MOVIE> movies = db.getmovie();
		ArrayList<THEATER> theaters = db.gettheater();
		String moviename = "";
		String theatername = "";
		
		for (MOVIE movie : movies) {
			if (moviecode.equals(movie.getMoviecode()))
				moviename = movie.getMoviename();
		}
		
		for (THEATER theater : theaters) {
			if (theatercode.equals(theater.getTheatercode()))
				theatername = theater.getTheatername();
		}
		
		System.out.println("번호 상영 영화 이름\t\t상영관 이름\t상영 날짜\t상영 시각");
		System.out.println("====================================================================");
		for (int i=0; i<screens.size();i++) {
			if (screens.get(i).getMoviecode().equals(moviecode)&&screens.get(i).getTheatercode().equals(theatercode)) {
				String screencode = screens.get(i).getScreencode();
				System.out.printf("%s. %s\t\t%s\t\t%s\t%s ~ %s\n", i+1, moviename, 
						theatername,db.lookstartdate(screencode), db.lookstarttime(screencode)
						,db.lookendtime(screencode));
			}
		}
	}
	public void printTheater(ArrayList<THEATER> TheaterList) {
		System.out.printf("\n%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s", "지점코드", "상영관코드", "상영관 이름", "마지막 좌석", "좌석당 금액", "청소 시간");
		System.out.println("\n=================================================================================");
		for(int i = 0; i < TheaterList.size(); i++) {
			System.out.printf("%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s\n",
					TheaterList.get(i).getCentercode(), TheaterList.get(i).getTheatercode(), TheaterList.get(i).getTheatername(),
					TheaterList.get(i).getTotalseats(), TheaterList.get(i).getSeatprice()+"원", TheaterList.get(i).getCleantime()+"분");
		}
		System.out.println("=================================================================================");
	}

}
