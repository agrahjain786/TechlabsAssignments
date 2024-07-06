package com.monocept.model;

import java.util.Map;

public class FIFOEvictionStrategy implements EvictionStrategy{

	@Override
	public void evict(Map<String, Integer> memoryMap, Map<Integer, String> insertionOrder, Map<String, Integer>recentlyUsed) {
		
		int minInsertionOrder = Integer.MAX_VALUE;
        String keyToRemove = null;
        
        for (Map.Entry<Integer, String> entry : insertionOrder.entrySet()) {
            if (entry.getKey() < minInsertionOrder) {
                minInsertionOrder = entry.getKey();
                keyToRemove = entry.getValue();
            }
        }
        
        memoryMap.remove(keyToRemove);
        recentlyUsed.remove(keyToRemove);
        insertionOrder.remove(minInsertionOrder);
        System.out.println("Evicted (FIFO): " + keyToRemove);
		
	}

}
