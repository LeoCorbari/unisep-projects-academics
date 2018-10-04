package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.model.vo.CategoriaVO;

@Named
@RequestScoped
public class ListaCategoriaBean {

	private List<CategoriaVO> categorias;
	
	@PostConstruct
	public void listar() {
		HibernateDAO<CategoriaVO> dao = new HibernateDAO<>();
		categorias = dao.listar(CategoriaVO.class);
	}

	public List<CategoriaVO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaVO> categorias) {
		this.categorias = categorias;
	}
	
}
