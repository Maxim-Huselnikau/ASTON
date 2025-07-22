package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    public Map<String, List<String>> telephoneDirectory;

    public TelephoneDirectory(Map<String, List<String>> telephoneDirectory) {
        this.telephoneDirectory = new HashMap<>();
        this.telephoneDirectory.putAll(telephoneDirectory);
    }

    public void add(String surname, String telephoneNumber) {
        if (!telephoneDirectory.containsKey(surname)) {
            telephoneDirectory.put(surname, new ArrayList<>(List.of(telephoneNumber)));
        } else {
            telephoneDirectory.get(surname).add(telephoneNumber);
        }
    }

    public void print() {
        System.out.println("Telephone Directory:");
        for (Map.Entry<String, List<String>> entry : telephoneDirectory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public List<String> get(String surname) {
        for (Map.Entry<String, List<String>> entry : telephoneDirectory.entrySet()) {
            if (entry.getKey().equals(surname)) {
                return entry.getValue();
            }
        }
        return null;
    }
}


