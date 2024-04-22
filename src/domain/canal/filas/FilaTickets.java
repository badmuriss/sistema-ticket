package domain.canal.filas;

import java.util.NoSuchElementException;

import domain.canal.Ticket;

public class FilaTickets {

	
		private class NO {
			Ticket dado;
			NO prox;
		}
		
		NO ini, fim;

		public void init() {
			ini = fim = null;
		}
		
		public boolean isEmpty() {
			return (ini==null && fim==null);
		}
		
		public void enqueue(Ticket elem) {
				NO novo = new NO();
				novo.dado = elem;
				novo.prox = null;
				if(isEmpty()) {
					ini = novo;
				} else {
					fim.prox = novo;
				}
				
				fim = novo;
		
		}
		
		public Ticket first() {
			return ini.dado;
		}
		
		public Ticket dequeue() {
			if(isEmpty()) {
				throw new NoSuchElementException("A fila está vazia");
			}
			Ticket elem = ini.dado;
			ini = ini.prox;
			if(ini==null) {
				fim=null;
			}
			
			
			return elem;
		}
		
	}