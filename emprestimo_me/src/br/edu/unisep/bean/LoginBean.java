package br.edu.unisep.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import br.edu.unisep.model.dao.UsuarioDAO;
import br.edu.unisep.model.vo.UsuarioVO;

@Named
@RequestScoped
@FacesConfig(version=Version.JSF_2_3)
public class LoginBean {

	private String login;
	
	private String senha;
	
	@Inject
	private ExternalContext context;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private AcessoBean acesso;
	
	public String entrar() {
		
		HttpServletRequest req = (HttpServletRequest) context.getRequest();
		
		try {
			
			req.login(login, DigestUtils.md5Hex(senha));
			
			UsuarioDAO dao = new UsuarioDAO();
			UsuarioVO usuario = dao.consultar(login);
			
			acesso.setUsuario(usuario);
			
		} catch (ServletException e) {
			facesContext.addMessage("login", new FacesMessage("Login invalido!"));
			e.printStackTrace();
			
			return "login";
		}
		
		return "app/listaObjetos?faces-redirect=true";
	}

	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
