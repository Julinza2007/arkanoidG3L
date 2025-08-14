package GUI;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	private int dx = 2;
	private int dy = 2;
	
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
	
	public void rebotar(int anchoPanel, int altoPanel, Player player) {
		int posX = getX();
		int posY = getY();
		
		if(posX <= 0 || posX >= anchoPanel - getWidth()) {
			dx *= -1;
		}
		if(posY <= 0 || posY >= altoPanel - getHeight()) {
			dy *= -1;
		}
		
		if (posX <= player.getX() + player.getWidth() && posX + getWidth() >= player.getX() &&
			posY <= player.getY() + player.getHeight() && posY + getHeight() >= player.getY()) {
				dy = -dy;					
			}
	}

}
