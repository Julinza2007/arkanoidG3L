package GUI;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class Arkanoid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int anchoPanel=0;
	private int altoPanel=0;
	private ArrayList<Block> bloques = new ArrayList<>();



	public Arkanoid() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();
		setBounds(100, 100, 816, 572);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon galaxy = new ImageIcon(getClass().getResource("/GUI/galaxia.png"));
		

		Random random = new Random();
		for(int i=0; i < 8; i++) {
			for(int j=0; j < 3; j++) {
				int rojo = random.nextInt(256);
				int azul = random.nextInt(256);
				int verde = random.nextInt(256);
				
				Color colorRandom = new Color(rojo, verde, azul);
				Block bloque = new Block(100 * i, 35 * j, 100, 35, colorRandom);
				bloques.add(bloque);
				contentPane.add(bloque);
			    
			}
		}
		
		Ball ball = new Ball(400, 250, 20, 20);
		ball.setBackground(Color.RED);
		contentPane.add(ball);
		
		Player player = new Player(360, 470, 80, 10);
		player.setBackground(Color.GREEN);
		contentPane.add(player);
		
		JLabel contenedorGalaxy = new JLabel(galaxy);
		contenedorGalaxy.setBounds(0, 0, 800, 533);
		contentPane.add(contenedorGalaxy);
		

		

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("Ancho del ContentPane: " + anchoPanel);
				System.out.println("Alto del contentPane: " + altoPanel);
				if(e.getKeyCode() == KeyEvent.VK_D){
					player.moverDerecha(anchoPanel);
				}
				
				if(e.getKeyCode() == KeyEvent.VK_A) {
					player.moverIzquierda();
				}
			}
		});
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				anchoPanel = contentPane.getWidth();
				altoPanel = contentPane.getHeight();
				ball.mover();
				ball.rebotar(anchoPanel, altoPanel, player, bloques);
				ArrayList<Block> paraEliminar = ball.detectarColisiones(bloques);
				for (Block bloque : paraEliminar) {
					bloques.remove(bloque);
					contentPane.remove(bloque);
				}
				contentPane.repaint();
			}
		});
		timer.start();
		
	}

	
	


}
