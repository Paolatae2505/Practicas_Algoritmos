import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList; 
/**
 * @author Vargas Bravo Paola
 *
 */
public class Main {
    public static void main(String[] args) {
        Nodo nodo;
        ArrayList<Nodo> vertices = new ArrayList<>();
        ArrayList<Nodo> nodos = new ArrayList<>();
        ArrayList<Arista> aristas = new ArrayList<>();
        Grafica grafica = new Grafica();
        try{
        ArrayList<String> aristasDoc = new ArrayList<String>();
        int i  = 1;
        InputStream ins = new FileInputStream("Test.txt");
        Scanner obj = new Scanner(ins);
        String verticesDoc = "";
        String aristaDoc = "";
        while (obj.hasNextLine()){
            if(i==1){
                verticesDoc = obj.nextLine();
        
            }else{
                aristaDoc = obj.nextLine();
                aristasDoc.add(aristaDoc);
    
            }
            i++;
        }
        int long1 = verticesDoc.length();
        for(int j = 0; j <= long1; j = j + 2){
             char numero = verticesDoc.charAt(j);
             nodo = new Nodo(numero);
             grafica.addNodo(nodo);
             vertices.add(nodo);
        }
        for(int k = 0 ; k <= aristasDoc.size(); k ++){
            String v = aristasDoc.get(k);
            char nodoInicial = v.charAt(0);
            char nodoFinal = v.charAt(2);
            Arista arista1 = new Arista();
            Nodo nodo1  = null;
            for(int l = 0; l <= vertices.size(); l++){
               nodo1 = vertices.get(l);
               if(nodo1.getNumero() == nodoInicial){
                     arista1.setorigen(nodo1);
               }else if(nodo1.getNumero() == nodoFinal){
                     arista1.setdestino(nodo1);
               }
            }
            nodo1.addArista(arista1);
            nodos.add(nodo1);
        }
        grafica.setNodos(nodos);
      
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}