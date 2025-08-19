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
	private Puntaje puntaje;
	private boolean juegoPausado = false;

	public Arkanoid() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setFocusable(true);
		requestFocusInWindow();
		setBounds(100, 100, 816, 572);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		puntaje = new Puntaje();
		puntaje.setBounds(350, 490, 150, 50);
		contentPane.add(puntaje);
		repaint();

		
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
				if (juegoPausado) return;
				anchoPanel = contentPane.getWidth();
				altoPanel = contentPane.getHeight();
				ball.mover();
				ball.rebotar(anchoPanel, altoPanel, player, bloques, Arkanoid.this);
				ArrayList<Block> paraEliminar = ball.detectarColisiones(bloques);		// Se crea una nueva lista de Arrays sobre los bloques que se deben eliminar
				for (Block bloque : paraEliminar) {										// Se hace un for each para explorar cada bloque que esta para eliminar
					bloques.remove(bloque);												// Remueve el bloque que esta para eliminar de la lista de bloques
					contentPane.remove(bloque);											// Remueve el bloque para eliminar del "contentPane", osea de la pestaña
					puntaje.add(100);
				}
				contentPane.repaint();													// Se "pinta" denuevo la pestaña, basicamente se actualiza la pestaña.
			}
		});
		timer.start();
		
	}
	/*
	public void perderVida() {
		puntaje.perderVida();
		
		if (puntaje.getVidas() > 0) {
			reiniciarPosiciones();
		} else {
			reiniciarNivel();
		}
	}

	private void reiniciarPosiciones() {
		for (java.awt.Component comp : contentPane.getComponents()) {
			if (comp instanceof Ball) {
				comp.setLocation(400, 250);
			} else if (comp instanceof Player) {
				comp.setLocation(360, 470);
			}
		}
	}

	private void reiniciarNivel() {
		for (Block bloque : bloques) {
			contentPane.remove(bloque);
		}
		bloques.clear();
		
		Random random = new Random();
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 3; j++) {
				int rojo = random.nextInt(256);
				int azul = random.nextInt(256);
				int verde = random.nextInt(256);
				
				Color colorRandom = new Color(rojo, verde, azul);
				Block bloque = new Block(100 * i, 35 * j, 100, 35, colorRandom);
				bloques.add(bloque);
				contentPane.add(bloque);
			}
		}
		
		reiniciarPosiciones();
		puntaje.resetVidas();
	} */

	
	


}
