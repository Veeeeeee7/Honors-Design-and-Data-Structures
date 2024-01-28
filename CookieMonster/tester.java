import java.util.ArrayList;

public class tester {
    public static void main(String[] args) throws Exception {
        CookieMonster c = new CookieMonster("cookies4.txt");
        // System.out.println(c.recursiveCookies());
        // System.out.println(c.queueCookies());
        // System.out.println(c.stackCookies());
        System.out.println(c.pqCookies());
        // ArrayList<String> a = T.searchDirectory("./");
        // for (String s : a) {
        // System.out.println(s);
        // }
    }
}