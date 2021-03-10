package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSoket extends Thread {
	public void run() {

        Socket socket = null;
		
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
		
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
		
        Scanner scanner = null;
		
        try {
			
            socket = new Socket("localhost", 9000);
           // System.out.println("서버 연결 완료!");
			
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
			
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
			
            scanner = new Scanner(System.in);
			
            while (true) {
				
             //   System.out.println("↓ 메시지를 입력해주세요 ↓");
				
                String outMessage = scanner.nextLine();
                dataOutputStream.writeUTF(outMessage); // 서버 측으로 데이터 전송
                dataOutputStream.flush(); // 완전히 비우기 위함
				
                String receviedMessage = dataInputStream.readUTF();
				
              //  System.out.println("받은 메세지 : " + receviedMessage);
				
                if (outMessage.equals("stop")) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			
            try {
				
                if (dataOutputStream != null) dataOutputStream.close();
                if (outputStream != null) outputStream.close();
                if (dataInputStream != null) dataInputStream.close();
                if (inputStream != null) inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

}
