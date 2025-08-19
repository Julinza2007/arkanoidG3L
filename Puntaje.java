package GUI;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class Puntaje extends JPanel {
	
	private int score = 0;
	private int vidas = 3;
	
	private JLabel puntaje;
	private JLabel vidasLbl;
	
	public Puntaje() {
		setLayout(null);
		setOpaque(false);
		puntaje = new JLabel("PUNTAJE: 0");
		puntaje.setBounds(0, 11, 150, 20);
		puntaje.setForeground(Color.WHITE);
		add(puntaje);
		
		vidasLbl = new JLabel("VIDAS: 3");
		vidasLbl.setBounds(0, 26, 150, 20);
		vidasLbl.setForeground(Color.WHITE);
		add(vidasLbl);

	}
	public void setPuntaje(int s) {
        score = s;
        puntaje.setText("PUNTAJE: " + score);
    }

    public void add(int points) {
        setPuntaje(score + points);
    }

    public int getPuntaje() {
        return score;
    }
    
    public void perderVida() {
        vidas--;
        actualizarVidas();
    }
    
    public void resetVidas() {
        vidas = 3;
        actualizarVidas();
    }
    
    public int getVidas() {
        return vidas;
    }
    
    private void actualizarVidas() {
        vidasLbl.setText("VIDAS: " + vidas);
    }

    public void reset() {
        setPuntaje(0);
        resetVidas();
    }
}
