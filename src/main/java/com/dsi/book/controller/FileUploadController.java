package com.dsi.book.controller;

import com.dsi.book.helper.FileUploadHelper;
import com.dsi.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
//        System.out.println(multipartFile.getName());
//        System.out.println(multipartFile.getSize()); // byte e hisab kore.
//        System.out.println(multipartFile.getOriginalFilename());
//        System.out.println(multipartFile.getContentType());
        if(multipartFile.isEmpty()){
            return new ResponseEntity<>("Request must contain file",HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        if(!multipartFile.getContentType().equals("image/*")){
//            return new ResponseEntity<>("Only image file is acceptable",HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        Boolean f = fileUploadHelper.uploadFile(multipartFile);
        if(f){
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
        }
        return new ResponseEntity<>("Something wrong when file uploading",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
