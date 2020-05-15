package com.kmne68.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	
	public void addAccount() {
		
		System.out.println(getClass() + ": DOING JDBC WORK: ADDING AN ACCOUNT");
		
	}
}
