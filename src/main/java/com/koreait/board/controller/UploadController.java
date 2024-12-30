package com.koreait.board.controller;

import java.io.File;
import java.nio.file.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload/*")
public class UploadController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("uploadAjaxAction")
    @ResponseBody// 메소드 종료 시 html(view)로 가지 않고 데이터를 리턴
    public String uploadAjaxPost(MultipartFile[] uploadFile){
        log.info("[uploadController] uploadAjaxPost() Called OK");

        String uploadFolder = "C:/upload/temp";

        for(MultipartFile f : uploadFile){
            log.info("filename : " + f.getOriginalFilename());
            log.info("filesize : " + f.getSize());

            //1. File Createion(Empty)
            File saveFile = new File(uploadFolder, f.getOriginalFilename());

            //2. Contents Copy
            try{
                f.transferTo(saveFile);

                if(checkImageType(saveFile)){
                    log.info("Image File");
                }else{
                    log.info("Not Image File");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    private boolean checkImageType(File file) {
        try{
            String contentType = Files.probeContentType(file.toPath());
            log.info("ContentType : " + contentType);
            return contentType.startsWith("image");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
