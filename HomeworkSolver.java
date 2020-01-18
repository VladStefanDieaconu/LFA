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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class HomeworkSolver {
    public Vector<String> states = new Vector<>();
    public Vector<Character> symbols = new Vector<>();
    public Vector<String> transitionFrom = new Vector<>();
    public Vector<Character> transitionOn = new Vector<>();
    public Vector<String> transitionTo = new Vector<>();
    public String startState;
    public Vector<String> finalState = new Vector<>();

    public Vector<String> accessibleStates = new Vector<>();
    public Vector<String> productiveStates = new Vector<>();
    Map<String, Boolean> visitedAccesibleStates = new HashMap<>();
    Map<String, Boolean> visitedProductive = new HashMap<>();

    public HomeworkSolver() {
    }

    void BFS(Graph g, String start, Map<String, Boolean> visited) {
        LinkedList<String> q = new LinkedList<String>();

        visited.put(start, true);
        q.add(start);

        while (q.size() != 0) {
            start = q.poll();

            if(g.getGraph().containsKey(start)) {
                for (String lookinForThisState : g.getGraph().get(start)) {
                    if (!visited.containsKey(lookinForThisState)) {
                        visited.put(lookinForThisState, true);
                        q.add(lookinForThisState);
                    }
                }
            }
        }
    }

    public void computeGraphProductiveStates() {
        Graph G = new Graph();
        for(int i = 0; i < transitionFrom.size(); ++i) {
            G.addEdge(transitionTo.get(i), transitionFrom.get(i));
        }

        for (String finalS: finalState) {
            BFS(G, finalS, visitedProductive);
        }
    }

    public void computeGraph() {
        Graph G = new Graph();
        for (int i = 0; i < transitionFrom.size(); ++i) {
            G.addEdge(transitionFrom.get(i), transitionTo.get(i));
        }

        BFS(G, startState, visitedAccesibleStates);
    }

    public void hasEorNot() {
        boolean found = false;
        for (String s : finalState) {
            if(s.equals(startState)) {
                System.out.println("Yes");
                found = true;
                break;
            }
        }
        if(found == false) {
            System.out.println("No");
        }
    }

    public void showAccessibleStates() {
        computeGraph();
        accessibleStates.addAll(visitedAccesibleStates.keySet());
        for (String state : accessibleStates) {
            System.out.println(state);
        }
    }

    public void computeProductiveStates() {
        computeGraphProductiveStates();
        productiveStates.addAll(visitedProductive.keySet());
    }

    public void showUsefulStates() {
        computeGraph();
        accessibleStates.addAll(visitedAccesibleStates.keySet());
        computeProductiveStates();
        for (String state : accessibleStates) {
            if(visitedProductive.containsKey(state)) {
                System.out.println(state);
            }
        }
    }

    public void isEmptyLanguage() {
        boolean yes = false;
        computeGraph();
        accessibleStates.addAll(visitedAccesibleStates.keySet());
        computeProductiveStates();


        for (String state : finalState) {
            if (visitedAccesibleStates.containsKey(state)) {
                System.out.println("No");
                yes = true;
                break;
            }
        }
        if(!yes) {
            for (String state : accessibleStates) {
                if (visitedProductive.containsKey(state)) {
                    System.out.println("No");
                    yes = true;
                    break;
                }
            }
        }

        if(!yes) {
            if(visitedProductive.containsKey(startState)) {
                System.out.println("No");
                yes = true;
            }
        }

        if(yes == false) {
            System.out.println("Yes");
        }
    }

    public void addFinalState(String s) {
        finalState.add(s);
    }

    public void addStartState(String s) {
        startState = s;
    }

    public void addState(String state) {
        states.add(state);
    }

    public void addSymbol(char sym) {
        symbols.add(sym);
    }


    public void addTransitionTo(String t) {
        transitionTo.add(t);

    }

    public void addTransitionFrom(String t) {
        transitionFrom.add(t);
    }

    public void addTransitionOn(char c) {
        transitionOn.add(c);
    }
}
