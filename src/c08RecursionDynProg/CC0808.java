package c08RecursionDynProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Permutations with Dups
 */
public class CC0808 {
    public List<String> getPermsWrapper(String s) {
        Map<Character, Integer> charMap = buildCharMap(s);
        List<String> resultList = new ArrayList<>();
        getPerms(charMap, "", s.length(), resultList);
        return resultList;
    }

    private Map<Character, Integer> buildCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 0);
            }
            charMap.put(c, charMap.get(c) + 1);
        }
        return charMap;
    }

    private void getPerms(Map<Character, Integer> charMap, String prefix, int len, List<String> resultList) {
        if (len == 0) {
            resultList.add(prefix);
            return;
        }
        for (Character c : charMap.keySet()) {
            int count = charMap.get(c);
            if (count > 0) {
                charMap.put(c, count - 1);
                getPerms(charMap, prefix + c, len - 1, resultList);
                charMap.put(c, count);
            }
        }
    }
}
