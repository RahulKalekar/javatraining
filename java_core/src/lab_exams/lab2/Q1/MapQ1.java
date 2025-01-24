package Q1;

import java.util.HashMap;

public class MapQ1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);

        System.out.println("1. print map using stream");
        map.entrySet().stream()
                .forEach(entry-> System.out.println(entry.getKey()+" : "+ entry.getValue()));

        System.out.println("2. print only that recrods that contain key contains raj");
        map.entrySet().stream()
                .filter(entry->entry.getKey().contains("raj"))
                .forEach(entry-> System.out.println(entry.getKey()+" : "+entry.getValue()));

        System.out.println("3. print map sorted by key");
        map.entrySet().stream()
                .sorted((entry1,entry2)->entry1.getKey().compareTo(entry2.getKey()))
                .forEach(entry-> System.out.println(entry.getKey()+" : "+entry.getValue()));

        System.out.println("4. map sorted by values:");
        map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        System.out.println("5. Map reverse sorted by key:");
        map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()))  // Comparator for reverse sorting by key
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }


}
