package com.stream.test.sparksqs;

class Employee {

	private static Employee emp;

	String name = "smart employee";

	@Override
	public String toString() {
		return name;
	}

	/**
	 * This finalize method is never invoked > once by JVM for any given object.
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("EMPLOYEE FINALIZED..");
		emp = this;
		System.out.println("this: " + this);
		System.out.println("emp: " + emp);
	}

	public static Employee getEmployee() {
		return emp;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Test extends Thread {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("THREAD FINALIZED..");
	}
}

public class GC {

	public static void main(String[] args) throws InterruptedException {
		Employee emp1 = new Employee();
		System.out.println("emp1: " + emp1.hashCode());
		emp1 = null;
		System.gc();
		Thread.sleep(1000);
		Employee emp2 = Employee.getEmployee();
		System.out.println("emp2: " + emp2.hashCode());
		emp2 = null;
		System.gc();
		Thread.sleep(1000);
		Employee emp3 = Employee.getEmployee();
		System.out.println("emp3: " + emp3.hashCode());
		emp2 = null;
		System.gc();
		Thread.sleep(1000);
		Test t1 = new Test();
		t1 = null;
		System.gc();
		Test t2 = new Test();
		t2 = null;
		System.gc();

	}
}
