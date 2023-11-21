package ru.egordiy39.string_parser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.egordiy39.string_parser.service.StringParserService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestParsString {
    @Autowired
    private StringParserService stringParserService;
    @Test
    public void TestReturnMapFromParsString() {
        String parsStr = "aaaaabcccc";
        Map<Character, Integer> hashMap  = new HashMap<>() {{put('a', 5); put('b', 1); put('c', 4);}};
        Map<Character, Integer> characterIntegerMap = stringParserService.parsString(parsStr);
        Assert.assertEquals(hashMap, characterIntegerMap);
    }

    @Test
    public void TestSortMap() {
        Map<Character, Integer> hashMap  = new LinkedHashMap<>() {{put('a', 5); put('c', 4); put('b', 1);}};
        Map<Character, Integer> characterIntegerMap = stringParserService.sortMap(hashMap);
        Assert.assertArrayEquals (hashMap.values().toArray(), characterIntegerMap.values().toArray());
    }
}
