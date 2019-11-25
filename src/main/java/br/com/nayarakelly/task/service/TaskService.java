package br.com.nayarakelly.task.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.nayarakelly.task.dao.TaskDAO;
import br.com.nayarakelly.task.model.Status;
import br.com.nayarakelly.task.model.Task;
import br.com.nayarakelly.task.util.TransactionalInterceptor;
/**
 * 
 * @author nayara
 */
@Interceptors(TransactionalInterceptor.class)
public class TaskService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private TaskDAO taskDAO;
	
	/*Salva a Task verificando se é um regitro novo ou uma edição.*/
	public void save(Task task) {
		if (task.isNovo()) {
			task.setDtCriation(new Date());
		}
		
		if (task.isEdicao()) {
			task.setDtEdition(new Date());
		}
		
		if ((task.getDtConclusion()==null) && (task.getStatus().getDescription() == Status.ENCERRADO.getDescription())) {
			task.setDtConclusion(new Date());
		}
		
		taskDAO.saveTask(task);
	}
	
	/*Deleta o registro da Task*/
	public void delete(Task task) {
		taskDAO.deleteTask(task);
		
	}
	
	/*Lista todas as Tasks*/
	public List<Task> listAll(){
		return taskDAO.listAllTasks();
	}
	
	/*Busca a Task pelo ID*/
	public Task findById(Long id) {
		return taskDAO.findById(id);
	}
	
	/*Busca a Task pelo título*/
	public Task findByTitle(String title) {
		return taskDAO.findByTitleTask(title);
	}
}

