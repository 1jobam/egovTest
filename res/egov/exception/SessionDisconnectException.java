package egov.exception;

/**
 * @ClassName : SessionDisconnectException.java
 * @Description :
 * @Modification Information
 * 
 * 2011. 8. 4. / ?��?��?�� / 최초?��?��
 *
 * @author KCC?��보통?�� / ?��?��?��
 * @since 2011. 8. 4.
 */
public class SessionDisconnectException extends Exception {

	private static final long serialVersionUID = -608969194671426800L;

	public SessionDisconnectException(Throwable e) {
		super(e);
	}

	public SessionDisconnectException(String message) {
		super(message);
	}
}
