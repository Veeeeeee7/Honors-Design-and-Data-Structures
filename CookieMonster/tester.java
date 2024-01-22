public class tester {
    public static void main(String[] args) {
        CookieMonster c = new CookieMonster("factory");
        System.out.println(c.recursiveCookies());
        System.out.println(c.queueCookies());
        System.out.println(c.stackCookies());
    }
}