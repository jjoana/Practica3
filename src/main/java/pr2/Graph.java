package pr2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Graph<V>{
    private Map<V, HashSet<V>> listaAdyacencia;

    /**
     * Constructor por defecto del grafo.
     */
    public Graph (){
        // Inicializamos los HashSet y el HashMap.
        listaAdyacencia = new HashMap<>();
    }

    public HashMap<V, HashSet<V>> getListaDeAdyacencia(){
        return (HashMap<V, HashSet<V>>) listaAdyacencia;
    }
    
    /**
     * Añade el vértice 'V' al grafo.
     * @param v vértice a añadir
     * @return 'true' si no estaba anteriormente y 'false' en caso contrario.
     */
    public boolean addVertex (V v){
        Set<V> vertice = new HashSet<>();
        if (listaAdyacencia.containsKey(v)){
            return true;
        }else{
            listaAdyacencia.put(v, (HashSet<V>) vertice);
            return false;
        }
    }

    /**
     * Añade un arco entre los vértices v1 y v2 al grafo.
     * En caso de que no exista alguno de los vértices, lo añade también.
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return 'true' si no exixtía el arco y 'false' en caso contrario.
     */
    public boolean addEdge (V v1, V v2){
        Set<V> vertice1 = new HashSet<>();
        Set<V> vertice2 = new HashSet<>();
        
        boolean edgeExists = true;
        if (listaAdyacencia.containsKey(v1) == false && listaAdyacencia.containsKey(v2) == false){
            //System.out.println("No existen v1 y v2");
            vertice1.add(v1);
            vertice2.add(v2);
            listaAdyacencia.put(v1, (HashSet<V>) vertice2);
            listaAdyacencia.put(v2, (HashSet<V>) vertice1);
            edgeExists = false;
        }else if (listaAdyacencia.containsKey(v1) == true && listaAdyacencia.containsKey(v2) == false){
            //System.out.println("Existe v1 pero no v2");
            vertice1.add(v1);
            listaAdyacencia.get(v1).add(v2);
            listaAdyacencia.put(v2, (HashSet<V>) vertice1);
            edgeExists = false;
        }else if (listaAdyacencia.containsKey(v1) == false && listaAdyacencia.containsKey(v2) == true){
            //System.out.println("Existe v2 pero no v1");
            vertice2.add(v2);
            listaAdyacencia.put(v1, (HashSet<V>) vertice2);
            listaAdyacencia.get(v2).add(v1);
            edgeExists = false;
        }else if (listaAdyacencia.containsKey(v1) == true && listaAdyacencia.containsKey(v2) == true && listaAdyacencia.get(v2).contains(v1) == false){
            //System.out.println("Existe v2 y existe v1 pero no están conectados");
            if (listaAdyacencia.get(v2).contains(v1) == false){
                listaAdyacencia.get(v2).add(v1);
            }
            if (listaAdyacencia.get(v1).contains(v2) == false){
                listaAdyacencia.get(v1).add(v2);
            }
            edgeExists = false;
        }else{
            //System.out.println("Ya exitía la arista");
        }
        if (edgeExists){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Obtiene el conjunto de vértices adyacentes al vértice v.
     * @param v vértice del que se obtienen los vértices adyacentes
     * @return un hashSet que contiene el conjunto de vértices adyacentes a uno dado.
     */
    public HashSet<V> obtainAddyacents (V v) throws Exception{
        return listaAdyacencia.get(v);
    }

    /**
     * Comprueba si el grafo contiene el vertice dado.
     * @param v vértice del que se realiza la comprobación.
     * @return 'true' si 'v' es un verice del grafo.
     */
    public boolean containsVertex (V v){
        return listaAdyacencia.containsKey(v);
    }

    /**
     * Devuelve una cadena que contiene todos los vértices del grafo.
     * @return 'la cadena buscada.
     */
    public String toString(){
        Set<V> conjuntoVertices = new HashSet<>();
        for (V elemento : listaAdyacencia.keySet()) {
            conjuntoVertices.add(elemento);
        }
        return conjuntoVertices.toString();
    }

    /**
     * Devuelve el HashSet asociado al vértice v.
     * @param v vértice del que queremos obtener el HashSet.
     * @return 'el HashSet asociado
     */
    public HashSet<V> dameHashSet(V v) {
        return listaAdyacencia.get(v);
    }

    /**
     * Comprueba si en el HashSet está un determinado valor (vértice).
     * @param v El vértice que buscamos en el HashSet
     * @return true o false, dependiendo si existe o no existe ese valor en el HAshSet
     */
    public boolean contieneValorElHashSet(HashSet<V> hashSet, V v) {
        return hashSet.contains(v);
    }

    /**
     * Comprueba si el hashmap con el que estamos trabajando contiene una determinada clave.
     * @param v La clave que buscamos en el hashmap.
     * @return true o false, dependiendo si existe o no existe esa clave en el hashmap.
     */
    public boolean contieneClave(V v) {
        return listaAdyacencia.containsKey(v);
    }

    /**
     * Inicializa el grafo con el que estamos trabajando.
     */
    public void vaciaListaAdyacencia() {
        listaAdyacencia.clear();
    }

    /**
     * Obtiene, en caso de que exista, un camino entre 'v1' y 'v2'
     * Caso contrario devuelve un null
     * @param v1 El vértice qorigen
     * @param v2 El vértice qfinal
     * @return Lista con la secuencia de vértices desde 'v1' hasta 'v2' pasando por arcos del grafo.
     */
    public List<V> onePath(V v1, V v2){
        boolean encontrado;
        V v, padre, hijo;
        List<V> camino = new ArrayList<>();
        List<V> visitados = new ArrayList<>(); //no debo poder visitar los ya visitados.
        Set<V> vertice = new HashSet<>();
        Tabla<V> traza = new Tabla<>();
        Pila<V> abierta = new Pila<>(100);
        abierta.push(v1);
        traza.annadir(v1, null);
        encontrado = false;
        while (abierta.esVacia() == false && encontrado == false){
            try{
                v = (V) abierta.pop();
                visitados.add(v);
                if (v2 == v){
                    encontrado = true;
                }else{
                    vertice = dameHashSet(v);
                    for (V elemento : vertice) {
                        if (visitados.contains(elemento) == false){
                            abierta.push(elemento);
                            traza.annadir(elemento, v);
                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("El programa está intenatando acceder a la pila fuera de sus límites");
            }
        }
        if (encontrado){
            abierta.vaciaPila();
            abierta.push(v2);
            hijo = v2;
            padre = traza.damePadreDeVertice(hijo);
            while (padre != null){
                hijo = padre;
                abierta.push(hijo);
                padre = traza.damePadreDeVertice(hijo);
            }
            while (abierta.esVacia() == false){
                camino.add(abierta.pop());
            }
            return camino;
        }else{
            return null;
        }
    }

}