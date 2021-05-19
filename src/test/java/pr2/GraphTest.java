package pr2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Unit tests for Graph class.
 */
public class GraphTest {
    Graph<String> grafo = new Graph<String> ();

    HashSet<String> hashSet = new HashSet<String> ();
    List<String> camino = new ArrayList <String> ();

    Graph<Integer> grafoI = new Graph<Integer> ();
    HashSet<Integer> hashSetI = new HashSet<Integer> ();
    List<Integer> caminoI = new ArrayList <Integer> ();

    /**
     * Tests unitarios para el método addVertex.
     * Prbamos con un grafo de String y otros grafo de Integer.
     */
    @Test
    public void testAddVertex1(){
        grafo.addVertex("A");
        grafo.addVertex("B");
        grafo.addVertex("C");
        assertTrue("Clave introducida incorrectamente", grafo.contieneClave("A"));
        assertTrue("Clave introducida incorrectamente", grafo.contieneClave("B"));
        assertTrue("Clave introducida incorrectamente", grafo.contieneClave("C"));
        assertFalse("Clave introducida incorrectamente", grafo.contieneClave("D"));
        grafo.vaciaListaAdyacencia();
    }

    @Test
    public void testAddVertex2(){
        grafoI.addVertex(1);
        grafoI.addVertex(2);
        grafoI.addVertex(3);
        assertTrue("Clave introducida incorrectamente", grafoI.contieneClave(1));
        assertTrue("Clave introducida incorrectamente", grafoI.contieneClave(2));
        assertTrue("Clave introducida incorrectamente", grafoI.contieneClave(3));
        assertFalse("Clave introducida incorrectamente", grafoI.contieneClave(4));
        grafo.vaciaListaAdyacencia();
    }

    /**
     * Tests unitarios para el método addEdge.
     */
    @Test
    //Prueba de inserción de un arco y no existe el vertice v1 ni el v2
    public void testAddEdge1(){ 
        grafo.addEdge("A", "B");
        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        grafo.vaciaListaAdyacencia();
    }

    @Test
    //Prueba para verificar que funciona correctamente la inserción del vertice v1 y el v2 cuando ninguno de los dos existe.
    public void testAddEdge2(){ 
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "D");
        grafo.addEdge("E", "F");
        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("B"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("C"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("D"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("E"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("F"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F") == false);
        hashSet = grafo.dameHashSet("B");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F") == false);
        hashSet = grafo.dameHashSet("C");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F") == false);
        hashSet = grafo.dameHashSet("D");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F") == false);
        hashSet = grafo.dameHashSet("E");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F"));
        hashSet = grafo.dameHashSet("F");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "F") == false);
        grafo.vaciaListaAdyacencia();
    }

    @Test
    //Prueba para verificar que funciona correctamente la inserción cuando existe el vertice v1 pero el v2 no existe.
    public void testAddEdge3(){ 
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("A", "D");
        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("B"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("C"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("D"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D"));
        hashSet = grafo.dameHashSet("B");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        hashSet = grafo.dameHashSet("C");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        hashSet = grafo.dameHashSet("D");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        grafo.vaciaListaAdyacencia();
    }

    @Test
    //Prueba para verificar que funciona correctamente la inserción cuando existe el vertice v2 pero el v1 no existe.
    public void testAddEdge4(){ 
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "B");
        grafo.addEdge("D", "C");
        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("B"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("C"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("D"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        hashSet = grafo.dameHashSet("B");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        hashSet = grafo.dameHashSet("C");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D"));
        hashSet = grafo.dameHashSet("D");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        grafo.vaciaListaAdyacencia();
    }

    @Test
    //Prueba para verificar que si existen el nodo v1 y el nodo v2, pero no estan conectados, los conectamos.
    public void testAddEdge5(){ 
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("D", "C");
        grafo.addEdge("C", "E");

        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("B"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("C"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("D"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("E"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("B");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("C");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E"));
        hashSet = grafo.dameHashSet("D");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("E");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);

        //Se añade un nuevo arco en el grafo y se comprueba si la inserción se ha realizado correctamente.
        grafo.addEdge("C", "B");
        assertTrue("Clave leida incorrecta", grafo.contieneClave("A"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("B"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("C"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("D"));
        assertTrue("Clave leida incorrecta", grafo.contieneClave("E"));
        hashSet = grafo.dameHashSet("A");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("B");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("C");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E"));
        hashSet = grafo.dameHashSet("D");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        hashSet = grafo.dameHashSet("E");
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "E") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "A") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "B") == false);
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "C"));
        assertTrue("Valor leido incorrecto", grafo.contieneValorElHashSet(hashSet, "D") == false);
        grafo.vaciaListaAdyacencia();
    }

    /**
     * Tests unitarios para el método obtainAdyacents.
     */
    @Test
    // Prueba del método obtainAdyacents.
    // Devuelve los vértices adyacentes a un vértice dado como parámetro.
    public void testObtainAdyacents1(){
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "D");
        grafo.addEdge("C", "B");
        try{
            hashSet = grafo.obtainAddyacents("C");
            assertTrue("Comprobación de adyacentes incorrecta", hashSet.contains("D"));
            assertTrue("Comprobación de adyacentes incorrecta", hashSet.contains("B"));
            assertFalse("Comprobación de adyacentes incorrecta", hashSet.contains("C"));
        }catch(Exception e){
            assertTrue("Capturada la excepción:", false);
        }
    }

    @Test
    public void testObtainAdyacents2(){
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "D");
        grafo.addEdge("C", "B");
        try{
            hashSet = grafo.obtainAddyacents("F");
        }catch(Exception e){
            System.out.println("Capturada la excepción: " + e);
            assertTrue("Capturada la excepción :", true);
        }
    }

    /**
     * Tests unitarios para el método containsVertex.
     */
    @Test
    public void testContainsVertex(){
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "D");
        grafo.addEdge("C", "B");
        assertTrue("Error: Vértice existente no ha sido encontrado.", grafo.containsVertex("A"));
        assertTrue("Error: Vértice existente no ha sido encontrado.", grafo.containsVertex("B"));
        assertTrue("Error: Vértice existente no ha sido encontrado.", grafo.containsVertex("C"));
        assertTrue("Error: Vértice existente no ha sido encontrado.", grafo.containsVertex("D"));
        assertFalse("Error: Vértice no existente ha sido reconocido.", grafo.containsVertex("E"));
    }

    /**
     * Tests unitarios para el método containsVertex.
     */
    @Test
    public void testToString(){
        grafo.addEdge("A", "B");
        grafo.addEdge("C", "D");
        grafo.addEdge("C", "B");
        hashSet.add("A");
        hashSet.add("C");
        hashSet.add("B");
        hashSet.add("D");
        assertEquals("Error: Conjunto de vértices no correcto.", hashSet.toString(), grafo.toString());
    }

    /**
     * Tests de Integración para el método onePath() tanto para tipo 'Integer' como para tipo 'String'.
     */
    @Test
    public void testOnePath(){
        grafo.addEdge("A", "B");
        grafo.addEdge("B", "D");
        grafo.addEdge("B", "C");
        grafo.addEdge("C", "E");
        grafo.addEdge("C", "F");
        grafo.addEdge("D", "E");
        grafo.addEdge("E", "F");
        grafo.addEdge("F", "G");
        //Busco el camino entre dos vértices.
        camino = grafo.onePath("A", "G");
        System.out.println("El camino encontrado es: " + camino);
        camino = grafo.onePath("A", "E");
        System.out.println("El camino encontrado es: " + camino);
        camino = grafo.onePath("D", "G");
        System.out.println("El camino encontrado es: " + camino);
    }

    @Test
    public void testOnePath2(){
        grafoI.addEdge(1, 2);
        grafoI.addEdge(3, 4);
        grafoI.addEdge(1, 5);
        grafoI.addEdge(5, 6);
        grafoI.addEdge(6,7 );
        //Busco el camino entre dos vértices
        caminoI = grafoI.onePath(1, 4);
        System.out.println("El camino encontrado es: " + caminoI);
        caminoI = grafoI.onePath(1, 7);
        System.out.println("El camino encontrado es: " + caminoI);
        caminoI = grafoI.onePath(2, 7);
        System.out.println("El camino encontrado es: " + caminoI);
    }
    
}
