package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.model.vo.ObjetoVO;

@Named
@RequestScoped
public class ListaObjetosBean {
	
	private ObjetoVO objeto = new ObjetoVO();

	private List<ObjetoVO> objetos;
	
	@PostConstruct
	public void listar() {
		HibernateDAO<ObjetoVO> dao = new HibernateDAO<>();
		this.objetos = dao.listar(ObjetoVO.class);
		
	}

	public List<ObjetoVO> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<ObjetoVO> objetos) {
		this.objetos = objetos;
	}

	public ObjetoVO getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoVO objeto) {
		this.objeto = objeto;
	}
	
	
}
