/**
 * Classe que contém os atributos das arestras
 *
 */
public class Aresta {
	
	private double custo;
	public Vertice origem;
	public Vertice destino;
	
	private boolean visitado = false;
	
	public Aresta(){
		
	}
	
    public Aresta(double custo, Vertice origem, Vertice destino){
		this.custo = custo;
		this.origem = origem;
		this.destino = destino;
	}
	
	public double getCusto() {
		return custo;
	}

	public void setOrigem(Vertice v){
		this.origem = v;
	}
	
	public Vertice getOrigem(){
		return origem;
	}

	public Vertice getDestino() {
		return destino;
	}
	
	public boolean checkVisitado(){
		return this.visitado;
	}

	public void visitar(){
		 this.visitado = true;
	}
	
	public void clearVisitado(){
		this.visitado = false;
	}

	
	 public String toString() {
		    StringBuilder tmp = new StringBuilder("Aresta[de: ");
		    tmp.append(origem.getID());
		    tmp.append(",para: ");
		    tmp.append(destino.getID());
		    tmp.append(", custo: ");
		    tmp.append(custo);
		    tmp.append("]");
		    tmp.append("\n");
		    return tmp.toString();
		  }
}
