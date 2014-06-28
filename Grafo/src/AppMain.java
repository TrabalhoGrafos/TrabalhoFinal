import java.io.*;
import java.util.*;


public class AppMain {

	static Scanner sc = new Scanner(System.in);

	static Grafo<?> grafo;
	
	
	public static void main(String [] args){
		
		grafo = new Grafo<>();
		
		try {
			readFile("grafo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    System.out.println(grafo);
		System.out.println(grafo.getVertices());
		System.out.println(grafo.findVerticeById(5));
	}
	
	/**
	 * Metodo que faz a leitura do arquivo
	 * */
	
	static void readFile(String filename) throws IOException {

			 Scanner reader = new Scanner(new FileReader(filename));
			
			 
			 String currentLine = reader.next();
			
			 boolean read1 = true;
			 boolean read2 = false;
			 		 
			 Vertice currentVertice;
			 
			  
			while(reader.hasNext())
			{
				
				 if(!reader.hasNext("arestas")&&read1){
					
				    currentLine = reader.next();
				   // System.out.println(currentLine);
			
				    currentVertice = new Vertice<>(Integer.parseInt(currentLine));
				    currentLine = reader.next();
				    currentVertice.setCoordenadaX(Double.parseDouble(currentLine));
					currentLine = reader.next();
					currentVertice.setCoordenadaY(Double.parseDouble(currentLine));
					
					//listaVertices.add(currentVertice);
					grafo.addVertice(currentVertice);
				
				}
				  if(reader.hasNext("arestas")){
					read1 = false;
					currentLine = reader.next();
					read2 = true;
						
				}
				else if(read2)
				{
					currentLine = reader.next();
				
					int o = Integer.parseInt(currentLine);
				
					currentLine = reader.next();
					int d = Integer.parseInt(currentLine);
					
					currentLine = reader.next();
					double custo = Double.parseDouble(currentLine);
					//currentAresta = new Aresta<>(custo, vertice1, vertice2);
					
					grafo.addAresta(o,d, custo);
					//listaArestas.add(currentAresta);
				
				}
				  
			}
			reader.close();
		}
}
