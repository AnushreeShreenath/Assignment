package com.springboot.crud.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
	public RecordNotFoundException()
	{
	}
	
	public RecordNotFoundException(String msg)
	{
		super(msg);
	}
}