package com.cutelife.basic;

import java.util.Map;
import java.util.Map.Entry;

public class HashMap<K, V> {

	private final int MAXIMUM_CAPACITY = 100;
	private double loadFactor;
	private int threshold;
	private Entry table[];

	/*static class Entry<K, V> implements Map.Entry<K, V> {

		private K key;
		private V value;
		private Entry next;

		public void setKey() {
			this.key = key;
		}

		@Override
		public K getKey() {

			return this.key;
		}

		@Override
		public V getValue() {

			return this.value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return this.value;
		}

	}*/

	public HashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException(
					"IllegalArgument initialCapacity::" + initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if(loadFactor<=0||Float.isNaN(loadFactor))
			throw new IllegalArgumentException("IllegalArgumentException::"+loadFactor);
		
		int capacity=1;
		if(capacity<initialCapacity)
			capacity<<=1;
		
		this.loadFactor=loadFactor;
		
	    threshold = (int)(capacity*loadFactor);
	    
	    table=new Entry[capacity];
	    //init();

	}

}
