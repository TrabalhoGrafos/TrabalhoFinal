import java.io.*;
import java.util.*;

/**
 * Classe principal do trabalho sobre grafos do prof. Rafael Jeffman
 * 
 * 
 * @authors Dennis Kaffer, Lucas Gutier, Vanderson Nunes, ***
 * */

public class AppMain {

	static Scanner sc = new Scanner(System.in);

	static Grafo grafo;

	public static void main(String[] args) {
		grafo = new Grafo();
		prepararFile();
		
		int origem = 49;
		int destino = 9;
		
		dijkstra(origem, destino);
	
		caixeiroViajante(9);
		System.out.println("\n");
		trajetoria(origem, destino);
		
		
	}
	
	/**
	 * Metodo que contem o caminho do arquivo de texto
	 */
	static void prepararFile(){
		try {
			readFile("grafo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que faz a leitura do arquivo
	 * 
	 * @param filename-
	 * 		nome do arquivo onde contem as informacoes para construcao do grafo
	 * */

	static void readFile(String filename) throws IOException {

		Scanner reader = new Scanner(new FileReader(filename));

		String currentLine = reader.next();

		boolean read1 = true;
		boolean read2 = false;

		Vertice currentVertice;

		while (reader.hasNext()) {

			if (!reader.hasNext("arestas") && read1) {

				currentLine = reader.next();
			
				currentVertice = new Vertice(Integer.parseInt(currentLine));
				currentLine = reader.next();
				currentVertice.setCoordenadaX(Double.parseDouble(currentLine));
				currentLine = reader.next();
				currentVertice.setCoordenadaY(Double.parseDouble(currentLine));

				grafo.addVertice(currentVertice);

			}
			if (reader.hasNext("arestas")) {
				read1 = false;
				currentLine = reader.next();
				read2 = true;

			} else if (read2) {
				currentLine = reader.next();

				int o = Integer.parseInt(currentLine);

				currentLine = reader.next();
				int d = Integer.parseInt(currentLine);

				currentLine = reader.next();
				double custo = Double.parseDouble(currentLine);

				grafo.addAresta(o, d, custo);

			}
		}
		reader.close();
	}
	
	/**
	 * Metodo que executa o algoritmo Dijkstra
	 * @param origem
	 * @param destino
	 */
	static void dijkstra(int origem, int destino){
		System.out.println("\nDijkstra");
		Utils.dijkstra(grafo, origem);
		Utils.printMenorCaminho(grafo, destino);
	}
	
	/**
	 * Metodo que executa o caixeiro viajante
	 * @param origem
	 */
	static void caixeiroViajante(int origem){
		Utils.DFS(grafo, origem);
	}
	
	/**
	 * Metodo que imprime a distancia entre dois pontos
	 * @param origem
	 * @param destino
	 */
	static void printDistanciaEntrePontos(int origem, int destino){
		Vertice v1 = grafo.getVertice(origem);
		Vertice v2 = grafo.getVertice(destino);
		System.out.print("Distancia entre "+origem+"(Origem) e "+destino+"(Destino): "+Utils.calculaDistanciaEntreVertices(v1, v2));
	}
	
	/**
	 * Metodo que insere a trajetoria a ser percorrida pelo GPS
	 * @param origem
	 * @param destino
	 */
	static void trajetoria(int origem, int destino){
		Veiculo veiculo = new Veiculo();
		Utils.dijkstra(grafo, origem);
		Vertice vDestinto = grafo.getVertice(destino);
		List<Vertice> trajeto = Utils.getMenorCaminho(vDestinto);
		Trajetoria trajetoria = new Trajetoria(veiculo, trajeto);
		System.out.println("Vertices: "+trajeto.size());
		System.out.println(trajetoria);
	} 

}
