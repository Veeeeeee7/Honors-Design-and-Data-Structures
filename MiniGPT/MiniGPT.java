import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MiniGPT {
	private HashMap<String, ArrayList<Character>> map = new HashMap<>();

	public MiniGPT(String fileName, int chainOrder) throws IOException {
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

			if (!reader.ready()) {
				if (map.containsKey(previous.toString())) {
					map.get(previous.toString()).add('\0');
				} else {
					map.put(previous.toString(), new ArrayList<Character>(Arrays.asList('\0')));
				}
			}
		}
		reader.close();
	}

	public void generateText(String outputFileName, int numChars) throws IOException {
		File a = new File(outputFileName);
		if (a.exists()) {
			a.delete();
		}

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
		// System.out.println("|" + seed + "|");

		StringBuilder content = new StringBuilder(seed);
		for (int i = 0; i < numChars - seed.length(); i++) {
			// System.out.println(seed);
			if (!map.containsKey(seed.toString())) {
				File f = new File(outputFileName);
				FileWriter fw = new FileWriter(f);
				fw.write(content.toString());
				fw.close();
				System.out.println("ENDED EARLY bc doesnt contain key");
				return;
			}
			char c = map.get(seed.toString()).get((int) (Math.random() * map.get(seed.toString()).size()));
			if (c == '\0') {
				File f = new File(outputFileName);
				FileWriter fw = new FileWriter(f);
				fw.write(content.toString());
				fw.close();
				System.out.println("ENDED EARLY bc reached end");
				return;
			}

			content.append(c);
			seed.append(c);
			seed.deleteCharAt(0);
		}
		content.delete(numChars, content.length());

		File f = new File(outputFileName);
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		fw.write(content.toString());
		fw.close();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key + " : ");
			for (char c : map.get(key)) {
				sb.append(c + ", ");
			}
			sb.delete(sb.length() - 2, sb.length() - 1);
			sb.append(".\n");
		}
		return sb.toString();
	}
}
