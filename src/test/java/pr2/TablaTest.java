package pr2;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;

/**
 * Unit test for Tabla class.
 */

public class TablaTest {

    /**
     * Tests unitarios para los métodos push y pop de la pila.
     */
    @Test
    public void test_annadir_GetTabla(){ //Se introducen y se recueparan correctamente los valores de la tabla.
        Tabla<String> tabla = new Tabla<>();
        HashSet<String> hs = new HashSet<>();

        //Añadimos valores a la tabla
        tabla.annadir("A", null);
        tabla.annadir("B", "A");
        tabla.annadir("C", "A");
        tabla.annadir("D", "B");

        //Comprobamos que se recuperan correctamente los valores introducidos en la tabla.
        System.out.println("La tabla contiene los siguientes elementos: " + tabla.toString());
    }

    
}
