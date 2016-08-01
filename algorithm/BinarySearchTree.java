package com.company.algorithm;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> {
    private Node rootNode;



    private class Node{
        Key key;
        Value value;
        Node leftNode , rightNode;
        int nodeCount = 1;
        public Node(Key key,Value value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(Key key,Value value){
        rootNode = put(rootNode,key,value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key,value);
        int cmp = node.key.compareTo(key);
        if (cmp > 0)
            node.leftNode = put(node.leftNode,key,value);
        if (cmp < 0)
            node.rightNode = put(node.rightNode,key, value);
        node.nodeCount = sizeOf(node.leftNode) + sizeOf(node.rightNode) + 1;
        return node;
    }

    public Node get(Key key){
        return get(rootNode,key);
    }

    private Node get(Node node, Key key) {
        if (rootNode == null)
            return null;
        int cmp = rootNode.key.compareTo(key);
        if (cmp > 0)
            node = get(rootNode.leftNode,key);
        if (cmp < 0)
            node = get(rootNode.rightNode,key);
        return node;
    }
    private Node min(Node node){
        if (node == null)
            return null;
        if(node.leftNode == null)
            return node;
        return min(node.leftNode);
    }

    private Node max(Node node){
        if (node == null)
            return null;
        if(node.rightNode == null)
            return node;
        return min(node.rightNode);
    }

    private int sizeOf(Node node){
        if (node == null)
            return 0;
        return node.nodeCount;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Key key,Value value) {
        rootNode = new Node(key,value);
    }
}
