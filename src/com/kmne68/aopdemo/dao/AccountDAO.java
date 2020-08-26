package com.kmne68.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kmne68.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// simulate an exception
		if(tripWire) {
			throw new RuntimeException("Not allowed");
		}
		
		
		List<Account > accounts = new ArrayList<>();
		
		// create sample accounts
		Account accountOne = new Account("Frodo", "Silver");
		Account accountTwo = new Account("Sam", "Gold");
		Account accountThree = new Account("Merry", "Platinum");
		
		accounts.add(accountOne);
		accounts.add(accountTwo);
		accounts.add(accountThree);
		
		
		return accounts;
	}
	
	
	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}


	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING JDBC WORK: ADDING AN ACCOUNT");
		
	}
	
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;		
	}
	
	
	public void goToSleep() {
		System.out.println(getClass() + ": I am going to sleep now...");
	}
}
