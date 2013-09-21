package com.avijit.poc.standalone.designpatterns.observer;

public class AccountBalanceChangeEmailer implements Observer {

	private Observable observable;
	
	public AccountBalanceChangeEmailer(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}
	
	@Override
	public void notifyObserver() {
		if (observable instanceof Account) {
			System.out.println("EMAIL ACCOUNT BALANCE CHANGE, NEW ACCOUNT BALANCE: " + ((Account)observable).getAccountBalance());
		}
	}

}
