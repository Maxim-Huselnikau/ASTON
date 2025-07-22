package Task2;

import java.util.List;
import java.util.Map;

public class MainTask2 {
    public static void main(String[] args) {
        //task2
        Map<String, List<String>> data = Map.of(
                "Иванов", List.of("123-456"),
                "Петров", List.of("555-777", "999-888")
        );

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory(data);
        telephoneDirectory.add("Huselnikau", "+37529123451");
        telephoneDirectory.add("Huselnikau", "+37529123000");

        telephoneDirectory.print();

        System.out.println("\nPhones with surname 'Huselnikau': " + telephoneDirectory.get("Huselnikau"));
    }
}
