package co.com.aptamob.core.exception;

import javax.ws.rs.WebApplicationException;

/**
 * User: porter
 * Date: 03/05/2012
 * Time: 12:27
 */
public class NotFoundException extends WebApplicationException {

    public NotFoundException() {
        super(404);
    }
}
