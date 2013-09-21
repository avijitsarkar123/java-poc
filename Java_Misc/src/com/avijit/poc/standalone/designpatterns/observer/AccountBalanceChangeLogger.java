package com.avijit.poc.standalone.designpatterns.observer;

public class AccountBalanceChangeLogger implements Observer {

	private Observable observable;
	
	public AccountBalanceChangeLogger(Observable observable) {
		this.observable = observable;
		observable.registerObserver(this);
	}
	
	@Override
	public void notifyObserver() {
		if (observable instanceof Account) {
			System.out.println("LOG ACCOUNT BALANCE CHANGE, NEW ACCOUNT BALANCE: " + ((Account)observable).getAccountBalance());
		}
	}

}
