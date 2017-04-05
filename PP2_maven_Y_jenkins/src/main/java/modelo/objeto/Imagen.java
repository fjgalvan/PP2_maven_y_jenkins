package modelo.objeto;

import java.awt.Image;

import entorno.Herramientas;

public class Imagen 
{
	private String rutaImg;
	private Image imagen;
	
	public Imagen(String ruta)
	{
		this.rutaImg = ruta;
		this.imagen = Herramientas.cargarImagen(rutaImg);
	}

	public Imagen(){}
	
	public String getRutaImg() 
	{
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) 
	{
		this.rutaImg = rutaImg;
	}

	public Image getImagen() 
	{
		return imagen;
	}

	public void setImagen(Image imagen) 
	{
		this.imagen = imagen;
	}	
	
}
