package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.edu.unisep.hibernate.HibernateDAO;
import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.ObjetoVO;

public class ObjetoDAO extends HibernateDAO<ObjetoVO>{

	public List<ObjetoVO> localizarEmprestimos(String login){
		
		Session session = HibernateSessionFactory.getSession();
				
		Query<ObjetoVO> q = session.createQuery("From ObjetoVO where status = 2 and login = :LOGIN", ObjetoVO.class);
		
		q.setParameter("LOGIN",	login); 
		
		List<ObjetoVO> objetos = q.list();
		
		session.close();
		
		return objetos;
		
	}
	
}
