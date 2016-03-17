package utils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhabenya on 17.03.16.
 */
public class Randomizer {

    public static int[] getRandomNumbers(int maxValue, int quantity){
        int[] numbers = new int[quantity];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < maxValue; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        for (int i = 0; i < quantity; i++) {
            numbers[i] = list.get(i);
        }
        return numbers;
    }
}
