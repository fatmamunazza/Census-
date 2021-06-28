package com.censusapp.exceptions;

import java.sql.SQLException;

import com.censusapp.constant.Constants;

public class UpdateRelationshipException extends Exception {
	public UpdateRelationshipException(SQLException e) {
		super(Constants.failedToSetRelationship + " : " + e);
	}
}
