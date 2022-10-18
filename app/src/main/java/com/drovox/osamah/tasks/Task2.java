package com.drovox.osamah.tasks;

import java.util.*;
import java.util.Map.Entry;

public class Task2 {

    public static int getFirstNonRepeatingIndex(String input) {
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {

            //In case user enters uppercase
            char ch = Character.toLowerCase(input.charAt(i));

            if (hashMap.containsKey(ch))
                hashMap.put(ch, -1);
            else
                hashMap.put(ch, i);
        }

        for (Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != -1)
                return entry.getValue();
        }

        return -1;
    }

}
