package com.fulin.offer.problem2;

public class Singleton3 extends Singleton {

	private static Singleton3 instance = null;

	private Singleton3(){
		System.out.println("构建Singleton3");
	}

	public static Singleton3 getInstance(){
		if(instance == null){
			synchronized (Singleton3.class) {
				if(instance == null){
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}

	public void run(){
		System.out.println("run Singleton3");
	}
}