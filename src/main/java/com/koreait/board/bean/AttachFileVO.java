package com.koreait.board.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AttachFileVO {
    private String fileName;
    private String upladPath;
    private String uuid;
    private boolean image;
    private Long bno;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUpladPath() {
        return upladPath;
    }

    public void setUpladPath(String upladPath) {
        this.upladPath = upladPath;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }
}
