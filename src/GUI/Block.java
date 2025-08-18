package GUI;

import java.awt.Color;

import javax.swing.JButton;

public class Block extends JButton {

	private static final long serialVersionUID = 1L;
	
	private boolean estaRoto = false;

	public Block(int posX, int posY, int ancho, int alto, Color color, int[][] vida) {
		setBounds(posX, posY, ancho, alto);
		setEnabled(false);
		
		for(int i=0; i < 8; i++) {
			for(int j=0; j < 3; j++) {
				
			if (vida[i][j] == 3) {
				setBackground(Color.RED);
			}
			if (vida[i][j] == 2) {
				setBackground(Color.BLUE);
			}
			if (vida[i][j] == 1) {
				setBackground(Color.GREEN);
			}
		}
		}
	}
	
	public void romperBloque() {
		estaRoto = true;
		setVisible(false);		
	}

	

}
