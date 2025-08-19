package GUI;

import java.awt.Color;

import javax.swing.JButton;

public class Block extends JButton {

	private static final long serialVersionUID = 1L;
	
	private boolean estaRoto = false;

	private int vida;

	public Block(int posX, int posY, int ancho, int alto, Color color, int vida) {
		setBounds(posX, posY, ancho, alto);
		setEnabled(false);
		this.vida = vida;
		

				
			if (vida == 3) {
				setBackground(Color.GREEN);
			}
			if (vida == 2) {
				setBackground(Color.YELLOW);
			}
			if (vida == 1) {
				setBackground(Color.RED);
			}
			
	}
	
	public int restarVida(){
		
		vida -=1;
		
		if (vida == 3) {
			setBackground(Color.GREEN);
		}
		if (vida == 2) {
			setBackground(Color.YELLOW);
		}
		if (vida == 1) {
			setBackground(Color.RED);
		}
		
		return vida;
	}
	
	
	
	public void romperBloque() {
		estaRoto = true;
		setVisible(false);		
	}

	

}
