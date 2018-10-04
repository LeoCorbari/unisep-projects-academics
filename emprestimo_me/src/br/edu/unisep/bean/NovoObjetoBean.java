package br.edu.unisep.bean;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.model.vo.CategoriaVO;
import br.edu.unisep.model.vo.ObjetoVO;

@Named
@RequestScoped
public class NovoObjetoBean {

	@Inject
	private AcessoBean acesso;
	
	private ObjetoVO objeto = new ObjetoVO();
	
	@PostConstruct
	public void iniciar() {
		this.objeto.setIdCategoria(new CategoriaVO());
	}
	
	public String salvar() {
		
		HibernateDAO<ObjetoVO> dao = new HibernateDAO<>();
		
		LocalDate local = LocalDate.now();
		
		objeto.setLogin(acesso.getUsuario().getLogin());
		objeto.setDataCadastro(local);
		objeto.setStatus(1);
		
		dao.salvar(objeto);
		
		objeto = new ObjetoVO();
		
		return "listaObjetos?faces-redirect=true";
		
	}

	public ObjetoVO getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoVO objeto) {
		this.objeto = objeto;
	}
	
}
