package com.codewithinoussa.HashTables;

import java.util.*;

public class NonRepeatedCharacter {
    public char firstNonRepeatingChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch: chars){
            var count = map.containsKey(ch)? map.get(ch) : 0; // get value
            map.put(ch, count + 1);
        }
        //System.out.println(map);
        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public char firstRepeatedChar(String str){
      Set<Character> set = new HashSet<>();

      for (var ch : str.toCharArray()) {
          if (set.contains(ch))
              return ch;
          set.add(ch);
      }
      return  Character.MIN_VALUE;
    }

}
