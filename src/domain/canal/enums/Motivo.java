package domain.canal.enums;

public enum Motivo {

	RECLAMACAO(1),
	SUGESTAO(2);
	
	private int id;
	
	Motivo(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Motivo fromId(int id) {
		for(Motivo motivo : values()) {
			if(motivo.getId() == id) {
				return motivo;
			}
		}
		
		return null;
	}
	
}
