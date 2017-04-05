package modelo;

//import util.Util;

import entorno.Entorno;
import sonido.Sonido;


public class Disparo{
	//private Util util;
	private Bala bala;
	private Tanque tanque;
	private Entorno entorno;

	
	public Disparo(Tanque tanque, Entorno entorno){
    	this.entorno = entorno;
		this.tanque = tanque;
		//util = new Util();
	}
//ESTE DISPARO ES VIEJO; NO SE PORQUE SE BORRO EL OTRO; HOY AL MEDIODIA SUBO EL OTRO
	

	//controlaLaOrientacionEnLa que se encuentra el tanque
	//esa orientacion se la pasa a ControlarLimiteDeTablero, que controla si se puede disparar en esa direccion
	//despues sale el disparo
	boolean fuegoActivado= false;
	int contador=0;
	public boolean disparar(){//public void disparar(){
		if((this.bala == null)&& (contador==0)){
			contador +=1;
			//System.out.println("se creo la bala");
			Sonido.TanqueDisparo.play();
			this.bala = new Bala(this.entorno, tanque);
		}
		else{
			//El fuago estará activado si la bala está dentro de los limites permitidos "0<x<800"   "0<y<600"
			//fuegoActivado =util.controlarLimiteDeTablero(this.bala.getX(), this.bala.getY(), this.tanque.getAnguloOrientacion());
			fuegoActivado= controlFronteraBala();
			if(fuegoActivado){
				fuegoActivado= movimiento(this.entorno);
				//System.out.println("movimiento1");
			}
			else{
				contador=0;
			}
			//System.out.println("fuegoActivado: "+fuegoActivado);
		}
		return fuegoActivado;
	}
	
	//estoy manejando pixeles, hay que cambiar por casillas
	boolean balaEnTrayecto= true;
	public boolean movimiento(Entorno ent){//public void movimiento(Entorno ent){
		/****/balaEnTrayecto= true;
		if((this.tanque.getAnguloOrientacion() == 0) && (this.bala != null)){//0º){//DERECHA
			this.bala.setX(this.bala.getX()+3);
			if(this.bala.getX() >= 800){
				this.bala = null;
				balaEnTrayecto= false;
				
				contador=0;
				return balaEnTrayecto;
			}
		}else if(this.tanque.getAnguloOrientacion() == Math.PI/2){//90º){//ABAJO
			this.bala.setY(this.bala.getY()+3);
			if(this.bala.getY() >= 600){
				this.bala = null;
				balaEnTrayecto= false;
				
				contador=0;
				return balaEnTrayecto;
			}
		}else if(this.tanque.getAnguloOrientacion() == Math.PI ){//180º){//IZQUIERDA
			this.bala.setX(this.bala.getX()-3);
			if(this.bala.getX() <= 0){
				this.bala = null;
				balaEnTrayecto= false;
				
				contador=0;
				return balaEnTrayecto;
			}
		}else if(this.tanque.getAnguloOrientacion() == Math.PI*1.5){//270º){ARRIBA
			this.bala.setY(this.bala.getY()-3);
			if(this.bala.getY() <= 0){
				this.bala = null;
				balaEnTrayecto= false;
				
				contador=0;
				return balaEnTrayecto;
			}
		}
		//if(bala != null){
		try{
			this.bala.dibujar();
		}catch(Exception ex){
			
		}
		
		//}
		return balaEnTrayecto;
	}

		/*public void movimiento2(Entorno ent){
			if(this.tanque.getAnguloOrientacion() == 0){//DERECHA
				this.bala.avanzarDerecha();
				if(this.bala.getX() >= 800){
					this.bala = null;
				}
			}else if(this.tanque.getAnguloOrientacion() == Math.PI/2){//ABAJO
				this.bala.avanzarAbajo();
				if(this.bala.getY() >= 600){
					this.bala = null;
				}
			}else if(this.tanque.getAnguloOrientacion() == Math.PI){//IZQUIERDA
				this.bala.avanzarIzquierda();
				if(this.bala.getX() <= 0){
					this.bala = null;
				}
			}else if(this.tanque.getAnguloOrientacion() == Math.PI*1.5){//ARRIBA
				this.bala.avanzarArriba();
				if(this.bala.getY() <= 0){
					this.bala = null;
				}
			}
			if(this.bala == null){
				Sonido.TanqueDisparo.stop();
				Sonido.TanqueDisparoExplocion.play();
			}
			this.bala.dibujar();
		}*/
		
		
		boolean controlFront = true;
		public boolean controlFronteraBala(){
			if(this.bala!= null){
				
				/***/controlFront = true;
				if(this.bala.getY()>=600){//OK
					this.bala= null;
					//contador=0;
					fuegoActivado=false;
					controlFront = false;
					balaEnTrayecto= false;
					//System.out.println("controlFront = "+controlFront);
					return controlFront;
				}
				if(this.bala.getX()<=0){//OK
					this.bala= null;
					//contador=0;
					fuegoActivado=false;
					controlFront = false;
					balaEnTrayecto= false;
					//System.out.println("controlFront = "+controlFront);
					return controlFront;
				}
				if(this.bala.getY()<=0){//OK
					this.bala= null;
					//contador=0;
					fuegoActivado=false;
					controlFront = false;
					balaEnTrayecto= false;
					//System.out.println("controlFront = "+controlFront);
					return controlFront;
				}
				if(this.bala.getX()>=800){//OK
					this.bala= null;
					//contador=0;
					fuegoActivado=false;
					controlFront = false;
					balaEnTrayecto= false;
					//System.out.println("controlFront = "+controlFront);
					return controlFront;
				}	
				controlFront= true;
			}
			/****/controlFront= true;
			//System.out.println("controlFront = "+controlFront);
			
			return controlFront;
		}
		
		public boolean isBalaEnTrayecto() {
			return balaEnTrayecto;
		}

		public void setBalaEnTrayecto(boolean balaEnTrayecto) {
			this.balaEnTrayecto = balaEnTrayecto;
		}
		
}
