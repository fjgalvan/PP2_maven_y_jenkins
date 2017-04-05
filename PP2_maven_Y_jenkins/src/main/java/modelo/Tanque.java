package modelo;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Tanque {
	
	private double x;
	private double y;
	private double anguloOrientacion= 0; // (0º=0*Math.PI), (90º=Math.PI/2), (180º=Math.PI) ó (270º=Math.PI*1.5)
	private Image imagen_tanque;
	
	double avanceDeCasillero=2;//debería avanzar 20 pixeles (1 casillero)
	//private Bala bala;
	//private Disparo disparo;
	//Construcor
	public Tanque(double unX, double unY, double unAnguloOrientacion){
		this.x= unX;
		this.y= unY;
		this.anguloOrientacion= unAnguloOrientacion;
		
		this.imagen_tanque= Herramientas.cargarImagen("imagen/tanqueDerecha.png");
	}
	
	
	/****** cambiarOrientacion-inicio ******/
	
	//Si se presiona la tecla 'derecha' una sola vez y si el Tanque NO estaba 
	//orientado hacia la 'izquierda'
	public void girar_Derecha(){
		this.anguloOrientacion =0;//0º
		//modificarFrenteTanque();
		//this.x += 1;
	}
	
	//Si se presiona la tecla 'izquierda' una sola vez y si el Tanque NO estaba 
	//orientado hacia la 'izquierda'
	public void girar_Izquierda(){
		this.anguloOrientacion = Math.PI;//180º;
	}
	
	public void girar_Arriba(){
		this.anguloOrientacion = Math.PI*1.5;//270º;
	}
	
	public void girar_Abajo(){
		this.anguloOrientacion = Math.PI/2;//90º
	}
	
	//Da la vuelta el tanque
	public void girar_180(){
		this.anguloOrientacion +=180;
		modificarFrenteTanque();
	}
	
	//Gira el tanque con el nuevo "anguloOrientación"
	public void modificarFrenteTanque(){
		this.x += Math.cos(anguloOrientacion);
		this.y += Math.sin(anguloOrientacion);
	}
	
	/******* cambiarOrientacion-fin *******/
	
	
	
	/****** movimientos-inicio ******/
	
	public void avanzarDerecha(){
		this.x += avanceDeCasillero;
	}
	
	public void avanzarIzquierda(){
		this.x -= avanceDeCasillero;
	}
	
	public void avanzarArriba(){
		this.y -= avanceDeCasillero;
	}
	
	public void avanzarAbajo(){
		this.y += avanceDeCasillero;
	}
	
	public void controlAvance(Entorno ent){
		controlFronteraTanque();
		//DERECHA
		if(ent.estaPresionada(ent.TECLA_DERECHA) && anguloOrientacion==0){
			avanzarDerecha();
		}
		if(ent.estaPresionada(ent.TECLA_DERECHA) && anguloOrientacion!=0){
			girar_Derecha();
		}
		
		//ARRIBA
		if(ent.estaPresionada(ent.TECLA_ARRIBA) && anguloOrientacion==Math.PI*1.5){
			avanzarArriba();
		}
		if(ent.estaPresionada(ent.TECLA_ARRIBA) && anguloOrientacion!=Math.PI*1.5){
			girar_Arriba();
		}
		
		//IZQUIERDA
		if(ent.estaPresionada(ent.TECLA_IZQUIERDA) && anguloOrientacion==Math.PI){
			avanzarIzquierda();
		}
		if(ent.estaPresionada(ent.TECLA_IZQUIERDA) && anguloOrientacion!=Math.PI){
			girar_Izquierda();
		}
		
		//ABAJO
		if(ent.estaPresionada(ent.TECLA_ABAJO) && anguloOrientacion==Math.PI/2){
			avanzarAbajo();
		}
		if(ent.estaPresionada(ent.TECLA_ABAJO) && anguloOrientacion!=Math.PI/2){
			girar_Abajo();
		}
		
		controlFronteraTanque();
	}
	
	/****** movimientos-fin ******/
	int contador=0;
	boolean fuego= false;
	public boolean controlDisparo(Entorno ent){
		if(ent.estaPresionada(ent.TECLA_ENTER)){
			fuego= true;
			contador +=1;
		}
		/*if((fuego == true) && (contador == 1)){
			disparo(ent);
			contador +=1;
			System.out.println("Presiono la tecla Enter!");
		}*/
		return fuego;
	}
	
	//disparo la bala segun el "anguloOrientacion" actual
	/*public void disparo(Entorno ent){
		this.tanque =new Tanque(this.x, this.y, this.anguloOrientacion); 
		this.disparo= new Disparo(this.tanque, ent);
		this.disparo.disparar();//this.disparo.disparar(tanque);
	}*/
	
	
	
	//AutoDestruccion
	public void autoDestruccion(){
		
	}
	
	private void controlFronteraTanque(){
		if(this.y <= 700 && this.y >= 560){//OK
			this.y = 560;
		}
		if(this.x<=40 && this.x>=-100){//OK
			this.x=40;
		}
		if(this.y<=40 && this.y>=-100){//OK
			this.y=40;
		}
		if(this.x<=900 && this.x>=560){//OK
			this.x=561;
		}	
	}
	
	public double getAnguloOrientacion() {
		return anguloOrientacion;
	}


	public void setAnguloOrientacion(double anguloOrientacion) {
		this.anguloOrientacion = anguloOrientacion;
	}


	public double getX() {
		return this.x;
	}


	public double getY() {
		return this.y;
	}


	public void Dibujar(Entorno ent,boolean bala){
		ent.dibujarImagen(this.imagen_tanque,this.x, this.y,this.anguloOrientacion,0.1);
	}
	
}

