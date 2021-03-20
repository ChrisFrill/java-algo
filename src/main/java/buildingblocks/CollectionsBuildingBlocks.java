package main.java.buildingblocks;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsBuildingBlocks {
    List<String> strings = new ArrayList<>();
    List<String> strings2 = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    {
        Collections.addAll(strings, "1", "2");
        strings.addAll(strings2);
        Collections.binarySearch(strings, "string");
        // If no common elements
        Collections.disjoint(strings, strings2);
        // Deque to Queue
        Collections.asLifoQueue(deque);
        Collections.max(strings);
        Collections.min(strings);

        // Union
        union(strings, strings2);
        // OR two add alls
        Set<String> union = new HashSet<>();
        union.addAll(strings);
        union.addAll(strings2);


        // Intersection OR Common elements
        Set<String> commonElements = strings.stream()
                .distinct()
                .filter(strings2::contains)
                .collect(Collectors.toSet());

        intersection(strings, strings2);
        // OR retainAll, but that modifies original list
        List<String> commonElement2 = new ArrayList<>(strings);
        commonElements.retainAll(strings2);

        // Difference
        List<String> differences = strings.stream()
                .filter(element -> !strings2.contains(element))
                .collect(Collectors.toList());

        List<String> differences2 = new ArrayList<>(strings);
        differences.removeAll(strings2);
    }

    private <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    private <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
