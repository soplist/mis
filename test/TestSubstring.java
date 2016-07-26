
public class TestSubstring {
    public static void main(String[] args) {
		String s = "\"bcde\"fg\"";
		String s1 = "www.hao123.com/aaaa";
		int firstAIndex = s.indexOf("\"");
		int lastAIndex = s.lastIndexOf("\"");
		int domainIndex = s1.indexOf(".com");
		System.out.println(s);
		System.out.println(firstAIndex+","+lastAIndex);
		System.out.println(s.substring(firstAIndex+1,lastAIndex));
		System.out.println(s.contains("bc"));
		System.out.println(s1.substring(0, domainIndex+".com".length()));
	}
}
