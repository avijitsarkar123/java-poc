package com.avijit.poc.standalone.designpatterns.observer;

public class Client {
	public static void main(String args[]) {
		Account account = new Account();
		
		AccountBalanceChangeLogger accountBalanceChangeLogger = new AccountBalanceChangeLogger(account);
		
		account.updateAccountBalance(10.00);
		
		AccountBalanceChangeEmailer accountBalanceChangeEmailer = new AccountBalanceChangeEmailer(account);
		
		account.updateAccountBalance(20.00);
	}
}
