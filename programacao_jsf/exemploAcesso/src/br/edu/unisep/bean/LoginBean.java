package br.edu.unisep.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

@Named
@RequestScoped
@FacesConfig(version=Version.JSF_2_3)
public class LoginBean {

	private String usuario;
	
	private String senha;
	
	@Inject
	private ExternalContext context; //Objeto que existe apenas uma instancia é SingleTom
	
	public String entrar() {
		
		//Recupera o Objeto da requisição
		HttpServletRequest req = (HttpServletRequest) context.getRequest();
		
		//COnverte a senha para cirptografia MD5
		String senhaMD5 = DigestUtils.md5Hex(senha);
		
		try {
			req.logout();
			
			// Dispara o processo de verificação do Login pelo servidor
			// utilizando as configurações definidas no arquivo META-INF/context.xml
			req.login(usuario, senhaMD5);
			
			if (req.isUserInRole("ADMIN")) {
				return "admin/telaAdmin?faces-redirect=true";
				
			} else {
				return "cliente/telaCliente?faces-redirct=true";
			}
			
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "login";

	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
