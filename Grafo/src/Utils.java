
public class Utils {
	public static double calculaDistanciaEntreVertices( Vertice<?> v1,  Vertice<?> v2){
		double d,a,b;
		a = Math.pow((v1.getCoordenadaX() - v2.getCoordenadaX()), 2);
		b = Math.pow((v1.getCoordenadaY() - v2.getCoordenadaY()), 2);
		d = Math.sqrt(a+b);
		return d;
	}
}
