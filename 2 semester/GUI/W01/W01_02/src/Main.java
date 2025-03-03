import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileInput = fileToString(
                "G:\\OneDrive\\111000\\uni-code-pja\\2 semester\\GUI\\W01\\W01_02\\src\\tab.txt")
                .replaceAll("\\n", "");
        fileInput = fileInput.replaceAll("\\n", "");
        String[] numbers = fileInput.split("\\s");

        // printing all
        for (String i: numbers) {
            System.out.print(i+ " ");
        }
        System.out.println();

        // value of max
        int max = Integer.MIN_VALUE;
        for (String j: numbers) {
            int val = Integer.parseInt(j);
            if (val > max) max = val;
        }
        System.out.println(max);

        // index of max value
        for (int k = 0; k < numbers.length; k++) {
            if (Integer.parseInt(numbers[k]) == max) System.out.print(k + " ");
        }
    }

    static private String fileToString(String pathToFile) {
        try {
            FileInputStream stream = new FileInputStream(pathToFile);
            int data = stream.read();
            StringBuilder fileInputStr = new StringBuilder();
            while (data != -1) {
                fileInputStr.append((char) data);
                data = stream.read();
            }
            return fileInputStr.toString();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}