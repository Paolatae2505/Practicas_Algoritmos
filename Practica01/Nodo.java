import java.util.ArrayList;
import java.util.List;
 
/**
 * @author raidentrance
 *
 */
public class Nodo{
    private char numero;
    private List<Arista> aristas;
 
    public Nodo(char numero) {
        this.numero = numero;
    }
 
    public char getNumero() {
        return numero;
    }
 
    public void setNumero(char numero) {
        this.numero = numero;
    }
 
    public List<Arista> getAristas() {
        return aristas;
    }
 
    public void addArista(Arista arista) {
        if (aristas == null) {
            aristas = new ArrayList<>();
        }
        aristas.add(arista);
    }
 
    @Override
    public String toString() {
        return "\n \tNodo [numero=" + numero + ", Aristas=" + aristas + "]";
    }
}