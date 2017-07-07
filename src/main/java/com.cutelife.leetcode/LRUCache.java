package com.cutelife.leetcode;

/**
 * used an LinkedList with pre and next to record the LRU strategy
 * 
 * HashMap to record the key value
 */
import java.util.HashMap;

class Node{
	int key;
	int value;
	Node pre;
	Node next;
    public Node(int key,int value){
		this.key=key;
		this.value=value;
		pre=null;
		next=null;
	}
	public Node(){
	    this.key=0;
	    this.value=0;
	    pre=null;
	    next=null;
	}
}
public class LRUCache {
	
	HashMap<Integer,Node> map;
	int size;
	
	Node head=new Node();
	Node tail=new Node();
	
	public LRUCache(int capacity){
		map=new HashMap<Integer,Node>(capacity);
		this.size=capacity;
		head.next=tail;
		tail.pre=head;
	}
	
	/*
	 * get the value from map
	 */
	public int get(int key){
		if(map.containsKey(key)){
			Node p=map.get(key);
			putToHead(p);
			return p.value;
		}else
			return -1;
		
	}
	/**
	 * 1. No key then insert( replace / no need to replace) 2. contains the key, reset
	 * 
	 * @param key
	 * @param value
	 */
	public void set(int key,int value){
		if(map.containsKey(key)){
			Node p=map.get(key);
			p.value=value;
			//map.put(key, p); // need or not
			putToHead(p);
		}else{
			Node p=new Node(key,value);
			if(map.size()<size){ // not full
				
				map.put(key,p);
				putToHead(p);
			}else{ // 1. removed 2. putToHead
				int replaceKey=removedEnd();
				map.remove(replaceKey);
				map.put(key, p);
				putToHead(p);
			}
		}
		
	}
	public void putToHead(Node p){
		if(p.next!=null&&p.pre!=null)
		{
			p.pre.next=p.next;
			p.next.pre=p.pre;
		}
		
		p.next=head.next;
		head.next.pre=p;
		head.next=p;
		p.pre=head;
	}
	
	public int removedEnd(){
		Node p=tail.pre;
		p.pre.next=tail;
		tail.pre=p.pre;
		
		p.pre=null;
		p.next=null;
		
		return p.key;
		
	}

	public static void main(String args[]){
		LRUCache lru=new LRUCache(1);
	
		lru.set(2,1);
		System.out.println(lru.get(2));
		lru.set(3,22);
		System.out.println(lru.get(2));
		lru.set(3,33);
		
		System.out.println(lru.get(1));
		
	}
}
