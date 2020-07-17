package sw.algo;

import java.util.Vector;

// 邻接表-稀疏图
public class SparseGraph implements Graph{

    private int n; // 节点数
    private int m; // 边数量
    private boolean directed; // 是否有向图
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        g = new Vector[n];
        for (int i = 0; i < n; i ++)
            g[i] = new Vector<Integer>();
    }

    public int V() {return n;}
    public int E() {return m;}

    // 建立 v 和 w 的边
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v,w)) return;

        g[v].add(w);
        if (v != w && !directed)
            g[w].add(v);

        m++;
    }

    // v 和 w 是否存在边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i ++)
            if (g[v].elementAt(i) == w)
                return true;
        return false;
    }

    public void show(){
        for (int i = 0; i < n; i ++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j ++)
                System.out.print(g[i].elementAt(j)+"\t");

            System.out.println();
        }
    }

    // 返回 v 的所有邻边
    public Iterable<Integer> adj (int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
