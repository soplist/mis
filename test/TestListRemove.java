import java.util.ArrayList;
import java.util.List;


public class TestListRemove {
    public static void main(String[] args) {
		class O{
			public int index;
		}
		O o1 = new O();
		o1.index = 1;
		O o2 = new O();
		o2.index = 2;
		O o3 = new O();
		o3.index = 3;
		O o5 = new O();
		o5.index = 5;
		O o4 = null;
		
		List<O> list = new ArrayList<O>();
		list.add(o1);
		list.add(o2);
		list.add(o3);
		list.add(o5);
		for (O o : list) {
			System.out.println("o.index="+o.index);
			if(o.index==2){
				o4 = o;
				list.remove(o);
			}
			
		}
		
		
		
		System.out.println("list.size="+list.size());
		System.out.println("o4.index="+o4.index);
	}
}
