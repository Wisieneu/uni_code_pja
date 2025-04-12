import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] arr = {
                "office A", "John", "Doe",
                "office B", "John", "Brown",
                "office C", "Mary", "Jones",
                "office B", "Adam", "Rust",
                "office C", "Cindy", "Frost",
                "office A", "Kate", "Coe",
                "office A", "Bill", "Brown"
        };

        mainFn(arr);
    }

    public static void mainFn(String[] arr) {
        HashMap<String, List<Person>> mapa1 = new HashMap<>();
        for (int i = 0; i < arr.length / 3; i++) {
            System.out.println(arr[i*3] + arr[(i*3) + 1] + arr[(i*3) + 2]);
            String officeNo = arr[i*3];
            Person os = new Person(officeNo, arr[(i*3) + 1], arr[(i*3) + 2]);
            System.out.println(os);
            List<Person> temp = mapa1.get(officeNo);
            if (temp == null)
                temp = new ArrayList<>();
            temp.add(os);
            mapa1.put(officeNo, temp);
        }
        System.out.println(mapa1);
        System.out.println("office A: " + mapa1.get("office A").size() + " users");
    }
}
