import java.util.*;

public abstract class Utils {

	public static double calculaDistanciaEntreVertices(Vertice v1, Vertice v2) {
		double d, a, b;
		a = Math.pow((v1.getCoordenadaX() - v2.getCoordenadaX()), 2);
		b = Math.pow((v1.getCoordenadaY() - v2.getCoordenadaY()), 2);
		d = Math.sqrt(a + b);
		return d;
	}

	public static void dijkstra(Grafo g, int ref) {
		
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
}
