import java.io.*;
import java.util.*;


public class AppMain {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Vertice<?>> listaVertices = new ArrayList<Vertice<?>>();
	static ArrayList<Aresta> listaArestas = new ArrayList<Aresta>();
	public static void main(String [] args){
		
		try {
			readFile("grafo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(listaVertices.size());
		
		System.out.println(listaVertices);
		
        System.out.println(listaArestas.size());
		
		System.out.println(listaArestas);
	}
	
	/**
	 * Metodo que faz a leitura do arquivo
	 * */
	  static void readFile(String filename) throws IOException {

			 Reader fileReader = new FileReader(filename);
			 Scanner reader = new Scanner(fileReader);
			
			 String currentLine = reader.next();
			
			 boolean read1 = true;
			 boolean read2 = false;
			
			while(reader.hasNext())
			{
				Aresta currentAresta = new Aresta();
				
				 if(!reader.hasNext("arestas")&&read1){
					Vertice<?> currentVertice = new Vertice<>();
				    currentLine = reader.next();
				    System.out.println(currentLine);
			
				    currentVertice.setID(Integer.parseInt(currentLine));
				    currentLine = reader.next();
				    currentVertice.setCoordenadaX(Double.parseDouble(currentLine));
					currentLine = reader.next();
					currentVertice.setCoordenadaY(Double.parseDouble(currentLine));
					
					listaVertices.add(currentVertice);
				
				}
				  if(reader.hasNext("arestas")){
					read1 = false;
					currentLine = reader.next();
					read2 = true;
						
				}
				else if(read2)
				{
					currentLine = reader.next();
					Vertice<?> vertice1 = new Vertice<>();
					Vertice<?> vertice2 = new Vertice<>();
					
					vertice1.setID(Integer.parseInt(currentLine));
					currentAresta.origem = vertice1;
					currentLine = reader.next();
					vertice2.setID(Integer.parseInt(currentLine));
					currentAresta.destino = vertice2;
					currentLine = reader.next();
					currentAresta.setCusto(Double.parseDouble(currentLine));
					
					listaArestas.add(currentAresta);
					
				}		
			}	

			fileReader.close();
			reader.close();
		}
}
