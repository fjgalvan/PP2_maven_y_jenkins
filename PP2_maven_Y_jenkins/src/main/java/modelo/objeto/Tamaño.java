package modelo.objeto;

public class Tama�o 
{
	private double ancho, alto;
	
	public Tama�o(double ancho ,double alto)
	{
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public Tama�o()
	{
		this.alto = 20;
		this.ancho = 20;
	}

	public double getAncho() 
	{
		return ancho;
	}

	public void setAncho(double ancho) 
	{
		this.ancho = ancho;
	}

	public double getAlto() 
	{
		return alto;
	}

	public void setAlto(double alto) 
	{
		this.alto = alto;
	}	
	
}
