package pr2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal de la Practica 3.
 *
 */
public class App<V> {

    public static void main (String[] args){
        Graph<String> grafo = new Graph<String> ();
        List<String> camino = new ArrayList<>();
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "D");
        grafo.addEdge("B", "E");
        grafo.addEdge("E", "G");
        grafo.addEdge("E", "D");
        grafo.addEdge("D", "C");
        grafo.addEdge("D", "F");
        grafo.addEdge("D", "H");
        camino = grafo.onePath("A", "H");
    }


}
