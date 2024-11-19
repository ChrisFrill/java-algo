package main.java;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        if (c_lib <= c_road) {
            System.out.println("Building libs: " + (long) n * c_lib);
            return (long) n * c_lib;
        }

        var unionFind = new UnionFind(n);
        for (var cityUnions : cities) {
            unionFind.union(cityUnions.get(0) - 1, cityUnions.get(1) - 1);
        }
        var unions = new HashMap<Integer, Long>();
        for (var p : unionFind.parents) {
            var parent = unionFind.find(p);
            unions.merge(parent, 1L, Long::sum);
        }

        var cost = 0L;
        for (var value : unions.values()) {
            cost += c_lib + (value - 1) * c_road;

        }
        System.out.println("Cost: " + cost);
        System.out.println("Building: " + (long) n * c_lib);
//        System.out.println("Unions: " + unions);
        return Math.min(cost, (long) n * c_lib);
    }

    static class UnionFind {
        public static int[] parents;
        public static int[] ranks;
        
        UnionFind(int cityCount) {
            parents = new int[cityCount];
            ranks = new int[cityCount];
            for (int i = 0; i < cityCount; i++) {
                parents[i] = i;
            }
        };
        
        public static int find(int city) {
            if (parents[city] == city) {
                return city;
            } else {
                parents[city] = find(parents[city]);
                return parents[city];
            }
        }
        
        public static void union(int firstCity, int secondCity) {
            var firstParent = find(firstCity);
            var secondParent = find(secondCity);
            if (firstParent != secondParent) {
                if (ranks[firstCity] < ranks[secondCity]) {
                    parents[firstParent] = secondParent;
                }
                if (ranks[secondCity] < ranks[firstCity]) {
                    parents[secondParent] = firstParent;
                }
                 if (ranks[firstCity] == ranks[secondCity]) {
                    parents[firstParent] = secondParent;
                    ranks[firstParent] = ranks[firstParent] + 1;
                }
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/krisz/Projects/java-algo/test.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/krisz/Projects/java-algo/test_solution.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);
                System.out.println(result);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
