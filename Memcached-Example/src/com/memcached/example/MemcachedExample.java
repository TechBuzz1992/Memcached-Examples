package com.memcached.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;

public class MemcachedExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		System.out.println("Memcached server started...");
		System.out.println("Set status:" + mcc.set("key1", 9000, "value1").isDone());
		System.out.println("Get status:" + mcc.get("key1"));
		System.out.println("Memcahed Name is:" + mcc.getName());
		System.out.println("Is it alive now?:" + mcc.isAlive());
		mcc.shutdown();
		System.out.println("shutting down memcache...");
		for (int i = 0; i < 8; i++)
			System.out.println("Is it alive now?:" + mcc.isAlive());
		try {
			System.out.println("Get status:" + mcc.get("key1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		MemcachedClient mcc1 = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		System.out.println("Memcached server started...");
		System.out.println("Get status:" + mcc1.get("key1"));

		mcc1.flush();
		System.out.println("Get status after flushing:" + mcc1.get("key1"));

	}

}
