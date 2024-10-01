/**
 * @author raidentrance
 *
 */
public class Arista {
    private Nodo origen;
    private Nodo destino;
    private double distancia;

    public Arista(){
        origen = null;
        destino = null;
        distancia = 0;
    }
 
    public Arista(Nodo origen, Nodo destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
 
    public Nodo getorigen() {
        return origen;
    }
 
    public void setorigen(Nodo origen) {
        this.origen = origen;
    }
 
    public Nodo getdestino() {
        return destino;
    }
 
    public void setdestino(Nodo destino) {
        this.destino = destino;
    }
 
    public double getdistancia() {
        return distancia;
    }
 
    public void setdistancia(double distancia) {
        this.distancia = distancia;
    }
 
    @Override
    public String toString() {
        return "\n Edge [origen=" + origen.getNumero() + ", destino=" + destino.getNumero() + ", distancia="
                + distancia + "]";
    }
 
}
