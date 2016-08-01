package com.company.algorithm;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Administrator on 2016/7/23 0023.
 */
public class BanlanceTree<Key extends Comparable ,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    class Node{
        Key key;
        Value value;
        Node leftNode,rightNode;
        int N;
        //指向这个节点的链接的颜色
        boolean color;

        public Node(Key key,Value value, int n ,boolean color){
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }
    int sizeof(Node node){
        if (node == null)
            return 0;
        if (node.leftNode == null && node.rightNode == null)
            return 1;
        int n = 1;
        if (node.leftNode != null)
            n += node.leftNode.N;
        if (node.rightNode != null)
            n+= node.rightNode.N;
        return n;
    }
    /*
        在新插入键是我们可以使用旋转操作来帮助我们保证 保证红黑树的
        有序性和完美平衡性两个重要性质
     */
    //左旋转      如果新键大于老键，那么新增的红色节点将会产生一条红色的右链接。这个时候我们需要 root = rotateLeft（root） 来进行一哥左旋转
    Node rotateLeft(Node h){
        Node x = h.rightNode;
        h.rightNode = x.leftNode;
        x.leftNode = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+sizeof(h.leftNode) + sizeof(h.rightNode);
        return x;
    }
    //右旋转
    /*

     */
    Node rotateRight(Node h){
        Node x = h.leftNode;
        h.leftNode = x.rightNode;
        h.rightNode = x;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+sizeof(h.leftNode) + sizeof(h.rightNode);
        return x;
    }
    void flipColors (Node h){
        h.color = RED;
        h.leftNode.color = BLACK;
        h.rightNode.color = RED;
    }

    public Node put (Node node,Key key,Value value){
        if (node == null)
            return new Node(key,value,1,RED);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.leftNode = put(node.leftNode,key,value);
        if (cmp > 0) node.rightNode = put(node.rightNode,key,value);
        //红连接只可能出现在父节点的左侧
        if (node.rightNode.color==RED && node.rightNode.color == RED) flipColors(node);
        if (node.rightNode.color == RED && node.rightNode.color == BLACK) rotateLeft(node);
        if (node.leftNode.color == RED && node.leftNode.leftNode.color == RED) rotateRight(node);
        node.N = sizeof(node.leftNode) + sizeof(node.rightNode) + 1;
        return  node;
    }
}
