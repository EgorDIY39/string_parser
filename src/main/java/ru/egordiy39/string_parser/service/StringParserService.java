package ru.egordiy39.string_parser.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("StringParserService")
public class StringParserService {
    public Map<Character, Integer> parsString(String parsStr) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        char[] charArray = parsStr.toCharArray();
        for (char c : charArray) {
            charMap.merge(c, 1, Integer::sum);
        }
        return charMap;
    }

    public LinkedHashMap<Character, Integer> sortMap(Map<Character, Integer> charMap) {
        LinkedHashMap<Character, Integer> sortedMap = charMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedMap;
    }

}
