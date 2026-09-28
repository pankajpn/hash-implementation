public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(10, 15);
        map.put(20, 25);
        System.out.println(map.get(10));

        map.put(10, 76);
        System.out.println(map.get(10));
        Integer v = map.remove(10);
        System.out.println(v);
        System.out.println(map.get(10));
        System.out.println(map.getSize());

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("abc", 27);
        map2.put("xyz", 37);
        System.out.println(map2.get("abc"));
    }
}