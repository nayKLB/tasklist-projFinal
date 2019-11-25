package br.com.nayarakelly.task.model;

/**
 * 
 * @author nayara
 * Classe Enum para garantir os tipos de Status Pré-Existentes
 */
public enum Status {
	
	ANDAMENTO("Em Andamento"),
	ENCERRADO("Encerrado");

	private String description;

	/*Construtor para iniciar os atributos declarados.*/
	Status(String description) {
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
