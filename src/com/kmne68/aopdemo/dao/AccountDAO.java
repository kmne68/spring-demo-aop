package com.kmne68.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.kmne68.aopdemo.Account;

@Component
public class AccountDAO {

	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING JDBC WORK: ADDING AN ACCOUNT");
		
	}
}
