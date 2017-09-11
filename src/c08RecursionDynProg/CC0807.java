package c08RecursionDynProg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SkinTang on 9/10/17.
 * Permutation without Dups
 */
public class CC0807 {
    public Set<String> getPerms(String s) {
        Set<String> resultSet = new HashSet<>();
        if (s.length() == 0) {
            resultSet.add(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String aChar = s.charAt(i) + "";
            String remain = s.substring(0, i) + s.substring(i+1);
            Set<String> remainSet = getPerms(remain);
            for (String str : remainSet) {
                resultSet.add(aChar + str);
            }
        }
        return resultSet;
    }
}
