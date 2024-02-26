public class tester {
    public static void main(String[] args) {
        MyHashMap<String, String> hm = new MyHashMap<>();
        hm.put("KEY1", "VALUE1");
        hm.put("KEY2", "VALUE1");
        hm.put("KEY3eeeeeeeeeeeeeadvxz", "VALUE2");
        hm.put("KEY3eeeeebeeeeeeadvxz", "VALUE2");
        hm.put("KEY3eeeeeeeeeeeeeadvxz", "VALUE2");
        hm.put("KEY3eeeeceeadvxz", "VALUE2");
        hm.put("KEY3eeeeefeaeeeseeeeadvxz", "VALUE2");
        hm.put("KEY3eeeeecewedeeeeeeeadvxz", "VALUE2");
        System.out.println(hm);
        hm.put("KEY3eeeeeeeedeeseseeeeadvxz", "VALUE2");
        System.out.println(hm);
        hm.put("KEY3eeeeeaeeeedeeeeeeeadvxz", "VALUE2");
        hm.put("KEY3eeeedeeeeeeeeedeadvxz", "VALUE2");
        hm.put("KEY3eeeeveeexeedxeeeeeeadvxz", "VALUE2");
        System.out.println(hm);
        hm.rehash(20);
        System.out.println(hm);
    }
}
