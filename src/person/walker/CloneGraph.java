package person.walker;

import org.omg.CORBA.NO_IMPLEMENT;
import sun.nio.cs.ext.ISCII91;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17 0017.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null || node.neighbors == null)
            return node;
        Map<UndirectedGraphNode,UndirectedGraphNode> isHandled = new HashMap<>();
        return  cloneNode(node,isHandled);
    }

    private UndirectedGraphNode cloneNode(UndirectedGraphNode node, Map<UndirectedGraphNode,UndirectedGraphNode> isHandled) {
        UndirectedGraphNode clonedGraph = new UndirectedGraphNode(node.label);
        if (isHandled.get(node) != null){
            return isHandled.get(node);
        }
        isHandled.put(node,clonedGraph);
        for (UndirectedGraphNode neighbor : node.neighbors)
            clonedGraph.neighbors.add(cloneNode(neighbor,isHandled));
        return clonedGraph;
    }



    /*public static void main(String[] args){
        UndirectedGraphNode node_1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node_2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node_3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node_4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node_5 = new UndirectedGraphNode(5);

        node_1.neighbors.add(node_2);
        node_1.neighbors.add(node_3);
        node_1.neighbors.add(node_5);

        node_2.neighbors.add(node_4);
        node_2.neighbors.add(node_1);
        node_2.neighbors.add(node_5);
        new CloneGraph().cloneGraph()
    }*/
}
