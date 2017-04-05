package modelo.objeto;

public class Posicion 
{
	private int casillaI, casillaJ;

	public Posicion(int i, int j)
	{
		this.casillaI = i;
		this.casillaJ = j;
	}
	
	public int getCasillaI() 
	{		
		return casillaI;
	}

	public void setCasillaI(int casillaI) 
	{
		this.casillaI = casillaI;
	}

	public int getCasillaJ() 
	{
		return casillaJ;
	}

	public void setCasillaJ(int casillaJ) 
	{
		this.casillaJ = casillaJ;
	}

	@Override
	public String toString() 
	{
		return "Posicion [casillaI=" + casillaI + ", casillaJ=" + casillaJ + "]";
	}
	
}