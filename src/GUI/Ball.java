package GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	private double dx = 3.0;
	private double dy = 3.0;

	
	public Ball(int posX, int posY, int ancho, int alto) {
		setBounds(posX, posY, ancho, alto);
	}
	
	public void mover() {
		int posX = getX();
		int posY = getY();
		
		posX += dx;
		posY += dy;
		
		setLocation(posX, posY);
	}
	
	public void rebotar(int anchoPanel, int altoPanel, Player player, ArrayList<Block> bloques) {
		int posX = getX();
		int posY = getY();
		
		
		if(posX <= 0 || posX >= anchoPanel - getWidth()) {
			dx *= -1;
		}
		if(posY <= 0) {
			dy *= -1;
		}
		if (posY >= altoPanel - getHeight()) {
			resetBall(408, 286);
			return;
		}
		
		if (posX <= player.getX() + player.getWidth() && posX + getWidth() >= player.getX() &&
			posY <= player.getY() + player.getHeight() && posY + getHeight() >= player.getY()) {
				dy = -dy;					
			}
		
	}
	public ArrayList<Block> detectarColisiones(ArrayList<Block> bloques){							// se crea una nueva funcion para las colisiones con los bloques
		int posX = getX();
		int posY = getY();
		ArrayList<Block> bloquesColisionados = new ArrayList<>();									// Se crea una nueva lista de arrays de los bloques colisionados
		for (Block bloque : bloques) {																// Se hace un for each, donde se van a explorar cada bloque dentro de la lista de bloques
				if (posX <= bloque.getX() + bloque.getWidth() && posX + getWidth() >= bloque.getX() &&
					posY <= bloque.getY() + bloque.getHeight() && posY + getHeight() >= bloque.getY()) {
								dy = -dy;				
								if(bloque.restarVida() == 0) {
									bloquesColisionados.add(bloque);											// A la lista de colsiones se le agrega el bloque con el que colisiono.
								}
						}
					
					
				}
		return bloquesColisionados;																	// La funcion devuelve la lista de colisiones
	}
	public void resetBall(int x, int y) {
        setLocation(x, y);
    }
	
	public void aumentarVelocidad(double velocidad) {
		dx *= velocidad;
		dy *= velocidad;
	}

}
