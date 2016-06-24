import java.util.HashSet;
import java.util.Set;


public class MySet{

	Set<TestSet.User> testSet = new HashSet<TestSet.User>();
	public Set<TestSet.User> getTestSet() {
		return testSet;
	}
	public void setTestSet(Set<TestSet.User> testSet) {
		this.testSet = testSet;
	}
	public boolean add(TestSet.User u){
		boolean exist = false;
		for (TestSet.User user : testSet) {
			if(user.getId().equals(u.getId())){
				exist = true;
			}
		}
		if(!exist){
			testSet.add(u);
			return true;
		}else{
			return false;
		}
		
	}
	public Integer size(){
		return testSet.size();
	}

}
