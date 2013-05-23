package sort1;
import java.util.*;
public class foodTest {
	
	static class Student{
		
		int comeTime;
		int mount;
		String food;
		
		public int getComeTime() {
			return comeTime;
		}
		public void setComeTime(int comeTime) {
			this.comeTime = comeTime;
		}
		public int getMount() {
			return mount;
		}
		public void setMount(int mount) {
			this.mount = mount;
		}
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		Student man;
		
		int N=scan.nextInt();
		int mount;
		int time;
		int wait[]=new int[N];
		//Object student[][];
		List student=new ArrayList<Student>();
		for (int j = 0; j < N; j++) {//输入其他同学的到达时间等等信息
			man = new Student();
			time=scan.nextInt();
			mount=scan.nextInt();
			man.setComeTime(time);
			man.setMount(mount);
			//student=new Object[N][mount+2]
			for (int l = 0; l < mount; l++) {
				man.setFood(scan.next());
			}
			student.add(man);
		}
		
		for (int i = 0; i < N; i++){
			//System.out.println(it.next().toString());  //优化后的代码
			//System.out.println(((Student)student.get(i)).comeTime);
			wait[i]=((Student)student.get(i)).comeTime;
		}
		Arrays.sort(wait);
		for (int j = 0; j < wait.length; j++) {
			System.out.println(wait[j]);
		}
	}

}
