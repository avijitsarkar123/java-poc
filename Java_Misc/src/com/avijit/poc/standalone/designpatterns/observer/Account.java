package com.avijit.poc.standalone.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Account implements Observable {
	private double accountBalance;
	
	
	private List<Observer> observersList = new ArrayList<Observer>();
	
	public double getAccountBalance() {
		return accountBalance;
	}

	public void updateAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observersList.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		observersList.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for (Observer observer : observersList) {
			observer.notifyObserver();
		}
	}
}
