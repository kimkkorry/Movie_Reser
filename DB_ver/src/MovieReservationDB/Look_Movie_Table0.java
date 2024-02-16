package MovieReservationDB;

import java.util.ArrayList;

public class Look_Movie_Table0 {
	// MOVIE 리스트 출력
	public void look_movie() {
		DBconnectMov db = new DBconnectMov();
		ArrayList<MOVIE> movies = db.getmovie();

		String ageprint = "";
		System.out.printf("\n%-6s\t%-16s\t%-10s\t%-8s\t%-16s\t%-15s", "영화코드", "영화제목", "장르", "러닝타임", "등급", "개봉일");
		System.out.println("\n===================================================================================================");
		for (MOVIE movie : movies) {
			if (movie.getAgegroup() == 0)
				ageprint = "전체이용가";
			else if (movie.getAgegroup() == 19)
				ageprint = "청소년 관람 불가";
			else
				ageprint = (movie.getAgegroup()+"") +"세 이상 관람가"; 
			
			System.out.printf("%-6s\t%-16s\t%-10s\t%-8s\t%-16s\t%-15s\n",
					movie.getMoviecode(), movie.getMoviename(), movie.getThema(), movie.getRuntime()+"분", ageprint, movie.getOpendate());
		}
		System.out.println("===================================================================================================");

	}	
}
