package com.dan.serenity.factories;

import com.dan.serenity.entity.User;
import com.dan.serenity.entity.User;
import com.dan.serenity.utils.FieldGenerator;

public class Factory {
	
	public static User generateUser(){
		
		User user = new User();
		user.setFirstname(FieldGenerator.generateStringValue(10, FieldGenerator.TypeOfString.ALPHANUMERIC));
		user.setLastname(FieldGenerator.generateStringValue(10, FieldGenerator.TypeOfString.ALPHANUMERIC));
		user.setEmail(FieldGenerator.generateStringValue(10, FieldGenerator.TypeOfString.ALPHANUMERIC) + "@dan.com");
		user.setPassword(FieldGenerator.generateStringValue(10, FieldGenerator.TypeOfString.ALPHANUMERIC));
		
		return user;
	}

}
