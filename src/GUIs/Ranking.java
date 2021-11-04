package GUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import DataBase.connect;

public class Ranking extends JFrame {

	// Atributos
	private JPanel panel, text;
	private JLabel labelTitulo;
	private String texto;
	private JTextArea areaDeTexto;
	private JButton bt1;
	JScrollPane scrollPane;

	public Ranking() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("RANKING");
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
		labelTitulo.setText("RANKING");
		labelTitulo.setBounds(250, 40, 400, 60);
		labelTitulo.setFont(new Font("courier", Font.PLAIN, 30));
		
		connect con = new connect();

		texto = "Nombre \t Victorias \t Derrotas \t Empates \t Partidas \n";
		texto += con.ranking();

		areaDeTexto = new JTextArea();
		areaDeTexto.setText(texto);
		areaDeTexto.setBackground(getForeground());
		areaDeTexto.setFont(new Font("verdana", Font.PLAIN, 15));
		areaDeTexto.setBounds(20, 160, 680, 200);
		areaDeTexto.setEditable(false);
		

		scrollPane = new JScrollPane(areaDeTexto);
		scrollPane.setBounds(80, 120, 600, 200);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		bt1 = new JButton("ATRAS");
		bt1.setBounds(280, 380, 140, 50);
		bt1.setFont(new Font("courier", Font.PLAIN, 15));

		panel.setPreferredSize(new Dimension(600, 380));

		panel.add(labelTitulo);
		panel.add(scrollPane);
		panel.add(bt1);

		add(panel);
	}

	// Getters&Setters
	public JButton getBt1() {
		return bt1;
	}

}
