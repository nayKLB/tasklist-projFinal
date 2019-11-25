package br.com.nayarakelly.task.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 @author nayarakelly
 
 Classe relacionada a entidade TASK no BD
 **/

@Entity
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String title;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String description;
	private Date dtCriation;
	private Date dtEdition;
	private Date dtConclusion;
	
	/* Getters e Setters de todas as variáveis (todos as variáveis possuem nome igual no BD) */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDtCriation() {
		return dtCriation;
	}

	public void setDtCriation(Date dtCriation) {
		this.dtCriation = dtCriation;
	}

	public Date getDtEdition() {
		return dtEdition;
	}

	public void setDtEdition(Date dtEdition) {
		this.dtEdition = dtEdition;
	}

	public Date getDtConclusion() {
		return dtConclusion;
	}

	public void setDtConclusion(Date dtConclusion) {
		this.dtConclusion = dtConclusion;
	}

	/* Verifica se é um registro novo */
	public boolean isNovo() {
		return getId() == null ? true : false;
	}
	/* Verifica se é uma edição de um registro já existente*/
	public boolean isEdicao() {
		return !isNovo();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
