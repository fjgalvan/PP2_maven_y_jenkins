package modelo;

import entorno.Entorno;
import estructura.*;
import modelo.objeto.*;

public class TableroGrafico {
//codificar a pixeles
	//imagen
	//[][]
private Tablero tablero;
	
	public TableroGrafico(TableroSize t)
	{
		this.tablero = new Tablero(t);
	}
	
	public void calcularPosicionesCasillas()
	{
		int valorX = 40;
		int valorY = 40;
		Coordenada coor = new Coordenada();
		for(int fila=0;fila<tablero.getSize().getFilas();fila++)
		{
			for(int colum=0;colum<tablero.getSize().getColumnas();colum++){
				coor.setX(valorX);
				coor.setY(valorY);
				Posicion p = new Posicion(fila, colum);
				tablero.getCasilla(p).setCoordenada(coor);
			//	System.out.println("contruyendo " +coor);
				valorY = valorY + 20;
			}
			valorY = 40;
			valorX = valorX + 20;
		}		
	}
	
	public void generarEscenarioAleatorio()
	{
		this.agregarEstructura(new EstructuraAgua(), 5);
		this.agregarEstructura(new EstructuraAcero(), 5);
		this.agregarEstructura(new EstructuraLadrillo(), 5);
	}	
	
	public void agregarEstructura(Estructura e, int cantidad)
	{	
		Casilla casilla = null;
		int i = 0;
		while(i < cantidad)
		{
			casilla = tablero.obtenerCasillaAleatoria();
			if(casilla.isEstaVacia()){
				casilla.setObjetoGrafico((ObjetoGrafico) e);
				//System.out.println(casilla.getCoordenada()+" "+casilla.getObjeto().getPosicion());
				i++;
			}
			System.out.println("estoy ciclando en el while de estructura");
		}
		System.out.println("termine con las estructuras");
	}
	
	public ObjetoGrafico getObjetoEnTablero(Posicion posicion)	
	{
		return tablero.getCasilla(posicion).getObjeto();
	}
		
	public static void main(String[] args) 
	{
		TableroGrafico t = new TableroGrafico(null);
		t.calcularPosicionesCasillas();
	}

	public void dibujar(Entorno ent) 
	{
		for (int i = 0; i < tablero.getSize().getFilas(); i++) 
		{
			for (int j = 0; j < tablero.getSize().getColumnas(); j++) {
				Posicion p = new Posicion(i, j);
				//System.out.println(p);
				//System.out.println(tablero.getCasilla(p).getCoordenada());
				ObjetoGrafico obj = tablero.getCasilla(p).getObjeto();
				if(obj!=null){
					System.out.println(p);
					obj.dibujar(ent,tablero.getCasilla(p).getCoordenada());
					System.out.println(tablero.getCasilla(p).getCoordenada() +" "+tablero.getCasilla(p).getObjeto().getPosicion());
				}	
			}
		}		
	}

}
