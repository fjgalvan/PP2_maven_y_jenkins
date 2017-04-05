package modelo;

//import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Bala {
	private Entorno entorno;
	private double x;
	private double y;
    private double velocidad = 3;
    private double orientacion;
	
	public Bala (Entorno entorno, Tanque tanque){
		this.entorno = entorno;
		this.x = tanque.getX();
		this.y = tanque.getY();
		this.orientacion = tanque.getAnguloOrientacion();
	}

	 public void avanzarArriba() {
		 if (this.y > 0)
			 this.y -= this.velocidad;
	 }
	 
	 public void avanzarAbajo() {
		 if (this.y > 0)
			 this.y += this.velocidad;
	 }
	
	public void avanzarDerecha() {
		if (this.x > 0)
			this.x += this.velocidad;
	}
	
	public void avanzarIzquierda() {
		 if (this.x > 0)
			 this.x -= this.velocidad;
	}
	
	public void dibujar() {
		 this.entorno.dibujarImagen(Herramientas.cargarImagen("imagen/bala00Derecha.png"), this.x, this.y, 0);
	}
	
	public double getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(double orientacion) {
		this.orientacion = orientacion;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
}
