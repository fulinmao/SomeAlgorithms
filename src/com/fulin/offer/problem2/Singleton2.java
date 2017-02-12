package com.fulin.offer.problem2;

public class Singleton2 extends Singleton {

	private static Singleton2 instance = null;

	private Singleton2(){
		System.out.println("构建singleton2 ");
	}

	public void run(){
		System.out.println("run Singleton2");
	}

	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
}