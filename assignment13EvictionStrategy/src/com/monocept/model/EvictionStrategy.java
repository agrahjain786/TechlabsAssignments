package com.monocept.model;

import java.util.Map;

public interface EvictionStrategy {
	
	void evict(Map<String, Integer>memoryMap, Map<Integer, String> insertionOrder, Map<String, Integer>recentlyUsed);

}
