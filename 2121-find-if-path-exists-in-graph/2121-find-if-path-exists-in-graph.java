import java.util.*;

public class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
                    for (int[] edge : edges) {
                                graph.putIfAbsent(edge[0], new ArrayList<>());
                                            graph.putIfAbsent(edge[1], new ArrayList<>());
                                                        graph.get(edge[0]).add(edge[1]);
                                                                    graph.get(edge[1]).add(edge[0]);
                                                                            }

                                                                                    Set<Integer> visited = new HashSet<>();
                                                                                            return dfs(graph, start, end, visited);
                                                                                                }

                                                                                                    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int end, Set<Integer> visited) {
                                                                                                            if (current == end) {
                                                                                                                        return true;
                                                                                                                                }
                                                                                                                                        if (visited.contains(current)) {
                                                                                                                                                    return false;
                                                                                                                                                            }
                                                                                                                                                                    
                                                                                                                                                                            visited.add(current);
                                                                                                                                                                                    
                                                                                                                                                                                            for (int neighbor : graph.get(current)) {
                                                                                                                                                                                                        if (dfs(graph, neighbor, end, visited)) {
                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                    public static void main(String[] args) {
                                                                                                                                                                                                                                                                            Solution solution = new Solution();
                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                            int n = 6;
                                                                                                                                                                                                                                                                                                    int[][] edges = {
                                                                                                                                                                                                                                                                                                                {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
                                                                                                                                                                                                                                                                                                                        };
                                                                                                                                                                                                                                                                                                                                int start = 0;
                                                                                                                                                                                                                                                                                                                                        int end = 5;

                                                                                                                                                                                                                                                                                                                                                boolean result = solution.validPath(n, edges, start, end);
                                                                                                                                                                                                                                                                                                                                                        System.out.println(result);
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            