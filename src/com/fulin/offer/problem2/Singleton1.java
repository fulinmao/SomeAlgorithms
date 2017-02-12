package com.fulin.offer.problem2;

/**
 * 仅适用于单线程的环境
 * @author mfl4482
 *
 */
public class Singleton1 extends Singleton{

	private static Singleton1 instance = null;

	private Singleton1(){
		System.out.println("构建SingleTon1实例");
	}

	public static Singleton1 getInstance(){
		if(instance == null){
//			try {
//				Thread.sleep(1000L * 1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			instance = new Singleton1();
		}

		return instance;
	}

	public void run(){
		System.out.println("run Singleton1");
	}

}