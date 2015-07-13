package com.test;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Action a= new Action("test", "test", "test"); // new Action(); <- 이게 객체생성  () 이게 생성자 
		
		System.out.println(a.label);
		System.out.println(a.time);
		
		/* 사칙연산 분모의 값이 0일때, if문 익히기
		int a = 5, b= 0;
		 		
		System.out.println(a+b);
		System.out.println(a-b);
		if(b==0){
			System.out.println("0");
		}
		else{
			System.out.println(a/b);
		}
		System.out.println(a*b);
		*/
		
		/* for문 익히기 1
		int a=10;
		int sum =0;
		
		for(int i=0; i<a; i++)
			
			System.out.println(i);
			
		*/
		
		/* for문 익히기 2
		int a = 10;
		int sum = 0;
		
		for(int i=0; i<=a; i++)
		{
			sum += i;
		}
		
		System.out.println(sum);
		*/
		
		/* for문 익히기 3
		int a = 10;
		int sum = 0;
		
		for(int i=0; i<=a; sum += i , i++)
			;
		
		System.out.println(sum);
		*/
		
		/* while문 익히기
		int a = 10;
		int sum = 0;
		int i = 0;
		
		while(i <= a)
		{
			sum += i;
			i++;
		}
		System.out.println(sum);
		*/
		
		/* 배열 익히기 1
		int[] arr = new int[10]; //0번째부터, 초기값은 0
		arr[0] = 1;
		arr[9] = 10;
		
		for(int i=0; i<arr.length; ++i)
			System.out.println(arr[i]);
		*/
		
		/* 배열 익히기 2 역차순
		int[] arr = new int[10]; //0번째부터, 초기값은 0
		arr[0] = 4;
		arr[1] = 6;
		arr[2] = 9;
		arr[3] = 3;
		arr[4] = 1;
		arr[5] = 2;
		arr[6] = 5;
		arr[7] = 15;
		arr[8] = 22;
		arr[9] = 8;
		
		for(int i=9; i>=0; i--)
			System.out.println(arr[i]);
		
		*/
		
		/* 배열익히기 3 오름차순 퀵소트
		int[] arr = new int[10]; //0번째부터, 초기값은 0

		arr[0] = 4;
		arr[1] = 6;
		arr[2] = 9;
		arr[3] = 3;
		arr[4] = 1;
		arr[5] = 2;
		arr[6] = 5;
		arr[7] = 15;
		arr[8] = 22;
		arr[9] = 8;
		
		Arrays.sort(arr);
		
		//for(int i : arr ) 자동으로 오름차순으로 배열해줌.
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		*/
		
		/* 0~50까지 숫자에서 3의 배수만 출력
		int a= 50;
		
		for(int i=0; i<=a; i++)
			if(i%3==0){
				System.out.println(i);
			}
		*/
		
		
	}
}