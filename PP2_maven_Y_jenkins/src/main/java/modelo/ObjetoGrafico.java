package modelo;

import java.awt.Color;

import entorno.Entorno;
import modelo.objeto.*;

public abstract class ObjetoGrafico {
	
	protected Posicion posicion;
	protected Tama�o tama�o;
	protected Imagen imagen;
	
	public ObjetoGrafico()
	{

	}
	//public abstract void dibujar(Entorno ent);

	public abstract void dibujar(Entorno ent, Coordenada c);
	
	public Posicion getPosicion() 
	{
		return posicion;
	}

	public void setPosicion(Posicion posicion) 
	{
		this.posicion = posicion;
	}

	public Imagen getImagen() 
	{
		return imagen;
	}

	public void setImagen(Imagen imagen) 
	{
		this.imagen = imagen;
	}	
	
	public Tama�o getTama�o()
	{
		return this.tama�o;
	}
	
	public void setTama�o(Tama�o t)
	{
		this.tama�o = t ;
	}
	
}