package br.com.nayarakelly.task.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nayarakelly.task.model.Task;
import br.com.nayarakelly.task.service.TaskService;

@Named("registerTaskMB")
@ViewScoped
public class RegisterTaskMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Task task =  new Task();
	private Long idTask;
	
	@Inject
	private TaskService taskService;
	
	public void init() {
		if (idTask != null) {
			task = taskService.findById(idTask);
		}
	}
	
	public String save() {
		taskService.save(task);
		return "lista-task.xhtml?faces-redirect=true";
	}
	
	public String delete() {
		taskService.delete(task);
		return "lista-task.xhtml?faces-redirect=true";
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}
	
	
}

