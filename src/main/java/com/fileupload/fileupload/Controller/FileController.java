package com.fileupload.fileupload.Controller;

import com.fileupload.fileupload.Payload.FileResponce;
import com.fileupload.fileupload.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private  String path;
    @PostMapping("/upload")
    public ResponseEntity<FileResponce> fileUpload(@RequestParam("image")MultipartFile image)
    {
        String filename = null;
        try {
            filename = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            e.printStackTrace();
            return  new ResponseEntity<>(new FileResponce(null,"Images is not upload succesfully due to error"), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return  new ResponseEntity<>(new FileResponce(filename,"Images is Upload succesfully"), HttpStatus.OK);
    }

}
