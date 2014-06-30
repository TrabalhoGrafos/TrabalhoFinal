/**
 * Classe na qual ha a estrutura do grafo.
 * 
 * @author Dennis Kaffer
 * */

import java.util.*;

public class Grafo{
	
	 private List<Vertice> listaVertices;
	 private List<Aresta> listaArestas;

	  public Grafo(){
		  listaVertices = new ArrayList<Vertice>();
		  listaArestas = new ArrayList<Aresta>();
		  
	  }
		  
	  
	  public Vertice addVertice(Vertice newVertice){
		    // adiciona no arraylist
		    listaVertices.add(newVertice);
		    return newVertice;
		  }
	  

	  public boolean addAresta(int o, int d, double c) throws IllegalArgumentException {
		    //usando as referencias do arquivo, localizo o vertice na lista por elas...
		  
		  if (listaVertices.get(o) == null){
		      throw new IllegalArgumentException("vertice de origem nao esta no grafo");
		      }
		      if (listaVertices.get(d) == null){
		      throw new IllegalArgumentException("vertice de destino nao esta no grafo");
		      }
		      
		      if (listaVertices.get(o).findAresta(listaVertices.get(d)) != null){
		          return false;
		      }else{
		    Aresta e = new Aresta(c, listaVertices.get(o), listaVertices.get(d));
		  
		      listaVertices.get(o).addArestaVertice(e);
		      listaVertices.get(d).addArestaVertice(e);
		      listaArestas.add(e);
		      return true;
		      }
		  }
	 

	  public Vertice getVertice(int n){
	    return listaVertices.get(n);
	  }

	  
	  public List<Vertice> getVertices(){
		    return this.listaVertices;
		  }
	  
	  
	  public Vertice findVerticeById(int id){
		  Vertice tmp = null;
		    for (Vertice v : listaVertices){
		      if (id == v.getID()){
		    	  tmp = v;
		        break;
		      }
		    }
		    return tmp;
		  }
	  

	  public boolean isEmpty(){
		    return listaVertices.size() == 0;
		  }
	
	  public int size(){
		    return listaVertices.size();
		  }
	  
	  public String toString(){
		    StringBuilder tmp = new StringBuilder("Grafo [");
		    for(Vertice v : listaVertices)
		      tmp.append(v);
		    tmp.append(']');
		    return tmp.toString();
		  }
	  
	  //TO DO
}
