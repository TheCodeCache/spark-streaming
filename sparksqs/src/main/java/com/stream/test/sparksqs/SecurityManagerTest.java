package com.stream.test.sparksqs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SecurityManagerTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setSecurityManager(new SecurityManager());
		new URL("http://www.google.com").openConnection().connect();
		System.out.println("hello");
	}
}
