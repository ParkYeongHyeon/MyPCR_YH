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
			System.out.println("에러났어");
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
					System.out.println("연결됨");
					statusFlag = true;
				}
				break;
			case DISCONNECTED:
					System.out.println("연결해제됨");
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
		
		BufferedReader in = null; //읽어주는 아이
		
		try{
			in = new BufferedReader(new FileReader(path)); //파일 리더를 읽는다. 
			//파일 리더를 오픈한 상태.
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
				System.out.println("올바른 프로토콜 파일");
				
				for(int i=0; i<=lines; ++i)
				{
					System.out.println(String.format("Label : %s, temp : %s, time : %s", 
							actions[i].label, actions[i].temp, actions[i].time));
					// label이 goto인지 확인하는 방법
					if( actions[i].label.equals("GOTO"))
						System.out.println("GOTO");
					
					System.out.println(Integer.parseInt(actions[i].time));
				}
				
				System.out.println(String.format("%02d:%02d", 10, 10)); //02d를 붙이면 두자리. 총 걸린 시간을 구하는~
				
				//1. actions 변수를 이용하여 전체 프로토콜 파일의 프로토콜 시간을 계산하여 분:초 형태로 출력하시오 (eg. 05:05)
				//2. actions 변수를 이용하여 전체 프로토콜 파일의 실행 순서를 label값을 넣어 
				//       ArratList<String> list2 에 저장하여 출력하시오. (GOTO는 넣지 말고 label 값만 출력) 1,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4 이런식으로 배열에 넣어주기
				//3. 지난 주에 못한 숙제를 마저 해오시요.
			}
			else
			{
				System.out.println("프로토콜 파일 아님");
			}
			
		}catch(IOException e) 
		{
			System.out.println("파일이 없습니다");
		}
		
	}
}
	