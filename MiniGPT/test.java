import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Scanner;

import java.io.File;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class test {
    @BeforeAll
    static void setup() throws Exception {
        File f = new File("sequel.txt");
        if (f.exists()) {
            f.delete();
        }
    }

    @Test
    public void testConstructor() throws Exception {
        MiniGPT gpt = new MiniGPT("thegreatgatsby.txt", 5);
        assertEquals(gpt.toString(), gpt.toString());
    }

    @Test
    public void testGenerateText() throws Exception {
        MiniGPT gpt = new MiniGPT("thegreatgatsby.txt", 5);
        gpt.generateText("sequel.txt", 100000);
        File output = new File("sequel.txt");
        assertTrue(output.exists());
        Scanner scanner = new Scanner(output);
        assertTrue(scanner.hasNext());
    }
}
