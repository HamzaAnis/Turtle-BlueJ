
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamza
 */
public class UnixCommandsTest {

    public static LinkedList<String> lineList = new LinkedList<String>();

    public static int[] wc(FileReader in) throws IOException {
        int wordCount = 0;
        int lineCount = 0;
        int chars = 0;
        int c = 0;
        while ((c = in.read()) != -1) {
            chars++;
            if (c == '\n') {
                lineCount++;
            }
            if (c == '\t' || c == ' ' || c == '\n') {
                ++wordCount;
            }
            if (chars != 0) {
                ++chars;
            }
        }
        int[] arr = new int[3];
        arr[0] = lineCount;
        arr[1] = wordCount;
        arr[2] = chars;
        return arr;
    }

    public static void tail(FileInputStream in, FileOutputStream out, int lines) throws IOException {
        int c = 0;
        String line = "";
        char current;
        while (in.available() > 0) {
            current = (char) in.read();
            line = line + current;
            if (current == '\n') {
                lineList.add(line);
                line = "";//clearing the line
            }
        }

        //outputting
        for (int i = 0; i < lineList.size(); i++) {
            System.out.print(lineList.get(i));
        }
        //writing file
        for (int i = 0; i < lineList.size(); i++) {
            out.write(lineList.get(i).getBytes());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("lorem.txt");
        int[] res = new int[3];
        res = wc(fr);
        for (int i = 0; i < 3; i++) {
            System.out.println("The result is " + res[i]);
        }
        FileInputStream in = new FileInputStream("lorem.txt");
        FileOutputStream out = new FileOutputStream("lorem_out.txt");
        tail(in, out, res[0]);

    }
}
