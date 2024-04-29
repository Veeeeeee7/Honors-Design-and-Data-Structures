import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class HuffmanEncoder {
    private String[] codes = new String[128];

    public HuffmanEncoder(String codeFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeFile));
            int index = 0;
            while (br.ready()) {
                codes[index] = br.readLine();
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCodes() {
        for (int i = 0; i < codes.length; i++) {
            System.out.println((char) i + " : " + codes[i]);
        }
    }

    public String encodeChar(char input) {
        return codes[input];
    }

    public void encodeLong(String fileToCompress, String encodedFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToCompress));
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                char c = (char) br.read();
                System.out.println(c);
                sb.append(codes[c]);
                count += codes[c].length();
            }
            sb.append(codes[26]);
            count += codes[26].length();
            for (int i = 8 - count % 8; i > 0; i--) {
                sb.append("0");
            }

            File f = new File(encodedFile);
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(sb.toString());
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
