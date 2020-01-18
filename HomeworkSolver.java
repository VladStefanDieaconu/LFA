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

            if(g.getGraph().containsKey(start))
                for (String n : g.getGraph().get(start)) {
                    if (!visited.containsKey(n)) {
                        visited.put(n, true);
                        q.add(n);
                    }
                }
        }
    }

    public Integer getNumOfStates() {
        return states.size();
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
                System.out.println("Yes");
                yes = true;
                break;
            }
        }
        if(!yes) {
            for (String state : accessibleStates) {
                if (visitedProductive.containsKey(state)) {
                    System.out.println("Yes");
                    yes = true;
                    break;
                }
            }
        }

        if(!yes) {
            if(visitedProductive.containsKey(startState)) {
                System.out.println("Yes");
                yes = true;
            }
        }

        if(yes == false) {
            System.out.println("No");
        }
    }

    public void isLanguageFinite() {

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
