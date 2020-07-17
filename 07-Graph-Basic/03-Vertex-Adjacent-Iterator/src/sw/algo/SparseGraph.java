package sw.algo;

import java.util.Vector;

// 邻接表-稀疏图
public class SparseGraph {

    private int n; // 节点数量
    private int m; // 边的数量
    private boolean directed; // 是否有向图
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed){
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // 每行创建一个空vector, 存储边关系
        g = new Vector[n];
        for (int i = 0; i < n; i ++)
            g[i] = new Vector<Integer>();
    }

    public int V() {return n;}
    public int E() {return m;}

    // 向图中添加一条边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        // 无向图, 双向连接
        if (v != w && !directed)
            g[w].add(v);

        // 边+1
        m++;
    }

    // 验证图中是否有从v到w的边
    boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i ++)
            if (g[v].elementAt(i) == w)
                return true;
        return false;
    }

    // 返回图中一个顶点的所有邻边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

}
