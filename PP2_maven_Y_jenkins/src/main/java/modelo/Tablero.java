package modelo;

import java.util.Random;

import modelo.objeto.Posicion;

public class Tablero {
	private Casilla [][] casillas;
	private TableroSize size;
	
	public Tablero(TableroSize size){
		this.setSize(size);
		this.casillas = new Casilla[size.getFilas()][size.getColumnas()];
		inicializar();
	}
	
	public Tablero() 
	{
		// TODO Auto-generated constructor stub
	}

	private void inicializar() {
		for(int fila = 0; fila < size.getFilas(); fila++)
		{
			for(int colum = 0; colum < size.getColumnas();colum++){
				casillas [fila] [colum] = new Casilla (); 
			}
		}
	}
	
	public boolean estaOcupada(int i, int j)
	{
		return casillas[i][j].isEstaVacia();
	}
	
	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public TableroSize getSize() {
		return size;
	}

	public void setSize(TableroSize size) {
		this.size = size;
	}

	public Casilla getCasilla(Posicion posicion) 
	{
		return casillas[posicion.getCasillaI()][posicion.getCasillaJ()];
	}
	
	public Casilla obtenerCasillaAleatoria()
	{
		Random aleatorio = new Random();
		int i = aleatorio.nextInt(size.getFilas());
		int j = aleatorio.nextInt(size.getColumnas());
		return getCasilla(new Posicion(i,j));
	}
	
}
