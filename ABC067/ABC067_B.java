import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
 
		int haveNum = scan.nextInt();
		int selectNum = scan.nextInt();
		int answer = 0;
 
		ArrayList<Integer> list = new ArrayList<Integer>();
 
		for(int i = 0; i < haveNum; i++) {
			list.add(scan.nextInt());
		}
 
		Collections.sort(list, Comparator.reverseOrder());
 
		for(int i = 0; i < selectNum; i++) {
			answer += list.get(i);
		}
 
		System.out.println(answer);
	}
}