package com.o.panadao.util;

import org.slf4j.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "C:\\Users\\Remi\\JavaEE\\Panado\\opanadao\\src\\main\\webapp\\WEB-INF\\assets\\images\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//get REAL_PATH
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		// directory exists? if not create
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//project upload
			file.transferTo(new File(ABS_PATH+ code + ".jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
