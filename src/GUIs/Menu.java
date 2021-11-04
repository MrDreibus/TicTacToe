package GUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {

	// Atributos
	private JPanel panel;
	private JLabel labelTitulo;
	private JButton bt1, bt2, bt3, bt4;
	
	
	public Menu() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TRES EN RAYA");
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
		labelTitulo = new JLabel("TRES EN RAYA");
		labelTitulo.setBounds(180, 40, 400, 60);
		labelTitulo.setFont(new Font("ZapfDingbats", Font.BOLD, 50));

		bt1 = new JButton("REGLAS");
		bt1.setBounds(250, 130, 200, 100);
		bt1.setFont(new Font("courier", Font.PLAIN, 30));

		bt2 = new JButton("JUGAR");
		bt2.setBounds(250, 250, 200, 100);
		bt2.setFont(new Font("courier", Font.PLAIN, 30));

		bt3 = new JButton("RANKING");
		bt3.setBounds(20, 350, 140, 50);
		bt3.setFont(new Font("courier", Font.PLAIN, 15));

		bt4 = new JButton("SALIR");
		bt4.setBounds(560, 350, 140, 50);
		bt4.setFont(new Font("courier", Font.PLAIN, 15));

		panel.add(labelTitulo);
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(bt4);

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

	public JButton getBt4() {
		return bt4;
	}
	

}
