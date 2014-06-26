
public class Aresta {
	private double custo;
	public Vertice<?> origem;
	public Vertice<?> destino;
	
	
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public Vertice<?> getOrigem() {
		return origem;
	}
	public void setOrigem(Vertice<?> origem) {
		this.origem = origem;
	}
	public Vertice<?> getDestino() {
		return destino;
	}
	public void setDestino(Vertice<?> destino){
		this.destino = destino;
	}
	public String toString(){
		return this.custo+" "+this.origem.getID()+" "+this.destino.getID()+"\n";
	}
	
}
