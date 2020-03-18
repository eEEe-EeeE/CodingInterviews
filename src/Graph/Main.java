package Graph;

public class Main {
    public static void main(String[] args) {
        UUGraph uug = new UUGraph(5);
        uug.addEdge(0, 1);
        uug.addEdge(0, 4);
        uug.addEdge(1, 2);
        uug.addEdge(1, 3);
        uug.addEdge(1, 4);
        uug.addEdge(2, 3);
        uug.addEdge(3, 4);
        uug.dfs(4);
        System.out.println();
        uug.bfs(4);
    }
}
