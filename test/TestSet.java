import java.util.HashSet;
import java.util.Set;


public class TestSet {
	public class User{
		private Integer id;
		private String name;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySet testSet = new MySet();
		TestSet ts = new TestSet();
		User u1 = ts.new User();
		u1.setId(1);
		u1.setName("wang");
		User u2 = ts.new User();
		u2.setId(2);
		u2.setName("kang");
		User u3 = ts.new User();
		u3.setId(1);
		u3.setName("wang");
		testSet.add(u1);
		testSet.add(u2);
		testSet.add(u3);
		System.out.println(testSet.size());
	}

}
