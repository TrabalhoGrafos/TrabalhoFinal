
public class Aresta<T> {
	private double custo;
	public Vertice<T> origem;
	public Vertice<T> destino;
	
	
	public Aresta(){
		
	}
	
    public Aresta(double custo, Vertice<T> origem, Vertice<T> destino){
		this.custo = custo;
		this.origem = origem;
		this.destino = destino;
	}
	
	public double getCusto() {
		return custo;
	}

	public Vertice<T> getOrigem(){
		return origem;
	}

	public Vertice<T> getDestino() {
		return destino;
	}


	 public String toString() {
		    StringBuilder tmp = new StringBuilder("Aresta[de: ");
		    tmp.append(origem.getID());
		    tmp.append(",para: ");
		    tmp.append(destino.getID());
		    tmp.append(", custo: ");
		    tmp.append(custo);
		    tmp.append("]");
		    return tmp.toString();
		  }
	
}
