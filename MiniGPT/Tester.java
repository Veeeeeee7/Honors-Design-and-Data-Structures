public class Tester {
    public static void main(String[] args) throws Exception {
        MiniGPT gpt = new MiniGPT("thegreatgatsby.txt", 2);
        // MiniGPT gpt = new MiniGPT("test", 2);
        // System.out.println(gpt);

        for (int i = 0; i < 10000; i++) {

            gpt.generateText("output.txt", 500);
        }
    }
}
