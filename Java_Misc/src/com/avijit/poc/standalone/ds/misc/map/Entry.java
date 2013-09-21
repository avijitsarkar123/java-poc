package com.avijit.poc.standalone.ds.misc.map;

public class Entry<K, V> {
	private final K key;
	private V value;
	
	private Entry<K,V> nextEntry;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K,V> getNext() {
		return nextEntry;
	}
	
	public void setNext(Entry<K,V> nextEntry) {
		this.nextEntry = nextEntry;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == null) {
			return false;
		}
		
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Entry)) {
			return false;
		}
		
		Entry<K, V> other = (Entry<K, V>) o;
		
		
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else {
			if (!value.equals(other.value)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entry [key=");
		builder.append(key);
		builder.append(", value=");
		builder.append(value);
		if (nextEntry != null) {
			builder.append(", ");
			builder.append(nextEntry);
		}
		builder.append("]");
		return builder.toString();
	}
}
