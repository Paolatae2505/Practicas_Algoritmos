import java.util.ArrayList;
import java.util.List;
 
/**
 * @author raidentrance
 *
 */
public class Grafica{
 
    private List<Nodo> nodos;

    public Grafica(){
        
    }
 
    public void addNodo(Nodo nodo) {
        if (nodos == null) {
            nodos = new ArrayList<>();
        }
        nodos.add(nodo);
    }
 
    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodosNuevo){
        this.nodos = nodosNuevo;
    }
 
    @Override
    public String toString() {
        return "Gráfica [nodeo=" + nodos + "]";
    }
 
}


