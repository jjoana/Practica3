package pr2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Graph class.
 */

public class PilaTest {

    /**
     * Tests unitarios para los métodos push y pop de la pila.
     */
    @Test
    public void testPushPull1(){ //Se introducen y se recueparan correctamente los valores de la pila.
        Pila<String> abierta =  new Pila<>(100);
        try{
            abierta.push("Primer elemento");
            abierta.push("Segundo elemento");
            assertTrue ("Verificando la introducción en la pila", abierta.pop() == "Segundo elemento");
            assertTrue ("Verificando por segunda vez la introducción en la pila", abierta.pop() == "Primer elemento");
        }catch (ArrayIndexOutOfBoundsException e){
            assertTrue("Fallo en lectura de la pila", false);
        }
    }

    @Test
    public void testPushPull2(){ //Se intentan introducir más valores que el tamaño de la pila.
        Pila<String> abierta =  new Pila<>(100);
        try{
            abierta.push("Primer elemento");
            abierta.push("Segundo elemento");
            abierta.push("Tercer elemento");
            abierta.push("Elemento que supera el tamaño de la pila");
        }catch (ArrayIndexOutOfBoundsException e){
            assertTrue("Recogida la excepción ArrayIndexOutOfBoundsException", true);
        }
    }

    @Test
    public void testPushPull3(){ //Se intentan leer valores en la pila cuando ya no quedan valores.
        Pila<String> abierta =  new Pila<>(100);
        try{
            abierta.push("Primer elemento");
            abierta.push("Segundo elemento");
            abierta.pop();
            abierta.pop();
            abierta.pop();

        }catch (ArrayIndexOutOfBoundsException e){
            assertTrue("Recogida la excepción ArrayIndexOutOfBoundsException", true);
        }
    }

    @Test
    public void testPushPull4(){ //Se introduce justo hasta el tamaño máximo de la pila y se lee justo hasta el último elemento de la pila.
        Pila<String> abierta =  new Pila<>(100);
        try{
            abierta.push("Primer elemento");
            abierta.push("Segundo elemento");
            abierta.push("Tercer elemento");
            abierta.pop();
            abierta.pop();
            abierta.pop();
            assertTrue("Ejecución correcta de lectura en valores extremos de pila", true);
        }catch (ArrayIndexOutOfBoundsException e){
            assertTrue("Fallo en lectura de los extremos de la pila", false);
        }
    }
}
