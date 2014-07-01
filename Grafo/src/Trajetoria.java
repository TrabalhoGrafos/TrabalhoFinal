import java.util.ArrayList;
import java.util.List;


public class Trajetoria {
	private int nParadas;
	private List<Vertice> paradasAbastecimento;
	private Veiculo veiculo;
	private List<Vertice> trajeto;
	
	public Trajetoria(Veiculo veiculo, List<Vertice> trajeto){
		this.nParadas = 0;
		this.paradasAbastecimento = new ArrayList<Vertice>();
		this.veiculo = veiculo;
		this.trajeto = trajeto;
	}
	
	private void doTrajeto(){
		for(int i = 0; i < (this.trajeto.size()-1); i++){
//			Vertice origem = thi
//			this.trajeto.get(i);
			//ALGORITMO
		}
		this.toString();
	}
	
	private void addParadas(int nParadas){
		this.nParadas += nParadas;
	}
	
	private void addParadaAbastecimento(Vertice v){
		this.paradasAbastecimento.add(v);
	}
	
	private double calculaConsumo(double distancia){
		double consumo = distancia/this.veiculo.getConsumo();
		return consumo;
	}
	
	public String toString(){
		return "";
	}
	
	
}
