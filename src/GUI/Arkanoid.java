package GUI;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Arkanoid extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel contenedorGalaxy;
	private int anchoPanel=0;
	private int altoPanel=0;
	private boolean aPressed = false;
	private boolean dPressed = false;
	private JLabel contadorDeNiveles;
	
	private ArrayList<Block> bloques = new ArrayList<>();
	private int nivelActual = 1;
	
	
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
		
		contadorDeNiveles = new JLabel("Nivel: " + nivelActual);
		contadorDeNiveles.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contadorDeNiveles.setBounds(10, 484, 100, 20);
		contadorDeNiveles.setForeground(Color.WHITE);
		contentPane.add(contadorDeNiveles);
		
		
		Ball ball = new Ball(400, 250, 20, 20);
		ball.setBackground(Color.RED);
		contentPane.add(ball);
		
		Player player = new Player(360, 470, 80, 10);
		player.setBackground(Color.GREEN);
		contentPane.add(player);
		
		
		contenedorGalaxy = new JLabel(galaxy);
		contenedorGalaxy.setBounds(0, 0, 800, 533);
		contentPane.add(contenedorGalaxy);
		
		generarBloques(nivelActual); // Genera los bloques del primer nivel.
		
		
		addKeyListener(new KeyListener() {
			
		    public void keyTyped(KeyEvent e) {} // Se abre el listener para poder escuchar input del teclado en el juego.

		    public void keyPressed(KeyEvent e) {
		        int teclaPresionada = e.getKeyCode();
		        
		        if (teclaPresionada == KeyEvent.VK_A) { aPressed = true; }      // Actualiza los booleanos de las teclas cuando están presionadas.
		        if (teclaPresionada == KeyEvent.VK_D) { dPressed = true; }

		        if (aPressed) { player.moverIzquierda(); }
		        if (dPressed) { player.moverDerecha(anchoPanel); }
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		        int teclaPresionada = e.getKeyCode();
		        if (teclaPresionada == KeyEvent.VK_A) { aPressed = false; }     // Actualiza los booleanos cuando una tecla es soltada.
		        if (teclaPresionada == KeyEvent.VK_D) { dPressed = false; }
		    }
			});
		
		
		Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				anchoPanel = contentPane.getWidth();
				altoPanel = contentPane.getHeight();
				ball.mover();
				ball.rebotar(anchoPanel, altoPanel, player, bloques);
				ArrayList<Block> paraEliminar = ball.detectarColisiones(bloques);		// Se crea una nueva lista de Arrays sobre los bloques que se deben eliminar
				for (Block bloque : paraEliminar) {										// Se hace un for each para explorar cada bloque que esta para eliminar
						bloque.romperBloque();			  								// ocultar bloque 
						bloques.remove(bloque);											// Remueve el bloque que esta para eliminar de la lista de bloques
						contentPane.remove(bloque);										// Remueve el bloque para eliminar del "contentPane", osea de la pestaña
				}
				
				if (nivelCompletado()) {
				    pasarAlSiguienteNivel(ball); // Si el nivel esta completado, se pasa al siguiente nivel.
				}
				
//				contentPane.revalidate();											// Se revalida el panel, para que se actualicen los cambios.
				contentPane.repaint();												// Se "pinta" de nuevo el panel, basicamente se actualiza el panel.
			}
		});
		timer.start();
		
	}
	
	
	private boolean nivelCompletado() {
	    return bloques.isEmpty(); // Método que devuelve true o false si la lista de bloques está vacía.
	}
	
	private void generarBloques(int nivel) {
		Random random = new Random();
		int filas = 1 + nivel;
		int columnas = 8;
		
		if (filas > 5) {
		    filas = 5; // Limita el número de filas a 5 para no exceder el espacio visible.
		}
		
		for(int i=0; i < filas; i++) {
			for(int j=0; j < columnas; j++) {
				int vida = 1;
				int probab = random.nextInt(100); // Se genera un numero de 0 a 99.

				if (nivel == 1) {
				    if (probab < 70) vida = 1;
				    else if (probab < 95) vida = 2;
				    else vida = 3;
				} else if (nivel == 2) {
				    if (probab < 40) vida = 1;
				    else if (probab < 80) vida = 2;
				    else vida = 3;
				} else {
				    if (probab < 20) vida = 1;
				    else if (probab < 60) vida = 2;
				    else vida = 3;
				}
				
				Block bloque = new Block(100 * j, 35 * i, 100, 35, vida);
				bloques.add(bloque);
				contentPane.add(bloque);
			    
			}
		}
		
		
	    contentPane.setComponentZOrder(contenedorGalaxy, contentPane.getComponentCount() - 1); // Asegura que la galaxia esté al fondo.

	}
	
	private void pasarAlSiguienteNivel(Ball ball) {
	    nivelActual++;
	    contadorDeNiveles.setText("Nivel: " + nivelActual);
	    generarBloques(nivelActual);
	    ball.aumentarVelocidad(1.1); // Este método lo agregás en tu clase Ball
	    ball.resetBall(408, 286); // Posición inicial, dirección, etc.
	}
	
	

	
	


}
