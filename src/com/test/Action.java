package com.test;

public class Action {
	public String label, temp, time;
	
	public Action() // Action�̶�� �����ڸ� ���� ���ؼ��� �⺻ �������� �̰��� ���� �־��־�� �Ѵ�.
	{
		label = null;
		temp = null;
		time = null;
	}
	
	public Action(String label, String temp, String time)
	{
		this. label = label; // this��� ���� ���⿡ �ִ�  �Լ��� ����Ѵٴ� ���̴�.
		this. temp = temp;
		this. time = time;
	}
}
