package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UUGraph {
    private int total;
    private ArrayList<LinkedList<Integer>> adj;

    UUGraph(int total) {
        this.total = total;
        this.adj = new ArrayList<>(total);
        for (int i = 0; i < total; ++i) {
            this.adj.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void dfs(int start) {
        dfs(start, new boolean[total]);
    }

    private void dfs(int node, boolean[] visited) {
        // 1.访问标记
        System.out.print(node + " ");
        visited[node] = true;

        // 2.依次深度遍历邻接结点
        for (Integer i : adj.get(node)) {
            if (!visited[i])
                dfs(i, visited);
        }
    }

    void bfs(int start) {
        bfs(start, new boolean[total]);
    }

    private void bfs(int node, boolean[] visited) {
        // 1.访问并标记
        System.out.print(node + " ");
        visited[node] = true;

        // 2.依次访问邻接结点再依刚才的次序广度遍历邻接结点
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Integer i : adj.get(node)) {
                if (!visited[i]) {
                    System.out.print(i + " ");
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
