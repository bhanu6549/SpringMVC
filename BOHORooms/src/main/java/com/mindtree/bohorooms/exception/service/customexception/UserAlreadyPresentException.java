package com.mindtree.bohorooms.exception.service.customexception;

import com.mindtree.bohorooms.exception.service.BOHORoomsServiceApplicationException;

public class UserAlreadyPresentException extends BOHORoomsServiceApplicationException {

	public UserAlreadyPresentException() {
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyPresentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyPresentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyPresentException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyPresentException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
