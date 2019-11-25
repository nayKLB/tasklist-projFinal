package br.com.nayarakelly.task.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nayarakelly.task.model.Task;
import br.com.nayarakelly.task.service.TaskService;
import br.com.nayarakelly.task.util.SFUtils;

/**
 * 
 * @author nayara
 *
 */
@Named("taskListMB")
@ViewScoped
public class TaskListMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private TaskService taskService;
	
	private List<Task> tasks = new ArrayList<>();	
	private List<Task> selectedTasks = new ArrayList<Task>();
	
	@PostConstruct
	public void init() {
		tasks = taskService.listAll();
	}
	
	public void deleteSelected() {
		
		for (Task task : selectedTasks) {
			taskService.delete(task);
			tasks.remove(task);
		}
		
		SFUtils.addMessage("Tarefa(s) deletadas(s) com sucesso!");
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Task> getSelectedTasks() {
		return selectedTasks;
	}

	public void setSelectedTasks(List<Task> selectedTasks) {
		this.selectedTasks = selectedTasks;
	}
	
	
}
