package com.practice.test.model;

public class User {
	
	// Es mala práctica utilizar datos primitivos como int, vease product Model
	private int id;
	private String name;
	private Integer age;
	private String password;
	private String greeting;
	
	/**
	 * @param i
	 * @param name
	 * @param age
	 * @param password
	 * @param greeting
	 */
	public User(int id, String name, Integer age, String password, String greeting) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		this.greeting = greeting;
	}
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}
	/**
	 * @param greeting the greeting to set
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
