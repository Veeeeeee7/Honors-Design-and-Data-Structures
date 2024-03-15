import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MiniGPT {
	private HashMap<String, ArrayList<Character>> map = new HashMap<>();

	public MiniGPT(String fileName, int chainOrder) throws Exception {
		if (chainOrder <= 0) {
			return;
		}

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		StringBuilder previous = new StringBuilder();
		char next = '\0';
		for (int i = 0; i < chainOrder && reader.ready(); i++) {
			previous.append((char) reader.read());
		}
		while (reader.ready()) {
			next = (char) reader.read();

			if (map.containsKey(previous.toString())) {
				map.get(previous.toString()).add(next);
			} else {
				map.put(previous.toString(), new ArrayList<Character>(Arrays.asList(next)));
			}

			previous.deleteCharAt(0);
			previous.append(next);
		}
		reader.close();
	}

	public void generateText(String outputFileName, int numChars) throws Exception {
		if (numChars <= 0) {
			return;
		}
		StringBuilder seed = new StringBuilder();
		int max = 0;
		for (String key : map.keySet()) {
			if (map.get(key).size() > max) {
				max = map.get(key).size();
				seed = new StringBuilder(key);
			}
		}
		System.out.println("|" + seed + "|");

		StringBuilder content = new StringBuilder(seed);
		for (int i = 0; i < numChars - seed.length(); i++) {
			System.out.println(seed);
			char c = map.get(seed.toString()).get((int) (Math.random() * map.get(seed.toString()).size()));
			content.append(c);
			seed.append(c);
			seed.deleteCharAt(0);
		}
		content.delete(numChars, content.length());

		File f = new File(outputFileName);
		FileWriter fw = new FileWriter(f);
		fw.write(content.toString());
		fw.close();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key + " : ");
			for (char c : map.get(key)) {
				sb.append(c + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
