package GUI;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

public class Puntaje extends JPanel {
	
	private int score = 0;
	private JLabel puntaje;
	
	public Puntaje() {
		setLayout(null);
		setOpaque(false);
		puntaje = new JLabel("PUNTAJE: 0");
		puntaje.setBounds(10, 5, 150, 20);
		puntaje.setForeground(Color.WHITE);
		add(puntaje);

	}
	public void setPuntaje(int s) {
        score = s;
    }

    public void add(int points) {
        setPuntaje(score + points);
    }

    public int getPuntaje() {
        return score;
    }

    public void reset() {
        setPuntaje(0);
    }
}
