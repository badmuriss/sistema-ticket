package domain.canal.filas;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import domain.canal.Ticket;

public class FilaTickets {

		
		List<Ticket> dados = new LinkedList<>();
		int ini, cont;

		public void init() {
			ini = cont = 0;
		}
		
		public boolean isEmpty() {
			return (cont==0);
		}
		
		public void enqueue(Ticket elem) {
				dados.add(elem);
				cont++;
		
		}
		public Ticket dequeue() {
			if(isEmpty()) {
				throw new NoSuchElementException("A fila está vazia");
			}
			Ticket elem = dados.get(0);
			dados.remove(0);
			cont--;
			return elem;
		}
		
	}