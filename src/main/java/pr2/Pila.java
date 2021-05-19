package pr2;

public class Pila<E> {
    private E[] elementos;
    private E elemento;
    private int superior = 0;

    public Pila (int tamanyo){
        elementos = (E[]) new Object[tamanyo];
    }

    /**
     * Comprueba si la pila está vacia.
     * @retun devuelve true si la pila está vacia y false en caso contrario
     */
    public boolean esVacia() {
        if (superior == 0){
            return true;
        }
        return false;
    }

    /**
     * Este método vacia la pila con la que estamos trabajando
     * @param
     * @retun 
     */
    public void vaciaPila() {
        superior = 0;
    }

    /**
     * Este método añade un nuevo elemento a la pila.
     * @param elemento es el elemento que se añade a la pila
     */
    public void push (E elemento) throws ArrayIndexOutOfBoundsException{
        elementos[superior++] = elemento;
    }

    /**
     * Este método extrae un elemento de la pila.
     * @return 'el último elemento que se introdujo en la pila es el que se recupera.
     */
    public E pop () throws ArrayIndexOutOfBoundsException{
        return elementos[--superior];
    }

    /**
     * Método toString() .
     * Sobreescribe el método toString() de la clase Object.
     * @return 'String' la cadena.
     */
    @Override
    public String toString(){
        return elemento.toString();
    }
}