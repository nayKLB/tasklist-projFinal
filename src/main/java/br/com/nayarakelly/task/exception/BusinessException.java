package br.com.nayarakelly.task.exception;

/**
 * 
 * @author nayara
 * Classe Exception para tratar mensagem de exce��o no sistema e trazer a mensagem correta do erro
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException (String msg) {
		super(msg);
	}

}
