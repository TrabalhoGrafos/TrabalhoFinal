/**
 * Classe na qual ha a estrutura do grafo.
 * 
 * @author Dennis Kaffer
 * */

import java.util.*;

public class Grafo{
	/**Vetor <Vertice> com os vertices do grafo**/
	 private List<Vertice> listaVertices;
	 /**Vetor <Aresta> com as arestas do grafo**/
	 private List<Aresta> listaArestas;

	 /**
	   * Construtor do novo grafo
	   * */
	  public Grafo(){
		  listaVertices = new ArrayList<Vertice>();
		  listaArestas = new ArrayList<Aresta>();
		  
	  }
	  /**
	   * Adiciona vertice no grafo
	   * 
	   * @param newVertice
	   *          o vertice para adicionar
	   */
	  public Vertice addVertice(Vertice newVertice){
		    // adiciona no arraylist
		    listaVertices.add(newVertice);
		    return newVertice;
		  }
	  
	  /**
	   *Insere uma Aresta direta no grafo
	   * 
	   * @param o -
	   *         referencia para a busca pelo vertice de origem
	   * @param d -
	   *          referencia para a busca pelo vertice de destino
	   * @param c -
	   *          o custo/tamanho da aresta
	   *          
	   * @return  true se a aresta foi adicionada, false se já existe essa aresta
	   * @throws IllegalArgumentException
	   *           se pelas referencias nao eh encontrado nenhum vertice no grafo
	   */
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
	 
	  /**
	   * Metodo que busca o vertice no grafo pela sua posicao na listaVertices
	   * @return vertice alocado na determinada posicao
	   * */
	  public Vertice getVertice(int n){
	    return listaVertices.get(n);
	  }

	  
	  /**
	   * @return vertices contidos no grafo
	   * */
	  public List<Vertice> getVertices(){
		    return this.listaVertices;
		  }
	  
	  /**
	   * Faz a procura no grafo pelo id do vertice
	   * @return vertice com id igual
	   * */
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
	  
	  /**
	   * Verifica se o grafo esta vazio
	   * @return quantidade de vertices
	   * */
	  public boolean isEmpty(){
		    return listaVertices.size() == 0;
		  }
	
	  /**
	   * Metodo que retorna a quantidade de vertices que contem no grafo
	   * @return quantidade de vertices
	   * */
	  public int size(){
		    return listaVertices.size();
		  }
	  
	  /**
	   * Metodo responsavel por limpar o status de visitado dos vertices
	   * */
	  public void clearVertices(){
		    for (Vertice v : listaVertices)
		      v.clearVisitado();
		  }

	  /**
	   * Metodo responsavel por limpar o status de visitado das arestas 
	   * */
		  public void clearArestas(){
		    for (Aresta a : listaArestas)
		      a.clearVisitado();
		  }

  
	  public String toString(){
		    StringBuilder tmp = new StringBuilder("Grafo [");
		    for(Vertice v : listaVertices)
		      tmp.append(v);
		    tmp.append(']');
		    return tmp.toString();
		  }
	  
}
