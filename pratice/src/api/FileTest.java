package api;

import java.io.File;

/*
 *  자바 api : 메서드 -> 인수, 리턴
 */
public class FileTest {
	
	
	public static void main(String[] args) {
		
		//temp 파일 목록 / 삭제 / 정보확인
		
		File file = new File("c:/temp/copy.jpg");
		
//		String[] fileList =  file.list();
//		for (String string : fileList) {
//			System.out.println(string);
//		}
		file.renameTo(new File("ccopy.jpg "));
	}
}
