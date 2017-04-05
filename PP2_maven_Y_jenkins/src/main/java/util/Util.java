package util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Util {

	//controlarPosicion
	public boolean controlarLimiteDeTablero(double posicionX, double posicionY, double anguloOrientacion){ //,Posicion posicion
		if(anguloOrientacion  == Math.PI && posicionX == 0){
			System.out.println("FUERA DE RANGO IZQUIERDA");
			return  false; //izquierda
		}if(anguloOrientacion  == 0 && posicionX == 800){
			System.out.println("FUERA DE RANGO DERECHA");
			return false; //derecha 
		}if(anguloOrientacion  == Math.PI*1.5 && posicionY == 0){
			System.out.println("FUERA DE RANGO ARRIBA");
			return false;//arriba 
		}if(anguloOrientacion  == Math.PI/2 && posicionY == 600){
			System.out.println("FUERA DE RANGO ABAJO");
			return false; //abajo 
		}
		return true;
	}
	
	public static ImageIcon redimension(ImageIcon icono, int x,int y){
		Image img = icono.getImage(); 
		Image otraimg = img.getScaledInstance(x,y,java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dándole las dimensiones que queramos a la antigua
		ImageIcon otroicon = new ImageIcon(otraimg);
		return otroicon;
	}
	
}


/*if(anguloOrientacion  == 270 && posicionX == 0){
return  false; //izquierda
}if(anguloOrientacion  == 90 && posicionX == 24){
return false; //derecha 
}if(anguloOrientacion  == 0 && posicionY == 0){
return false;//arriba 
}if(anguloOrientacion  == 180 && posicionY == 24){
return false; //abajo 
}
return true;*/
