package com.monocept.model;

import java.util.Map;

public class LRUEvictionStrategy implements EvictionStrategy{

	@Override
	public void evict(Map<String, Integer> memoryMap, Map<Integer, String> insertionOrder, Map<String, Integer>recentlyUsed) {
		// TODO Auto-generated method stub
		
		int leastUse = Integer.MAX_VALUE;
        String keyToRemove = null;
        
        for (Map.Entry<String, Integer> entry : recentlyUsed.entrySet()) {
            if (entry.getValue() < leastUse) {
            	leastUse = entry.getValue();
                keyToRemove = entry.getKey();
            }
        }
        
        memoryMap.remove(keyToRemove);
        recentlyUsed.remove(keyToRemove);
        insertionOrder.values().remove(keyToRemove);
        System.out.println("Evicted (LRU): " + keyToRemove);
		
	}

}
