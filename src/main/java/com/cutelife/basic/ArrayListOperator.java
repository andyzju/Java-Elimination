package com.cutelife.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayListOperator {
	
	public ArrayList<Integer> removeDuplicates(ArrayList<Integer> alist){
		
		HashSet<Integer> hs=new HashSet<Integer>(alist);
		alist.clear();
		alist.addAll(hs);
		
		return alist;
		
	}
	public static void main(String args[]){
		ArrayList<Integer> alist=new ArrayList<Integer>();
		alist.add(6);
		alist.add(5);
		alist.add(4);
		alist.add(3);
		alist.add(2);
		alist.add(6);
		alist.add(5);
		alist.add(3);
		
		alist=new ArrayListOperator().removeDuplicates(alist);
		
		for(Iterator it=alist.iterator();it.hasNext();){
			System.out.print(it.next());
		}
		
	}

}
