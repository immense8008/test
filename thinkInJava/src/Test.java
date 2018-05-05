import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
//		String[] str = new String[] { "you", "wu" };
//		List list = Arrays.asList(str);
//		list.add("yangguanbao");
//		str[0] = "gujin";
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String item : list) {
			if ("2".equals(item)) {
				list.remove(item);
			}
		}
		System.out.println(list);
		System.out.println("test");
	}
}
