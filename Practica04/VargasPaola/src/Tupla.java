/**
 * Clase Tupla
 * @author Vargas Bravo Paola
 * @version 1.0 (07 Dic 2022)
 * @since Analsis de Algortimos (2023-1)
 */
public class Tupla {
     // Atributos 
    private String key;
    private int value;

    /**
     * Inicializa una Tupla apartir de su llave y valor
     * @param key  --- String llave de la Tupla
     * @param value --- int value de la tupla
     */
    public Tupla(String key , int value){
        this.key = key;
        this.value = value;
    }
    /**
     * Obtiene el elemento key
     * @return -- String atributo Key
     */
    public String getKey(){
      return key;
    } 
    /**
     * Obtiene el elemento Value
     * @return --- int atributo Value
     */
    public int getValue(){
      return value;
    }
}
