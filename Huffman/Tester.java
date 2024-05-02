import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class Tester {
    public static void main(String[] args) throws Exception {
        // HuffmanCodeGenerator h = new HuffmanCodeGenerator("frequencyCountInput
        // (1).txt");
        // for (int i = 0; i < 128; i++) {
        // System.out.println((char) i + " : " + h.getFrequency((char) i));
        // }

        HuffmanEncoder h = new HuffmanEncoder("codes.txt");
        // h.encodeLong("frequencyCountInput.txt", "encoded.txt");
        h.encodeFile("frequencyCountInput.txt");
        // try {
        // BufferedReader br = new BufferedReader(new FileReader("encoded.txt"));
        // System.out.println(br.readLine().length());

        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        HuffmanDecoder hd = new HuffmanDecoder("codes.txt");
        hd.decodeFile("frequencyCountInput.huf");
    }
}
