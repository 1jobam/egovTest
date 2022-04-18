package egov.exception;

/**
 * @ClassName : SessionDisconnectException.java
 * @Description :
 * @Modification Information
 * 
 * 2011. 8. 4. / ?ù¥?û¨?õê / ÏµúÏ¥à?Éù?Ñ±
 *
 * @author KCC?†ïÎ≥¥ÌÜµ?ã† / ?ù¥?û¨?õê
 * @since 2011. 8. 4.
 */
public class AjaxSessionDisconnectException extends Exception {

	private static final long serialVersionUID = -608969194671426800L;

	public AjaxSessionDisconnectException(Throwable e) {
		super(e);
	}

	public AjaxSessionDisconnectException(String message) {
		super(message);
	}
}
