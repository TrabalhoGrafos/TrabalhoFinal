import java.util.*;


public class Vertice<T>{

	private int ID;
	private double coordenadaX = 0;
	private double coordenadaY = 0;
	private boolean visitado;
	

	ArrayList<Aresta<T>> arestaEntrada;
	ArrayList<Aresta<T>> arestaSaida;
	
	  public Vertice() {
	 
	    }
	
	  public Vertice(int id) {
		  arestaEntrada = new ArrayList<Aresta<T>>();
		  arestaSaida = new ArrayList<Aresta<T>>();
		  
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
		
	
	 public boolean addArestaVertice(Aresta<T> a) {
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
	
	  public Aresta<T> findAresta(Vertice<T> v) {
		    for (Aresta<T> a : arestaSaida) {
		      if (a.getDestino() == v)
		        return a;
		    }
		    return null;
		  }

	 
	  public boolean checkAresta(Aresta<T> a) {
		    if(a.getOrigem() == this){
		      return arestaEntrada.contains(a);
		    }
		    else if(a.getDestino() == this){
		      return arestaSaida.contains(a);
		      }else{
		      return false;
		      }
		    }
	  
	  public String toString() {
		    StringBuilder tmp = new StringBuilder("Vertice (");
		    tmp.append(ID);
		    tmp.append("), ENTRADA:[");
		    for(int i = 0; i < arestaEntrada.size(); i++) {
		      Aresta<T> a = arestaEntrada.get(i);
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
		      Aresta<T> a = arestaSaida.get(i);
		      if(i > 0)
		        tmp.append(',');
		      tmp.append('{');
		      tmp.append(a.getDestino().ID);
		      tmp.append(',');
		      tmp.append(a.getCusto());
		      tmp.append('}');
		    }
		    tmp.append(']');
		    return tmp.toString();
		  }
	  
}
