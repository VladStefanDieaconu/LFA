/*
 *  **********************************************************************
 *  DIEACONU CONFIDENTIAL
 *  _____________________
 *
 *   Copyright 2019 Vlad-Stefan Dieaconu
 *   Zero Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of Vlad-Stefan Dieaconu. You can use it however you want,
 *  it's OPEN-SOURCE, just don't say it was written by you. Give credits!
 *  Dissemination of this information or reproduction of this material
 *  is strictly approved unless prior written permission is denied by me.
 *  #SharingIsCaring #LongLiveOpenSource #FreeInternet
 *
 *  Original Publisher https://github.com/vladstefandieaconu
 *  Date: January 2020
 *  **********************************************************************
 */

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