package com.censusapp.exceptions;

import com.censusapp.constant.Constants;

public class UpdateEntryException extends Exception {
	private static final long serialVersionUID = 1L;

	public UpdateEntryException() {
		super(Constants.failedToUpdateMember);
	}
}	
