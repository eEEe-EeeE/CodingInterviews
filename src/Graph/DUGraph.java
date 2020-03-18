package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DUGraph {
    private int total;
    private ArrayList<LinkedList<Integer>> adj;

    DUGraph(int total) {
        this.total = total;
        this.adj = new ArrayList<>();
        for (int i = 0; i < total; ++i) {
            this.adj.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void dfs(int start) {
        boolean[] visited = new boolean[total];

        for (int i = start; i < total; ++i)
            if (!visited[i])
                dfs(i, visited);
        for (int i = 0; i < start; ++i)
            if (!visited[i])
                dfs(i, visited);
    }

    private void dfs(int node, boolean[] visited) {
        System.out.print(node + " ");
        visited[node] = true;

        for (Integer i : adj.get(node)) {
            if (!visited[i])
                dfs(i, visited);
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[total];
        for (int i = start; i < total; ++i) {
            if (!visited[i])
                bfs(i, visited);
        }
        for (int i = 0; i < start; ++i) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

    private void bfs(int node, boolean[] visited) {
        System.out.print(node + " ");
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            for(Integer i : adj.get(node)) {
                if (!visited[i]) {
                    System.out.print(i + " ");
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
