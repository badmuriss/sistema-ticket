package application;

import java.util.Scanner;

import domain.canal.Atendedor;
import domain.canal.Encaminhador;
import domain.canal.Recebedor;
import domain.canal.enums.Motivo;
import domain.canal.filas.FilaTickets;

public class AtendimentoTickets {

	/*
	 
	GRUPO CP:
	MURILO ALVES DE MOURA - RM 98220
	ROBERTO FELIX DE ARAUJO GUEDES - RM 99976
	
	*/
	
	public static void main(String[] args) {

		FilaTickets filaReclamacao = new FilaTickets();
		FilaTickets filaSugestao = new FilaTickets();
		FilaTickets filaResolucao = new FilaTickets();
		Recebedor recebedor = new Recebedor(filaReclamacao, filaSugestao);
		Atendedor atendedor = new Atendedor(filaReclamacao, filaSugestao, filaResolucao);
		Encaminhador encaminhador = new Encaminhador(filaResolucao);
		int opcao;

	
			
		try (Scanner sc = new Scanner(System.in)) {
			recebedor.setSc(sc);
			atendedor.setSc(sc);
			
			while (true) {
				System.out.println("---------------------------------------------------------------------------");
				System.out.println(
						"CANAL DE ATENDIMENTO - O QUE DESEJA REALIZAR?\n\n0 - ENCERRAR O PROGRAMA\n1 - RECEBIMENTO DE MENSAGEM\n2 - ATENDIMENTO DE MENSAGEM\n3 - RECEBIMENTO E ENCAMINHAMENTO DE RESOLUÇÃO");
				System.out.println("---------------------------------------------------------------------------\n");
				
				opcao = sc.nextInt();
				
				sc.nextLine();
				
				
				
				System.out.println();

				switch (opcao) {

				case 0:
					System.out.println("\nEncerrando...");
					System.exit(0);
					break;

				case 1:
					recebedor.receberTicket(recebedor.criarTicketUI());
					break;

				case 2:
					System.out.print("Deseja atender um ticket de qual natureza? (1 - reclamação, 2 - sugestão) ");
					Motivo naturezaAtendimento = Motivo.fromId(sc.nextInt());
					atendedor.atenderTicket(atendedor.recuperarTicketAtendimento(naturezaAtendimento));
					break;

				case 3:
					encaminhador.encaminharTicket();
					break;

				default:
					throw new IllegalArgumentException("Opcao invalida");
				}
				
				System.out.println();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
