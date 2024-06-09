import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.PriorityQueue;

public class HuffmanCodeGenerator {
    private int[] frequencyList = new int[128];
    private String[] codes = new String[128];

    public HuffmanCodeGenerator(String frequencyFile) {
        for (int i = 0; i < frequencyList.length; i++) {
            frequencyList[i] = 0;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(frequencyFile));
            while (br.ready()) {
                frequencyList[br.read()]++;
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        frequencyList[26] = 1;
        createCodes(createTree(), "");
        makeCodeFile("codes.txt");
    }

    public int getFrequency(char c) {
        return frequencyList[c];
    }

    public NodeV createTree() {
        PriorityQueue<NodeV> pq = new PriorityQueue<>();

        for (int i = 0; i < frequencyList.length; i++) {
            if (frequencyList[i] != 0) {
                pq.add(new NodeV(frequencyList[i], (char) i));
            }
        }

        while (pq.size() > 1) {
            NodeV first = pq.poll();
            NodeV second = pq.poll();
            NodeV parent = new NodeV(first.frequency + second.frequency);
            if (first.compareTo(second) < 0) {
                parent.left = first;
                parent.right = second;
            } else {
                parent.left = second;
                parent.right = first;
            }

            pq.add(parent);
        }
        return pq.poll();
    }

    public void createCodes(NodeV node, String currentCode) {
        if (node.left == null && node.right == null) {
            codes[node.value] = currentCode;
        }
        if (node.left != null) {
            createCodes(node.left, currentCode + "0");
        }
        if (node.right != null) {
            createCodes(node.right, currentCode + "1");
        }
    }

    public String getCode(char c) {
        return codes[c];
    }

    public void makeCodeFile(String codeFile) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] != null) {
                sb.append(codes[i] + "\n");
            } else {
                sb.append('\n');
            }
        }

        try {
            File f = new File(codeFile);
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(sb.toString());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
