package presentacion.controlador;

import entorno.Entorno;
import modelo.Bala;
import modelo.Tanque;
import sonido.Sonido;

public class Disparo{
//	private Util util;
	private Bala bala;
	private Tanque tanque;
	private Entorno entorno;
	
	public Disparo(Tanque tanque, Entorno entorno){
    	this.entorno = entorno;
		this.tanque = tanque;
	//	util = new Util();
	}

	boolean fuegoActivado= false;
	int contador=0;
	
	public boolean disparar(){//public void disparar(){
		if((this.bala == null)&& (contador==0)){
			Sonido.TanqueDisparo.play();
			contador +=1;
			this.bala = new Bala(this.entorno, tanque);
		}
		else{
			//El fuago estará activado si la bala está dentro de los limites permitidos "0<x<800"   "0<y<600"
			//fuegoActivado =util.controlarLimiteDeTablero(this.bala.getX(), this.bala.getY(), this.tanque.getAnguloOrientacion());
			fuegoActivado = controlFronteraBala();
			if(fuegoActivado && this.bala != null){
				fuegoActivado= movimiento(this.entorno);
			}
			else{
				contador=0;
			}
		}
		return fuegoActivado;
	}
	
	//estoy manejando pixeles, hay que cambiar por casillas
	boolean balaEnTrayecto= true;
	public boolean movimiento(Entorno ent){//public void movimiento(Entorno ent){
		/****/balaEnTrayecto= true;
		if((this.bala.getOrientacion() == 0)){//0º){//DERECHA
			this.bala.setX(this.bala.getX()+3);
		}else if(this.bala.getOrientacion() == Math.PI/2){//90º){//ABAJO
			this.bala.setY(this.bala.getY()+3);
		}else if(this.bala.getOrientacion() == Math.PI ){//180º){//IZQUIERDA
			this.bala.setX(this.bala.getX()-3);
		}else if(this.bala.getOrientacion() == Math.PI*1.5){//270º){ARRIBA
			this.bala.setY(this.bala.getY()-3);
		}
		try{
			this.bala.dibujar();
		}catch(Exception ex){	
		}
		return balaEnTrayecto;
	}
		
		public boolean controlFronteraBala(){
			if(this.bala!= null){
				if(this.bala.getY()>=560 || this.bala.getX()<=40 || this.bala.getY()<=40 || this.bala.getX()>=560){//OK
					this.bala= null;
					fuegoActivado=false;
					balaEnTrayecto= false;
					return false;
				}	
			}
			return true;
		}
		
		public boolean isBalaEnTrayecto() {
			return balaEnTrayecto;
		}

		public void setBalaEnTrayecto(boolean balaEnTrayecto) {
			this.balaEnTrayecto = balaEnTrayecto;
		}
}
