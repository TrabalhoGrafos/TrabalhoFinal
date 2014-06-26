
public class Vertice<T extends Comparable<T>>{

	private int ID;
	private double coordenadaX = 0;
	private double coordenadaY = 0;
	private boolean visitado = false;
	
	public int getID() {
		return ID;
	}
	public void setID(final int iD) {
		ID = iD;
	}
	public double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	public String toString(){
		return this.ID+" "+this.coordenadaX+" "+this.coordenadaY+"\n";
	}

	
}
