package com.koreait.board.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.koreait.board.bean.AttachFileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload/*")
public class UploadController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping(value="uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // 메소드 종료 시 html(view)로 가지 않고 데이터를 리턴
    public List uploadAjaxPost(MultipartFile[] uploadFile) {
        log.info("[uploadController] uploadAjaxPost() Called OK");

        List<AttachFileVO> fileList = new ArrayList<>();

        String uploadFolder = "C:/upload/temp";  // 업로드할 경로
        String uploadFolderPath = getFolder();
        // yyyy/MM/dd 경로 생성
        File uploadPath = new File(uploadFolder, uploadFolderPath);

        //디렉토리가 없으면 생성 / 있으면 skip
        if (uploadPath.exists()) {
            log.info("this deirectory is exist");
        } else {
            uploadPath.mkdirs();
        }

        // 업로드된 파일들 처리
        for (MultipartFile f : uploadFile) {
            log.info("filename : " + f.getOriginalFilename());
            log.info("filesize : " + f.getSize());

            //UUID 적용
            //network 상에서 각각의 개체를 식별하기 위해 사용
            String uploadFileName = f.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            log.info("uuid : " + uuid.toString());
            uploadFileName = uuid.toString() + "_" + uploadFileName;

            AttachFileVO attachFileVO = new AttachFileVO();
            attachFileVO.setFileName(uploadFileName);
            attachFileVO.setUuid(uuid.toString());
            attachFileVO.setUpladPath(uploadFolderPath);

            // 1. File Creation (Empty)
//            String originalFileName = f.getOriginalFilename();
//            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//            String saveFileName = UUID.randomUUID().toString() + fileExtension;  // 중복 방지를 위한 UUID 생성
            //File saveFile = new File(uploadFolder, f.getOriginalFilename());
            File saveFile = new File(uploadPath, uploadFileName);

            // 2. Contents Copy (파일 저장)
            try {
                f.transferTo(saveFile);

                // 3. 이미지 타입 확인
                if (checkImageType(saveFile)) {
                    log.info("Image File");
                    attachFileVO.setImage(true);
                } else {
                    log.info("Not Image File");
                }
            } catch (Exception e) {
                log.error("File Upload Failed", e);
            }
            fileList.add(attachFileVO);
        }
        return fileList;
    }

    // 이미지 파일인지 확인하는 메소드
    private boolean checkImageType(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());
            log.info("ContentType : " + contentType);
            return contentType != null && contentType.startsWith("image");
        } catch (Exception e) {
            log.error("Error checking image type", e);
        }
        return false;
    }


    /**
     * 오늘 일자를 연/월/일 형태로 리넡한다.
     * @return DATE
     */
    private String getFolder(){
        String str = null;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        str = sdf.format(date);

        return str;
    }
}
