package cn.lastwhisper.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
	private static ServerSocket serverSocket;

//	public static void main(String[] args) {
//		try {// new Socket("localhost", 60000);
//			serverSocket = new ServerSocket(5000);
//			System.out.println("服务器正常启动。。。");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Socket socket = null;
//		BufferedReader br = null;
//		String linestr;
//		while (true) {
//			try {
//				socket = serverSocket.accept();
//				System.out.println("用户接入成功。。。");
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				while ((linestr = br.readLine()) != null) {
//					// 接收到id
//					System.out.println("接收到新增数据的id为：" + linestr);
//				}
//
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	}
	
	 public static void main(String[] args) {
	    	int a= 3;
	        if(a<10){
	            System.out.println(a);
	        }else if (a<20){
	            System.out.println(a);
	        }else {
	            System.out.println(a);
	        }
		} 
	
}
