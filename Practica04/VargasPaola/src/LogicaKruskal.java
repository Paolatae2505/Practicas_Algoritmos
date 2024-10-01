import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase LogicaKruskal
 * @author Vargas Bravo Paola
 * @version 1.0 (10 Dic 2022)
 * @since Analsis de Algortimos (2023-1)
 * @see leerTXT
 * @see Tupla
 */
public class LogicaKruskal{
     
    /// Atributos
    public String [] parentesco;
    public ArrayList<Tupla> T = new ArrayList<>();
    public Tupla[] AristasNueva;
    public Map<String,Integer> referencias = new HashMap<>();
    public LeerTXT leerTXT;
    public OrdenamientoAristas ord = new OrdenamientoAristas();


   /**
    * Inicializa a LogicaKruskal, apartir de las aristas, parentesco
    * y referencias
    * @param AristasNueva --- Tuplas [] aristas con peso de G
    * @param parentesco  --- String [] Parentesco de G
    * @param referencias  --- Map<String,Integer>  Referencia 
    *                         de cada vertice asignando una posicion
    *                         Ej :  a - 0, b -1 
    */
    public LogicaKruskal(Tupla[] AristasNueva,String [] parentesco,
    Map<String,Integer> referencias){
    this.parentesco = parentesco;
    this.referencias = referencias;
    this.AristasNueva = AristasNueva;
    }

    /**
     * Verifica que todos los vertices tengan el mismo padre
     * @return  --- boolean True en caso de ser cierto
     *              False en caso contrario
     */
    public boolean allSameFather(){
        String fst = ""; 
        for(int i = 0; i < parentesco.length; i++){
            if(i == 0){
               fst  = parentesco[i];
            }else{
                String rst = parentesco[i];
              if (sameFather(fst, rst) == false ){
                  return false;
              }
            }
        }
       return true;
    }
    /**
     * Obtiene si dos vertices tienen el mismo padre
     * @param a  --- String vertice 1
     * @param b  --- String vertice 2
     * @return --- boolean True en caso de ser cierto
     *            False en caso contrario
     */
    private boolean sameFather(String a, String b){
        int indexFatherA = referencias.get(a);
        int indexFatherB = referencias.get(b);
        String fatherA, fatherB;
        fatherA = parentesco[indexFatherA];
        fatherB = parentesco[indexFatherB];
         if(fatherA.equals(a) && fatherB.equals(b)){
            return fatherA.equals(fatherB);
         }else if(fatherA.equals(a) &&  fatherB.equals(b) == false){
            return sameFather(a, fatherB);
         }else if(fatherA.equals(a) == false &&  fatherB.equals(b)){
            return sameFather(fatherA, b);
         }else{
            return sameFather(fatherA, fatherB);
         }
    }
    /**
     * Obtiene el padre de vertice apartir de Parentesco
     * @param a -- Strin vertice a obtener Padre
     * @return  --- String padre de a
     */
    private String getFather(String a){
        int indexFatherA = referencias.get(a);
        String fatherA;
        fatherA = parentesco[indexFatherA];
         if(fatherA.equals(a)){
            return fatherA;
         }else{
            return getFather(fatherA);
         }
    }
    /**
     * Cambia la referencia de padre de dos vertices, tal que 
     * el padre de B será el de A
     * @param a --- String vertice 1
     * @param b  -- String vertice 2
     */
    private void changesFather(String a , String b){
        String fatherA, fatherB;
        int indexFatherB;
        fatherA = getFather(a);
        fatherB = getFather(b);
        indexFatherB = referencias.get(fatherB);
        parentesco[indexFatherB] = fatherA; 
        //imprimirParentesco();

    }

    /**
     * Aplica el algoritmo de Kruskal usando
     * conjuntos Ajenos con union por tamaño
     */

    public void KruskalUCA(){
         String arista = "";
         int peso = 0;
         Tupla tuplaAux;
         int i = 0;
         String key,aS,bS;
         int value;
         int n = AristasNueva.length;
        ord.sort3(AristasNueva, 0, n-1);
        while(allSameFather() == false){
            tuplaAux = AristasNueva[i];
            key = tuplaAux.getKey();
            value = tuplaAux.getValue();
            aS = Character.toString( key.charAt(0));
            bS = Character.toString( key.charAt(1));
            Boolean entrar = sameFather(aS, bS); 
            if(entrar == false ){             
                 changesFather(aS, bS);
                 T.add(tuplaAux);
            }
            i++;
        }

        imprimirT();
        pesoT();
    }
    /**
     * Imprime el parentesco de G
     */
    public void imprimirParentesco(){
        System.out.println("Parentestco :");
        System.out.println(parentesco.length);
        for (String a : parentesco) {
          System.out.println(a);
          
        }
    }
    /**
     * Imprime el peso de nuestro arbol T
     */
    public void pesoT(){
        System.out.println("Peso de T (árbol) :");
        int suma = 0;
        for (Tupla t : T) {
             suma = suma + t.getValue();
        }
        System.out.println(suma);
    }
    /**
     * Imprime las refrencias de los vertices
     */
    public void imprimirReferencias(){
        System.out.println("Referencias :");
        System.out.println(referencias.size());
        for (Map.Entry<String, Integer> entry : referencias.entrySet()) {
            System.out.println("Arista :" + entry.getKey() + ", Peso :" + entry.getValue());
        }
        
    }
   /**
    * Imprime las aristas de T final obtenido
    */
    public void imprimirT(){
        System.out.println("T(A) -> Aristas de T(árbol) :");
        for (Tupla t : T) {
            String cadena = "<" + t.getKey() + "," + t.getValue() + ">";
            System.out.println(cadena);
        }
    }

}