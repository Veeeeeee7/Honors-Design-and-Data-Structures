public class Tester {
    public static void main(String[] args) throws Exception {
        HuffmanCodeGenerator h = new HuffmanCodeGenerator("frequencyCountInput (1).txt");
        for (int i = 0; i < 128; i++) {
            System.out.println((char) i + " : " + h.getFrequency((char) i));
        }
    }
}
