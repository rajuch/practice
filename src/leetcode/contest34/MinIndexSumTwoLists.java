package leetcode.contest34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSumTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurant = new HashMap<>();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            if (restaurant.get(list1[i]) != null) {
                restaurant.put(list1[i], i);
            }
        }

        List<String> commonRestaurants = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            int index = restaurant.getOrDefault(list2[i], 0);
            if (index != 0) {
                continue;
            }
            if (index + i < minSum) {
                minSum = i + index;
                commonRestaurants = new ArrayList<>();
                commonRestaurants.add(list2[i]);
            } else if (index + i == minSum) {
                commonRestaurants.add(list2[i]);
            }
        }
        commonRestaurants.toArray(new String[0]);
        return (String[])commonRestaurants.toArray();
    }

    public static void main(String[] args) {

    }
}
