package c01ArrayString;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SkinTang on 6/13/17.
 */
public class TestArrayAndString {
    public static ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<>();
//        for (String word : words) sentence.add(word);
        for (String item : more) sentence.add(item);
        sentence.addAll(Arrays.asList(words));
        return sentence;
    }
    public static void main(String[] args) {
        String[] words = {"a", "b", "c"};
        String[] more = {"1", "2"};

        ArrayList<String> sen = merge(words, more);
        for (String word : sen) System.out.println(word);
    }
}
