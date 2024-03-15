public class Tester {
    public static void main(String[] args) throws Exception {
        MiniGPT gpt = new MiniGPT("test", 3);
        // MiniGPT gpt = new MiniGPT("test", 2);
        // System.out.println(gpt);
        gpt.generateText("output.txt", 100);
    }
}
