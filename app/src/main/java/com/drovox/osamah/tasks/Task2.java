package com.drovox.osamah.tasks;

public class Task2 {

    public static int getFirstNonRepeatingIndex(String input) {
        for (char i : input.toCharArray()) {
            if (input.indexOf(i) == input.lastIndexOf(i)) {
                return input.indexOf(i);
            }
        }
        return -1;
    }

}
