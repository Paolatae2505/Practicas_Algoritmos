import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
/**
 * Clase LeerTXT
 * @author Vargas Bravo Paola
 * @version 1.0 (07 Dic 2022)
 * @since Analsis de Algortimos (2023-1)
 */
public class LeerTXT {

    // Atributos
    private String path ;
    private LogicaKruskal k;
    /**
     * Crea una instancia LeerDocumento a partir del path
     * para poder leer el documento y genera la grafica
     * @param path --- String Ruta de la grafica txt
     */
    public LeerTXT(String path){
       this.path = path;
    }
    /**
     * Crea una grafica apatir de la lectura del documento txt
     * ademas de aplicar el algoritmo de Kruscal
     */
    public  void  inicializarGrafica(){
       ArrayList<String>  lineas = new ArrayList<>();
        //Tupla [] AristasNueva;
        String [] aristas = null;
        String [] vertex = null;
        Tupla [] AristasNueva;
        String [] parentesco;
        Map<String,Integer> referencias = new HashMap<>();
        String verticeInicial = "";
        String verticeFinal = "";
        String vertices = "";
        Tupla tuplaAux = null;
        int peso = 0;
        String pesoString = "";
        try{
            String linea = "";
            InputStream ins = new FileInputStream(path);
            Scanner obj = new Scanner(ins);
            int z = 0;
            while (obj.hasNextLine()){
                linea = obj.nextLine();
                if(z == 0){
                    z++;
                   vertices = linea;  
                 }else if(z > 0) {
                    lineas.add(linea);
                }             
            }
        }catch(Exception e){
          System.out.println(e);
        }
      
        vertex = vertices.split(",",-1);
        parentesco = new String[vertex.length];
        for(int i = 0 ; i <= vertex.length - 1; i++){
           String vertexAux = vertex[i];   ///// Obtenemos vertices
           parentesco[i] = vertexAux;
           referencias.put(vertexAux,i);
        }

         int j  = 0;
           AristasNueva = new Tupla[lineas.size()];
          for(String id : lineas){
            aristas = id.split(",",-1);
            verticeInicial = aristas[0];
            verticeFinal = aristas[1]; 
            pesoString = aristas[2];    //// Obtenermos aristas y Pesos
            peso = Integer.parseInt(pesoString);
            String union = verticeInicial + verticeFinal;
            tuplaAux = new Tupla(union, peso);
            AristasNueva[j] = tuplaAux;
            j ++;
          }          
          k = new LogicaKruskal(AristasNueva, parentesco, referencias);
         k.KruskalUCA();
    }
}
