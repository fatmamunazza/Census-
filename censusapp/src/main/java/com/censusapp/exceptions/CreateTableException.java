package com.censusapp.exceptions;

import java.sql.SQLException;

import com.censusapp.constant.Constants;

public class CreateTableException extends Exception {
	private static final long serialVersionUID = 1L;

	public CreateTableException(SQLException e) {
		super(Constants.failedToCreateMemberInfoTable + ":" + e.toString());
	}
}
