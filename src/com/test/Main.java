package com.test;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Action a= new Action("test", "test", "test"); // new Action(); <- �̰� ��ü����  () �̰� ������ 
		
		System.out.println(a.label);
		System.out.println(a.time);
		
		/* ��Ģ���� �и��� ���� 0�϶�, if�� ������
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
		
		/* for�� ������ 1
		int a=10;
		int sum =0;
		
		for(int i=0; i<a; i++)
			
			System.out.println(i);
			
		*/
		
		/* for�� ������ 2
		int a = 10;
		int sum = 0;
		
		for(int i=0; i<=a; i++)
		{
			sum += i;
		}
		
		System.out.println(sum);
		*/
		
		/* for�� ������ 3
		int a = 10;
		int sum = 0;
		
		for(int i=0; i<=a; sum += i , i++)
			;
		
		System.out.println(sum);
		*/
		
		/* while�� ������
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
		
		/* �迭 ������ 1
		int[] arr = new int[10]; //0��°����, �ʱⰪ�� 0
		arr[0] = 1;
		arr[9] = 10;
		
		for(int i=0; i<arr.length; ++i)
			System.out.println(arr[i]);
		*/
		
		/* �迭 ������ 2 ������
		int[] arr = new int[10]; //0��°����, �ʱⰪ�� 0
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
		
		/* �迭������ 3 �������� ����Ʈ
		int[] arr = new int[10]; //0��°����, �ʱⰪ�� 0

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
		
		//for(int i : arr ) �ڵ����� ������������ �迭����.
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		*/
		
		/* 0~50���� ���ڿ��� 3�� ����� ���
		int a= 50;
		
		for(int i=0; i<=a; i++)
			if(i%3==0){
				System.out.println(i);
			}
		*/
		
		
	}
}