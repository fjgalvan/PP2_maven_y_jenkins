package modelo.objeto;

public class Tamaño 
{
	private double ancho, alto;
	
	public Tamaño(double ancho ,double alto)
	{
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public Tamaño()
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
