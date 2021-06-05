package com.duoduopin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface picService {
    public String UploadPic(long userid,String picFile);
    public void updatePic(long userid,String url);
    public String get_pic(long userid);
}
