
public class Tester {
    public static void main(String[] args) {
        String str = "How are you.";
        MyString s1 = new MyString(str.toCharArray());
        MyString[] words = s1.getWords();
        for (int i = 0; i < words.length; i++) {
            words[i].print();
            System.out.println();
        }

        MyString reverse = s1.reverseSentence();
        reverse.print();

        System.out.println("HI");
    }
}
