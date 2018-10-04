package br.edu.unisep.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.UsuarioVO;

public class UsuarioDAO extends HibernateDAO<UsuarioVO>{

	public UsuarioVO consultar(String login) {
		
		Session session = HibernateSessionFactory.getSession();
		
		Query<UsuarioVO> q = session.createQuery("From UsuarioVO where login = :LOGIN", UsuarioVO.class);
		
		q.setParameter("LOGIN", login);
		
		UsuarioVO resultado = q.uniqueResult();
		
		session.close();
		
		return resultado;
		
	}
	
}
