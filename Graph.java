import java.io.*;
import java.util.*;

class Graph {
    private Map<String, Vector<String>> adj = new HashMap<>();

    Graph() {
    }

   public Map<String, Vector<String>> getGraph () {
        return adj;
    }


    void addEdge(String from, String to) {
        if(adj.containsKey(from)) {
            adj.get(from).add(to);
        } else {
            Vector<String> aux = new Vector<>();
            aux.add(to);
            adj.put(from, aux);
        }
    }
}