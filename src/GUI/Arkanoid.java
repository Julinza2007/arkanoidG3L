package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Arkanoid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Arkanoid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 816, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		generarBloques();
		
		Player player = new Player(360, 520, 80, 10);
		player.setBackground(Color.BLACK);
		contentPane.add(player);
		
		

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int anchoPanel = contentPane.getWidth();
				System.out.println("Ancho del ContentPane: " + anchoPanel);
				if(e.getKeyCode() == KeyEvent.VK_D){
					player.moverDerecha(anchoPanel);
					
				}
				
				if(e.getKeyCode() == KeyEvent.VK_A) {
					player.moverIzquierda(anchoPanel);
				}
			}
		});
		
	}
	
	public void generarBloques() {
		Random random = new Random();
		
		for(int i=0; i < 8; i++) {
			for(int j=0; j < 3; j++) {
				int rojo = random.nextInt(256);
				int azul = random.nextInt(256);
				int verde = random.nextInt(256);
				
				Color colorRandom = new Color(rojo, verde, azul);
				Block bloque = new Block(100 * i, 35 * j, 100, 35, colorRandom);
				contentPane.add(bloque);
			}
		}
		
	}

}
