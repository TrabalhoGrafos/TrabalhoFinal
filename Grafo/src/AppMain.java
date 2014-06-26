import java.io.*;
import java.util.*;


public class AppMain {

	static Scanner sc = new Scanner(System.in);
	private static BufferedReader br;
	static ArrayList<Vertice> listaVertices = new ArrayList<Vertice>();

	public static void main(String [] args){
		
		try {
			readFile("grafo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(listaVertices.size());
		
		    System.out.println(listaVertices);
	}
	
	/**
	 * Metodo que faz a leitura do arquivo
	 * */
	  static void readFile(String filename) throws IOException {

			 Reader fileReader = new FileReader(filename);
			 Scanner reader = new Scanner(fileReader);
			
			 String currentLine = reader.next();
			
			while(reader.hasNext()){
				
				currentLine = reader.next();
				
				Vertice<?> currentVertice = new Vertice<>();
				
				//System.out.println(currentLine);
			
				    int currentID = Integer.parseInt(currentLine);
				    currentLine = reader.next();
					double currentX = Double.parseDouble(currentLine);
					currentLine = reader.next();
					double currentY = Double.parseDouble(currentLine);
					
					currentVertice.setID(currentID);
					currentVertice.setCoordenadaX(currentX);
					currentVertice.setCoordenadaY(currentY);
					
					listaVertices.add(currentVertice);
				
				if(reader.hasNext("arestas")){
					currentLine = reader.next();
					break;
				
				}
			}	

			fileReader.close();
			reader.close();

		}
	
	
	
}
