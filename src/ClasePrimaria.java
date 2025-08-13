import GUI.Arkanoid;

public class ClasePrimaria {

	public static void main(String[] args) {
		mostrarArkanoid();
	}
	
	public static void mostrarArkanoid() {
		Arkanoid arkanoid = new Arkanoid();
		arkanoid.setVisible(true);
	}

}
