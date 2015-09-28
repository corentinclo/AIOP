package fr.polytech.todo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class TodoDAO {
	
	@PersistenceContext(unitName="MyPU")
	private EntityManager em;
	
	public TodoDAO() {
	}
	
	public void create(Todo todo) {
		em.persist(todo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Todo> all() {
		return em.createQuery("SELECT t FROM Todo t").getResultList();
	}
	
	public Todo findById(long id) {
		return em.find(Todo.class, id);
	}
	
	public void update(Todo todo) {
		em.merge(todo);
	}
}
