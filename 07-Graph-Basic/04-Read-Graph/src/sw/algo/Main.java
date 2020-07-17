package sw.algo;

// 测试通过文件读取图的信息
public class Main {

    public static void main(String[] args) {

        String dir = "04-Read-Graph/src/";
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = dir + "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        sw.algo.ReadGraph readGraph1 = new sw.algo.ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        sw.algo.ReadGraph readGraph2 = new sw.algo.ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = dir + "testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        sw.algo.ReadGraph readGraph3 = new sw.algo.ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        sw.algo.ReadGraph readGraph4 = new sw.algo.ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();
    }
}
