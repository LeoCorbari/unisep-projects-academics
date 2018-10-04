package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.model.dao.ObjetoDAO;
import br.edu.unisep.model.vo.ObjetoVO;

@Named
@RequestScoped
public class EmprestimoBean {
	
	private ObjetoVO objeto = new ObjetoVO();
	
	private List<ObjetoVO> objetos;
	
	@Inject
	private AcessoBean acesso;
	
	@PostConstruct
	public void listar() {
		ObjetoDAO dao = new ObjetoDAO();
		objetos = dao.localizarEmprestimos(acesso.getUsuario().getLogin());
		
	}

	public String devolver() {
		HibernateDAO<ObjetoVO> dao = new HibernateDAO<>();
		objeto.setStatus(1);
		dao.alterar(objeto);
		
		return "listaEmprestimos?faces-redirect=true";
	}
	
	public String emprestar() {
		HibernateDAO<ObjetoVO> dao = new HibernateDAO<>();
		objeto.setStatus(2);
		
		dao.alterar(objeto);
		
		return "listaEmprestimos?faces-redirect=true";
	}
	
	public ObjetoVO getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoVO objeto) {
		this.objeto = objeto;
	}



	public List<ObjetoVO> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<ObjetoVO> objetos) {
		this.objetos = objetos;
	}
	
}
