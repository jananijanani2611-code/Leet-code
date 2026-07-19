// Last updated: 19/07/2026, 20:25:10
1import java.util.*;
2
3class Solution {
4    public List<String> findItinerary(List<List<String>> tickets) {
5        Map<String, PriorityQueue<String>> graph = new HashMap<>();
6        List<String> itinerary = new LinkedList<>();
7        
8        // Step 1: Build the graph using Min-Heaps for lexical sorting
9        for (List<String> ticket : tickets) {
10            String departure = ticket.get(0);
11            String arrival = ticket.get(1);
12            graph.computeIfAbsent(departure, k -> new PriorityQueue<>()).offer(arrival);
13        }
14        
15        // Step 2: Run Hierholzer's Algorithm starting from "JFK"
16        dfs("JFK", graph, itinerary);
17        
18        return itinerary;
19    }
20    
21    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
22        PriorityQueue<String> destinations = graph.get(airport);
23        
24        // Greedily travel to the lexicographically smallest neighbor first
25        while (destinations != null && !destinations.isEmpty()) {
26            String nextDestination = destinations.poll(); // Consume the ticket
27            dfs(nextDestination, graph, itinerary);
28        }
29        
30        // Post-order insertion: add to the front of the list to reverse order implicitly
31        itinerary.add(0, airport);
32    }
33}