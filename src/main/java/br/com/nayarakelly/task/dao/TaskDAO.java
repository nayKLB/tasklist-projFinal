package br.com.nayarakelly.task.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.nayarakelly.task.model.Task;
import br.com.nayarakelly.task.exception.BusinessException;

/**
 * 
 * @author nayara
 * Classe DAO para acesso aos dados no BD
 */
public class TaskDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	public void saveTask(Task task) {
		entityManager.merge(task);
	}
	/* M�todo para deletar todas as Tasks com o titulo referido do filtro*/
	public void deleteTask(Task task) {
		try {
			task = findById(task.getId());
			entityManager.remove(task);
			entityManager.flush();
		} catch (Exception e) {
			throw new BusinessException("Tarefa n�o pode ser exclu�da");
		}
	}
	/* M�todo para listar todas as Tasks com o ID referido do filtro*/
	public Task findById(Long id) {
		return entityManager.find(Task.class, id);
	}
	/* M�todo para listar todas as Tasks com o titulo referido do filtro*/
	public Task findByTitleTask(String title) {
		return entityManager.find(Task.class, title);
	}
	
	/* M�todo para listar todas as Tasks*/
	public List<Task> listAllTasks(){
		return entityManager.createNativeQuery("SELECT * FROM TASK", Task.class).getResultList();
		
	}
}
