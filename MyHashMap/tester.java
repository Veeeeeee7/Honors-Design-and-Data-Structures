public class tester {
    public static void main(String[] args) {
        MyHashMap<String, String> hm = new MyHashMap<>();
        System.out.println(hm.put("KEY1", "VALUE1"));
        System.out.println(hm.put("KEY1", "VALUE1"));
        System.out.println(hm);
    }
}
