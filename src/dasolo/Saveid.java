package dasolo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class Saveid {
	public String getid() {
		String result = "";
		try {
			// 파일 객체 생성
			File file = new File("./../id.txt");
			// 입력 스트림 생성
			FileReader file_reader = new FileReader(file);
			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				result +=(char) cur;
			}
			file_reader.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e1) {
			e1.getStackTrace();
		}
		return result;
	}
	public void saveid(String id) {
		try {
		    OutputStream output = new FileOutputStream("./../id.txt");
		    String str =id;
		    byte[] by=str.getBytes();
		    output.write(by);
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}

}
