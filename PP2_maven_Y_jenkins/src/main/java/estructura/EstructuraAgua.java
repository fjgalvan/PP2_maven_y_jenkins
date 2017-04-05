package estructura;

import modelo.Bala;
import modelo.Casilla;
import modelo.ObjetoGrafico;
import modelo.objeto.Coordenada;
import modelo.objeto.Imagen;

import java.awt.Color;

import entorno.Entorno;

public class EstructuraAgua extends ObjetoGrafico implements Estructura {
	

	public EstructuraAgua()
	{
		//this.imagen = new Imagen("/PP2/src/imagen/agua.png");
		System.out.println("me construi , estructura agua");
	}
	
	
	public void colisionBala(){
		
	}

	@Override
	public void colisionBala(Bala bala, Casilla casilla) 
	{
		// no hace nada
		
	}

	@Override
	public void destruir(Casilla casilla) 
	{
		
		
	}

	@Override
	public void dibujar(Entorno unEntorno, Casilla casilla) {
		//unEntorno.dibujarRectangulo(casilla.x, casilla.y, 20, 20, 0, Color.BLUE);
		
	}

	@Override
	public void dibujar(Entorno ent, Coordenada c) {
		// TODO Auto-generated method stub
		ent.dibujarRectangulo(c.getX(), c.getY(), 20, 20, 0, Color.BLUE);
	}
}

