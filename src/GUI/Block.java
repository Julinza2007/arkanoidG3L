package GUI;

import java.awt.Color;

import javax.swing.JButton;

public class Block extends JButton {

	private static final long serialVersionUID = 1L;
	
	private boolean estaRoto = false;

	public Block(int posX, int posY, int ancho, int alto, Color color) {
		setBounds(posX, posY, ancho, alto);
		setEnabled(false);
		setBackground(color);
	}
	
	public void romperBloque() {
		estaRoto = true;
		setVisible(false);		
	}

}
