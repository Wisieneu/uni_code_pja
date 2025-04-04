import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Osoba os = new Osoba("alojzy", "dupa", "000213123301101", new Date(101001), "pieklo");

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        ObjectInputStream ois = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        FileInputStream raf = null;

        try {
            // zapis
            fos = new FileOutputStream("testFos.txt");
            oos = new ObjectOutputStream(new FileOutputStream("testOos.txt"));
            oos.writeObject(os);


            // odczyt
            ois = new ObjectInputStream(new FileInputStream("testOos.txt"));
            Osoba osTest = (Osoba) ois.readObject();
            System.out.println(osTest);

            br = new BufferedReader(new FileReader("testInput.txt"));
            bw = new BufferedWriter(new FileWriter("testOutputBw.txt"));

            String c;
            while ((c = br.readLine()) != null) {
                System.out.println(c);
                bw.write(c);
                bw.newLine();
            }
            br.close();

            raf = new FileInputStream("testInput.txt");
            int x;
            while ((x = raf.read()) != -1) {
                fos.write(x);
            }


        } finally {
            if (fos != null) fos.close();
            if (oos != null) oos.close();
            if (ois != null) ois.close();
            if (br != null) br.close();
            if (bw != null) bw.close();
        }
    }
}
