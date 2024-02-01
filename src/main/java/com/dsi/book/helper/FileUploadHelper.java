package com.dsi.book.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
//    public final String UPLOAD_DIR = "/home/dsi/Documents/Code/Java/boot/REST_API_Book_Boot/src/main/resources/static/image/";

    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException{

    }

    public Boolean uploadFile(MultipartFile file) {
        try{
//            InputStream inputStream = file.getInputStream();
//            byte[] data = new byte[inputStream.available()];
//            inputStream.read(data);
//
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+file.getOriginalFilename() , true);
//            fos.write(data);
//
//            fos.flush();
//            fos.close();

            Files.copy(file.getInputStream(), Path.of(UPLOAD_DIR+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
