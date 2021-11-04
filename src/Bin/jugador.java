package Bin;

public class jugador {
private String nombre;
private int victorias;
private int derrotas;
private int empate;
private boolean local = false;
	public jugador(String nombre, int victorias,int derrotas,int empate) {
		this.nombre = nombre;
		this.victorias=victorias;
		this.derrotas=derrotas;
		this.empate=empate;
		// TODO Auto-generated constructor stub
	}
	
	public jugador() {
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getEmpate() {
		return empate;
	}
	public void setEmpate(int empate) {
		this.empate = empate;
	}
	
public int PartidasTotales() {
	return empate+victorias+derrotas;
}

@Override
public String toString() {
	return "jugador [nombre=" + nombre + ", victorias=" + victorias + ", derrotas=" + derrotas + ", empate=" + empate
			+ "]";
}

public boolean getLocal() {
	return local;
}

public void setLocal(boolean local) {
	this.local = local;
}


}
