package test;



import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import modelo.Bala;
import modelo.Tanque;
import presentacion.controlador.Disparo;

public class Test_Tanque extends InterfaceJuego{
    private Entorno entorno;
    private Tanque tanque;
    
    private Disparo disparo;
    
    private int ANCHO_ENTORNO = 800;
    private int ALTO_ENTORNO = 600;
    
    private Image fondo;
    
    //private boolean permiso= false;
    private Bala bala;
    boolean tiro=false;
  
    
    public Test_Tanque(){
    	this.fondo=Herramientas.cargarImagen("imagen/fondoTablero.jpg");
    	this.entorno = new Entorno(this, "Battle-City", ANCHO_ENTORNO, ALTO_ENTORNO);
    	this.tanque = new Tanque(400, 300, 0);
    	
    	this.disparo = new Disparo(tanque,entorno);
    	
    	//this.fondo=Herramientas.cargarImagen("imagen/fondoTablero.jpg");
    }
    
    boolean controlTick = true;
    public void tick(){
    	try{
    	this.entorno.dibujarImagen(this.fondo, entorno.getWidth()/2,entorno.getHeight()/2, 0, 0.5);
    	}catch(Exception ex){
    	}
    	
    	try{
    	this.tanque.Dibujar(this.entorno, true);
    	}catch(Exception ex){
    	}
    	
		try{
		this.tanque.controlAvance(this.entorno);
		}catch(Exception ex){
		}
		
		//SI PRESIONO LA TECLA ENTER Y LA BALA NO ESTA CREADA, SE CREA LA BALA Y SE PONE tiro= true;
		if(this.entorno.estaPresionada(this.entorno.TECLA_ENTER) && bala == null ){
			//System.out.println("presiono Enter");
			this.bala=new Bala(this.entorno,this.tanque);				
			tiro=true;
			//System.out.println("tiro Enter: "+tiro);
		}
		
		//SI SE PRESIONO LA TECLA ENTER Y SE CREÓ LA BALA Y LA BALA ESTA DENTRO DE LOS RANGOS (0<X<800) y  (0<Y<600)
		//PONEMOS EN MOVIMIENTO LA BALA
		if((tiro==true) && (this.disparo.controlFronteraBala()==true) ){
			if(this.bala!=null){//la bala está en trayectoria
				this.disparo.disparar();
				if(this.disparo.isBalaEnTrayecto() == true){
					if((this.disparo.disparar() == true) && (this.disparo.isBalaEnTrayecto() == true ))
					System.out.println();//System.out.println("tiro: "+tiro);
				}
				else{
					this.bala= null;
					tiro= false;
					//System.out.println("bala null");
				}
			}
			else{
				tiro= false;
				//System.out.println("tiro: "+tiro);
				this.bala= null;
			}
		}
		else{
			tiro= false;
			this.bala= null;
			//System.out.println("tiro: "+ tiro);
			//System.out.println("frontera: "+this.disparo.controlFronteraBala());
			//System.out.println("bala corte: "+bala);
		}
		if(this.bala == null){
			tiro=false;
		}
		
    }

	@SuppressWarnings("unused")
    public static void main(String[] args) {
    	Test_Tanque test = new Test_Tanque();
    }
}
