import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contem os atributos e metodos da trajetoria do GPS
 * 
 * 
 */
public class Trajetoria {
	public static int LIMITE_DE_HORAS_DIRIGINDO = 3;
	private int nParadas;
	private List<Vertice> paradasAbastecimento;
	private Veiculo veiculo;
	private List<Vertice> trajeto;

	/**
	 * Construtor padrao
	 * 
	 * @param veiculo
	 * @param trajeto
	 */
	public Trajetoria(Veiculo veiculo, List<Vertice> trajeto) {
		this.nParadas = 0;
		this.paradasAbastecimento = new ArrayList<Vertice>();
		this.veiculo = veiculo;
		this.trajeto = trajeto;
		this.doTrajeto();
	}

	/**
	 * Conjunto de metodos que constroem a trajetoria do
	 * carro,paradas,abastecimento, etc
	 */
	private void doTrajeto() {
		for (int i = 0; i < (this.trajeto.size() - 1); i++) {
			Vertice origem = this.trajeto.get(i);
			Vertice destino = this.trajeto.get(i + 1);
			double distancia = Utils.calculaDistanciaEntreVertices(origem,
					destino);
			this.addParadas(calculaQuantidadeDeParadas(distancia));
			if (this.simulaCombustivelVeiculo(this.calculaConsumo(distancia)) <= 1) {
				this.addParadaAbastecimento(origem);
				this.veiculo.abastecer();
			}
			this.veiculo.percorreDistancia(distancia);
		}
	}

	private void addParadas(int nParadas) {
		this.nParadas += nParadas;
	}

	private void addParadaAbastecimento(Vertice v) {
		this.paradasAbastecimento.add(v);
	}

	private double simulaCombustivelVeiculo(double consumo) {
		return this.veiculo.getTanque() - consumo;
	}

	private double calculaConsumo(double distancia) {
		double consumo = distancia / this.veiculo.getConsumo();
		return consumo;
	}

	private int calculaQuantidadeDeParadas(double distancia) {
		double horas = distancia / this.veiculo.getVelocidadeMedia();
		return (int) horas / Trajetoria.LIMITE_DE_HORAS_DIRIGINDO;
	}

	public String toString() {
		String infos = "";
		infos += " Paradas para descanso: " + this.nParadas + "\n";
		infos += " Paradas para reabastecer (parada:vertice): ";
		String paradasBastecer = "";
		for (int i = 0; i < this.paradasAbastecimento.size(); i++) {
			if (i < (this.paradasAbastecimento.size() - 1)) {
				paradasBastecer += (i + 1) + ":"
						+ this.paradasAbastecimento.get(i).getID() + ", ";
			} else {
				paradasBastecer += (i + 1) + ":"
						+ this.paradasAbastecimento.get(i).getID();
			}
		}
		if (paradasBastecer.isEmpty()) {
			paradasBastecer = "0";
		}
		infos += paradasBastecer;
		return infos;
	}

}
