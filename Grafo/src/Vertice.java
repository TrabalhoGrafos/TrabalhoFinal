import java.util.*;


public class Vertice implements Comparable<Vertice>{

	private int ID;
	private double coordenadaX = 0;
	private double coordenadaY = 0;
	private boolean visitado;
	 private double distancia = Double.POSITIVE_INFINITY;

	private ArrayList<Aresta> arestaEntrada;
	private ArrayList<Aresta> arestaSaida;
	
	private Vertice pai = null;
	
	  public Vertice() {
	 
	    }
	
	  public Vertice(int id) {
		  arestaEntrada = new ArrayList<Aresta>();
		  arestaSaida = new ArrayList<Aresta>();
		  
	      this.ID = id;
	    }
	
	public int getID() {
		return ID;
	}

	public double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	  public double getDistancia() {
			return distancia;
		}

		public void setDistancia(double distancia) {
			this.distancia = distancia;
		}
		
		public boolean checkVisitado(){
			return this.visitado;
		}
		
		public void visitar(){
			this.visitado = true;
		}
		
	
	 public boolean addArestaVertice(Aresta a) {
		    if(a.getOrigem() == this){
		    	arestaSaida.add(a);
		    }
		    else if(a.getDestino() == this){
		    	arestaEntrada.add(a);
		    }
		    else{
		      return false;
		    }
		      return true;
		  }
	
	 
	 
	 
	  public Aresta findAresta(Vertice v) {
		    for (Aresta a : arestaSaida) {
		      if (a.getDestino() == v)
		        return a;
		    }
		    return null;
		  }

	 
	  public boolean checkAresta(Aresta a) {
		    if(a.getOrigem() == this){
		      return arestaEntrada.contains(a);
		    }
		    else if(a.getDestino() == this){
		      return arestaSaida.contains(a);
		      }else{
		      return false;
		      }
		    }
	  
	  public ArrayList<Aresta> getArestas(){
		  ArrayList<Aresta> todasArestas = new ArrayList<>();
		  todasArestas.addAll(arestaSaida);
		  todasArestas.addAll(arestaEntrada);
		    return todasArestas;
		  }
	  

	public Vertice getPai() {
		return pai;
	}

	public void setPai(Vertice pai) {
		this.pai = pai;
	}

	@Override
	public int compareTo(Vertice o) {
		// TODO Auto-generated method stub
		return 0;
	}

	  public String toString() {
		    StringBuilder tmp = new StringBuilder("Vertice (");
		    tmp.append(ID);
		    tmp.append("), ENTRADA:[");
		    for(int i = 0; i < arestaEntrada.size(); i++) {
		      Aresta a = arestaEntrada.get(i);
		      if(i > 0)
		        tmp.append(',');
		      tmp.append('{');
		      tmp.append(a.getOrigem().ID);
		      tmp.append(',');
		      tmp.append(a.getCusto());
		      tmp.append('}');
		    }
		    tmp.append("], SAIDA:[");
		    for(int i = 0; i < arestaSaida.size(); i++) {
		      Aresta a = arestaSaida.get(i);
		      if(i > 0)
		        tmp.append(',');
		      tmp.append('{');
		      tmp.append(a.getDestino().ID);
		      tmp.append(',');
		      tmp.append(a.getCusto());
		      tmp.append('}');
		    }
		    tmp.append(']');
		    tmp.append('\n');
		    return tmp.toString();
		  }

}
