package livro;

public class Livro {
	
	private String titulo;
	private String autor;
	private double valor;
	private int id;
	private static int contadorDeId = 1;
	private double notaDeAvaliacao = 0;
	private int numeroDeVotos = 0;
	
	public Livro(String titulo, String autor, double valor) {
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
		id = contadorDeId;
		contadorDeId++;
		System.out.println("O livro " + this.getTitulo() + " foi cadastrado com sucesso.");
	}
	
	public String getTitulo() {
		return titulo;
	}
	
 	public void setTitulo(String titulo) {
 		this.titulo = titulo;
 	}

	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public String toString() {
		return "\nID: " + this.getId() +
				"\nTítulo: " + this.getTitulo() + 
				"\nAutor: " + this.getAutor() +
				"\nAvaliação: " + this.getAvaliacao() +
				"\nValor: R$ " + this.getValor();
	}
	
	public void avaliar(Double notaDeAvaliacao) {
		this.notaDeAvaliacao += notaDeAvaliacao;
		numeroDeVotos++;
	}
	
	public double getAvaliacao() {
		if (numeroDeVotos == 0) {
			return 0;
		} else {
			return notaDeAvaliacao / numeroDeVotos;
		}
	}	
	
 
}
