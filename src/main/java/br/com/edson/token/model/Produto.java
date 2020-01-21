package br.com.edson.token.model;

public class Produto {
	private int codigo;
	private String titulo;
	private String detalhes;
	private float preco;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return "{\"codigo\":"+codigo+",\"titulo\":\""+titulo+"\",\"detalhes\":"+detalhes+"\",\"preco\":"+preco+"}";
	}
}