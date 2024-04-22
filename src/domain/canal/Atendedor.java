package domain.canal;

import java.util.Scanner;

import domain.canal.enums.Motivo;
import domain.canal.filas.FilaTickets;

public class Atendedor {

	public Atendedor(FilaTickets filaReclamacao, FilaTickets filaSugestao, FilaTickets filaResolucao) {
		this.filaReclamacao = filaReclamacao;
		this.filaSugestao = filaSugestao;
		this.filaResolucao = filaResolucao;
	}

	private Scanner sc;
	private FilaTickets filaReclamacao;
	private FilaTickets filaSugestao;
	private FilaTickets filaResolucao;

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

	public FilaTickets getFilaResolucao() {
		return filaResolucao;
	}

	public void setFilaResolucao(FilaTickets filaResolucao) {
		this.filaResolucao = filaResolucao;
	}

	public void atenderTicket(Ticket ticket) {
		
		System.out.println("MENSAGEM: " + ticket.getMensagem());
		
		System.out.println("\nO que deseja fazer?\n(a) Mensagem pode ser prontamente respondida, enviar resolução ao cliente\n(b) Mensagem não pode ser prontamente respondida, encaminhar para o setor responsavel\n");
		
		char opcao = sc.next().toUpperCase().charAt(0);
		
		switch (opcao) {
		
		case 'A':
			System.out.println("\nEnviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");
			break;
			
		case 'B':
			filaResolucao.enqueue(ticket);
			System.out.println("\nTicket encaminhado para a fila de resolução.");
			break;
			
		default:
			throw new IllegalArgumentException("Comando invalido, insira 'A' ou 'B'");
		}
	}
	
	public Ticket recuperarTicketAtendimento(Motivo motivo) {
		Ticket ticket;
		
		switch (motivo) {

		case RECLAMACAO:
			ticket = filaReclamacao.dequeue();
			break;

		case SUGESTAO:
			ticket = filaSugestao.dequeue();
			break;

		default:
			throw new IllegalArgumentException("Comando invalido");
		}
		
		return ticket;
		
	}
	

}
