package br.com.nayarakelly.task.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class SFUtils {

	public static void addMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}

}