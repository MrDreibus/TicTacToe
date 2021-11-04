package GUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dificultad extends JFrame {

	// Atributos
	private JPanel panel;
	private JLabel labelTitulo;
	private JButton bt1, bt2, bt3;

	public Dificultad() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("DIFICULTAD");
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
		labelTitulo = new JLabel("DIFICULTAD");
		labelTitulo.setBounds(200, 40, 400, 60);
		labelTitulo.setFont(new Font("ZapfDingbats", Font.BOLD, 50));

		bt1 = new JButton("FACIL");
		bt1.setBounds(100, 170, 200, 100);
		bt1.setFont(new Font("courier", Font.PLAIN, 30));

		bt2 = new JButton("NORMAL");
		bt2.setBounds(400, 170, 200, 100);
		bt2.setFont(new Font("courier", Font.PLAIN, 30));

		bt3 = new JButton("ATRAS");
		bt3.setBounds(280, 350, 140, 50);
		bt3.setFont(new Font("courier", Font.PLAIN, 15));

		panel.add(labelTitulo);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);

		add(panel);
	}

	// Getters&Setters
	public JButton getBt1() {
		return bt1;
	}

	public JButton getBt2() {
		return bt2;
	}

	public JButton getBt3() {
		return bt3;
	}

}
