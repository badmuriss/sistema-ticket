package domain.canal;

import domain.canal.filas.FilaTickets;

public class Encaminhador {

	public Encaminhador(FilaTickets filaResolucao) {
		this.filaResolucao = filaResolucao;
	}

	private FilaTickets filaResolucao;

	public FilaTickets getFilaResolucao() {
		return filaResolucao;
	}

	public void setFilaResolucao(FilaTickets filaResolucao) {
		this.filaResolucao = filaResolucao;
	}

	public void encaminharTicket() {
		Ticket ticket = filaResolucao.dequeue();

		System.out.println("Ticket com a mensagem - '" + ticket.getMensagem()
				+ "' já encaminhado ao setor responsavel. Enviada resposta para cliente: sua solicitação já foi resolvida pelo setor responsável. Obrigado!!");
	}

}
