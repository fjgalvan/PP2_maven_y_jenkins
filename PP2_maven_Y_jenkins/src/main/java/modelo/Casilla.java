package modelo;

import modelo.objeto.Coordenada;

public class Casilla {

	private boolean estaVacia;
	private ObjetoGrafico objetoGrafico;
	private Coordenada coordenada;
	
	//ObjetoGrafico
	public Casilla()
	{
		this.estaVacia = true;		
	}
	
	public boolean isEstaVacia() 
	{
		return estaVacia;
	}

	public void setEstaVacia(boolean estaVacia) 
	{
		this.estaVacia = estaVacia;
	}

	public ObjetoGrafico getObjeto()
	{
		return objetoGrafico;
	}

	public void setObjetoGrafico(ObjetoGrafico objeto)
	{
		this.objetoGrafico = objeto;
	}
	
	public void liberarCasilla() 
	{
		this.setEstaVacia(true);
		this.setObjetoGrafico(null);		
	}

	public Coordenada getCoordenada() 
	{
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) 
	{
		this.coordenada = coordenada;
	}
}
