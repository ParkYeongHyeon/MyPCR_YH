package com.test;

public class Action {
	public String label, temp, time;
	
	public Action() // Action이라는 생성자를 쓰기 위해서는 기본 생성자인 이것을 먼저 넣어주어야 한다.
	{
		label = null;
		temp = null;
		time = null;
	}
	
	public Action(String label, String temp, String time)
	{
		this. label = label; // this라는 것은 여기에 있는  함수를 사용한다는 것이다.
		this. temp = temp;
		this. time = time;
	}
}
