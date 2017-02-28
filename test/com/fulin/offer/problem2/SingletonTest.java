/**
 * 
 */
package com.fulin.offer.problem2;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * @author mfl4482
 *
 */
public class SingletonTest {

	@Test
	public void test() {
		Singleton2 instance = Singleton2.getInstance();
		instance.run();
	}

	@Test
	public void testMultiThread(){
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<?> t1 = pool.submit(new SingletonRunnable());
		Future<?> t2 = pool.submit(new SingletonRunnable());
//		if(t1.isDone() && t2.isDone()){
			pool.shutdown();
//			System.out.println("done");
//		}
	}
}

class SingletonRunnable implements Runnable{

	@Override
	public void run() {
		Singleton instance = Singleton3.getInstance();
		instance.run();
	}
	
}
