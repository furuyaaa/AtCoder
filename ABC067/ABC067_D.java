import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
	class Masu {
		int masuNumber;
		ArrayList<Integer> closeMasuNumber;
 
		Masu(int i) {
			masuNumber = i;
			closeMasuNumber = new ArrayList<Integer>();
		}
	}
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
 
		// マスの数を取得
		int masuNum = scan.nextInt();
 
		ArrayList<Masu> masuList = new ArrayList<Masu>();
		Main main = new Main();
		for(int i = 0; i < masuNum; i++) {
			masuList.add(main.new Masu(i));
		}
 
		for(int i = 0; i < masuNum - 1; i++) {
			main.inputMasu(scan.nextInt(), scan.nextInt(), masuList);
		}
 
		int[] fennecList = new int[masuNum];
		fennecList[0] = -1;
		int[] snukeList = new int[masuNum];
		snukeList[masuNum - 1] = -1;
 
		// 何手で相手のマスに行き着くか計算する
		// fennecの探査
		main.tansa(masuList,fennecList,0,0);
		// snukeの探査
		main.tansa(masuList,snukeList,masuNum - 1,0);
 
		int fennecWinMasu = 0;
		int snukeWinMasu = 0;
 
		for(int i = 0; i < masuNum; i++) {
			if(fennecList[i] <= snukeList[i]) {
				fennecWinMasu++;
			} else {
				snukeWinMasu++;
			}
		}
 
		if(fennecWinMasu > snukeWinMasu) {
			System.out.println("Fennec");
		} else {
			System.out.println("Snuke");
		}
	}
 
	private void inputMasu(int i, int j, ArrayList<Masu> masuList) {
		masuList.get(i - 1).closeMasuNumber.add(j - 1);
		masuList.get(j - 1).closeMasuNumber.add(i - 1);
	}
 
	private void tansa(ArrayList<Masu> masuList, int[] tansaList, int masu, int depth) {
		ArrayList<Integer> closeMasuList = masuList.get(masu).closeMasuNumber;
 
		for(Integer i:closeMasuList) {
			if(tansaList[i] == 0) {
				tansaList[i] = depth + 1;
				tansa(masuList, tansaList, i , depth + 1);
			}
		}
	}
}