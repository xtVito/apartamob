package co.com.aptamob.core.exception;

import co.com.aptamob.core.base.exception.BaseWebApplicationException;

public class ApplicationRuntimeException extends BaseWebApplicationException {

    public ApplicationRuntimeException(String applicationMessage) {
        super(500, "50002", "Ocurrió un error en el sistema", applicationMessage);
    }
}
