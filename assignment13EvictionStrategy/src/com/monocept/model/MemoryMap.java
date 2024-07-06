package com.monocept.model;

import java.util.HashMap;
import java.util.Map;

public class MemoryMap{
	
	private EvictionStrategy evictionStrategy;
	private Map<String, Integer> memoryMap;
	private Map<Integer, String> insertionOrder;
	private Map<String, Integer>recentlyUsed;
    private int countInsertionOrder = 0;
	private int countRecentlyUsed = 0;
	

	public MemoryMap(EvictionStrategy evictionStrategy) {
		// TODO Auto-generated method stub
		this.evictionStrategy = evictionStrategy;
		this.memoryMap = new HashMap<>();
		this.insertionOrder = new HashMap<>();
		this.recentlyUsed = new HashMap<>();
	}
	
	public void get(String key) {
        if (memoryMap.containsKey(key)) {
        	memoryMap.put(key, memoryMap.get(key)+1);
        	recentlyUsed.put(key, countRecentlyUsed++);
        	System.out.println(key + " Read");
        }
    }
	
	public void put(String key, Integer value) {
        if(memoryMap.size() >= 3) {
        	evictionStrategy.evict(memoryMap, insertionOrder, recentlyUsed);
        }
        memoryMap.put(key, value);
        insertionOrder.put(countInsertionOrder++, key);
        System.out.println(key +" has added with value "+ value + " in memory Map");
    }
	
	public void printMemoryMap() {
        for (Map.Entry<String, Integer> entry : memoryMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
	
}
