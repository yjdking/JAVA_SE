package newfeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lamda {
    public List arrayList = (List) Arrays.asList(1,2,3);

    public List<String> arrayList1 = Arrays.asList("1","2");

    public void testlamda() {
        arrayList.forEach(element -> System.out.println("test: " + element));
    }
}


