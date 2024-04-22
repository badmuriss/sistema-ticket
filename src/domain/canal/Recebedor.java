package domain.canal;

import java.util.Scanner;

import domain.canal.enums.Motivo;
import domain.canal.filas.FilaTickets;

public class Recebedor {

	public Recebedor(FilaTickets filaReclamacao, FilaTickets filaSugestao) {
		this.filaReclamacao = filaReclamacao;
		this.filaSugestao = filaSugestao;
	}

	private Scanner sc;
	private FilaTickets filaReclamacao;
	private FilaTickets filaSugestao;

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	public FilaTickets getFilaReclamacao() {
		return filaReclamacao;
	}

	public void setFilaReclamacao(FilaTickets filaReclamacao) {
		this.filaReclamacao = filaReclamacao;
	}

	public FilaTickets getFilaSugestao() {
		return filaSugestao;
	}

	public void setFilaSugestao(FilaTickets filaSugestao) {
		this.filaSugestao = filaSugestao;
	}

	public Ticket criarTicketUI() {	
		System.out.print("Nome (deixe em branco se preferir): ");
		String nome = sc.nextLine();
		
		System.out.print("Email/Telefone: ");
		String contato = sc.nextLine();
		
		System.out.print("Motivo do contato (1 - reclamação / 2 - sugestão): ");
		Motivo motivo = Motivo.fromId(sc.nextInt());
		
		System.out.print("Mensagem (texto): ");
		String mensagem = sc.next();
		
		return new Ticket(nome, contato, motivo, mensagem);
	}
	
	public void receberTicket(Ticket ticket) {
		switch (ticket.getMotivo()) {

		case RECLAMACAO:
			filaReclamacao.enqueue(ticket);
			break;

		case SUGESTAO:
			filaSugestao.enqueue(ticket);
			break;

		default:
			throw new IllegalArgumentException("Comando invalido");
		}
	}

}
