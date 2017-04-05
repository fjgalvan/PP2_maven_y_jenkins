package estructura;

import java.awt.Color;

import entorno.Entorno;
import modelo.Bala;
import modelo.Casilla;
import modelo.ObjetoGrafico;
import modelo.objeto.Coordenada;
import modelo.objeto.Imagen;

public class EstructuraLadrillo extends ObjetoGrafico implements Estructura{
		
	
	public EstructuraLadrillo()
	{
		//this.imagen = new Imagen("agua.png");
		System.out.println("me construi estructura ladrillo");
	}
		
	@Override
	public void colisionBala(Bala bala, Casilla casilla) {
		//bala.destruir();
		this.destruir(casilla);
	}

	@Override
	public void destruir(Casilla casilla) {
		casilla.liberarCasilla();
	}

	@Override
	public void dibujar(Entorno unEntorno, Casilla casilla) {
		//unEntorno.dibujarRectangulo(casilla.x, Casilla.y, 20, 20, 0, Color.RED);
		
	}

	@Override
	public void dibujar(Entorno ent, Coordenada c) {
		// TODO Auto-generated method stub
		ent.dibujarRectangulo(c.getX(), c.getY(), 20, 20, 0, Color.YELLOW);
	}
	
}
