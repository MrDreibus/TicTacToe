package GUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Reglas extends JFrame {

	// Atributos
	private JPanel panel;
	private JLabel labelTitulo;
	private String texto;
	private JTextArea areaDeTexto;
	private JButton bt1;

	public Reglas() {
		
		Menu m1 = new Menu();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("REGLAS");
		setResizable(false);
		Toolkit monitor = Toolkit.getDefaultToolkit();
		Dimension tamanio = monitor.getScreenSize();
		int anchuraMonitor = tamanio.width;
		int alturaMonitor = tamanio.height;
		setSize(anchuraMonitor / 2, alturaMonitor / 2);
		setLocation(anchuraMonitor / 4, alturaMonitor / 4);

		Image iconoAPP=monitor.getImage("src/icono.png");
		setIconImage(iconoAPP);

		iniciarComponentes();

	}

	private void iniciarComponentes() {

		panel = new JPanel();
		panel.setLayout(null);

		labelTitulo = new JLabel();
		labelTitulo = new JLabel("REGLAS");
		labelTitulo.setBounds(250, 40, 400, 60);
		labelTitulo.setFont(new Font("ZapfDingbats", Font.BOLD, 50));

		texto = "El juego del tres en raya es un juego en el que participan 2 jugadores. Cada jugador\n"
				+ "tiene que elegir un simbolo 'X' o 'O'. El tablero es un espacio de 3x3, donde cada\n"
				+ "jugador debe colocar su simbolo una vez por turno y sobre una casilla no ocupada.";

		areaDeTexto = new JTextArea();
		areaDeTexto.setText(texto);
		areaDeTexto.setBackground(getForeground());
		areaDeTexto.setFont(new Font("verdana", Font.PLAIN, 15));
		areaDeTexto.setBounds(20, 170, 680, 100);

		bt1 = new JButton("ATRAS");
		bt1.setBounds(280, 350, 140, 50);
		bt1.setFont(new Font("courier", Font.PLAIN, 15));

		panel.add(labelTitulo);
		panel.add(areaDeTexto);
		panel.add(bt1);

		add(panel);
	}

	// Getters&Setters
	public JButton getBt1() {
		return bt1;
	}
}
