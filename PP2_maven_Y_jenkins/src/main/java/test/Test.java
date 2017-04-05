package test;

import entorno.Entorno;
import entorno.InterfaceJuego;
import modelo.Tanque;
import presentacion.controlador.Disparo;

public class Test extends InterfaceJuego{
    private Entorno entorno;
    private Tanque tanque;
    private Disparo disparo;
    private int ANCHO_ENTORNO = 800;
    private int ALTO_ENTORNO = 600;
    
    public Test(){
    	this.entorno = new Entorno(this, "Battle-City", ANCHO_ENTORNO, ALTO_ENTORNO);
    	this.tanque = new Tanque(400, 300, 0);
//    	this.tanque.Dibujar(entorno, false);
    	this.disparo = new Disparo(tanque,entorno);
    }
    
    public void tick(){
    	//this.entorno.dibujarCirculo(400, 300, 100, Color.red);
    	//Image imagen = Herramientas.cargarImagen("imagen/bala 00.png");
    	//this.entorno.dibujarImagen(imagen, 400, 300, 0);
    	if(this.entorno.estaPresionada(this.entorno.TECLA_CTRL)){
        		this.disparo.disparar(); 
    	}
    }

	@SuppressWarnings("unused")
    public static void main(String[] args) {
    	Test test = new Test ();
    }
}
