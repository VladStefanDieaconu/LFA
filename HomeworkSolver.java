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


    public HomeworkSolver() {
    }

    void BFS(Graph g, String start)
    {
        Map<String, Boolean> visited = new HashMap<>();

        LinkedList<String> queue = new LinkedList<String>();

        visited.put(start, true);
        queue.add(start);

        while (queue.size() != 0)
        {
            start = queue.poll();
            System.out.println(start);

            Iterator<String> i = g.adj.get(start).listIterator();
            while (i.hasNext())
            {
                String n = i.next();
                if (visited.containsKey(n) == false)
                {
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
    }

    public Integer getNumOfStates() {
        return states.size();
    }

    public void computeGraph() {
        Graph G = new Graph();
        Iterator from = transitionFrom.iterator();
        Iterator to = transitionTo.iterator();

        while (from.hasNext() && to.hasNext()) {
            G.addEdge((String) from.next(), (String) to.next());
        }

        BFS(G, startState);
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
        accessibleStates.add(startState);


    }

    public void showUsefulStates() {

    }

    public void isEmptyLanguage() {

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
