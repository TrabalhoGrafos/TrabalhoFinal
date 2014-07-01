
public class Veiculo {
	private double consumo;
	private double autonomia;
	private double velocidadeMedia;
	private double tanque;
	
	public Veiculo(){
		this.consumo = 15;
		this.autonomia = 600;
		this.setVelocidadeMedia(80);
		this.tanque = autonomia;
	}
	
	public Veiculo(double consumo,double autonomia,double velocidadeMedia){
		this.consumo = consumo;
		this.autonomia = autonomia;
		this.setVelocidadeMedia(velocidadeMedia);
		this.tanque = autonomia;
	}
	
	public void abastecer(){
		this.tanque = this.autonomia;
	}
	
	public void percorreDistancia(double distancia){
		this.tanque = tanque - (distancia/this.consumo);
	}

	public double getConsumo() {
		return consumo;
	}

	public double getAutonomia() {
		return autonomia;
	}
	
	public double getTanque(){
		return this.tanque;
	}

	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
}
