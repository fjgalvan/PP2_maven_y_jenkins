package estructura;

import entorno.Entorno;
import modelo.Bala;
import modelo.Casilla;

//abstracto
public interface Estructura {
	
	public void colisionBala(Bala bala, Casilla casilla);
	public void destruir(Casilla casilla);
	public void dibujar(Entorno unEntorno, Casilla casilla);
}

