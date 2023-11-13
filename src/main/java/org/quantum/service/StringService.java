package org.quantum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    public Map<Character, Integer> countLetters(String string) {
        var result = new HashMap<Character, Integer>();
        for (char ch : string.toCharArray()) {
            Integer prevValue = result.put(ch, 1);
            if (Objects.nonNull(prevValue)) {
                result.put(ch, prevValue + 1);
            }
        }
        return result;
    }

    public List<Entry<Character, Integer>> sortByValue(Map<Character, Integer> map) {
        return map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toList();
    }
}
