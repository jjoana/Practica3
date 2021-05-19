package pr2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tabla <V>{

    private Map<V, V> hm;
    private Set<V> hs;


    /**
     * Constructor por defecto de la tabla.
     */
    public Tabla(){
        hm = new HashMap<>();
        hs = new HashSet<>();
    }

    /**
     * Añade un elemento a la tabla.
     * La tabla es un hashmap con dos elementos verticeInicial y VerticeFinal.
     * @param verticeInicial (hijo)
     * @param verticeFinal (padre)
     */
    public void annadir (V verticeInicial, V verticeFinal){
        hm.put(verticeInicial, verticeFinal);
    }

    /**
     * Este método devuelve el vértice padre de un vértice dado.
     * @param vertice (hijo)
     * @return V (el vértice padre)
     */
    public V damePadreDeVertice (V vertice){
        return hm.get(vertice);
    }

    /** Este método devuelve las claves de la tabla (Todos los vértices hijos - por donde hemos pasado).
    * @param vertice (hijo)
    * @return HashSet<V>, que es el conjunto de 
    */
    public HashSet<V> buscarVerticeTabla (V vertice){
        return (HashSet<V>) hm.keySet();
    }

    /** Este método devuelve Todos los padres de un hijo.
    * @param vertice (hijo)
    * @return HashSet<V>, el conjunto de padres.
    */
    //Recupera todos los padres de un vértice dado.
    public HashSet<V> getPadresDeVertices (V vertice){
        for (V elemento: hm.keySet()) {
            if (vertice == elemento){
                hs.add(hm.get(elemento));
            }
        }
        return (HashSet<V>) hs;
    }

    @Override
    public String toString (){
        //Muestra todos los valores que hay en  la tabla.
        for (V elemento: hm.keySet()) {
            hs.add(elemento);
            hs.add(hm.get(elemento));
        }
        return hs.toString();
    }


    
}
