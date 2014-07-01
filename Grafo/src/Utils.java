import java.util.*;

/**
 * Classe que contem os metodos especiais do GPS
 * 
 * 
 */
public abstract class Utils {

	private static boolean go = true;
	private static boolean back = true;

	public static double calculaDistanciaEntreVertices(Vertice v1, Vertice v2) {
		double d, a, b;
		a = Math.pow((v1.getCoordenadaX() - v2.getCoordenadaX()), 2);
		b = Math.pow((v1.getCoordenadaY() - v2.getCoordenadaY()), 2);
		d = Math.sqrt(a + b);
		return d;
	}

	/**
	 * Algoritmo dijkstra
	 * 
	 * @param g
	 * @param ref
	 */
	public static void dijkstra(Grafo g, int ref) {
		// renovacao de status
		g.clearVertices();
		g.clearArestas();
		// entra referencia, e eh feita a pesquisa no grafo
		Vertice i = g.getVertice(ref);
		// muda a distancia de infinito para zero do vertice
		i.setDistancia(0);
		PriorityQueue<Vertice> q = new PriorityQueue<>();
		// adiciona o vertice atual
		q.add(i);

		while (!q.isEmpty()) {
			// atribui o head da fila ao vertice ev
			Vertice ev = q.poll();

			for (Aresta a : ev.getArestas()) {
				Vertice v = a.getDestino();
				double custo = a.getCusto();
				double distanciaPorEV = ev.getDistancia() + custo;

				if (distanciaPorEV < v.getDistancia()) {
					q.remove(v);
					v.setDistancia(distanciaPorEV);
					ev.visitar();
					v.setPai(ev);
					q.add(v);
				}
			}
		}
	}

	/**
	 * Menor caminho entre dois pontos
	 * 
	 * @param alvo
	 * @return
	 */
	public static List<Vertice> getMenorCaminho(Vertice alvo) {
		List<Vertice> caminho = new ArrayList<Vertice>();
		for (Vertice v = alvo; v != null; v = v.getPai()) {
			caminho.add(v);
		}
		// reverte o caminho para ter a ordem certa...
		List<Vertice> caminhoInvertido = new ArrayList<Vertice>();
		for (int i = caminho.size() - 1; i >= 0; i--) {
			caminhoInvertido.add(caminho.get(i));
		}

		return caminhoInvertido;
	}

	public static void printMenorCaminho(Grafo g, int ref) {
		Vertice v = g.getVertice(ref);
		List<Vertice> caminho = getMenorCaminho(v);
		System.out.println("Caminho: " + caminho);
	}

	/**
	 * Metodo de DFS modificado para resolver o problema do caixeiro viajante,
	 * eh feita uma verificacao nas arestas do vertice de entrada, se a aresta
	 * nao foi visitada o vertice destino no qual a aresta possui eh instanciado
	 * na recursividade, este ciclo continua ate que ultima aresta seja
	 * visitada.
	 * 
	 * @param g
	 *            - o grafo no qual eh feita a busca pelo vertice
	 * @param ref
	 *            - entrada de um inteiro que eh a referencia para pesquisa pelo
	 *            vertice no grafo
	 * */

	public static void DFS(Grafo g, int ref) {
		// renovacao de status
		g.clearVertices();
		g.clearArestas();

		Vertice v = g.getVertice(ref);
		System.out.println("\nCaixeiro Viajante com DFS");
		System.out.print("START V:" + v.getID());
		v.visitar();
		recDFS(v);
	}

	public static void recDFS(Vertice v) {

		for (Aresta a : v.getArestas()) {
			// checa se a aresta do v entrada ja foi visitada
			if (!a.checkVisitado()) {
				// tmp == vertice de destino
				Vertice tmp = a.getDestino();
				if (!tmp.checkVisitado()) {
					a.visitar();
					tmp.visitar();
					if (go) {
						System.out.println();
						go = false;
					}
					System.out.print("-> GO A:" + a.getCusto() + " V: "
							+ tmp.getID());
					// System.out.print("segue: " +tmp.getID());
					back = true;
					// invoca recursividade
					recDFS(tmp);

					if (back) {
						System.out.println();
						back = false;
					}
					// System.out.print("volta: " +v.getID());
					System.out.print("-> BACK A:" + a.getCusto() + " V:"
							+ v.getID());
					go = true;
				}
			}
		}
	}
}
