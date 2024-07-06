package com.monocept.test;

import com.monocept.model.EvictionStrategy;
import com.monocept.model.FIFOEvictionStrategy;
import com.monocept.model.LFUEvictionStrategy;
import com.monocept.model.LRUEvictionStrategy;
import com.monocept.model.MemoryMap;

public class EvictionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Using FIFO Eviction Strategy:");
        EvictionStrategy fifoStrategy = new FIFOEvictionStrategy();
        MemoryMap memoryMapFIFO = new MemoryMap(fifoStrategy);
        runOperations(memoryMapFIFO);
        
        
        System.out.println("\nUsing LRU Eviction Strategy:");
        EvictionStrategy lruStrategy = new LRUEvictionStrategy();
        MemoryMap memoryMapLRU = new MemoryMap(lruStrategy);
        runOperations(memoryMapLRU);
        
        
        System.out.println("\nUsing LFU Eviction Strategy:");
        EvictionStrategy lfuStrategy = new LFUEvictionStrategy();
        MemoryMap memoryMapLFU = new MemoryMap(lfuStrategy);
        runOperations(memoryMapLFU);

	}

	private static void runOperations(MemoryMap memoryMap) {
		// TODO Auto-generated method stub
		
		memoryMap.put("a", 0);
        memoryMap.put("b", 0);
        memoryMap.put("c", 0);
        
        memoryMap.get("b");
        memoryMap.get("b");
        memoryMap.get("a");
        memoryMap.get("a");
        memoryMap.get("c");
        memoryMap.get("a");
        
        memoryMap.put("d", 0);
        
        memoryMap.printMemoryMap();
		
	}

}
