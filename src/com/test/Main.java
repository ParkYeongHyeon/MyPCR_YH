package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.codeminders.hidapi.HIDManager;
import com.hidapi.CallbackDeviceChange;
import com.hidapi.DeviceChange;
import com.hidapi.HidClassLoader;

public class Main implements DeviceChange{
	
	static
	{
		if( !HidClassLoader.LoadLibrary())
		{
			JOptionPane.showMessageDialog(null, "This OS is not supported!");
		}
	}
	private CallbackDeviceChange deviceChange = null;
	private HIDManager manager = null;
	
	public Main()
	{
		try
		{
			manager = HIDManager.getInstance(); 
		}catch(IOException e){
			System.out.println("��������");
		}
		
		deviceChange = CallbackDeviceChange.getInstance(manager, this);
		deviceChange.setSerialNumber("MyPCR333333");
		deviceChange.start();
		
	}
	
	private boolean statusFlag = true;

	@Override
	public void OnMessage(int MessageType, Object data, int firmwareVersion) {
		
		String count = (String)data;
		switch(MessageType)
		{
			case CONNECTED:
				System.out.println("?");
				if( count.equals("1")){
					System.out.println("�����");
					statusFlag = true;
				}
				break;
			case DISCONNECTED:
					System.out.println("����������");
					statusFlag = !statusFlag;
				
				break;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		/*
		Main m = new Main();
		
		while(true);
		*/
		Action[] actions = new Action[20];
		int lines = 0;
		
		String path = "test.txt";
		
		BufferedReader in = null; //�о��ִ� ����
		
		try{
			in = new BufferedReader(new FileReader(path)); //���� ������ �д´�. 
			//���� ������ ������ ����.
			String line = null;
			ArrayList<String> list = new ArrayList<>();
			
			while(( line = in.readLine()) != null)
			{
				//System.out.println(line);
				list.add(line);
			}
			in.close();
			
			String first = list.get(0);
			String last = list.get(list.size()-1);
			
			if(first.contains("%PCR%") && last.contains("%END%"))
			{
				for(int i =1; i<=list.size()-2;i++)
				{
					String[] datas = list.get(i).split("\t");
					
					
					actions[lines] = new Action(datas[0], datas[1], datas[2]);
					lines++;
					
					//System.out.println(String.format("Label : %s, temp : %s, time : %s", datas[0],datas[1], datas[2]));
				}
				System.out.println("�ùٸ� �������� ����");
				
				for(int i=0; i<=lines; ++i)
				{
					System.out.println(String.format("Label : %s, temp : %s, time : %s", 
							actions[i].label, actions[i].temp, actions[i].time));
					// label�� goto���� Ȯ���ϴ� ���
					if( actions[i].label.equals("GOTO"))
						System.out.println("GOTO");
					
					System.out.println(Integer.parseInt(actions[i].time));
				}
				
				System.out.println(String.format("%02d:%02d", 10, 10)); //02d�� ���̸� ���ڸ�. �� �ɸ� �ð��� ���ϴ�~
				
				//1. actions ������ �̿��Ͽ� ��ü �������� ������ �������� �ð��� ����Ͽ� ��:�� ���·� ����Ͻÿ� (eg. 05:05)
				//2. actions ������ �̿��Ͽ� ��ü �������� ������ ���� ������ label���� �־� 
				//       ArratList<String> list2 �� �����Ͽ� ����Ͻÿ�. (GOTO�� ���� ���� label ���� ���) 1,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4 �̷������� �迭�� �־��ֱ�
				//3. ���� �ֿ� ���� ������ ���� �ؿ��ÿ�.
			}
			else
			{
				System.out.println("�������� ���� �ƴ�");
			}
			
		}catch(IOException e) 
		{
			System.out.println("������ �����ϴ�");
		}
		
	}
}
	