package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);
	
	//파일 이름과 경로를 받아서 파일을 삭제하는 메서드.
	//리턴타입 int => 잘 삭제되었는지 isDel
	public int deleteFile(String imageFileName, String savePath) {
		boolean isDel = false; //파일을 삭제하는 리턴타입이 boolean
		log.info(">>> deleteFile method 접근");
		log.info(">>> imageFileName : "+imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThumbFile = new File(fileDir+File.separator+"th_"+imageFileName);
		
		//파일이 있는지 (존재여부) 확인 => 있으면 삭제
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete(); //리턴형태는 boolean
			log.info(">>> removeFile : "+ (isDel? "ok":"fail"));
			if (isDel) {//main 파일이 지워졌다면 썸네일 파일도 지워준다.
				isDel = removeThumbFile.delete();
				log.info(">>> removeThumbFile : "+ (isDel? "ok":"fail"));
			}
		}
		log.info(">>> FileHandler remove OK ");
		return isDel ? 1:0;
	}
}
