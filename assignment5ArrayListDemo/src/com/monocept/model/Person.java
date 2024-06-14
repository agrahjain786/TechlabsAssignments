package com.monocept.model;

import java.util.Objects;

public class Person {
	
	private String name;
	private int age;
	private String address;
	
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	public String toString() {
        return "Person [Name=" + name + ", Age=" + age + ", Address=" + address + "]";
    }
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

}
