package sw.algo;

import java.util.LinkedList;

public class BST<K extends Comparable<K>,V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int count;

    public BST(){
        root = null;
        count = 0;
    }

    public int size(){return count;}

    public boolean isEmpty(){ return count == 0;}

    public void insert(K key, V value) {
        root = insert(root,key,value);
    }

    public boolean contain(K key){
        return getNode(root,key) != null;
    }

    public V search(K key) {
        Node ret = getNode(root,key);
        return ret == null ? null : ret.value;
    }

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    public void levelOrder(){
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();

            System.out.println(node.key);

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    public void remove(K key) {root = remove(root,key);}

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key,value);
        }
        
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left,key,value);
        } else {
            node.right = insert(node.right,key,value);
        }
        
        return node;
    }

    public Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }
    
    private void preOrder(Node node) {

        if (node != null){
            
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    private void inOrder(Node node) {
        if (node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }
    
    private void postOrder(Node node) {
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node remove(Node node,K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            return node;
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right,key);
            return node;
            
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;

            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;

            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;

        }
    }

    // 测试二分搜索树
    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }
}
