package sw.algo;

import java.util.Vector;

// 邻接矩阵-稠密图
public class DenseGraph implements Graph{

    private int n; // 节点数
    private int m; // 边数量
    private boolean directed; // 是否有向图
    private boolean[][] g; // 矩阵

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;

        g = new boolean[n][n];
    }

    public int V() {return n;}
    public int E() {return m;}

    // 构建 v 和 w 的边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v,w)) return;

        g[v][w] = true;
        if (!directed)
            g[w][v] = true;

        m++;
    }

    // v和w是否存在边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    public void show() {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++)
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回 v 的所有邻边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i ++)
            if (g[v][i])
                adjV.add(i);

        return adjV;
    }
}
