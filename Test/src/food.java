import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Student implements Comparable {

	public int comeTime;
	public int mount;
	public int consume_time;
	public boolean isMing = false;

	public String toString() {
		return comeTime + " " + consume_time;
	}

	public int compareTo(Object o) {
		return this.comeTime - ((Student) o).comeTime;
	}
}

public class food {
	public static int waitline[];
	public static int P, K, N, W;// 队伍数量P，食物种类K，人数N，询问W

	public static int queneChose(int moment,int consume_time) {
		int waitTime[] = new int[P];
		for (int i = 0; i < P; i++) {
			waitTime[i] = waitline[i] >= moment ? waitline[i] - moment : 0;
		}

		for (int i = 0; i < P; i++) {
			if (waitTime[i] == 0) {
				waitline[i] = consume_time + W + moment;
				return i;
			}
		}
		
		int minQuene = P - 1;
		int i;
		for (i = P - 1; i >= 0; i--)
			if (waitTime[i] <= waitTime[minQuene])
				minQuene = i;
		waitline[minQuene] += consume_time + W;
		return minQuene;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		P = scan.nextInt();
		K = scan.nextInt();
		N = scan.nextInt();
		N++;
		W = scan.nextInt();

		waitline = new int[P];
		HashMap<String, Integer> food = new HashMap<String, Integer>();
		Student student[] = new Student[N];

		for (int i = 0; i < N; i++)
			student[i] = new Student();

		for (int i = 0; i < K; i++) {// 输入食堂的食物
			String name = scan.next();
			int t = scan.nextInt();
			food.put(name, t);
		}

		student[0].comeTime = scan.nextInt();
		student[0].mount = scan.nextInt();// 输入主人公的到达时间，数量
		int Mconsume_time = 0;
		for (int i = 0; i < student[0].mount; i++) {
			Mconsume_time += food.get(scan.next());
		}
		student[0].consume_time = Mconsume_time;
		student[0].isMing = true;

		for (int j = 1; j < N; j++) {// 输入其他同学的到达时间等等信息
			student[j] = new Student();
			student[j].comeTime = scan.nextInt();
			student[j].mount = scan.nextInt();
			int consume_time = 0;
			for (int l = 0; l < student[j].mount; l++) {
				consume_time += food.get(scan.next());
			}
			student[j].consume_time = consume_time;
		}

		Arrays.sort(student);


		int result1 = 0;
		int result2 = 0;

		for (int i = 0; i < N; i++) {
			int h = queneChose(student[i].comeTime, student[i].consume_time);
			if (student[i].isMing)
				result1 = h;
			if (i == N - 1)
				result2 = h;
		}

		System.out.println(result1 + " " + waitline[result1]);
		System.out.println(waitline[result2]);
	}
}
