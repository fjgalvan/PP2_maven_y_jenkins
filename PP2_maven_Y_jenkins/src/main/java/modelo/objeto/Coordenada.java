package modelo.objeto;

public class Coordenada 
{
	private double x , y;
	
	public Coordenada(double coor_X,double coor_Y)
	{
		this.x = coor_X;
		this.y = coor_Y;
	}
	
	public Coordenada(){}
	
	// crear la regla que dice de que pixeles hay una coordenada valida
	
	
	public double getX() 
	{		
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
	}

	@Override
	public String toString() 
	{
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}	
	
}
