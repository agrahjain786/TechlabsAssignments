package com.monocept.model;

import java.util.Map;

public class LFUEvictionStrategy implements EvictionStrategy{

	@Override
	public void evict(Map<String, Integer> memoryMap, Map<Integer,String> insertionOrder, Map<String, Integer>recentlyUsed) {
		// TODO Auto-generated method stub
		
        int minCount = Integer.MAX_VALUE;
        String keyToRemove = null;
        
        for (Map.Entry<String, Integer> entry : memoryMap.entrySet()) {
            if (entry.getValue() < minCount) {
                minCount = entry.getValue();
                keyToRemove = entry.getKey();
            }
        }
        
        memoryMap.remove(keyToRemove);
        recentlyUsed.remove(keyToRemove);
        insertionOrder.values().remove(keyToRemove);
        System.out.println("Evicted (LFU): " + keyToRemove);
		
	}

}
