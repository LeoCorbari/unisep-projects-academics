package br.edu.unisep.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.edu.unisep.model.vo.UsuarioVO;

@Named
@SessionScoped
public class AcessoBean implements Serializable{
	
	private UsuarioVO usuario;

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	
	
}
