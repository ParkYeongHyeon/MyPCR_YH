package com.test;

import java.io.IOException;
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
			System.out.println("ø°∑Ø≥µæÓ");
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
					System.out.println("ø¨∞·µ ");
					statusFlag = true;
				}
				break;
			case DISCONNECTED:
					System.out.println("ø¨∞·«ÿ¡¶µ ");
					statusFlag = !statusFlag;
				
				break;
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		
		while(true);
	}
	
}