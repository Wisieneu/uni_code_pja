import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream x = null;

        try{
            x = new ObjectOutputStream(new FileOutputStream("output.txt"));
            x.writeObject(new Piornik(new Olowek("dasd"), new Dep2("xasd")));
        } finally {
            if(x != null) x.close();
        }
    }
}
