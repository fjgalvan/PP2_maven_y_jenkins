package modelo;

public class TableroSize 
{
	private int filas, columnas;
	
	public TableroSize(int filas, int column)
	{
		this.filas = filas;
		this.columnas = column;
	}
	
	public TableroSize(int valor) 
	{
		this.filas = this.columnas = valor; 
	}

	public boolean controlTamaño()						// seguir evaluando esta parte el tablero tiene qe seguir
	{													// una norma o unos valores predeterminados
		return (filas>25 && filas>35 && columnas>25 && columnas<40);
	}	
	
	public int getFilas() 
	{
		return filas;
	}

	public void setFilas(int filas) 
	{
		this.filas = filas;
	}

	public int getColumnas() 
	{
		return columnas;
	}

	public void setColumnas(int columnas) 
	{
		this.columnas = columnas;
	}
		
}
