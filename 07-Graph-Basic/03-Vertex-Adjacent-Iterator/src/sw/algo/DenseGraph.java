package sw.algo;

import java.util.Vector;

// 邻接矩阵-稠密图
public class DenseGraph {

    private int n; // 节点数
    private int m; // 边数
    private boolean directed; // 是否有向图
    private boolean[][] g; // 存储矩阵

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // 初始化, 每个g[n][n]均为false
        g = new boolean[n][n];
    }

    public int V() {return n;}
    public int E() {return m;}

    // 添加v到w的边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v,w))
            return;

        g[v][w] = true;
        if (!directed)
            g[w][v] = true;

        m++;
    }

    // 图中是否存在v到w的边
    boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i ++)
            if (g[v][i])
                adjV.add(i);

        return adjV;
    }

}
