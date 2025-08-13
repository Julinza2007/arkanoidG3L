package GUI;

import javax.swing.JPanel;

public class Player extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Player(int posX, int posY, int ancho, int alto) {
		setBounds(posX, posY, ancho, alto);
	}
	
	public void moverDerecha(int ancho) {
		int posY = getY();
		int posX = getX();
		if (posX < ancho) {
			setLocation(posX + 15, posY);
		}
	}
	
	public void moverIzquierda(int ancho) {
		int posY = getY();
		int posX = getX();
		
		if (posX > 0) {
			setLocation(posX - 15, posY);
		}
	}

}
