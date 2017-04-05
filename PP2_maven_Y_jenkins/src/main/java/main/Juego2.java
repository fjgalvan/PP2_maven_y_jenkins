package main;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import modelo.Bala;
import modelo.Disparo;
import modelo.TableroGrafico;
import modelo.TableroSize;
import modelo.Tanque;
import sonido.Sonido;
import util.Util;

public class Juego2 extends InterfaceJuego {
    private Entorno entorno;
    private Tanque tanque;
    private Util util;
    private Disparo disparo;
    private int ANCHO_ENTORNO = 800;
    private int ALTO_ENTORNO = 600;
	private Image fondo = Herramientas.cargarImagen("imagen/fondo.jpg");
    private boolean controlTick = true;
    private Bala bala;
    private boolean tiro=false;
    private TableroGrafico tablero;
	
	public Juego2() {
    	this.entorno = new Entorno(this, "Battle-City", ANCHO_ENTORNO, ALTO_ENTORNO);
		this.tanque = new Tanque(400, 400, 0);
		this.disparo = new Disparo(tanque, entorno);
		
		this.tablero = new TableroGrafico(new TableroSize(26));
    	tablero.calcularPosicionesCasillas();
    	tablero.generarEscenarioAleatorio();
    	tablero.dibujar(entorno);
	}
	

    public void tick() {

		
    	//tablero.dibujar(entorno);    	
//    	if (!esElFin()) {
//        	this.entorno.dibujarRectangulo(300,300, 520, 520, 0, Color.gray);
//        	//this.entorno.dibujarRectangulo(300,300, 500, 500, 0, Color.black);
//        	this.entorno.dibujarImagen(fondo, 300, 300, 0);
//        	
//    		manejoTanque();
//    		
//    		//manejo_disparo();
//    		
//    	}
//    	else{
//            String mensaje;
//            mensaje = "Termino el Juego";
//            this.entorno.cambiarFont("Arial", 28, Color.yellow);
//            this.entorno.escribirTexto(mensaje, 300, 290);
//    	}
    	
    	
    	
    }

    private void manejoTanque(){
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

//	private void manejo_tanque() {
//		
//		if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.tanque.getAnguloOrientacion() == 0){
//			this.tanque.avanzarDerecha();
//		}
//		if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.tanque.getAnguloOrientacion()!=0){
//			this.tanque.girar_Derecha();
//		}
//		//ARRIBA
//		if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA) && this.tanque.getAnguloOrientacion()==Math.PI*1.5){
//			this.tanque.avanzarArriba();
//		}
//		if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA) && this.tanque.getAnguloOrientacion()!=Math.PI*1.5){
//			this.tanque.girar_Arriba();
//		}
//		//IZQUIERDA
//		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.tanque.getAnguloOrientacion()==Math.PI){
//			this.tanque.avanzarIzquierda();
//		}
//		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.tanque.getAnguloOrientacion()!=Math.PI){
//			this.tanque.girar_Izquierda();
//		}
//		//ABAJO
//		if(this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.tanque.getAnguloOrientacion()==Math.PI/2){
//			this.tanque.avanzarAbajo();
//		}
//		if(this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.tanque.getAnguloOrientacion()!=Math.PI/2){
//			this.tanque.girar_Abajo();
//		}
//    	this.tanque.dibujar(this.entorno);
//		
//	}
//
//    private void manejo_disparo() {
//    	if(this.entorno.estaPresionada(this.entorno.TECLA_ENTER)){
//    		if(this.disparo.getBala() == null){
//    			Sonido.TanqueDisparo.play();
//    			this.disparo.setBala(new Bala(this.entorno, this.tanque.getX(),this.tanque.getY(), this.tanque.getAnguloOrientacion()));
//    		}
//    		if(util.controlarLimiteDeTablero(this.tanque.getX(), this.tanque.getY(), this.tanque.getAnguloOrientacion())){
//    			this.disparo.movimiento(this.entorno);
//    		}
//		}
//	}

	//cuando termina eñ juego
	private boolean esElFin() {
		return false;
	}
}
