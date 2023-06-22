package com.wf.first.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,7,8,10,12,3,12,100};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tempList = map.get(arr[i]);
            if (tempList == null) {
                tempList = new ArrayList<>();
                map.put(arr[i], tempList);
            }
            tempList.add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue() != null && entry.getValue().size() > 1) {
                System.out.println("数字【" + entry.getKey() + "】重复，重复的下标有：" + entry.getValue().toString());
            }
        }

    }
}
