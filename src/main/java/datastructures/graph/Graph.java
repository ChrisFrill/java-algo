package main.java.datastructures.graph;

import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = adjVertices.keySet().stream().filter(vertex -> vertex.label.equals(label1)).findFirst().get();
        Vertex v2 = adjVertices.keySet().stream().filter(vertex -> vertex.label.equals(label2)).findFirst().get();
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            System.out.println(stack);
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            System.out.println(queue);
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    void printGraph() {
        adjVertices.forEach((key, values) -> System.out.println("Vertex: " + key.label + " adjacent vertices: " +
                values.stream().map(vertex -> vertex.label).collect(Collectors.joining(","))));
    }


    List<Vertex> getAdjVertices(String label) {
        return adjVertices.entrySet().stream().filter(vertex -> vertex.getKey().label.equals(label))
                .map(Map.Entry::getValue).findFirst().orElseThrow(() -> new RuntimeException("No such vertex"));
    }

    private static class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.printGraph();

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.printGraph();

        System.out.println("Depth first:");
        System.out.println(graph.depthFirstTraversal(graph, "Bob"));
        System.out.println("Breadth first");
        System.out.println(graph.breadthFirstTraversal(graph, "Bob"));
    }
}
