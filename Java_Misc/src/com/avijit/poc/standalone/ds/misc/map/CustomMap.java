package com.avijit.poc.standalone.ds.misc.map;

import java.util.Arrays;

public class CustomMap<K,V> {
	private static final int DEFAULT_SIZE = 10;
	private Entry<K, V>[] buckets = null;
	
	public CustomMap() {
		buckets = new Entry[DEFAULT_SIZE];
	}
	
	private int getBucketSlotForKey(Entry<K, V> newEntry){
		return Math.abs(newEntry.hashCode() % buckets.length);  
	}
	
	public V get(K key) {
		
		int bucketIndex = getBucketSlotForKey(new Entry<K, V>(key, null));
		
		if (buckets[bucketIndex] == null) {
			return null;
		} else {
			
			Entry<K, V> firstEntry = buckets[bucketIndex];
			
			while (!firstEntry.getKey().equals(key)) {
				firstEntry = firstEntry.getNext();
			}
			
			return firstEntry.getValue();
		}
	}
	
	public void put(K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		newEntry.setNext(null);
		
		int bucketIndex = getBucketSlotForKey(newEntry);
		
		if (buckets[bucketIndex] == null) {
			buckets[bucketIndex] = newEntry;
			return;
		}
		
		Entry<K, V> firstEntry = buckets[bucketIndex];
		
		while(!firstEntry.equals(newEntry) && firstEntry.getNext() != null) {
			firstEntry = firstEntry.getNext();
		}
		
		if (firstEntry.equals(newEntry)) {
			firstEntry.setValue(value);
		} else {
			firstEntry.setNext(newEntry);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Map [buckets=");
		builder.append(Arrays.toString(buckets));
		builder.append("]");
		return builder.toString();
	}
}
