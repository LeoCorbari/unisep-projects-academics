package br.edu.unisep.model.vo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "papeis_usuario")
public class PapelUsuarioVO {

	@EmbeddedId
	private PapelUsuarioPK id;

	public PapelUsuarioPK getId() {
		return id;
	}

	public void setId(PapelUsuarioPK id) {
		this.id = id;
	}	
}
