package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arkanoid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Arkanoid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Player player = new Player(362, 520, 60, 10);
		player.setBackground(Color.BLACK);
		contentPane.add(player);

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int anchoPanel = contentPane.getWidth();
				if(e.getKeyCode() == KeyEvent.VK_D){
					player.moverDerecha(anchoPanel);
					
				}
				
				else if(e.getKeyCode() == KeyEvent.VK_A) {
					player.moverIzquierda(anchoPanel);
				}
			}
		});
		
	}

}
