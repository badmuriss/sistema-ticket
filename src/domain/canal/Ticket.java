package domain.canal;

import domain.canal.enums.Motivo;

public class Ticket {
	
	public Ticket(String nome, String contato, Motivo motivo, String mensagem) {
		this.nome = nome;
		this.contato = contato;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}
	
	public Ticket(String contato, Motivo motivo, String mensagem) {
		this.nome = null;
		this.contato = contato;
		this.motivo = motivo;
		this.mensagem = mensagem;
	}

	private String nome;
	private String contato;
	private Motivo motivo;
	private String mensagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
