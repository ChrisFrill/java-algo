package main.java.datastructures.graph.dijkstra;

import java.util.*;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(1);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMaximumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void calculateMaximumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance * edgeWeight > evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance * edgeWeight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MIN_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance > lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

        public static void main(String[] args) {

        List<String[]> exchangeRates = Arrays.asList(
                new String[] {"A", "B", "5.0"},
                new String[] {"A", "C", "1.0"},
                new String[] {"B", "D", "2.0"},
                new String[] {"C", "E", "20.0"},
                new String[] {"D", "E", "1.0"}
        );

        String baseCurrency = "A";
        String targetCurrency = "E";

            Node nodeA = new Node("A");
            Node nodeB = new Node("B");
            Node nodeC = new Node("C");
            Node nodeD = new Node("D");
            Node nodeE = new Node("E");

            nodeA.addDestination(nodeB, 5);
            nodeA.addDestination(nodeC, 1);

            nodeB.addDestination(nodeD, 2);

            nodeC.addDestination(nodeE, 20);

            nodeD.addDestination(nodeE, 1);


            Graph graph = new Graph();

            graph.addNode(nodeA);
            graph.addNode(nodeB);
            graph.addNode(nodeC);
            graph.addNode(nodeD);
            graph.addNode(nodeE);

        // Find the highest exchange rate using Dijkstra's algorithm
        Graph result = calculateShortestPathFromSource(graph, nodeA);

        // Output the result rounded to 5 decimal places
        for (Node node : result.getNodes()) {
            System.out.println("Node: " + node.getName() + ". Distance: " + node.getDistance());
        }
    }
}