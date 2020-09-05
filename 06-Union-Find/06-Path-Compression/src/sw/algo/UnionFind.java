package sw.algo;

public class UnionFind {

    private int[] rank;
    private int[] parent;
    private int count;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找 p 的根节点
    // 路径压缩优化
    private int find(int p) {
        assert (p >= 0 && p < count);

        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;

        // 完全压缩
//        while (p != parent[p]) {
//            parent[p] = find(parent[p]);
//            p = parent[p];
//        }
//
//        return parent[p];
    }


    // p 和 q是否连接
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q的集合
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        // 优化, 高度小的向高度大的集合合并
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else { // 相等, 谁合谁都行
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }
    }

    public static void main(String[] args) {
        int n = 10000;

        UnionFind uf = new UnionFind(n);
        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF4, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }
}
