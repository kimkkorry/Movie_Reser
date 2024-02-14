package TeamC_Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Admin_Screen extends Admin_Class {
	Scanner sc = new Scanner(System.in);
	DAO_Movie dm = new DAO_Movie();
	DAO_Screen ds = new DAO_Screen();
	DAO_Moviecenter db = new DAO_Moviecenter();
	DAO_Theater dt = new DAO_Theater();
	Look_tables lt = new Look_tables();
	DBconnectMov dbt = new DBconnectMov();

	public String makecode() {
		ArrayList<DTO_Screen> screens = ds.getScreen();
		String tmp = "";
		if (screens.size() >= 1) {
			tmp = screens.get(screens.size()-1).getScreencode();
		}
		String screencode = ""; // 지점 코드 생성
		if (tmp.equals(""))
			screencode = "S001";
		else {
			int screencod = Integer.parseInt(tmp.substring(1));
			screencod++;
			if (screencod < 10) {
				screencode = "S00" + screencod;
			} else if (10 <= screencod && screencod < 100) {
				screencode = "S0" + screencod;
			} else {
				screencode = "S" + screencod;
			}
		}
		return screencode;
	}

	public void add() {
		ArrayList<DTO_Screen> screens = ds.getScreen();
		String screencode = makecode();
		ArrayList<DTO_Movie> movies = dm.getmovie();
		ArrayList<DTO_Moviecenter> moviecenters = db.getMoviecenter();
		ArrayList<DTO_Theater> theaters = dt.getTheater();
		ArrayList<DTO_Theater> theaterss = new ArrayList<>();
		ArrayList<DTO_Screen> screenss = new ArrayList<>();
		ArrayList<String> screentime = new ArrayList<>();
		
		System.out.println("\n\n< 새 상영 등록 >");
		System.out.println("\n영화 선택");
		System.out.println("=========================");
		System.out.println("번호\t영화 제목");
		System.out.println("=========================");
		for (int i = 0; i < movies.size(); i++) {
			System.out.printf("%s\t%s\n", i + 1, movies.get(i).getMoviename());
		}
		System.out.println("=========================");
		System.out.print("상영할 영화를 선택하세요. : ");
		int indexmov = sc.nextInt()-1;
		//sc.nextLine();// 개행처리

		String moviecode = movies.get(indexmov).getMoviecode();
		String moviename = movies.get(indexmov).getMoviename();
		int runtime = movies.get(indexmov).getRuntime();
		System.out.println("\n지점 선택");
		System.out.println("=========================");
		System.out.println("번호\t지점명");
		System.out.println("=========================");
		for (int i = 0; i < moviecenters.size(); i++) {
			System.out.printf("%d\t%s\n", i+1, "30VI8 "+moviecenters.get(i).getCentername());
		}
		System.out.println("=========================");
		System.out.print("상영할 지점을 선택하세요. : ");
		int indexcen = sc.nextInt()-1;
		//sc.nextLine();// 개행처리
		String centername = moviecenters.get(indexcen).getCentername();

		for (DTO_Theater theater : theaters) {
			if (theater.getCentercode().equals(moviecenters.get(indexcen).getCentercode()))
				theaterss.add(theater);
		}
		System.out.println("\n상영관 선택");
		System.out.println("=========================");
		System.out.println("번호\t상영관 이름");
		System.out.println("=========================");
		for (int i = 0; i < theaterss.size(); i++) {
			System.out.printf("%d\t%s\n", i+1, "30VI8 "+theaterss.get(i).getTheatername());
		}
		System.out.println("=========================");
		System.out.print("상영할 상영관울 선택하세요. : ");
		int indexthe = sc.nextInt()-1;
		//sc.nextLine();// 개행처리

		String theatercode = theaterss.get(indexthe).getTheatercode();
		String theatername = theaters.get(indexthe).getTheatername();
		int cleantime = theaters.get(indexthe).getCleantime();
		
		System.out.println("\n원하는 상영일을 입력하세요. ex) 2023/05/01");
		String screendate = sc.next();
		//sc.nextLine();// 개행처리
		
		for (DTO_Screen screen : screens) {
			if (screen.getTheatercode().equals(theatercode)&&
					(dbt.lookstartdate(screen.getScreencode())).equals(screendate))
				screenss.add(screen);
		}
		
		System.out.println("\n========================================================");
		if (screenss.size()==0) {
			System.out.println("해당 날짜 및 상영관에 등록된 상영이 없습니다.");
			System.out.println("========================================================");
			System.out.println("▶ 상영 중인 시간 및 청소시간을 제외한 나머지 시간에 상영추가가 가능합니다.");
			System.out.printf("▶ [%s]의 청소시간은 '%s분'입니다.\n", theatername, cleantime);
			System.out.printf("▶ 영화 [%s]의 런타임은 '%s분'입니다.\n", moviename, runtime);
			System.out.println("\n추가하실 시간을 입력해주세요. ex) 05:01");
			String time = sc.next();
			String[] times = time.split(":");
			
			if (addtime(screentime, time, runtime)) {
				String starttime = screendate.replaceAll("/", "-") + " ";
				starttime += time+"";
				String endtime = screendate.replaceAll("/", "-") + " ";
				endtime += makeendtime(Integer.parseInt(times[0]), Integer.parseInt(times[1]), runtime);
				System.out.printf("\n[ 영화 제목 : %s | 지점 : %s | 상영관 이름 : %s | 시작 시간 : %s | 종료 시간 : %s ]\n", 
						moviename, centername, theatername, starttime.replace("-", "/"), endtime.replace("-", "/"));
				System.out.println("\n추가하신 상영 정보입니다. 위의 정보가 확실합니까? 1. 예 | 2. 아니요");
				System.out.print("원하는 메뉴를 선택하세요. : ");
				int num = sc.nextInt();
				switch(num) {
				case 1:
					ds.insertscreen(screencode, moviecode, theatercode, starttime, endtime, 0);
					break;
				case 2:
					System.out.println("\n상영 등록이 취소됩니다.");
					break;
				default :
					System.out.println("\n올바른 번호를 입력해주세요.");
					break;
				}
			}
			else {
				System.out.println("\n※ 해당 시간에 상영되는 영화가 있어 상영 등록이 취소됩니다.");
			}
		} else {
			System.out.println("\n해당 날짜 및 상영관의 상영 내역입니다.\n");
			System.out.printf("%-3s\t%-8s\t%-15s\t%-10s\t%-8s\n", "번호", "상영 날짜", "상영 시각", "영화 이름", "상영관 이름");
			System.out.println("==========================================================================");
			int k=1;
			for (DTO_Screen screen : screenss) {
				System.out.printf("%-3s\t%-8s\t%-4s ~ %-8s\t%-10s\t%-8s\n", 
						k, dbt.lookstartdate(screen.getScreencode()).replace("-","/"),dbt.lookstarttime(screen.getScreencode()), dbt.lookendtime(screen.getScreencode()),
						moviename, theatername);
					k+=1;
			}
			System.out.println("==========================================================================");
			screentime = selecttime(screenss, theatercode);
			
			System.out.println("▶ 상영 중인 시간 및 청소시간을 제외한 나머지 시간에 상영추가가 가능합니다.");
			System.out.printf("▶ [%s]의 청소시간은 '%s분'입니다.\n", theatername, cleantime);
			System.out.printf("▶ 영화 [%s]의 런타임은 '%s분'입니다.\n", moviename, runtime);
			System.out.println("\n추가하실 시간을 입력해주세요. ex) 05:01");
			String time = sc.next();
			String[] times = time.split(":");
			
			if (addtime(screentime, time, runtime)) {
				String starttime = screendate.replaceAll("/", "-") + " ";
				starttime += time+"";
				String endtime = screendate.replaceAll("/", "-") + " ";
				endtime += makeendtime(Integer.parseInt(times[0]), Integer.parseInt(times[1]), runtime);
				System.out.printf("\n[ 영화 제목 : %s | 지점 : %s | 상영관 이름 : %s | 시작 시간 : %s | 종료 시간 : %s ]\n", 
						moviename, centername, theatername, starttime.replace("-", "/"), endtime.replace("-", "/"));
				System.out.println("\n추가하신 상영 정보입니다. 위의 정보가 확실합니까? 1. 예 | 2. 아니요");
				System.out.print("원하는 메뉴를 선택하세요. : ");
				int num = sc.nextInt();
				switch(num) {
				case 1:
					ds.insertscreen(screencode, moviecode, theatercode, starttime, endtime, 0);
					break;
				case 2:
					System.out.println("\n상영 등록이 취소됩니다.");
					break;
					default :
						System.out.println("\n올바른 번호를 입력해주세요.");
						break;
				}
			} else {
				System.out.println("\n※ 해당 시간에 상영되는 영화가 있어 상영 등록이 취소됩니다.");
			}
		}
	}

	public void delete() {
		ArrayList<DTO_Screen> screens = ds.getScreen();
		ArrayList<DTO_Movie> movies = dm.getmovie();
		ArrayList<DTO_Moviecenter> moviecenters = db.getMoviecenter();
		ArrayList<DTO_Theater> theaters = dt.getTheater();
		ArrayList<DTO_Theater> theaterss = new ArrayList<>();
		ArrayList<DTO_Screen> screenss = new ArrayList<>();
		
		System.out.println("\n\n< 기존 상영 삭제 >");
		System.out.println("\n영화 선택");
		System.out.println("=========================");
		System.out.println("번호\t영화 제목");
		System.out.println("=========================");
		for (int i = 0; i < movies.size(); i++) {
			System.out.printf("%s\t%s\n", i + 1, movies.get(i).getMoviename());
		}
		System.out.println("=========================");
		System.out.print("상영 삭제할 영화를 선택하세요. : ");
		int nummov = sc.nextInt()-1;
		String moviecode = movies.get(nummov).getMoviecode();
		String moviename = movies.get(nummov).getMoviename();

		System.out.println("\n지점 선택");
		System.out.println("=========================");
		System.out.println("번호\t지점명");
		System.out.println("=========================");
		for (int i = 0; i < moviecenters.size(); i++) {
			System.out.printf("%d\t%s\n", i+1, "30VI8 "+moviecenters.get(i).getCentername());
		}
		System.out.println("=========================");
		System.out.print("상영 삭제할 지점을 선택하세요. : ");
		int numcen = sc.nextInt()-1;
		for (DTO_Theater theater : theaters) {
			if (theater.getCentercode().equals(moviecenters.get(numcen).getCentercode()))
				theaterss.add(theater);
		}
		
		System.out.println("\n상영관 선택");
		System.out.println("=========================");
		System.out.println("번호\t상영관 이름");
		System.out.println("=========================");
		for (int i = 0; i < theaterss.size(); i++) {
			System.out.printf("%d\t%s\n", i+1, "30VI8 "+theaterss.get(i).getTheatername());
		}
		System.out.println("=========================");
		System.out.print("상영 삭제할 상영관울 선택하세요. : ");
		int numthe = sc.nextInt()-1;
		sc.nextLine();
		String theatercode = theaterss.get(numthe).getTheatercode();
		String theatername = theaterss.get(numthe).getTheatername();
		
		for (DTO_Screen screen : screens) {
			if (screen.getMoviecode().equals(moviecode)&&screen.getTheatercode().equals(theatercode))
				screenss.add(screen);
		}
		
		System.out.println("\n해당 영화 및 상영관의 상영 내역입니다.\n");
		System.out.printf("%-3s\t%-8s\t%-15s\t%-10s\t%-8s\n", "번호", "상영 날짜", "상영 시각", "영화 이름", "상영관 이름");
		System.out.println("==========================================================================");
		int k=1;
		for (DTO_Screen screen : screenss) {
				System.out.printf("%-3s\t%-8s\t%-4s ~ %-8s\t%-10s\t%-8s\n", 
					k, dbt.lookstartdate(screen.getScreencode()).replace("-","/"), dbt.lookstarttime(screen.getScreencode()), dbt.lookendtime(screen.getScreencode()),
					moviename, theatername); 
				k+=1;
		}
		System.out.println("==========================================================================");
		System.out.println("삭제하실 상영들을 'Space Bar'로 구분하여 번호를 입력해주세요. ex) 2 5 6 9");
		String[] delnum = sc.nextLine().split(" ");
		
		System.out.println("선택하신 상영들을 삭제하시겠습니까? 1. 예 | 2. 아니요");
		System.out.print("원하는 메뉴를 선택하세요. : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 :
			for (int i=0; i<delnum.length;i++) 
				//ds.deletescreen(screenss.get(Integer.parseInt(delnum[i])-1).getScreencode());
			dbt.deletescreen(screenss.get(Integer.parseInt(delnum[i])-1).getScreencode());
			
			break;
		case 2 :
			System.out.println();
			break;
			default :
				System.out.println();
				break;
		}
	}
	
	public ArrayList<String> selecttime(ArrayList<DTO_Screen> screens, String theatercode) {
		ArrayList<String> selecttime = new ArrayList<>();
		ArrayList<DTO_Theater> theaters = dt.getTheater();
		int cleantime = 0;
		for (DTO_Theater theater : theaters) {
			if (theater.getTheatercode().equals(theatercode))
				cleantime = theater.getCleantime();
		}
		for (DTO_Screen screen : screens) {
			int starthour = Integer.parseInt(dbt.lookstarttime(screen.getScreencode()).substring(0,2));
			int startmin = Integer.parseInt(dbt.lookstarttime(screen.getScreencode()).substring(3,5));
			int endhour = Integer.parseInt(dbt.lookendtime(screen.getScreencode()).substring(0,2));
			int endmin = Integer.parseInt(dbt.lookendtime(screen.getScreencode()).substring(3,5));
			
			String startttime = makestarttime(starthour, startmin, cleantime);
			String endtime = makeendtime(endhour, endmin, cleantime);
			selecttime.add(startttime);
			selecttime.add(endtime);
			}
		
		
		return selecttime;
	}
	public String makestarttime(int starthour, int startmin, int cleantime) {
		String starttime = "";
		int originhour = starthour;
		int originmin = startmin;
		startmin -= cleantime;
		while (true) {
		if (startmin<0) {
			starthour -= 1;
			startmin = 60 + startmin;
		}
		else
			break;
		}
		if (starthour<0) {
			if (originhour<10) 
				starttime += "0"+originhour+":";
			else
				starttime += originhour+":";
			if (originmin<10)
				starttime += "0"+originmin;
			else
				starttime += originmin+"";
		}
		else {
			if (starthour<10) 
				starttime += "0"+starthour+":";
			else
				starttime += starthour+":";
			if (startmin<10)
				starttime += "0"+startmin;
			else
				starttime += startmin+"";
		}
		
		return starttime;
	}
	public String makeendtime(int endhour, int endmin, int cleantime) {
		String endtime = "";
		int a = 0;
		endmin+=cleantime;
		if (endmin>=60) {
			a = endmin/60;
			endmin = endmin%60;
			endhour += a;
		}
		if (endhour<10) 
			endtime += "0"+endhour+":";
		else
			endtime += endhour+":";
		if (endmin<10)
			endtime += "0"+endmin;
		else
			endtime += endmin+"";
		
		
		return endtime;
	}
	public boolean addtime(ArrayList<String> selecttimes, String time, int runtime) {
		String [] timearr = time.split(":");
		int [] timeintarr = new int [4];
		for (int i=0; i<timearr.length;i++)
			timeintarr[i] = Integer.parseInt(timearr[i]);
		
		int count = 0;
		
		String endtime = makeendtime(timeintarr[0], timeintarr[1], runtime);
		
		String [] endtimearr = endtime.split(":");
		for (int i=0; i<endtimearr.length;i++)
			timeintarr[i+2] = Integer.parseInt(endtimearr[i]);
		
		for (int i=0; i<selecttimes.size(); i+=2) {
			String selectstart[] = selecttimes.get(i).split(":");
			String selectend[] = selecttimes.get(i+1).split(":");
			int select [] = new int [4];
			for (int j=0; j<selectstart.length;j++)
				select[j] = Integer.parseInt(selectstart[j]);
			for (int j=0; j<selectend.length;j++)
				select[j+2] = Integer.parseInt(selectend[j]);
			int chotime [] = new int [2];
			chotime[0] = timeintarr[0]*60+timeintarr[1];
			chotime[1] = timeintarr[2] * 60 + timeintarr[3];
			int seltime[] = new int [2];
			seltime[0] = select[0] * 60 + select[1];
			seltime[1] = select[2] * 60 + select[3];
			
			if (chotime[0]>=seltime[1]||chotime[1]<=seltime[0])
				count +=0;
			else
				count +=1;
		}
		if (count == 0)
			return true;
		else
			return false;
		
	}
}
