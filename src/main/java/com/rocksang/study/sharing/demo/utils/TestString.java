package com.rocksang.study.sharing.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Rock Sang
 * @Date: 2020/4/20 3:42 下午
 */
public class TestString {


    public static void main(String[] args) {
        List<String> combinations = getCombinations("abc");
        System.out.println(combinations);
    }

    private static List<String> getCombinations(String str) {
        List<String> resultList = new ArrayList<>();
        char[] charArray = str.toCharArray();
        String[] source = new String[charArray.length];
        for (int i = 0; i < source.length; i++) {
            source[i] = "" + charArray[i];
            resultList.add("" + charArray[i]);
        }
        List<String> preResult = Arrays.asList(source);
        for (int len = 0; len < source.length; len++) {

            Map<String, List<String>> map = new HashMap<>();
            for (int j = 0; j < preResult.size(); j++) {
                String k = preResult.get(j).charAt(0) + "";
                if (!map.containsKey(k)) {
                    map.put(k, new ArrayList<String>());
                }
                map.get(k).add(preResult.get(j));
            }
            preResult = new ArrayList<>();
            for (int i = 0; i < source.length; i++) {
                List<String> list = new ArrayList<>();
                for (int j = i + 1; j < source.length; j++) {
                    List<String> list2 = map.get(source[j]);
                    if (list2 != null) {
                        list.addAll(map.get(source[j]));
                    }
                }
                for (int j = 0; j < list.size(); j++) {
                    resultList.add("" + source[i] + list.get(j));
                    preResult.add("" + source[i] + list.get(j));
                }
            }
        }
        return resultList;
    }
}
