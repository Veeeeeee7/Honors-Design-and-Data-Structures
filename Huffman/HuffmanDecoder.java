import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.HashMap;

public class HuffmanDecoder {
    private HashMap<String, Character> codes = new HashMap<>();

    public HuffmanDecoder(String codeFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeFile));
            int index = 0;
            while (br.ready()) {
                String bin = br.readLine();
                if (!bin.equals("")) {
                    codes.put(bin, (char) index);
                }
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isCode(String binary) {
        return codes.containsKey(binary);
    }

    public char decodeChar(String binary) {
        return codes.get(binary);
    }

    public void decodeLong(String encodedFile, String decodeFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            StringBuilder current = new StringBuilder();
            StringBuilder result = new StringBuilder();
            while (br.ready()) {
                current.append((char) br.read());
                if (isCode(current.toString())) {
                    if (decodeChar(current.toString()) == 26) {
                        break;
                    }
                    System.out.println(current.toString());
                    result.append(decodeChar(current.toString()));
                    current = new StringBuilder();
                }
            }

            File f = new File(decodeFile);
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(result.toString());
            fw.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decodeFile(String encodedFile) {
        if (!encodedFile.substring(encodedFile.length() - 3, encodedFile.length()).equals("huf")) {
            throw new IllegalArgumentException();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            StringBuilder bins = new StringBuilder();
            while (br.ready()) {
                String bin = new BigInteger(Integer.toString(br.read())).toString(2);
                int count = 8 - bin.length();
                StringBuilder zeros = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    zeros.append("0");
                }
                bins.append(zeros.toString() + bin);
            }
            br.close();

            BufferedReader br2 = new BufferedReader(new StringReader(bins.toString()));
            StringBuilder current = new StringBuilder();
            StringBuilder result = new StringBuilder();
            while (br2.ready()) {
                current.append((char) br2.read());
                if (isCode(current.toString())) {
                    if (decodeChar(current.toString()) == 26) {
                        break;
                    }
                    result.append(decodeChar(current.toString()));
                    current = new StringBuilder();
                }
            }

            File f2 = new File("decodefile.txt");
            f2.createNewFile();
            FileWriter fw2 = new FileWriter(f2);
            fw2.write(result.toString());
            fw2.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
