package cn.lastwhisper.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SyncServer {
	/*
	 * private ServerSocket serverSocket;
	 * 
	 * @Async public void run() { try { serverSocket = new ServerSocket(60000); }
	 * catch (IOException e) { e.printStackTrace(); } while (true) { try { Socket
	 * socket = serverSocket.accept(); BufferedReader br = new BufferedReader(new
	 * InputStreamReader(socket.getInputStream())); String linestr; while ((linestr
	 * = br.readLine()) != null) { // 接收到id System.out.println("接收到新增数据的id为：" +
	 * linestr); } } catch (IOException e) { System.out.println("断开连接"); }
	 * 
	 * } }
	 * 
	 * @PostConstruct
	 * 
	 * @Async public void start() { Thread thread = new Thread(() -> { try {
	 * System.out.println("同步服务已经启动"); new SyncServer().run();
	 * System.out.println("执行中了"); } catch (Exception e) { e.printStackTrace(); }
	 * }); // 启动线程 thread.start(); }
	 */
}
