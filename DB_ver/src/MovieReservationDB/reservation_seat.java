package MovieReservationDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class reservation_seat {
	public ArrayList<String> reservationseat(int count, String screencode) {
		Scanner scanner = new Scanner(System.in);
		DBconnectMov db = new DBconnectMov();
		ArrayList<String> notresseats = new ArrayList<>();
	ArrayList<RESERVATION> reservations = db.getreservations();
	ArrayList<THEATER> theaters = db.gettheater();
	ArrayList<SCREEN> screens = db.getscreen();
		
		int aa = 0;
		ArrayList<String> seeaat = new ArrayList<>();
for (RESERVATION reservation : reservations) {
	if (reservation.getScreencode().equals(screencode)) {
		String [] seat = reservation.getSelectseat().split(";");
		List<String> a = Arrays.asList(seat);
		notresseats.addAll(a);
	}
}

String [] seat = new String[3];
String theatercode = "";

for (SCREEN screen : screens) {
	if (screen.getScreencode().equals(screencode))
		theatercode = screen.getTheatercode();
}

for (THEATER theater : theaters) {
	if (theater.getTheatercode().equals(theatercode))
		seat = theater.getTotalseats().split("");
}

int size1 = (seat[0].charAt(0)-64)+2;
int size2 = Integer.parseInt(seat[1]+seat[2])+2;

		String [][] theater1 = new String [size1][size2];
		for (int i = 1; i<4; i++) {
			String a = ""+i;
			theater1[0][i] = a;
		}
		for (int i = 3; i<7; i++) {
			String a = ""+i;
			theater1[0][i+1] = a;
		}
		for (int i = 7; i<size2; i++) {
			String a = ""+i;
			if ((i+2)<size2)
			theater1[0][i+2] = a;
		}
		theater1[0][0] = " ";
		for (int i = 1; i<5; i++) {
			char a = (char)('A'+i-1);
			theater1[i][0] = String.valueOf(a);
		}
		for (int i = 5; i<size1; i++) {
			char a = (char)('A'+i-1);
			if (i+1<size1)
			theater1[i+1][0] = String.valueOf(a);
		}
		for (int i=1; i<size1; i++) {
			for(int j=1; j<size2; j++) {
				theater1[i][j] = "□";
			}
		}
		for (int i=0; i<size1; i++) {
			theater1[i][3] = " ";
			theater1[i][8] = " ";
		}
		for (int i=0; i<size2; i++)
		theater1[5][i] = " ";
		
		for (int i=0; i<notresseats.size(); i++) {
			String notseat [] = notresseats.get(i).split("");
			for (int j= 0; j<size1; j++) {
				if (notseat[0].equals(theater1[j][0])) {
					for (int k=0; k<size2; k++) {
						if (!theater1[0][k].equals(" ")) {
						if (Integer.parseInt(notseat[1]+notseat[2]) == Integer.parseInt(theater1[0][k])) {
							theater1[j][k] = "■";	
						}
						}
					}
				}
			}
		}
		for (int i=0; i<size1; i++) {
			System.out.println();
			for(int j=0; j<size2; j++) {
				System.out.printf("%s ",theater1[i][j]);
			}
		}

		System.out.println();
		System.out.printf("'■'표시 된 좌석은 이미 예약된 자리입니다.\n위 자리중 원하시는 좌석 %d개를 선택해주세요.", count);
		ArrayList<String> seatss = new ArrayList<>();
		for (int i=0; i<count; i++) {
			System.out.printf("\n%d번째 좌석의 알파벳을 대문자로 입력해주세요. (ex : E)", i+1);
			String Alp = scanner.next();
			ArrayList<String> Alphabet = new ArrayList<>();
			for (char a = 'A'; a<'J'; a++) {
				String b = ""+a;
				Alphabet.add(b);
			}
			if (Alphabet.contains(Alp)) {
				System.out.printf("%d번째 좌석의 숫자를 입력해주세요. (ex : 3)", i+1);
				int nnum = scanner.nextInt();
				if (nnum>=1&&nnum<=size2-3) {
					String nnumm = "";
					if (nnum<10)
					nnumm = "0"+nnum;
					else
						nnumm = ""+nnum;
					seatss.add(Alp+nnumm);
					for (int j= 0; j<size1; j++) {
						if (Alp.equals(theater1[j][0])) {
							for (int k=0; k<size2; k++) {
								if ((nnum+"").equals(theater1[0][k])) 
									theater1[j][k] = "▣";	
							}
						}
					}
					for (int k=0; k<size1; k++) {
						System.out.println();
						for(int j=0; j<size2; j++) {
							System.out.printf("%s ",theater1[k][j]);
						}
					}
					System.out.println();
					System.out.printf("%s%s 좌석을 선택하셨습니다.\n", Alp, nnumm);

				}
				else {
					System.out.println("올바른 숫자를 입력해주세요.");
				i--;
				}
			}
			else {
				System.out.println("올바른 알파벗을 입력해주세요.");
			i--;
			}
		}
		System.out.println();
		for (int i=0; i<seatss.size(); i++)
			System.out.printf("%s좌석\n", seatss.get(i));

		return seatss;
	}
}
