import java.io.*;

public class S34380 {
    public static class Node {
        char key;
        int occurencesAmount = 0;
        Node next;

        public Node(char key) {
            this.key = key;
        }
    }

    public static class CharactersTab {
        Node tail;
        Node head;

        public CharactersTab(Node tail) {
            this.tail = tail;
            this.head = tail; // start and finish
        }

        void appendCharOccurence(char key) {
            Node curr = this.tail;
            boolean inc = false;
            do {
                if (curr.key == key) {
                    curr.occurencesAmount += 1;
                    inc = true;
                    break;
                }
            } while (curr.next != null);
            if (!inc) {
                Node newNode = new Node(key);
                this.head.next = newNode;
                newNode.occurencesAmount += 1;
            }
        }

        void displayOccurences() {
            Node curr = this.tail;
            do {
                System.out.println("Znak " + curr.key + " wystapil w pliku " + curr.occurencesAmount + " razy");
            } while (curr.next != null);
        }
    }

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(
                    "G:\\OneDrive\\111000\\uni-code-pja\\1 semester\\PPJ\\13\\JavaScriptSaveMePls.txt");
            String trescPliku = "";
            int currByte = fis.read();
            char currChar = (char) currByte;
            CharactersTab charTab = new CharactersTab(new Node(currChar));
            while (currByte != -1) {
                System.out.print(currChar);
                charTab.appendCharOccurence(currChar);
                trescPliku += currChar;

                currByte = fis.read();
                currChar = (char) currByte;
            }
            fis.close();
            System.out.println("Praca zakonczona. Rezulaty:");
            System.out.println("Zawartosc pliku:");
            System.out.println(trescPliku);
            charTab.displayOccurences();
        } catch (FileNotFoundException err) {
            err.printStackTrace();
            System.out.println("file not found");
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
